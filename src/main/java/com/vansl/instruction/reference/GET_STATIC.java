package com.vansl.instruction.reference;

import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.heap.*;

/**
 * @author: vansl
 * 取出类的某个静态变量值，然后推入栈顶
 * @create: 19-3-15 下午11:41
 */
public class GET_STATIC extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        // 获取并解析字段符号引用
        RuntimeConstantPool cp = frame.getMethod().getClazz().getConstantPool();
        FieldRef fieldRef = (FieldRef)cp.getConstant(index);
        Field field = fieldRef.resolvedField();
        Clazz clazz = field.getClazz();
        if (!field.isStatic()) {
            throw new Error("java.lang.IncompatibleClassChangeError");
        }
        // 根据字段类型取出值然后推入操作数栈顶
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Slots slots = clazz.getStaticVars();
        OperandStack stack = frame.getOperandStack();
        switch(descriptor.charAt(0)) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                stack.pushInt(slots.getInt(slotId));
                break;
            case 'F':
                stack.pushFloat(slots.getFloat(slotId));
                break;
            case 'J':
                stack.pushLong(slots.getLong(slotId));
                break;
            case 'D':
                stack.pushDouble(slots.getDouble(slotId));
                break;
            case 'L':
            case '[':
                stack.pushRef(slots.getRef(slotId));
        }
    }
}
