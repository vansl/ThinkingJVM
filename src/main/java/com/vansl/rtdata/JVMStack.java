package com.vansl.rtdata;

import java.util.Stack;

/**
 * @description Java虚拟机栈
 * @date 2019-03-12 15:27:46
 **/
public class JVMStack {

    private int maxSize;    // 栈容量，最多能容纳多少帧
    private Stack<Frame> stack;

    public JVMStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Stack<>();
    }

    // 栈帧入栈
    public void push(Frame frame) {
        if (stack.size()>=maxSize) {
            throw new Error("java.lang.StackOverflowError");
        }
        stack.push(frame);
    }

    // 栈帧出栈
    public Frame pop() {
        if (stack.size()==0) {
            throw new Error("jvm stack is empty!");
        }
        return stack.pop();
    }

    // 返回栈顶帧
    public Frame top() {
        return stack.peek();
    }
}
