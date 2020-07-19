package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Multiplexer8x1 extends Wrapper {


    public Multiplexer8x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Multiplexer4x1 m1 = new Multiplexer4x1("MUX1","6x1",getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6));
        Multiplexer4x1 m2 = new Multiplexer4x1("MUX1","6x1",getInput(1),getInput(2),getInput(7),getInput(8),getInput(9),getInput(10));
        Multiplexer2x1 m3 = new Multiplexer2x1("MUX1","3x1",getInput(0),m1.getOutput(0),m2.getOutput(0));

        addOutput(m3.getOutput(0));
    }
}
