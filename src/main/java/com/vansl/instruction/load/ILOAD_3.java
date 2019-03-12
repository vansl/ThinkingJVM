package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ILOAD_3 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        ILOAD.iload(frame,3);
    }
}
