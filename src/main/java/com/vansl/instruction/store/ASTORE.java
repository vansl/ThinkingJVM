package com.vansl.instruction.store;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.heap.Object;

public class ASTORE extends Index8Instruction {

    // ASTORE指令公用代码
    public static void astore(Frame frame,int index) {
        Object ref = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(index,ref);
    }
    @Override
    public void execute(Frame frame) {
        astore(frame,this.index);
    }
}
