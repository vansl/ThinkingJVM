package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class FSTORE_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        FSTORE.fstore(frame,2);
    }
}
