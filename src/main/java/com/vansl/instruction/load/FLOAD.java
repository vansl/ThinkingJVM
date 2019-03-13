package com.vansl.instruction.load;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class FLOAD extends Index8Instruction {

    // FLOAD指令公用代码
    public static void fload(Frame frame,int index) {
        float val = frame.getLocalVars().getFloat(index);
        frame.getOperandStack().pushFloat(val);
    }
    @Override
    public void execute(Frame frame) {
        fload(frame,this.index);
    }
}
