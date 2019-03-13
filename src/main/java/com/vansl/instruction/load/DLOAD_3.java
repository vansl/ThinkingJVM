package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DLOAD_3 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        DLOAD.dload(frame,3);
    }
}
