package com.vansl.rtdata;

import com.vansl.rtdata.heap.Method;
import lombok.Data;

/**
 * @description 栈帧
 * @date 2019-03-12 15:23:25
 **/
@Data
public class Frame {

    private LocalVars localVars;        // 局部变量表
    private OperandStack operandStack;  // 操作数栈
    private Thread thread;              // 所属线程
    private int nextPC;
    private Method method;              // 当前类的运行时常量池

    public Frame(Thread thread,Method method) {
        this.thread = thread;
        localVars = new LocalVars(method.);
        operandStack = new OperandStack(method.);
    }
}
