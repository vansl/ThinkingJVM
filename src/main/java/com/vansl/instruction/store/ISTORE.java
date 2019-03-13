package com.vansl.instruction.store;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class ISTORE extends Index8Instruction {

    // ISTORE指令公用代码
    public static void istore(Frame frame,int index) {
        int val = frame.getOperandStack().popInt();
        frame.getLocalVars().setInt(index,val);
    }
    @Override
    public void execute(Frame frame) {
        istore(frame,this.index);
    }
}
