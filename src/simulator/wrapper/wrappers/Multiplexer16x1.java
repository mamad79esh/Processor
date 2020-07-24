package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Multiplexer16x1 extends Wrapper {

    public Multiplexer16x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Multiplexer8x1 m1 = new Multiplexer8x1("mux1","11x1",getInput(1),getInput(2),getInput(3));
        Multiplexer8x1 m2 = new Multiplexer8x1("mux2","11x1",getInput(1),getInput(2),getInput(3));
        Multiplexer2x1 m3 = new Multiplexer2x1("mux3","3x1",getInput(0));
        m1.addInput(getInput(4),getInput(5),getInput(6),getInput(7),getInput(8),getInput(9),getInput(10),getInput(11));
        m2.addInput(getInput(12),getInput(13),getInput(14),getInput(15),getInput(16),getInput(17),getInput(18),getInput(19));

        m3.addInput(m1.getOutput(0),m2.getOutput(0));
        addOutput(m3.getOutput(0));
    }
}
