package com.vansl.instruction.comparison;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;

/**
 * @description 把操作数栈顶的两个int变量弹出，然后进行比较，满足条件则跳转
 * @date 2019-03-12 21:53:15
 **/
public class IF_ICMPEQ extends BranchInstruction {
    @Override
    public void execute(Frame frame) {
        int val2 = frame.getOperandStack().popInt();
        int val1 = frame.getOperandStack().popInt();
        if (val1==val2) {
            BranchLogic.branch(frame,this.offset);
        }
    }
}
