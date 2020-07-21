package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Multiplexer32x1 extends Wrapper {

    public Multiplexer32x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Multiplexer16x1 m1 = new Multiplexer16x1("mux1","20x1",getInput(1),getInput(2),getInput(3),getInput(4));
        Multiplexer16x1 m2 = new Multiplexer16x1("mux2","20x1",getInput(1),getInput(2),getInput(3),getInput(4));
        Multiplexer2x1 m3 = new Multiplexer2x1("mux2","3x1",getInput(0));

        for (int i = 5 ; i < 21 ; i++){
            m1.addInput(getInput(i));
        }

        for (int i = 21 ; i < 37 ; i++){
            m2.addInput(getInput(i));
        }


        m3.addInput(m1.getOutput(0),m2.getOutput(0));
        addOutput(m3.getOutput(0));
    }
}
