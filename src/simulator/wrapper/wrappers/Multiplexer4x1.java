package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Multiplexer4x1 extends Wrapper {


    public Multiplexer4x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Multiplexer2x1 m1 = new Multiplexer2x1("MUX1","3x1",getInput(1),getInput(2),getInput(3));
        Multiplexer2x1 m2 = new Multiplexer2x1("MUX2","3x1",getInput(1),getInput(4),getInput(5));
        Multiplexer2x1 m3 = new Multiplexer2x1("MUX3","3x1",getInput(0),m1.getOutput(0),m2.getOutput(0));

        addOutput(m3.getOutput(0));

    }
}
