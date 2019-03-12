package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ASTORE_3 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        ASTORE.astore(frame,3);
    }
}
