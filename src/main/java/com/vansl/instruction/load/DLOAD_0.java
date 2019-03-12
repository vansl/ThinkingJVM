package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DLOAD_0 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        DLOAD.dload(frame,0);
    }
}
