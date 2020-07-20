package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Multiplexer2x1 extends Wrapper {


    public Multiplexer2x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And and1 = new And("AND1");
        And and2 = new And("AND2");
        Or or1 = new Or("OR1");
        Not not1 = new Not("Not1");
        not1.addInput(getInput(0));
        and1.addInput(getInput(1),not1.getOutput(0));
        and2.addInput(getInput(0),getInput(2));
        or1.addInput(and1.getOutput(0),and2.getOutput(0));
        addOutput(or1.getOutput(0));
    }
}
