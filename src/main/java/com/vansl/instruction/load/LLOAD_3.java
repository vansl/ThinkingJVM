package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class LLOAD_3 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        LLOAD.lload(frame,3);
    }
}
