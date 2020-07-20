//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.wrapper.wrappers.*;

import java.util.ArrayList;

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
//        ControlUnit cu = new ControlUnit("CU", "6X10",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);// Jump

//        Decoder3X8 d0 = new Decoder3X8("Dec_0","4X8",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic);

//        Decoder5X32 d1 = new Decoder5X32("Dec_1","5X32",Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic);

        ArrayList<ArrayList<DFlipFlop>> Registers = new ArrayList<ArrayList<DFlipFlop>>(32);


        Clock clk = new Clock("Clock",1000);
        for (int i = 0 ; i < 32 ; i++){
            ArrayList<DFlipFlop> d = new ArrayList<>();
            for (int j = 0 ; j < 32 ; j++){
                d.add(new DFlipFlop(String.format("D%d_%d",i,j),clk.getOutput(0),Simulator.falseLogic));
            }
            System.err.println(d);
            Registers.add(d);
        }


        System.out.println("Hello");
        RegisterFile r = new RegisterFile("RegFile","0x0",Registers);

        Simulator.debugger.addTrackItem(r);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}