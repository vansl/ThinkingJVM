package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ISTORE_0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        ISTORE.istore(frame,0);
    }
}
