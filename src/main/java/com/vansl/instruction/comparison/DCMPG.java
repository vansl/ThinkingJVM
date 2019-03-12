package com.vansl.instruction.comparison;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class DCMPG extends NoOperandsInstruction {

    public static void fcmp(Frame frame,boolean gFlag) {
        OperandStack operandStack = frame.getOperandStack();
        double v2 = operandStack.popDouble();
        double v1 = operandStack.popDouble();
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
