package com.vansl.instruction.control;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

/**
 * @description 无条件跳转
 * @date 2019-03-12 22:05:45
 **/
public class GOTO extends BranchInstruction {
    @Override
    public void execute(Frame frame) {
        BranchLogic.branch(frame,offset);
    }
}
