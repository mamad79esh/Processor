package simulator.wrapper.wrappers;



import simulator.control.Simulator;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Twos_complement extends Wrapper {

	public Twos_complement(String label, String stream, Link[] links) {
		super(label, stream, links);
	}

	@Override
	public void initialize() {
		
		Not not1 = new Not("NOT1");
		for(int i=0 ; i<getInputSize() ; i++)
			not1.addInput(getInput(i));
		
		Adder adder1 = new Adder("ADDER1","64X32");
		for(int j=0 ; j<getInputSize() ; j++)
			adder1.addInput(not1.getOutput(j));
		
		for(int h=0 ; h<(getInputSize()-1) ; h++)
			adder1.addInput(Simulator.falseLogic);
		adder1.addInput(Simulator.trueLogic);
		
		for(int k=0 ; k<getInputSize() ; k++)
			addOutput(adder1.getOutput(k));
		
		
	}

}
