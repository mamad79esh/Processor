package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder5X32 extends Wrapper {

    public Decoder5X32(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Link a = getInput(0);
        Link b = getInput(1);
        Link c = getInput(2);
        Link d = getInput(3);
        Link e = getInput(4);

        Decoder3X8 d0 = new Decoder3X8("Dec_0","4X8",Simulator.trueLogic,Simulator.falseLogic,a,b);
        Decoder3X8 d1 = new Decoder3X8("Dec_1","4X8",d0.getOutput(0),c,d,e);
        Decoder3X8 d2 = new Decoder3X8("Dec_2","4X8",d0.getOutput(1),c,d,e);
        Decoder3X8 d3 = new Decoder3X8("Dec_3","4X8",d0.getOutput(2),c,d,e);
        Decoder3X8 d4 = new Decoder3X8("Dec_4","4X8",d0.getOutput(3),c,d,e);

        addOutput(d1.getOutput(0));
        addOutput(d1.getOutput(1));
        addOutput(d1.getOutput(2));
        addOutput(d1.getOutput(3));
        addOutput(d1.getOutput(4));
        addOutput(d1.getOutput(5));
        addOutput(d1.getOutput(6));
        addOutput(d1.getOutput(7));

        addOutput(d2.getOutput(0));
        addOutput(d2.getOutput(1));
        addOutput(d2.getOutput(2));
        addOutput(d2.getOutput(3));
        addOutput(d2.getOutput(4));
        addOutput(d2.getOutput(5));
        addOutput(d2.getOutput(6));
        addOutput(d2.getOutput(7));

        addOutput(d3.getOutput(0));
        addOutput(d3.getOutput(1));
        addOutput(d3.getOutput(2));
        addOutput(d3.getOutput(3));
        addOutput(d3.getOutput(4));
        addOutput(d3.getOutput(5));
        addOutput(d3.getOutput(6));
        addOutput(d3.getOutput(7));

        addOutput(d4.getOutput(0));
        addOutput(d4.getOutput(1));
        addOutput(d4.getOutput(2));
        addOutput(d4.getOutput(3));
        addOutput(d4.getOutput(4));
        addOutput(d4.getOutput(5));
        addOutput(d4.getOutput(6));
        addOutput(d4.getOutput(7));

    }
}