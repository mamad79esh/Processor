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

        Boolean [][]instrucions = new Boolean[32][32];
        // add instructions here



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

        pcUpdate.addInput(alu.getInput(0));// add zero flag
        pcUpdate.addInput(controlUnit.getOutput(6));// add branch flag
        pcUpdate.addInput(controlUnit.getOutput(7));// add jump flag


        //--------------------------------------------------------------------------------------------------------------
        // Connecting instruction memory
        instructionMemory.addInput(Simulator.falseLogic);
        for(int i = 16 ; i < 32 ; i++)// add address to fetch instruction
            instructionMemory.addInput(pcUpdate.getOutput(i));

        for(int i = 16 ; i < 32 ; i++)// add don't care data
            instructionMemory.addInput(Simulator.falseLogic);

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
        for (int i = 0 ; i < 5 ; i++){// add opcode to control unit
            controlUnit.addInput(instructionMemory.getOutput(i));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting alu control
        aluControl.addInput(controlUnit.getOutput(8),clock.getOutput(9));// add aluOp
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
        for (int i = 16 ; i < 32 ; i++){// add address
            dataMemory.addInput(alu.getOutput(i));
        }
        for (int i = 0 ; i < 32 ; i++){// add write data
            dataMemory.addInput(registerFile.getOutput(32+i));
        }

        //--------------------------------------------------------------------------------------------------------------
        // Connecting write back mux
        for (int i = 0 ; i < 32 ; i++) {
            writeRegisterData[i].addInput(controlUnit.getOutput(2));// selector(MemToReg)
            writeRegisterData[i].addInput(alu.getOutput(i), dataMemory.getOutput(i)); // inputs
        }

        //--------------------------------------------------------------------------------------------------------------



        Simulator.debugger.addTrackItem(clock,dataMemory,registerFile);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}