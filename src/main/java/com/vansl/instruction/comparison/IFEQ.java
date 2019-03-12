package com.vansl.instruction.comparison;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

/**
 * @description 把操作数栈顶的int变量弹出，然后跟0进行比较，满足条件则跳转
 * @date 2019-03-12 21:53:15
 **/
public class IFEQ extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        int val = frame.getOperandStack().popInt();
        if (val==0) {
            BranchLogic.branch(frame,this.offset);
        }
    }
}
