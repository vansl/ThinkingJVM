package com.vansl.instruction.comparison;

import com.vansl.instruction.base.BranchInstruction;
import com.vansl.instruction.base.BranchLogic;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.Object;

/**
 * @description 把操作数栈顶的两个引用弹出，然后进行比较，满足条件则跳转
 * @date 2019-03-12 21:53:15
 **/
public class IF_ACMPEQ extends BranchInstruction {
    @Override
    public void Execute(Frame frame) {
        Object val2 = frame.getOperandStack().popRef();
        Object val1 = frame.getOperandStack().popRef();
        if (val1==val2) {
            BranchLogic.branch(frame,this.offset);
        }
    }
}
