//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        ByteMemory m = new ByteMemory("t");
        m.addInput(Simulator.trueLogic);
        for(int i=0 ;i<16;i++ )
            m.addInput(Simulator.falseLogic);
        for(int i=0 ;i<32;i++ )
            m.addInput(Simulator.trueLogic);

        Simulator.debugger.addTrackItem(m);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}

