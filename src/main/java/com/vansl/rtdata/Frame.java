package com.vansl.rtdata;

import lombok.Data;

/**
 * @description 栈帧
 * @date 2019-03-12 15:23:25
 **/
@Data
public class Frame {

    private LocalVars localVars;        // 局部变量表
    private OperandStack operandStack;  // 操作数栈

    public Frame(int maxLocals,int maxOperandStack) {
        localVars = new LocalVars(maxLocals);
        operandStack = new OperandStack(maxOperandStack);
    }
}
