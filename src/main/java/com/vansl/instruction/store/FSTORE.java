package com.vansl.instruction.store;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class FSTORE extends Index8Instruction {

    // FSTORE指令公用代码
    public static void fstore(Frame frame,int index) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVars().setFloat(index,val);
    }
    @Override
    public void execute(Frame frame) {
        fstore(frame,this.index);
    }
}
