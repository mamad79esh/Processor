//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        ALU te = new ALU("tr","68X33",Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic);
        for (int j=0;j<32;j++){
            te.addInput(Simulator.falseLogic);
        }
        for (int j=0;j<32;j++){
            te.addInput(Simulator.trueLogic);
        }
        Link[] inp = new Link[32];

        for (int j=0; j<32 ; j++){
            inp[j] = Simulator.trueLogic ;

        }
        Twos_complement te1 = new Twos_complement("tr","32X32",inp);

        Simulator.debugger.addTrackItem(te);
        Simulator.debugger.setDelay(2000);
        Simulator.circuit.startCircuit();
    }
}