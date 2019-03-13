package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ASTORE_2 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        ASTORE.astore(frame,2);
    }
}
