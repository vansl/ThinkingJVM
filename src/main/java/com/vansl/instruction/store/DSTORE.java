package com.vansl.instruction.store;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;

public class DSTORE extends Index8Instruction {

    // DSTORE指令公用代码
    public static void dstore(Frame frame,int index) {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(index,val);
    }
    @Override
    public void execute(Frame frame) {
        dstore(frame,this.index);
    }
}
