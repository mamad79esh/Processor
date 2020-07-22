//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
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
//        ControlUnit cu = new ControlUnit("CU", "6X10",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);// Jump

//        Decoder3X8 d0 = new Decoder3X8("Dec_0","4X8",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic);

//        Decoder5X32 d1 = new Decoder5X32("Dec_1","5X32",Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic);

//
//
//        RegisterFile r = new RegisterFile("RegFile","49x64");
//
//        Clock clock = new Clock("Clock",1000);
//        Link write = Simulator.trueLogic;
//        Link []regWrite = {Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic};
//        Link []regRead1 = {Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic};
//        Link []regRead2 = {Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic};
        Link []regDataWrite = {Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                               Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic, Simulator.falseLogic,
                               Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                                Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic, Simulator.falseLogic,
                                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
                                ,Simulator.trueLogic,Simulator.falseLogic};
//
//        r.addInput(clock.getOutput(0));
//            r.addInput(write);
//                    r.addInput(regWrite);
//                            r.addInput(regRead1);
//                                r.addInput(regRead2);
//                                    r.addInput(regDataWrite);

//    Multiplexer32x1 m = new Multiplexer32x1("MUX_32x1","37x1",Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic);
//
//    m.addInput(regDataWrite);
        Clock c = new Clock("clk",1000);
        DFlipFlop d = new DFlipFlop("DFlipFlop","2x2",c.getOutput(0));
        d.addInput(d.getOutput(1));
        Memory m = new Memory("mem",d.getOutput(0));
        m.addInput(Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic, Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic);

        Link []regDataWrite2 = {c.getOutput(0),c.getOutput(0),c.getOutput(0),Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic, Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic, Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
                ,Simulator.trueLogic,Simulator.falseLogic};



        m.addInput(regDataWrite2);


        Simulator.debugger.addTrackItem(m,c);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}

