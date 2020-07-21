package simulator.wrapper.wrappers;



import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class PC_update extends Wrapper {

	public PC_update(String label, String stream, Link[] links) {
		super(label, stream, links);
	}

	@Override
	public void initialize() {
		
		Clock clk = new Clock("CLK", 1000);
		
		
		
		DFlipFlop df0 = new DFlipFlop("DF0",clk.getOutput(0),Simulator.trueLogic);
		DFlipFlop df1 = new DFlipFlop("DF1",clk.getOutput(0),df0.getOutput(0));
		
		
		Multiplexer2x1 mu0 = new Multiplexer2x1("MU0","3X1", df1.getOutput(0), getInput(0),
				getOutput(0));
		Multiplexer2x1 mu1 = new Multiplexer2x1("MU1","3X1", df1.getOutput(0), getInput(1),
				getOutput(1));
		Multiplexer2x1 mu2 = new Multiplexer2x1("MU2","3X1", df1.getOutput(0), getInput(2),
				getOutput(2));
		Multiplexer2x1 mu3 = new Multiplexer2x1("MU3","3X1", df1.getOutput(0), getInput(3),
				getOutput(3));
		Multiplexer2x1 mu4 = new Multiplexer2x1("MU4","3X1", df1.getOutput(0), getInput(4),
				getOutput(4));
		Multiplexer2x1 mu5 = new Multiplexer2x1("MU5","3X1", df1.getOutput(0), getInput(5),
				getOutput(5));
		Multiplexer2x1 mu6 = new Multiplexer2x1("MU6","3X1", df1.getOutput(0), getInput(6),
				getOutput(6));
		Multiplexer2x1 mu7 = new Multiplexer2x1("MU7","3X1", df1.getOutput(0), getInput(7),
				getOutput(7));
		Multiplexer2x1 mu8 = new Multiplexer2x1("MU8","3X1", df1.getOutput(0), getInput(8),
				getOutput(8));
		Multiplexer2x1 mu9 = new Multiplexer2x1("MU9","3X1", df1.getOutput(0), getInput(9),
				getOutput(9));
		Multiplexer2x1 mu10 = new Multiplexer2x1("MU10","3X1",df1.getOutput(0),getInput(10),
				getOutput(10));
		Multiplexer2x1 mu11 = new Multiplexer2x1("MU11","3X1",df1.getOutput(0),getInput(11),
				getOutput(11));
		Multiplexer2x1 mu12 = new Multiplexer2x1("MU12","3X1",df1.getOutput(0),getInput(12),
				getOutput(12));
		Multiplexer2x1 mu13 = new Multiplexer2x1("MU13","3X1",df1.getOutput(0),getInput(13),
				getOutput(13));
		Multiplexer2x1 mu14 = new Multiplexer2x1("MU14","3X1",df1.getOutput(0),getInput(14),
				getOutput(14));
		Multiplexer2x1 mu15 = new Multiplexer2x1("MU15","3X1",df1.getOutput(0),getInput(15),
				getOutput(15));
		Multiplexer2x1 mu16 = new Multiplexer2x1("MU16","3X1",df1.getOutput(0),getInput(16),
				getOutput(16));
		Multiplexer2x1 mu17 = new Multiplexer2x1("MU17","3X1",df1.getOutput(0),getInput(17),
				getOutput(17));
		Multiplexer2x1 mu18 = new Multiplexer2x1("MU18","3X1",df1.getOutput(0),getInput(18),
				getOutput(18));
		Multiplexer2x1 mu19 = new Multiplexer2x1("MU19","3X1",df1.getOutput(0),getInput(19),
				getOutput(19));
		Multiplexer2x1 mu20 = new Multiplexer2x1("MU20","3X1",df1.getOutput(0),getInput(20),
				getOutput(20));
		Multiplexer2x1 mu21 = new Multiplexer2x1("MU21","3X1",df1.getOutput(0),getInput(21),
				getOutput(21));
		Multiplexer2x1 mu22 = new Multiplexer2x1("MU22","3X1",df1.getOutput(0),getInput(22),
				getOutput(22));
		Multiplexer2x1 mu23 = new Multiplexer2x1("MU23","3X1",df1.getOutput(0),getInput(23),
				getOutput(23));
		Multiplexer2x1 mu24 = new Multiplexer2x1("MU24","3X1",df1.getOutput(0),getInput(24),
				getOutput(24));
		Multiplexer2x1 mu25 = new Multiplexer2x1("MU25","3X1",df1.getOutput(0),getInput(25),
				getOutput(25));
		Multiplexer2x1 mu26 = new Multiplexer2x1("MU26","3X1",df1.getOutput(0),getInput(26),
				getOutput(26));
		Multiplexer2x1 mu27 = new Multiplexer2x1("MU27","3X1",df1.getOutput(0),getInput(27),
				getOutput(27));
		Multiplexer2x1 mu28 = new Multiplexer2x1("MU28","3X1",df1.getOutput(0),getInput(28),
				getOutput(28));
		Multiplexer2x1 mu29 = new Multiplexer2x1("MU29","3X1",df1.getOutput(0),getInput(29),
				getOutput(29));
		Multiplexer2x1 mu30 = new Multiplexer2x1("MU30","3X1",df1.getOutput(0),getInput(30),
				getOutput(30));
		Multiplexer2x1 mu31 = new Multiplexer2x1("MU31","3X1",df1.getOutput(0),getInput(31),
				getOutput(31));
		
		
		
		
		DFlipFlop d0 = new DFlipFlop("D0", clk.getOutput(0),mu0.getOutput(0));
		DFlipFlop d1 = new DFlipFlop("D1", clk.getOutput(0),mu1.getOutput(0));
		DFlipFlop d2 = new DFlipFlop("D2", clk.getOutput(0),mu2.getOutput(0));
		DFlipFlop d3 = new DFlipFlop("D3", clk.getOutput(0),mu3.getOutput(0));
		DFlipFlop d4 = new DFlipFlop("D4", clk.getOutput(0),mu4.getOutput(0));
		DFlipFlop d5 = new DFlipFlop("D5", clk.getOutput(0),mu5.getOutput(0));
		DFlipFlop d6 = new DFlipFlop("D6", clk.getOutput(0),mu6.getOutput(0));
		DFlipFlop d7 = new DFlipFlop("D7", clk.getOutput(0),mu7.getOutput(0));
		DFlipFlop d8 = new DFlipFlop("D8", clk.getOutput(0),mu8.getOutput(0));
		DFlipFlop d9 = new DFlipFlop("D9", clk.getOutput(0),mu9.getOutput(0));
		DFlipFlop d10 = new DFlipFlop("D10", clk.getOutput(0),mu10.getOutput(0));
		DFlipFlop d11 = new DFlipFlop("D11", clk.getOutput(0),mu11.getOutput(0));
		DFlipFlop d12 = new DFlipFlop("D12", clk.getOutput(0),mu12.getOutput(0));
		DFlipFlop d13 = new DFlipFlop("D13", clk.getOutput(0),mu13.getOutput(0));
		DFlipFlop d14 = new DFlipFlop("D14", clk.getOutput(0),mu14.getOutput(0));
		DFlipFlop d15 = new DFlipFlop("D15", clk.getOutput(0),mu15.getOutput(0));
		DFlipFlop d16 = new DFlipFlop("D16", clk.getOutput(0),mu16.getOutput(0));
		DFlipFlop d17 = new DFlipFlop("D17", clk.getOutput(0),mu17.getOutput(0));
		DFlipFlop d18 = new DFlipFlop("D18", clk.getOutput(0),mu18.getOutput(0));
		DFlipFlop d19 = new DFlipFlop("D19", clk.getOutput(0),mu19.getOutput(0));
		DFlipFlop d20 = new DFlipFlop("D20", clk.getOutput(0),mu20.getOutput(0));
		DFlipFlop d21 = new DFlipFlop("D21", clk.getOutput(0),mu21.getOutput(0));
		DFlipFlop d22 = new DFlipFlop("D22", clk.getOutput(0),mu22.getOutput(0));
		DFlipFlop d23 = new DFlipFlop("D23", clk.getOutput(0),mu23.getOutput(0));
		DFlipFlop d24 = new DFlipFlop("D24", clk.getOutput(0),mu24.getOutput(0));
		DFlipFlop d25 = new DFlipFlop("D25", clk.getOutput(0),mu25.getOutput(0));
		DFlipFlop d26 = new DFlipFlop("D26", clk.getOutput(0),mu26.getOutput(0));
		DFlipFlop d27 = new DFlipFlop("D27", clk.getOutput(0),mu27.getOutput(0));
		DFlipFlop d28 = new DFlipFlop("D28", clk.getOutput(0),mu28.getOutput(0));
		DFlipFlop d29 = new DFlipFlop("D29", clk.getOutput(0),mu29.getOutput(0));
		DFlipFlop d30 = new DFlipFlop("D30", clk.getOutput(0),mu30.getOutput(0));
		DFlipFlop d31 = new DFlipFlop("D31", clk.getOutput(0),mu31.getOutput(0));
		
		
		
		
		
		
		//calculate PC+4
		Adder adder0 = new Adder("ADDER0","64X33");
		adder0.addInput(d0.getOutput(0));
		adder0.addInput(d1.getOutput(0));
		adder0.addInput(d2.getOutput(0));
		adder0.addInput(d3.getOutput(0));
		adder0.addInput(d4.getOutput(0));
		adder0.addInput(d5.getOutput(0));
		adder0.addInput(d6.getOutput(0));
		adder0.addInput(d7.getOutput(0));
		adder0.addInput(d8.getOutput(0));
		adder0.addInput(d9.getOutput(0));
		adder0.addInput(d10.getOutput(0));
		adder0.addInput(d11.getOutput(0));
		adder0.addInput(d12.getOutput(0));
		adder0.addInput(d13.getOutput(0));
		adder0.addInput(d14.getOutput(0));
		adder0.addInput(d15.getOutput(0));
		adder0.addInput(d16.getOutput(0));
		adder0.addInput(d17.getOutput(0));
		adder0.addInput(d18.getOutput(0));
		adder0.addInput(d19.getOutput(0));
		adder0.addInput(d20.getOutput(0));
		adder0.addInput(d21.getOutput(0));
		adder0.addInput(d22.getOutput(0));
		adder0.addInput(d23.getOutput(0));
		adder0.addInput(d24.getOutput(0));
		adder0.addInput(d25.getOutput(0));
		adder0.addInput(d26.getOutput(0));
		adder0.addInput(d27.getOutput(0));
		adder0.addInput(d28.getOutput(0));
		adder0.addInput(d29.getOutput(0));
		adder0.addInput(d30.getOutput(0));
		adder0.addInput(d31.getOutput(0));
		for(int i=0 ; i<29 ; i++)
			adder0.addInput(Simulator.falseLogic);
		adder0.addInput(Simulator.trueLogic);
		adder0.addInput(Simulator.falseLogic);
		adder0.addInput(Simulator.falseLogic);
		
		
		
		
		/////////////////////////////////////////////////////////////////////
		
		
		
		 //an example for beq_offset
		Link[] beq_offset = new Link[16];
		for(int i=0 ; i<16 ; i++)
			beq_offset[i]=getInput(i+32);
		
		SignExtend se1 = new SignExtend("SIGNEX1","16X32",beq_offset);
		
		Adder adder1 = new Adder("ADDER1","64X33");
		for(int i=2 ; i<32 ; i++)
			adder1.addInput(se1.getOutput(i));
		adder1.addInput(Simulator.falseLogic);
		adder1.addInput(Simulator.falseLogic);
		
		adder1.addInput(adder0.getOutput(1));
		adder1.addInput(adder0.getOutput(2));
		adder1.addInput(adder0.getOutput(3));
		adder1.addInput(adder0.getOutput(4));
		adder1.addInput(adder0.getOutput(5));
		adder1.addInput(adder0.getOutput(6));
		adder1.addInput(adder0.getOutput(7));
		adder1.addInput(adder0.getOutput(8));
		adder1.addInput(adder0.getOutput(9));
		adder1.addInput(adder0.getOutput(10));
		adder1.addInput(adder0.getOutput(11));
		adder1.addInput(adder0.getOutput(12));
		adder1.addInput(adder0.getOutput(13));
		adder1.addInput(adder0.getOutput(14));
		adder1.addInput(adder0.getOutput(15));
		adder1.addInput(adder0.getOutput(16));
		adder1.addInput(adder0.getOutput(17));
		adder1.addInput(adder0.getOutput(18));
		adder1.addInput(adder0.getOutput(19));
		adder1.addInput(adder0.getOutput(20));
		adder1.addInput(adder0.getOutput(21));
		adder1.addInput(adder0.getOutput(22));
		adder1.addInput(adder0.getOutput(23));
		adder1.addInput(adder0.getOutput(24));
		adder1.addInput(adder0.getOutput(25));
		adder1.addInput(adder0.getOutput(26));
		adder1.addInput(adder0.getOutput(27));
		adder1.addInput(adder0.getOutput(28));
		adder1.addInput(adder0.getOutput(29));
		adder1.addInput(adder0.getOutput(30));
		adder1.addInput(adder0.getOutput(31));
		adder1.addInput(adder0.getOutput(32));
		
		
		
		And and0 = new And("AND0",Simulator.falseLogic,Simulator.falseLogic);
		// the first one is branch flag and the other is zero flag
		
		Multiplexer2x1 mux0 = new Multiplexer2x1("MUX0","3X1",
				and0.getOutput(0),adder0.getOutput(1),adder1.getOutput(1));
		Multiplexer2x1 mux1 = new Multiplexer2x1("MUX1","3X1",
				and0.getOutput(0),adder0.getOutput(2),adder1.getOutput(2));
		Multiplexer2x1 mux2 = new Multiplexer2x1("MUX2","3X1",
				and0.getOutput(0),adder0.getOutput(3),adder1.getOutput(3));
		Multiplexer2x1 mux3 = new Multiplexer2x1("MUX3","3X1",
				and0.getOutput(0),adder0.getOutput(4),adder1.getOutput(4));
		Multiplexer2x1 mux4 = new Multiplexer2x1("MUX4","3X1",
				and0.getOutput(0),adder0.getOutput(5),adder1.getOutput(5));
		Multiplexer2x1 mux5 = new Multiplexer2x1("MUX5","3X1",
				and0.getOutput(0),adder0.getOutput(6),adder1.getOutput(6));
		Multiplexer2x1 mux6 = new Multiplexer2x1("MUX6","3X1",
				and0.getOutput(0),adder0.getOutput(7),adder1.getOutput(7));
		Multiplexer2x1 mux7 = new Multiplexer2x1("MUX7","3X1",
				and0.getOutput(0),adder0.getOutput(8),adder1.getOutput(8));
		Multiplexer2x1 mux8 = new Multiplexer2x1("MUX8","3X1",
				and0.getOutput(0),adder0.getOutput(9),adder1.getOutput(9));
		Multiplexer2x1 mux9 = new Multiplexer2x1("MUX9","3X1",
				and0.getOutput(0),adder0.getOutput(10),adder1.getOutput(10));
		Multiplexer2x1 mux10 = new Multiplexer2x1("MUX10","3X1",
				and0.getOutput(0),adder0.getOutput(11),adder1.getOutput(11));
		Multiplexer2x1 mux11 = new Multiplexer2x1("MUX11","3X1",
				and0.getOutput(0),adder0.getOutput(12),adder1.getOutput(12));
		Multiplexer2x1 mux12 = new Multiplexer2x1("MUX12","3X1",
				and0.getOutput(0),adder0.getOutput(13),adder1.getOutput(13));
		Multiplexer2x1 mux13 = new Multiplexer2x1("MUX13","3X1",
				and0.getOutput(0),adder0.getOutput(14),adder1.getOutput(14));
		Multiplexer2x1 mux14 = new Multiplexer2x1("MUX14","3X1",
				and0.getOutput(0),adder0.getOutput(15),adder1.getOutput(15));
		Multiplexer2x1 mux15 = new Multiplexer2x1("MUX15","3X1",
				and0.getOutput(0),adder0.getOutput(16),adder1.getOutput(16));
		Multiplexer2x1 mux16 = new Multiplexer2x1("MUX16","3X1",
				and0.getOutput(0),adder0.getOutput(17),adder1.getOutput(17));
		Multiplexer2x1 mux17 = new Multiplexer2x1("MUX17","3X1",
				and0.getOutput(0),adder0.getOutput(18),adder1.getOutput(18));
		Multiplexer2x1 mux18 = new Multiplexer2x1("MUX18","3X1",
				and0.getOutput(0),adder0.getOutput(19),adder1.getOutput(19));
		Multiplexer2x1 mux19 = new Multiplexer2x1("MUX19","3X1",
				and0.getOutput(0),adder0.getOutput(20),adder1.getOutput(20));
		Multiplexer2x1 mux20 = new Multiplexer2x1("MUX20","3X1",
				and0.getOutput(0),adder0.getOutput(21),adder1.getOutput(21));
		Multiplexer2x1 mux21 = new Multiplexer2x1("MUX21","3X1",
				and0.getOutput(0),adder0.getOutput(22),adder1.getOutput(22));
		Multiplexer2x1 mux22 = new Multiplexer2x1("MUX22","3X1",
				and0.getOutput(0),adder0.getOutput(23),adder1.getOutput(23));
		Multiplexer2x1 mux23 = new Multiplexer2x1("MUX23","3X1",
				and0.getOutput(0),adder0.getOutput(24),adder1.getOutput(24));
		Multiplexer2x1 mux24 = new Multiplexer2x1("MUX24","3X1",
				and0.getOutput(0),adder0.getOutput(25),adder1.getOutput(25));
		Multiplexer2x1 mux25 = new Multiplexer2x1("MUX25","3X1",
				and0.getOutput(0),adder0.getOutput(26),adder1.getOutput(26));
		Multiplexer2x1 mux26 = new Multiplexer2x1("MUX26","3X1",
				and0.getOutput(0),adder0.getOutput(27),adder1.getOutput(27));
		Multiplexer2x1 mux27 = new Multiplexer2x1("MUX27","3X1",
				and0.getOutput(0),adder0.getOutput(28),adder1.getOutput(28));
		Multiplexer2x1 mux28 = new Multiplexer2x1("MUX28","3X1",
				and0.getOutput(0),adder0.getOutput(29),adder1.getOutput(29));
		Multiplexer2x1 mux29 = new Multiplexer2x1("MUX29","3X1",
				and0.getOutput(0),adder0.getOutput(30),adder1.getOutput(30));
		Multiplexer2x1 mux30 = new Multiplexer2x1("MUX30","3X1",
				and0.getOutput(0),adder0.getOutput(31),adder1.getOutput(31));
		Multiplexer2x1 mux31 = new Multiplexer2x1("MUX31","3X1",
				and0.getOutput(0),adder0.getOutput(32),adder1.getOutput(32));
		
		
/////////////////////////////////////////////////////////
		
		// an example for jmp_offset
		Link[] jmp_offset = new Link[26];
		for(int i=0 ; i<26 ; i++)
			jmp_offset[i]=getInput(i+48);
	
		
		// jump muxs ( the selector(jump flag) is true here )
		
		Multiplexer2x1 mux00 = new Multiplexer2x1("MUX00","3X1",
				Simulator.trueLogic,mux0.getOutput(0),adder0.getOutput(1));
		Multiplexer2x1 mux01 = new Multiplexer2x1("MUX01","3X1",
				Simulator.trueLogic,mux1.getOutput(0),adder0.getOutput(2));
		Multiplexer2x1 mux02 = new Multiplexer2x1("MUX02","3X1",
				Simulator.trueLogic,mux2.getOutput(0),adder0.getOutput(3));
		Multiplexer2x1 mux03 = new Multiplexer2x1("MUX03","3X1",
				Simulator.trueLogic,mux3.getOutput(0),adder0.getOutput(4));
		Multiplexer2x1 mux04 = new Multiplexer2x1("MUX04","3X1",
				Simulator.trueLogic,mux4.getOutput(0),jmp_offset[0]);
		Multiplexer2x1 mux05 = new Multiplexer2x1("MUX05","3X1",
				Simulator.trueLogic,mux5.getOutput(0),jmp_offset[1]);
		Multiplexer2x1 mux06 = new Multiplexer2x1("MUX06","3X1",
				Simulator.trueLogic,mux6.getOutput(0),jmp_offset[2]);
		Multiplexer2x1 mux07 = new Multiplexer2x1("MUX07","3X1",
				Simulator.trueLogic,mux7.getOutput(0),jmp_offset[3]);
		Multiplexer2x1 mux08 = new Multiplexer2x1("MUX08","3X1",
				Simulator.trueLogic,mux8.getOutput(0),jmp_offset[4]);
		Multiplexer2x1 mux09 = new Multiplexer2x1("MUX09","3X1",
				Simulator.trueLogic,mux9.getOutput(0),jmp_offset[5]);
		Multiplexer2x1 mux010 = new Multiplexer2x1("MUX010","3X1",
				Simulator.trueLogic,mux10.getOutput(0),jmp_offset[6]);
		Multiplexer2x1 mux011 = new Multiplexer2x1("MUX011","3X1",
				Simulator.trueLogic,mux11.getOutput(0),jmp_offset[7]);
		Multiplexer2x1 mux012 = new Multiplexer2x1("MUX012","3X1",
				Simulator.trueLogic,mux12.getOutput(0),jmp_offset[8]);
		Multiplexer2x1 mux013 = new Multiplexer2x1("MUX013","3X1",
				Simulator.trueLogic,mux13.getOutput(0),jmp_offset[9]);
		Multiplexer2x1 mux014 = new Multiplexer2x1("MUX014","3X1",
				Simulator.trueLogic,mux14.getOutput(0),jmp_offset[10]);
		Multiplexer2x1 mux015 = new Multiplexer2x1("MUX015","3X1",
				Simulator.trueLogic,mux15.getOutput(0),jmp_offset[11]);
		Multiplexer2x1 mux016 = new Multiplexer2x1("MUX016","3X1",
				Simulator.trueLogic,mux16.getOutput(0),jmp_offset[12]);
		Multiplexer2x1 mux017 = new Multiplexer2x1("MUX017","3X1",
				Simulator.trueLogic,mux17.getOutput(0),jmp_offset[13]);
		Multiplexer2x1 mux018 = new Multiplexer2x1("MUX018","3X1",
				Simulator.trueLogic,mux18.getOutput(0),jmp_offset[14]);
		Multiplexer2x1 mux019 = new Multiplexer2x1("MUX019","3X1",
				Simulator.trueLogic,mux19.getOutput(0),jmp_offset[15]);
		Multiplexer2x1 mux020 = new Multiplexer2x1("MUX020","3X1",
				Simulator.trueLogic,mux20.getOutput(0),jmp_offset[16]);
		Multiplexer2x1 mux021 = new Multiplexer2x1("MUX021","3X1",
				Simulator.trueLogic,mux21.getOutput(0),jmp_offset[17]);
		Multiplexer2x1 mux022 = new Multiplexer2x1("MUX022","3X1",
				Simulator.trueLogic,mux22.getOutput(0),jmp_offset[18]);
		Multiplexer2x1 mux023 = new Multiplexer2x1("MUX023","3X1",
				Simulator.trueLogic,mux23.getOutput(0),jmp_offset[19]);
		Multiplexer2x1 mux024 = new Multiplexer2x1("MUX024","3X1",
				Simulator.trueLogic,mux24.getOutput(0),jmp_offset[20]);
		Multiplexer2x1 mux025 = new Multiplexer2x1("MUX025","3X1",
				Simulator.trueLogic,mux25.getOutput(0),jmp_offset[21]);
		Multiplexer2x1 mux026 = new Multiplexer2x1("MUX026","3X1",
				Simulator.trueLogic,mux26.getOutput(0),jmp_offset[22]);
		Multiplexer2x1 mux027 = new Multiplexer2x1("MUX027","3X1",
				Simulator.trueLogic,mux27.getOutput(0),jmp_offset[23]);
		Multiplexer2x1 mux028 = new Multiplexer2x1("MUX028","3X1",
				Simulator.trueLogic,mux28.getOutput(0),jmp_offset[24]);
		Multiplexer2x1 mux029 = new Multiplexer2x1("MUX029","3X1",
				Simulator.trueLogic,mux29.getOutput(0),jmp_offset[25]);
		Multiplexer2x1 mux030 = new Multiplexer2x1("MUX030","3X1",
				Simulator.trueLogic,mux30.getOutput(0),Simulator.falseLogic);
		Multiplexer2x1 mux031 = new Multiplexer2x1("MUX031","3X1",
				Simulator.trueLogic,mux31.getOutput(0),Simulator.falseLogic);
		
		
		
		// see the new PC address
		
		addOutput(mux00.getOutput(0),mux01.getOutput(0),mux02.getOutput(0),
				mux03.getOutput(0),mux04.getOutput(0),mux05.getOutput(0),
				mux06.getOutput(0),mux07.getOutput(0),mux08.getOutput(0),
				mux09.getOutput(0),mux010.getOutput(0),mux011.getOutput(0),
				mux012.getOutput(0),mux013.getOutput(0),mux014.getOutput(0),
				mux015.getOutput(0),mux016.getOutput(0),mux017.getOutput(0),
				mux018.getOutput(0),mux019.getOutput(0),mux020.getOutput(0),
				mux021.getOutput(0),mux022.getOutput(0),mux023.getOutput(0),
				mux024.getOutput(0),mux025.getOutput(0),mux026.getOutput(0),
				mux027.getOutput(0),mux028.getOutput(0),mux029.getOutput(0),
				mux030.getOutput(0),mux031.getOutput(0));
		
		
	}
	

}
