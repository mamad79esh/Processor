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
		
		Not not0 = new Not("NOT0",getInput(0));
		Not not1 = new Not("NOT0",getInput(1));
		Not not2 = new Not("NOT0",getInput(2));
		Not not3 = new Not("NOT0",getInput(3));
		Not not4 = new Not("NOT0",getInput(4));
		Not not5 = new Not("NOT0",getInput(5));
		Not not6 = new Not("NOT0",getInput(6));
		Not not7 = new Not("NOT0",getInput(7));
		Not not8 = new Not("NOT0",getInput(8));
		Not not9 = new Not("NOT0",getInput(9));
		Not not10 = new Not("NOT0",getInput(10));
		Not not11 = new Not("NOT0",getInput(11));
		Not not12 = new Not("NOT0",getInput(12));
		Not not13 = new Not("NOT0",getInput(13));
		Not not14 = new Not("NOT0",getInput(14));
		Not not15 = new Not("NOT0",getInput(15));
		Not not16 = new Not("NOT0",getInput(16));
		Not not17 = new Not("NOT0",getInput(17));
		Not not18 = new Not("NOT0",getInput(18));
		Not not19 = new Not("NOT0",getInput(19));
		Not not20 = new Not("NOT0",getInput(20));
		Not not21 = new Not("NOT0",getInput(21));
		Not not22 = new Not("NOT0",getInput(22));
		Not not23 = new Not("NOT0",getInput(23));
		Not not24 = new Not("NOT0",getInput(24));
		Not not25 = new Not("NOT0",getInput(25));
		Not not26 = new Not("NOT0",getInput(26));
		Not not27 = new Not("NOT0",getInput(27));
		Not not28 = new Not("NOT0",getInput(28));
		Not not29 = new Not("NOT0",getInput(29));
		Not not30 = new Not("NOT0",getInput(30));
		Not not31 = new Not("NOT0",getInput(31));
		
		
		
		Adder adder1 = new Adder("ADDER1","64X32");

			adder1.addInput(not0.getOutput(0));
			adder1.addInput(not1.getOutput(0));
			adder1.addInput(not2.getOutput(0));
			adder1.addInput(not3.getOutput(0));
			adder1.addInput(not4.getOutput(0));
			adder1.addInput(not5.getOutput(0));
			adder1.addInput(not6.getOutput(0));
			adder1.addInput(not7.getOutput(0));
			adder1.addInput(not8.getOutput(0));
			adder1.addInput(not9.getOutput(0));
			adder1.addInput(not10.getOutput(0));
			adder1.addInput(not11.getOutput(0));
			adder1.addInput(not12.getOutput(0));
			adder1.addInput(not13.getOutput(0));
			adder1.addInput(not14.getOutput(0));
			adder1.addInput(not15.getOutput(0));
			adder1.addInput(not16.getOutput(0));
			adder1.addInput(not17.getOutput(0));
			adder1.addInput(not18.getOutput(0));
			adder1.addInput(not19.getOutput(0));
			adder1.addInput(not20.getOutput(0));
			adder1.addInput(not21.getOutput(0));
			adder1.addInput(not22.getOutput(0));
			adder1.addInput(not23.getOutput(0));
			adder1.addInput(not24.getOutput(0));
			adder1.addInput(not25.getOutput(0));
			adder1.addInput(not26.getOutput(0));
			adder1.addInput(not27.getOutput(0));
			adder1.addInput(not28.getOutput(0));
			adder1.addInput(not29.getOutput(0));
			adder1.addInput(not30.getOutput(0));
			adder1.addInput(not31.getOutput(0));
			
		
		for(int i=0 ; i<31 ; i++)
			adder1.addInput(Simulator.falseLogic);
		adder1.addInput(Simulator.trueLogic);
		
		for(int i=0 ; i<32 ; i++)
			addOutput(adder1.getOutput(i));
		
		
	}

}
