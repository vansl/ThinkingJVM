package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class FLOAD_3 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        FLOAD.fload(frame,3);
    }
}
