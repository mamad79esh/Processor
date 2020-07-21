package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.sequential.Clock;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;

public class RegisterFile extends Wrapper {
//    public ArrayList<ArrayList<DFlipFlop>> Registers ;

    public RegisterFile(String label, String stream,Link... links) {

        super(label, stream, links);




    }

    @Override
    public void initialize() {
        ArrayList<ArrayList<DFlipFlop>> Registers = new ArrayList<ArrayList<DFlipFlop>>(32);


        Decoder5X32 decoder0 = new Decoder5X32("Dec1","5x32",getInput(2),getInput(3),getInput(4),getInput(5),getInput(6));
        Link clk = getInput(0);
        Link write = getInput(1);

        ArrayList<DFlipFlop> d0 = new ArrayList<>();
        for (int i = 0 ; i < 32 ; i++){
            d0.add(new DFlipFlop("D0_0", "2x2",clk,Simulator.falseLogic));
        }
        Registers.add(d0);

        for (int i = 1 ; i < 32 ; i++){
            ArrayList<DFlipFlop> d = new ArrayList<>();
            for (int j = 0 ; j < 32 ; j++){
                DFlipFlop flipFlop = new DFlipFlop(String.format("D%d_%d",i,j),"2x2", clk);
                And select = new And("And",write,decoder0.getOutput(i));
                Multiplexer2x1 mux = new Multiplexer2x1("MUX_2x1","3x1",select.getOutput(0),flipFlop.getOutput(0),getInput(j+17));
                flipFlop.addInput(mux.getOutput(0));
                d.add(flipFlop);
            }

            Registers.add(d);
        }





//        //write
//        for ( int j = 1 ; j < 32 ; j++){
//            And and0 = new And("And",getInput(1),decoder0.getOutput(j));
//            for( int i = 0 ; i < 32 ; i++ ){
//
//                Not n = new Not("n",and0.getOutput(0));
//                And and_0 = new And("a0",n.getOutput(0),Registers.get(j).get(i).getOutput(0));
//                And and_1 = new And("a1",and0.getOutput(0),getInputs().get(i+17));
//
//                Or or = new Or("or",and_0.getOutput(0),and_1.getOutput(0));
//
//                Registers.get(j).get(i).setInput(1,or.getOutput(0));
//            }
//        }
//
//        Decoder5X32 decoder1 = new Decoder5X32("Dec1","5x32",);
//        Decoder5X32 decoder2 = new Decoder5X32("Dec2","5x32",);


//        for( int i = 0 ; i < 32 ; i++){
//            Or or = new Or("Or");
//            for (int j = 0 ; j < 32 ; j++){
//                And and0 = new And("and",decoder1.getOutput(j),Registers.get(j).get(i).getOutput(0));
//                or.addInput(and0.getOutput(0));
//            }
//            addOutput(or.getOutput(0));
//        }
//
//        for( int i = 0 ; i < 32 ; i++){
//            Or or = new Or("Or");
//            for (int j = 0 ; j < 32 ; j++){
//                And and0 = new And("and",decoder2.getOutput(j),Registers.get(j).get(i).getOutput(0));
//                or.addInput(and0.getOutput(0));
//            }
//            addOutput(or.getOutput(0));
//        }




        for (int i = 0 ; i < 32 ; i++){
            Multiplexer32x1 m1 = new Multiplexer32x1("MUX","37x1");
            m1.addInput(getInput(7),getInput(8),getInput(9),getInput(10),getInput(11));
            for ( int j = 0 ; j < 32 ; j++){
                m1.addInput(Registers.get(j).get(i).getOutput(0));
            }
            addOutput(m1.getOutput(0));
        }



        for (int i = 0 ; i < 32 ; i++){
            Multiplexer32x1 m2 = new Multiplexer32x1("MUX","37x1");
            m2.addInput(getInput(12),getInput(13),getInput(14),getInput(15),getInput(16));
            for ( int j = 0 ; j < 32 ; j++){
                m2.addInput(Registers.get(j).get(i).getOutput(0));
            }
            addOutput(m2.getOutput(0));
        }

    }
}
