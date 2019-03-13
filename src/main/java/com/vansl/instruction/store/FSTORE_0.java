package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class FSTORE_0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FSTORE.fstore(frame,0);
    }
}
