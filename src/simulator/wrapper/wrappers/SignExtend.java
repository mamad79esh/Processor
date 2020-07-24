package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class SignExtend extends Wrapper {

    public SignExtend(String label, String stream, Link ...links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

//		for(int i=0 ; i<16 ; i++) {
//			getOutputs().set(i , (getInputs().get(0)));
//		}
//
//		for(int i=16 ; i<32 ; i++) {
//			getOutputs().set(i , (getInputs().get(i-15)));
//		}


        for(int i=0 ; i<16 ; i++)
            addOutput(getInput(0));

        for(int i=16 ; i<32 ; i++)
            addOutput(getInput(i-16));


    }



}
