package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DSTORE_3 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        DSTORE.dstore(frame,3);
    }
}
