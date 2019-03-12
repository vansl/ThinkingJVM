package com.vansl.instruction.comparison;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

public class IFLT extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        int val = frame.getOperandStack().popInt();
        if (val<0) {
            BranchLogic.branch(frame,this.offset);
        }
    }
}
