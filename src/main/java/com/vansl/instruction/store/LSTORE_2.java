package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class LSTORE_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        LSTORE.lstore(frame,2);
    }
}
