package com.vansl.instruction.comparison;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

public class IF_ICMPGE extends BranchInstruction {
    @Override
    public void execute(Frame frame) {
        int val2 = frame.getOperandStack().popInt();
        int val1 = frame.getOperandStack().popInt();
        if (val1>=val2) {
            BranchLogic.branch(frame,this.offset);
        }
    }
}
