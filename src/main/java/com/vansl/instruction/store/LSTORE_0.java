package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class LSTORE_0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        LSTORE.lstore(frame,0);
    }
}
