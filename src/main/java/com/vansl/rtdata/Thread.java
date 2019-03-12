package com.vansl.rtdata;

import java.util.Stack;

/**
 * @description 线程
 * @date 2019-03-12 15:23:31
 **/
public class Thread {

    private int pc;         // pc寄存器
    private JVMStack stack;    // Java虚拟机栈

    public Thread(int maxStackSize) {
        stack = new JVMStack(maxStackSize);
    }

    public void pushFrame(Frame frame) {
        stack.push(frame);
    }

    public Frame popFrame(Frame frame) {
        return stack.pop();
    }

    public Frame currentFrame() {
        return stack.top();
    }
}
