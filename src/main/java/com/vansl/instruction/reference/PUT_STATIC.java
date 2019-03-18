package com.vansl.instruction.reference;

import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.heap.*;

/**
 *  给类的某个静态变量赋值
 */
public class PUT_STATIC extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        // 获取字段符号引用
        Method currentMethod = frame.getMethod();
        Clazz currentClass = currentMethod.getClazz();
        RuntimeConstantPool cp = currentClass.getConstantPool();
        FieldRef fieldRef = (FieldRef) cp.getConstant(index);
        Field field = fieldRef.resolvedField();
        Clazz clazz = field.getClazz();
        // TODO 初始化类
        if (!field.isStatic()) {
            throw new Error("java.lang.IncompatibleClassChangeError");
        }
        // final变量只能在类初始化方法中赋值
        if (!field.isFinal()) {
            if (currentClass!=clazz || !currentMethod.getName().equals("<clinit>")) {
                throw new Error("java.lang.IllegalAccessError");
            }
        }
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Slots slots = clazz.getStaticVars();
        OperandStack stack = frame.getOperandStack();
        // 根据字段类型从操作数栈中弹出值
        switch (descriptor.charAt(0)) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                slots.setInt(slotId, stack.popInt());
                break;
            case 'F':
                slots.setFloat(slotId, stack.popFloat());
                break;
            case 'J':
                slots.setLong(slotId, stack.popLong());
                break;
            case 'D':
                slots.setDouble(slotId, stack.popDouble());
                break;
            case 'L':
            case '[':
                slots.setRef(slotId, stack.popRef());
        }
    }
}
