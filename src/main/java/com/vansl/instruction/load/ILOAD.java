package com.vansl.instruction.load;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class ILOAD extends Index8Instruction {

    // ILOAD指令公用代码
    public static void iload(Frame frame,int index) {
        int val = frame.getLocalVars().getInt(index);
        frame.getOperandStack().pushInt(val);
    }
    @Override
    public void execute(Frame frame) {
        iload(frame,this.index);
    }
}
