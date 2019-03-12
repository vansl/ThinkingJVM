package com.vansl.instruction.comparison;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

/**
 * @description 比较float
 * NaN值存在时无法比较float，FCMPG和FCMPL对这种情况定义不同。double同理
 * @date 2019-03-12 21:48:38
 **/
public class FCMPG extends NoOperandsInstruction {

    public static void fcmp(Frame frame,boolean gFlag) {
        OperandStack operandStack = frame.getOperandStack();
        float v2 = operandStack.popFloat();
        float v1 = operandStack.popFloat();
        if (v1>v2) {
            operandStack.pushInt(1);
        } else if (v1==v2) {
            operandStack.pushInt(0);
        } else if (v1<v2){
            operandStack.pushInt(-1);
        } else if (gFlag) {
            operandStack.pushInt(1);
        } else {
            operandStack.pushInt(-1);
        }
    }

    @Override
    public void Execute(Frame frame) {
        fcmp(frame,true);
    }
}
