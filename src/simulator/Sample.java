//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        //sample circuit
//        Adder adder = new Adder("ADDER", "10X6",
//                Simulator.falseLogic, Simulator.trueLogic, Simulator.trueLogic, Simulator.falseLogic, Simulator.trueLogic,
//                Simulator.falseLogic, Simulator.trueLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.trueLogic);

//        Multiplexer2x1 m1 = new Multiplexer2x1("MUX_2x1","3X1",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
//        Multiplexer4x1 m1 = new Multiplexer2x1("MUX_2x1","6X1",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
//
//
//        Multiplexer8x1 m1 = new Multiplexer8x1("MUX_8x1","11x1",Simulator.trueLogic,Simulator.falseLogic , Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic);

       // ControlUnit cu = new ControlUnit("CU", "6X10",Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic); // lw
        // ControlUnit cu = new ControlUnit("CU", "6X10",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);// R-format
        //ControlUnit cu = new ControlUnit("CU", "6X10",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);// Jump

        Simulator.debugger.addTrackItem(cu);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}