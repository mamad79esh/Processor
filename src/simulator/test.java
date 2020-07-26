package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.sequential.Clock;
import simulator.wrapper.wrappers.DFlipFlop;

public class test {
    public static void main(String[] args) {
        // Creating needed wrapper :
        Clock clock = new Clock("Clock",2000);
        DFlipFlop d = new DFlipFlop("CLK","2x2",clock.getOutput(0));
        d.addInput(d.getOutput(1));

        ByteMemory mem = new ByteMemory("Mem",clock.getOutput(0));
        for (int i = 0 ; i < 16 ; i++)
            mem.addInput(Simulator.falseLogic);

        for (int i = 0 ; i < 32 ; i++)
            mem.addInput(Simulator.falseLogic);




        Simulator.debugger.addTrackItem(mem,clock);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}
