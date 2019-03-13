package com.vansl.interpreter;

import com.vansl.classfile.MemberInfo;
import com.vansl.classfile.attribute.CodeAttribute;
import com.vansl.instruction.InstructionFactory;
import com.vansl.instruction.base.BytecodeReader;
import com.vansl.instruction.base.Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.Thread;

/**
 * @description 解释器
 * @date 2019-03-13 13:14:57
 **/
public class Interpreter {

    private static int MAX_STACK_SIZE = 1024;

    public static void interpret(MemberInfo memberInfo) {
        CodeAttribute codeAttribute = memberInfo.getCodeAttribute();
        int maxLocals = codeAttribute.getMaxLocals();
        int maxStack =  codeAttribute.getMaxStack();
        byte[] bytecode = codeAttribute.getCode();
        Thread thread = new Thread(MAX_STACK_SIZE);
        Frame frame = new Frame(thread,maxLocals,maxStack);
        thread.pushFrame(frame);
        loop(thread,bytecode);
    }

    public static void loop(Thread thread,byte[] bytecode) {
        Frame frame = thread.popFrame();
        BytecodeReader bytecodeReader = new BytecodeReader();
        while (true) {
            // 计算pc
            int pc = frame.getNextPC();
            thread.setPc(pc);
            // 解码指令
            bytecodeReader.reset(bytecode,pc);
            short opcode = bytecodeReader.readUint8();
            Instruction instruction = InstructionFactory.newInstruction(opcode);
            instruction.fetchOperands(bytecodeReader);
            frame.setNextPC(bytecodeReader.getPc());
            System.out.println(instruction.getClass());
            // 执行指令
            instruction.execute(frame);
        }
    }

}
