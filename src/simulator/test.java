package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.sequential.Clock;
import simulator.wrapper.wrappers.ALU;
import simulator.wrapper.wrappers.DFlipFlop;

public class test {
    public static void main(String[] args) {
        // Creating needed wrapper :
        ALU alu = new ALU("ALU","68X33",Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic);

        for (int i = 0 ; i < 32 ; i++)
            alu.addInput(Simulator.trueLogic);

        for (int i = 0 ; i < 32 ; i++)
            alu.addInput(Simulator.falseLogic);
        Simulator.debugger.addTrackItem(alu);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}
