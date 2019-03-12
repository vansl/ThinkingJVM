package com.vansl.instruction.store;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class LSTORE extends Index8Instruction {

    // LSTORE指令公用代码
    public static void lstore(Frame frame,int index) {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(index,val);
    }
    @Override
    public void Execute(Frame frame) {
        lstore(frame,this.index);
    }
}
