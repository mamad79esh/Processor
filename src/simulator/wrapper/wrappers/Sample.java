//Dedicated to Goli

package simulator;





import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Or;
import simulator.gates.combinational.Xor;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        //sample circuit
//        And a1 = new And("AND1");
//        a1.addInput(Simulator.trueLogic , Simulator.falseLogic);
//        
//        Or o1 = new Or("OR1");
//        o1.addInput(a1.getOutput(0) , Simulator.falseLogic);
        
        //HalfAdder ha1 = new HalfAdder("HALFADDER1", "2X2" );
        //ha1.addInput(Simulator.trueLogic , Simulator.trueLogic);
    	
    	//FullAdder fa1 = new FullAdder("FULLADDER1", "3X2");
    	//fa1.addInput(Simulator.trueLogic , Simulator.falseLogic , Simulator.trueLogic);
    	
    	//Clock clock1 = new Clock("CLOCK1", 1000) ;
    	//DFlipFlop d1 = new DFlipFlop("DF1", clock1.getOutput(0) , Simulator.trueLogic) ;
    	
//    	Link[] inp = new Link[16];
//    	for (int j = 0 ; j<5 ; j++)
//    		inp[j] = Simulator.trueLogic ;
//    	for (int j = 5 ; j<16 ; j++)
//    		inp[j] = Simulator.falseLogic ;
//    		
//    	SignExtend se1 = new SignExtend("SIGNEX", "16X32", inp);
    	
    	
      //Multiplexer2x1 m1 = new Multiplexer2x1("MUX_2x1","3X1",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
//      Multiplexer4x1 m1 = new Multiplexer2x1("MUX_2x1","6X1",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
//

//      Multiplexer8x1 m1 = new Multiplexer8x1("MUX_8x1","11x1",Simulator.trueLogic,Simulator.falseLogic , Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic);

//    	Link[] inp = new Link[32];
//    	for (int j=0 ; j<32 ; j++)
//    		inp[j] = Simulator.trueLogic ;
//
//    	Twos_complement tc1 = new Twos_complement("TWO's","32X32",inp);
    	
    	
    	//assume that the first address of PC is (00000000) in hex
    	Link[] firstPC = new Link[32];
    	for (int j=0 ; j<32 ; j++)
    		firstPC[j] = Simulator.falseLogic ;
    	
    	PC_update pcUpdate0 = new PC_update("PC_UPDATE0","32X32",firstPC);
		
    	
        Simulator.debugger.addTrackItem(pcUpdate0);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit("FAST");
    }
}