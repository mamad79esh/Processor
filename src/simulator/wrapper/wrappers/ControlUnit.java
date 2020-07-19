package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ControlUnit extends Wrapper {

    public ControlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Link op0,op1,op2,op3,op4,op5;
        op0 = getInput(5);
        op1 = getInput(4);
        op2 = getInput(3);
        op3 = getInput(2);
        op4 = getInput(1);
        op5 = getInput(0);
        Not not0 = new Not("Not0" , op0);
        Not not1 = new Not("Not1" , op1);
        Not not2 = new Not("Not2" , op2);
        Not not3 = new Not("Not3" , op3);
        Not not4 = new Not("Not4" , op4);
        Not not5 = new Not("Not5" , op5);

        And R_format = new And("R-format-AND",not0.getOutput(0),not1.getOutput(0),not2.getOutput(0),not3.getOutput(0),not4.getOutput(0),not5.getOutput(0));
        And lw = new And("Lw-AND",op0,op1,not2.getOutput(0),not3.getOutput(0),not4.getOutput(0),op5);
        And sw = new And("R-format-AND",op0,op1,not2.getOutput(0),op3,not4.getOutput(0),op5);
        And beq = new And("R-format-AND",not0.getOutput(0),not1.getOutput(0),op2,not3.getOutput(0),not4.getOutput(0),not5.getOutput(0));

        Or aluSrc = new Or("Or1",lw.getOutput(0),sw.getOutput(0));
        Or regWrite = new Or("Or1",lw.getOutput(0),R_format.getOutput(0));

        addOutput(R_format.getOutput(0));//         RegDst
        addOutput(aluSrc.getOutput(0));//           ALUSrc
        addOutput(lw.getOutput(0));//               MemToReg
        addOutput(regWrite.getOutput(0));//         RegWrite
        addOutput(lw.getOutput(0));//               MemRead
        addOutput(sw.getOutput(0));//               MemWrite
        addOutput(beq.getOutput(0));//              Branch
        addOutput(R_format.getOutput(0));//   ALUOp1
        addOutput(beq.getOutput(0));//              ALUOp2
    }

}
