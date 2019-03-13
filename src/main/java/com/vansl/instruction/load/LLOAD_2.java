package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class LLOAD_2 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        LLOAD.lload(frame,2);
    }
}
