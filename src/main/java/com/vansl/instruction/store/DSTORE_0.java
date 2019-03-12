package com.vansl.instruction.store;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DSTORE_0 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        DSTORE.dstore(frame,0);
    }
}
