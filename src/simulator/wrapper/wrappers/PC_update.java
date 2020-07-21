package simulator.wrapper.wrappers;


import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class PC_update extends Wrapper {

	public PC_update(String label, String stream, Link[] links) {
		super(label, stream, links);
	}

	@Override
	public void initialize() {
		
		
		DFlipFlop[] pc = new DFlipFlop[32];
        for (int i=0 ; i<32 ; ++i)
            pc[i] = new DFlipFlop("PC" + i,"2X2");
        
        
        Adder adder = new Adder("ADDER", "64X33");

        Link[] adderIn = new Link[32];
        for (int i = 0 ; i<29 ; ++i)
            adderIn[i] = Simulator.falseLogic;
        adderIn[29] = Simulator.trueLogic;
        adderIn[30] = Simulator.falseLogic;
        adderIn[31] = Simulator.falseLogic;
        
        
        Multiplexer2x1[] select = new Multiplexer2x1[32];
        
        
        for (int i=0 ; i<32 ; ++i)
            select[i] = new Multiplexer2x1("MUX" + i, "3X1");
        
        
        // select the PC input
        DFlipFlop[] shift = new DFlipFlop[2];
        shift[0] = new DFlipFlop("SH0","2X2",getInput(0), Simulator.falseLogic);
        shift[1] = new DFlipFlop("SH1","2X2",getInput(0), shift[0].getOutput(0));
        
        
        Adder tempAdder = new Adder("TEMP","64X33");
        
        for (int i=0 ; i<32 ; ++i)
            select[i].addInput(shift[1].getOutput(0),
            		tempAdder.getOutput(i+1),getInput(i+1));
		
		
		
        adder.addInput(adderIn);
        for (int i=0; i<32; ++i)
            adder.addInput(select[i].getOutput(0));         //calculate PC+4
        
        
        ///////////////////////////////////////////////////////////////
        
        //beq_offset
      	Link[] beq_offset = new Link[16];
      	for(int i=0 ; i<16 ; i++)
      		beq_offset[i]=getInput(i+33);
      	
      	
		SignExtend se1 = new SignExtend("SIGNEX1","16X32",beq_offset);
		
		Adder adder1 = new Adder("ADDER1","64X33");
		for(int i=2 ; i<32 ; i++)
			adder1.addInput(se1.getOutput(i));
		adder1.addInput(Simulator.falseLogic);
		adder1.addInput(Simulator.falseLogic);
		
		 for (int i=0 ; i<32 ; ++i)
			 adder1.addInput(adder.getOutput(i+1));     
		 
		 
		And and = new And("AND0",Simulator.falseLogic,Simulator.falseLogic);
		// the first one is branch flag and the other is zero flag
		
		Multiplexer2x1[] select1 = new Multiplexer2x1[32];
        for (int i=0 ; i<32 ; ++i)
            select1[i] = new Multiplexer2x1("MUX" + i, "3X1");
		
        for (int i=0 ; i<32 ; ++i)
            select1[i].addInput(and.getOutput(0),adder.getOutput(i+1),adder1.getOutput(i+1));
        
        //////////////////////////////////////////////////////////////////
        
        
        //jmp_offset
		Link[] jmp_offset = new Link[26];
		for(int i=0 ; i<26 ; i++)
			jmp_offset[i]=getInput(i+49);
		
		
		// jump muxs ( the selector(jump flag) is true here )
		Multiplexer2x1[] select2 = new Multiplexer2x1[32];
		
        for (int i=0 ; i<32 ; ++i)
            select2[i] = new Multiplexer2x1("MUX" + i, "3X1");
		
        for (int i=0 ; i<4 ; ++i)
            select2[i].addInput(Simulator.trueLogic,
            		select1[i].getOutput(0),adder.getOutput(i+1));
        for (int i=4 ; i<30 ; ++i)
            select2[i].addInput(Simulator.trueLogic,
            		select1[i].getOutput(0),jmp_offset[i-4]);
        
        select2[30].addInput(Simulator.trueLogic,
        		select1[30].getOutput(0),Simulator.falseLogic);
        select2[31].addInput(Simulator.trueLogic,
        		select1[31].getOutput(0),Simulator.falseLogic);
        
        
        
        for (int i=0 ; i<32 ; ++i)
            pc[i].addInput(getInput(0), select2[i].getOutput(0));
        
		
        for (int i=0 ; i<32 ; ++i)
        	tempAdder.addInput(select2[i].getOutput(0));
        for (int i=0 ; i<32 ; ++i)
        	tempAdder.addInput(Simulator.falseLogic);
        
        
        
		
		// see the new PC address
        for (int i=0; i<32; ++i)
        	addOutput(pc[i].getOutput(0));
		
		
		
	}
}
		
		
