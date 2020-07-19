//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        //sample circuit
        AluContorl adder = new AluContorl("Allocator", "8X4",
                Simulator.trueLogic,Simulator.falseLogic, Simulator.trueLogic,Simulator.falseLogic,
                Simulator.trueLogic,Simulator.falseLogic, Simulator.trueLogic,Simulator.falseLogic);

        Simulator.debugger.addTrackItem(adder);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}