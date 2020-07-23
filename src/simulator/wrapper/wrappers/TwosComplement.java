package simulator.wrapper.wrappers;



import simulator.control.Simulator;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class TwosComplement extends Wrapper {

    public TwosComplement(String label, String stream, Link[] links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Not not1 = new Not("NOT1");
        int size = getInputs().size();

        for(int i=0 ; i< size ; i++)
            not1.addInput(getInput(i));

        Adder adder1 = new Adder("ADDER1","64X33");
        for(int j=0 ; j < size ; j++)
            adder1.addInput(not1.getOutput(j));

        for(int h=0 ; h<(size-1) ; h++)
            adder1.addInput(Simulator.falseLogic);
        adder1.addInput(Simulator.trueLogic);


        for(int k=1 ; k<size+1 ; k++)
            addOutput(adder1.getOutput(k));


    }

}