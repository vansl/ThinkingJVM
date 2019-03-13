package com.vansl.instruction.load;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class DLOAD extends Index8Instruction {

    // DLOAD指令公用代码
    public static void dload(Frame frame,int index) {
        double val = frame.getLocalVars().getDouble(index);
        frame.getOperandStack().pushDouble(val);
    }
    @Override
    public void execute(Frame frame) {
        dload(frame,this.index);
    }
}
