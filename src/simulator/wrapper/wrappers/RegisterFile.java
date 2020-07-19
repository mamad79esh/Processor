package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;

public class RegisterFile extends Wrapper {
    public ArrayList<ArrayList<DFlipFlop>> Registers;

    public RegisterFile(String label, String stream,ArrayList<ArrayList<DFlipFlop>> registers, Link... links) {
        super(label, stream, links);
        Registers = registers;

    }

    @Override
    public void initialize() {

        Decoder5X32 decoder0 = new Decoder5X32("Dec1","5x32",getInput(1),getInput(2),getInput(3),getInput(4),getInput(5));


        //write
        for ( int j = 0 ; j < 32 ; j++){
            And and0 = new And("And",getInput(0),decoder0.getOutput(j));
            for( int i = 0 ; i < 32 ; i++ ){
                Link clk = Registers.get(j).get(i).getInput(0);
                Not n = new Not("n",and0.getOutput(0));
                And and_0 = new And("a0",n.getOutput(0),Registers.get(j).get(i).getOutput(0));
                And and_1 = new And("a1",and0.getOutput(0),getInputs().get(i+16));

                Or or = new Or("or",and_0.getOutput(0),and_1.getOutput(0));

                Registers.get(0).get(i).setInput(1,or.getOutput(0));
            }
        }

        Decoder5X32 decoder1 = new Decoder5X32("Dec1","5x32",getInput(6),getInput(7),getInput(8),getInput(9),getInput(10));
        Decoder5X32 decoder2 = new Decoder5X32("Dec2","5x32",getInput(11),getInput(12),getInput(13),getInput(14),getInput(15));


        for( int i = 0 ; i < 32 ; i++){
            Or or = new Or("Or");
            for (int j = 0 ; j < 32 ; j++){
                And and0 = new And("and",decoder1.getOutput(j),Registers.get(j).get(i).getOutput());
                or.addInput(and0.getOutput(0));
            }
            or.addOutput(or.getOutput(0));
        }

        for( int i = 0 ; i < 32 ; i++){
            Or or = new Or("Or");
            for (int j = 0 ; j < 32 ; j++){
                And and0 = new And("and",decoder2.getOutput(j),Registers.get(j).get(i).getOutput());
                or.addInput(and0.getOutput(0));
            }
            or.addOutput(or.getOutput(0));
        }


    }
}
