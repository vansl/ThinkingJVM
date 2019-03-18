package com.vansl.instruction.reference;

import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.heap.*;

/**
 * @author: vansl
 * 获取对象的实例变量值，然后推入操作数栈
 * @create: 19-3-16 上午1:18
 */
public class GET_FIELD extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        RuntimeConstantPool cp = frame.getMethod().getClazz().getConstantPool();
        FieldRef fieldRef = (FieldRef)cp.getConstant(index);
        Field field = fieldRef.resolvedField();
        if (field.isStatic()) {
            throw new Error("java.lang.IncompatibleClassChangeError");
        }
        OperandStack stack = frame.getOperandStack();
        HeapObject ref = stack.popRef();
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Slots slots = ref.getFields();
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
