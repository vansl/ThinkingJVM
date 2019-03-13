package com.vansl.instruction.load;

import com.vansl.instruction.base.Index8Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.heap.Object;

public class ALOAD extends Index8Instruction {

    // ALOAD指令公用代码
    public static void aload(Frame frame,int index) {
        Object ref = frame.getLocalVars().getRef(index);
        frame.getOperandStack().pushRef(ref);
    }
    @Override
    public void execute(Frame frame) {
        aload(frame,this.index);
    }
}
