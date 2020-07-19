package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder3X8 extends Wrapper {

    public Decoder3X8(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Link enable = getInput(0);
        Link c = getInput(1);// MSB
        Link b = getInput(2);
        Link a = getInput(3);// LSB

        Not not_a = new Not("Not_A",a);
        Not not_b = new Not("Not_B",b);
        Not not_c = new Not("Not_C",c);

        And and0 = new And("And0",not_a.getOutput(0),not_b.getOutput(0),not_c.getOutput(0),enable);
        And and1 = new And("And1",a,not_b.getOutput(0),not_c.getOutput(0),enable);
        And and2 = new And("And2",not_a.getOutput(0),b,not_c.getOutput(0),enable);
        And and3 = new And("And3",a,b,not_c.getOutput(0),enable);
        And and4 = new And("And4",not_a.getOutput(0),not_b.getOutput(0),c,enable);
        And and5 = new And("And5",a,not_b.getOutput(0),c,enable);
        And and6 = new And("And6",not_a.getOutput(0),b,c,enable);
        And and7 = new And("And7",a,b,c,enable);

        addOutput(and0.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and2.getOutput(0));
        addOutput(and3.getOutput(0));
        addOutput(and4.getOutput(0));
        addOutput(and5.getOutput(0));
        addOutput(and6.getOutput(0));
        addOutput(and7.getOutput(0));

    }
}
