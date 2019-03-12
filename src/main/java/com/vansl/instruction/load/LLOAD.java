package com.vansl.instruction.load;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class LLOAD extends Index8Instruction {

    // LLOAD指令公用代码
    public static void lload(Frame frame,int index) {
        long val = frame.getLocalVars().getLong(index);
        frame.getOperandStack().pushLong(val);
    }
    @Override
    public void Execute(Frame frame) {
        lload(frame,this.index);
    }
}
