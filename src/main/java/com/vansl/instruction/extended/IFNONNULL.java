package com.vansl.instruction.extended;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

public class IFNONNULL extends BranchInstruction {
    @Override
    public void execute(Frame frame) {
        Object ref = frame.getOperandStack().popRef();
        if (ref!=null) {
            BranchLogic.branch(frame,offset);
        }
    }
}
