//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

public class Processor {
    public static void main(String[] args) {
       // Creating needed wrapper :

        Clock clock = new Clock("Clock",1000);

        PCUpdate pcUpdate = new PCUpdate("PCUpdate","78x32");

        ByteMemory instructionMemory = new ByteMemory("InstructionMemory");

        Multiplexer2x1 []registerFileInput = new Multiplexer2x1[5];
        for (int i = 0 ; i < 5 ; i++)
            registerFileInput[i] = new Multiplexer2x1("RegisterFileInput_"+i,"3x1");

        ControlUnit controlUnit = new ControlUnit("ControlUnit","6X10");

        RegisterFile registerFile = new RegisterFile("RegisterFile","49x64");

        ALUControl aluControl = new ALUControl("ALUControl","8X4");

        SignExtend immediate = new SignExtend("Immediate","16X32");

        Multiplexer2x1 []aluInput = new Multiplexer2x1[32];
        for (int i = 0 ; i < 32 ; i++)
            aluInput[i] = new Multiplexer2x1("ALUInput_"+i,"3x1");

        ALU alu = new ALU("ALU","68X33");

        ByteMemory dataMemory = new ByteMemory("DataMemory");

        Multiplexer2x1 []writeRegisterData = new Multiplexer2x1[32];
        for (int i = 0 ; i < 32 ; i++)
             writeRegisterData[i] = new Multiplexer2x1("WriteRegisterData_"+i,"3X1");



        //--------------------------------------------------------------------------------------------------------------
        // Pushing instructions to instruction memory
        Link []startAddress = new Link[32];
        for( int i = 0 ; i < 32 ; i++)
            startAddress[i] = Simulator.falseLogic;

        Boolean [][]instrucions = new Boolean[65536][8];
        // add instructions here
        
       
        for(int i=0 ; i<65536 ; i++) 
        	for(int j=0 ; j<8 ; j++) 
        		instrucions[i][j] = false;
        
        
        // sw $t0,0($t1)
        // lw $t0,0($t1)
        instrucions[4][0] = true;    instrucions[4][1] = false;
        instrucions[4][2] = true;    instrucions[4][3] = false;
        instrucions[4][4] = true;    instrucions[4][5] = true;
        instrucions[4][6] = false;    instrucions[4][7] = true;
        
        instrucions[5][0] = false;    instrucions[5][1] = false;
        instrucions[5][2] = true;     instrucions[5][3] = false;
        instrucions[5][4] = true;    instrucions[5][5] = false;
        instrucions[5][6] = false;   instrucions[5][7] = false;
        
        instrucions[6][0] = false;    instrucions[6][1] = false;
        instrucions[6][2] = false;     instrucions[6][3] = false;
        instrucions[6][4] = false;    instrucions[6][5] = false;
        instrucions[6][6] = false;   instrucions[6][7] = false;
        
        instrucions[7][0] = false;    instrucions[7][1] = false;
        instrucions[7][2] = false;     instrucions[7][3] = false;
        instrucions[7][4] = false;    instrucions[7][5] = false;
        instrucions[7][6] = false;   instrucions[7][7] = false;
        
        /////////////////////////////////////////////////////////
        
        
        instrucions[8][0] = true;     instrucions[8][1] = false;
        instrucions[8][2] = false;    instrucions[8][3] = false;
        instrucions[8][4] = true;     instrucions[8][5] = true;
        instrucions[8][6] = false;    instrucions[8][7] = true;
        
        instrucions[9][0] = false;    instrucions[9][1] = false;
        instrucions[9][2] = true;     instrucions[9][3] = false;
        instrucions[9][4] = true;     instrucions[9][5] = false;
        instrucions[9][6] = false;    instrucions[9][7] = false;
        
        instrucions[10][0] = false;    instrucions[10][1] = false;
        instrucions[10][2] = false;    instrucions[10][3] = false;
        instrucions[10][4] = false;    instrucions[10][5] = false;
        instrucions[10][6] = false;    instrucions[10][7] = false;
        
        instrucions[11][0] = false;    instrucions[11][1] = false;
        instrucions[11][2] = false;    instrucions[11][3] = false;
        instrucions[11][4] = false;    instrucions[11][5] = false;
        instrucions[11][6] = false;    instrucions[11][7] = false;
        
        
        
        
//        instrucions[0][0] = true;    instrucions[0][1] = false;
//        instrucions[0][2] = false;    instrucions[0][3] = false;
//        instrucions[0][4] = true;    instrucions[0][5] = true;
//        
//        instrucions[0][6] = false;    instrucions[0][7] = true;
//        instrucions[0][8] = false;    instrucions[0][9] = false;
//        instrucions[0][10] = true;
//        
//        instrucions[0][11] = false;    instrucions[0][12] = true;
//        instrucions[0][13] = false;    instrucions[0][14] = false;
//        instrucions[0][15] = false;
//        
//        for(int i=16 ; i<32 ; i++)
//        	instrucions[0][i] = false;



        instructionMemory.setMemory(instrucions);
        // end of creation
        //--------------------------------------------------------------------------------------------------------------
        // Connecting gates and wrappers together


        // Connecting PCUpdate
        pcUpdate.addInput(clock.getOutput(0));// add clock for pc
        pcUpdate.addInput(startAddress);// add start address for fetch instruction
        for (int i = 16 ; i < 32 ; i++) {// add branch offset
            pcUpdate.addInput(instructionMemory.getOutput(i));
        }
        for (int i = 6; i < 32 ; i++)// add jump address
            pcUpdate.addInput(instructionMemory.getOutput(i));

        pcUpdate.addInput(alu.getOutput(0));// add zero flag
        pcUpdate.addInput(controlUnit.getOutput(6));// add branch flag
        pcUpdate.addInput(controlUnit.getOutput(7));// add jump flag


        //--------------------------------------------------------------------------------------------------------------
        // Connecting instruction memory
        instructionMemory.addInput(Simulator.falseLogic);
        
//        for(int i = 16 ; i < 32 ; i++)// add don't care data
//            instructionMemory.addInput(Simulator.falseLogic);
        
        for(int i = 16 ; i < 32 ; i++)// add address to fetch instruction
            instructionMemory.addInput(pcUpdate.getOutput(i));

        
        //--------------------------------------------------------------------------------------------------------------
        // Connecting register file input
        for (int i = 0 ; i < 5 ; i++) { // register file mux inputs
            registerFileInput[i].addInput(controlUnit.getOutput(0));// selector(RegDest)
            registerFileInput[i].addInput(instructionMemory.getOutput(11+i),instructionMemory.getOutput(16+i));// rs,rt
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting register file
        registerFile.addInput(clock.getOutput(0));// add clock
        registerFile.addInput(controlUnit.getOutput(3));// add write signal(RegWrite)
        for (int i = 0 ; i < 5 ; i++) { // register file write register
            registerFile.addInput(registerFileInput[i].getOutput(0));
        }
        for (int i = 0 ; i < 5 ; i++) { // register file first read register
            registerFile.addInput(instructionMemory.getOutput(11+i));
        }
        for (int i = 0 ; i < 5 ; i++) { // register file second read register
            registerFile.addInput(instructionMemory.getOutput(6+i));
        }
        for (int i = 0 ; i < 32 ; i++){// write register data
            registerFile.addInput(writeRegisterData[i].getOutput(0));
        }


        //--------------------------------------------------------------------------------------------------------------
        // Connecting control unit
        for (int i = 0 ; i < 6 ; i++){// add opcode to control unit
            controlUnit.addInput(instructionMemory.getOutput(i));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting alu control
        aluControl.addInput(controlUnit.getOutput(8),controlUnit.getOutput(9));// add aluOp
        for (int i = 0 ; i < 6 ; i++) // add funct
            aluControl.addInput(instructionMemory.getOutput(26+i));


        //--------------------------------------------------------------------------------------------------------------
        // Connecting signExtend for immediate input
        for (int i = 16 ; i < 32 ; i++) {// add branch offset
            immediate.addInput(instructionMemory.getOutput(i));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting alu second input mux
        for (int i = 0 ; i < 32 ; i++){// add alu input
            aluInput[i].addInput(controlUnit.getOutput(1));// selector(AluSrc)
            aluInput[i].addInput(registerFile.getOutput(32+i),immediate.getOutput(i));// from register or immediate
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting alu
        for (int i = 0 ; i < 4 ; i++) // add aluControl to alu
            alu.addInput(aluControl.getOutput(i));

        for (int i = 0 ; i < 32 ; i++){// add first input from register file
            alu.addInput(registerFile.getInput(i));
        }

        for (int i = 0 ; i < 32 ; i++){// add second input form mux
            alu.addInput(aluInput[i].getOutput(0));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting data memory
        dataMemory.addInput(controlUnit.getOutput(5));// write flag
        for (int i = 1 ; i < 33 ; i++){// add address
            dataMemory.addInput(alu.getOutput(i));
        }
        for (int i = 0 ; i < 32 ; i++){// add write data
            dataMemory.addInput(registerFile.getOutput(32+i));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting write back mux
        for (int i = 0 ; i < 32 ; i++) {
            writeRegisterData[i].addInput(controlUnit.getOutput(2));// selector(MemToReg)
            writeRegisterData[i].addInput(alu.getOutput(i+1), dataMemory.getOutput(i)); // inputs
        }

        //--------------------------------------------------------------------------------------------------------------



        Simulator.debugger.addTrackItem(clock,dataMemory,registerFile,alu,instructionMemory,
        		pcUpdate,controlUnit,aluControl,immediate);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}