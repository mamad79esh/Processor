package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ALUControl extends Wrapper {
    public ALUControl(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //Input and output is a link...
    //Se consideran 8 bits de entrada, los primeros dos bits ALUOp   6 bits son funciones
    //outputs is 4 bits
    @Override
    public void initialize() {
        And CLwSw =new And("lwsw");
        And  Cbeq =new And("beq");
        And Cadd=new And("add");
        And Csub=new And("sub");
        And CAND=new And("AND");
        And COR=new And("OR");
        And CSetOnLessThan=new And("slt");

        And LwSw0=new And("s0");
        And LwSw1=new And("s1");
        And LwSw2=new And("s2");
        And LwSw3=new And("s2");

        And beq0=new And("be0");
        And beq1=new And("be1");
        And beq2=new And("be2");
        And beq3=new And("be3");

        And add0=new And("add0");
        And add1=new And("add1");
        And add2=new And("add2");
        And add3=new And("add3");

        And sub0=new And("sub0");
        And sub1=new And("sub1");
        And sub2=new And("sub2");
        And sub3=new And("sub3");

        And and0=new And("and0");
        And and1=new And("and1");
        And and2=new And("and2");
        And and3=new And("and3");

        And or0=new And("or0");
        And or1=new And("or1");
        And or2=new And("or2");
        And or3=new And("or3");

        And slt0=new And("slt0");
        And slt1=new And("slt1");
        And slt2=new And("slt2");
        And slt3=new And("slt3");

        Or r0=new Or("r0");
        Or r1=new Or("r1");
        Or r2=new Or("r2");
        Or r3=new Or("r3");

        Not notA=new Not("notA");
        notA.addInput(getInput(0));
        Not notB=new Not("notB");
        notB.addInput(getInput(1));
        Not notC=new Not("notC");
        notC.addInput(getInput(2));
        Not notD=new Not("notD");
        notD.addInput(getInput(3));
        Not notE=new Not("notE");
        notE.addInput(getInput(4));
        Not notF=new Not("notF");
        notF.addInput(getInput(5));
        Not notG=new Not("notG");
        notG.addInput(getInput(6));
        Not notH=new Not("notH");
        notH.addInput(getInput(7));

        CLwSw.addInput(notA.getOutput(0),notB.getOutput(0));
        Cbeq.addInput(notA.getOutput(0),getInput(1));
        Cadd.addInput(getInput(0),notB.getOutput(0),getInput(2),notD.getOutput(0),notE.getOutput(0),
                notF.getOutput(0),notG.getOutput(0),notH.getOutput(0));
        Csub.addInput(getInput(0),notB.getOutput(0),getInput(2),notD.getOutput(0),notE.getOutput(0),
                notF.getOutput(0),getInput(6),notH.getOutput(0));

        CAND.addInput(getInput(0),notB.getOutput(0),getInput(2),notD.getOutput(0),notE.getOutput(0),
                getInput(5),notG.getOutput(0),notH.getOutput(0));
        COR.addInput(getInput(0),notB.getOutput(0),getInput(2),notD.getOutput(0),notE.getOutput(0),
                getInput(5),notG.getOutput(0),getInput(7));
        CSetOnLessThan.addInput(getInput(0),notB.getOutput(0),getInput(2),notD.getOutput(0),getInput(4),
                notF.getOutput(0),getInput(6),notH.getOutput(0));

        LwSw0.addInput(CLwSw.getOutput(0),Simulator.falseLogic);
        LwSw1.addInput(CLwSw.getOutput(0),Simulator.falseLogic);
        LwSw2.addInput(CLwSw.getOutput(0),Simulator.trueLogic);
        LwSw3.addInput(CLwSw.getOutput(0),Simulator.falseLogic);

        beq0.addInput(Cbeq.getOutput(0),Simulator.falseLogic);
        beq1.addInput(Cbeq.getOutput(0),Simulator.trueLogic);
        beq2.addInput(Cbeq.getOutput(0),Simulator.trueLogic);
        beq3.addInput(Cbeq.getOutput(0),Simulator.falseLogic);

        add0.addInput(Cadd.getOutput(0),Simulator.falseLogic);
        add1.addInput(Cadd.getOutput(0),Simulator.falseLogic);
        add2.addInput(Cadd.getOutput(0),Simulator.trueLogic);
        add3.addInput(Cadd.getOutput(0),Simulator.falseLogic);

        sub0.addInput(Csub.getOutput(0),Simulator.falseLogic);
        sub1.addInput(Csub.getOutput(0),Simulator.trueLogic);
        sub2.addInput(Csub.getOutput(0),Simulator.trueLogic);
        sub3.addInput(Csub.getOutput(0),Simulator.falseLogic);

        and0.addInput(CAND.getOutput(0),Simulator.falseLogic);
        and1.addInput(CAND.getOutput(0),Simulator.falseLogic);
        and2.addInput(CAND.getOutput(0),Simulator.falseLogic);
        and3.addInput(CAND.getOutput(0),Simulator.falseLogic);

        or0.addInput(COR.getOutput(0),Simulator.falseLogic);
        or1.addInput(COR.getOutput(0),Simulator.falseLogic);
        or2.addInput(COR.getOutput(0),Simulator.falseLogic);
        or3.addInput(COR.getOutput(0),Simulator.trueLogic);

        slt0.addInput(CSetOnLessThan.getOutput(0),Simulator.falseLogic);
        slt1.addInput(CSetOnLessThan.getOutput(0),Simulator.trueLogic);
        slt2.addInput(CSetOnLessThan.getOutput(0),Simulator.trueLogic);
        slt3.addInput(CSetOnLessThan.getOutput(0),Simulator.trueLogic);

        r0.addInput(LwSw0.getOutput(0),beq0.getOutput(0),add0.getOutput(0),sub0.getOutput(0),
                and0.getOutput(0),or0.getOutput(0),slt0.getOutput(0));
        r1.addInput(LwSw1.getOutput(0),beq1.getOutput(0),add1.getOutput(0),sub1.getOutput(0),
                and1.getOutput(0),or1.getOutput(0),slt1.getOutput(0));
        r2.addInput(LwSw2.getOutput(0),beq2.getOutput(0),add2.getOutput(0),sub2.getOutput(0),
                and2.getOutput(0),or2.getOutput(0),slt2.getOutput(0));
        r3.addInput(LwSw3.getOutput(0),beq3.getOutput(0),add3.getOutput(0),sub3.getOutput(0),
                and3.getOutput(0),or3.getOutput(0),slt3.getOutput(0));

        addOutput(r0.getOutput(0),r1.getOutput(0),r2.getOutput(0),r3.getOutput(0));

    }
}