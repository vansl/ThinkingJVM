package com.vansl.instruction.reference;

import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.heap.*;

/**
 * @author: vansl
 * 给实例变量赋值
 * @create: 19-3-16 上午12:21
 */
public class PUT_FIELD extends Index16Instruction{

    @Override
    public void execute(Frame frame) {
        // 获取字段符号引用
        Method currentMethod = frame.getMethod();
        Clazz currentClass = currentMethod.getClazz();
        RuntimeConstantPool cp = currentClass.getConstantPool();
        FieldRef fieldRef = (FieldRef) cp.getConstant(index);
        Field field = fieldRef.resolvedField();
        if(field.isStatic()) {
            throw new Error("java.lang.IncompatibleClassChangeError");
        }
        // final变量只能在构造方法中赋值
        if (!field.isFinal()) {
            if (currentClass!= field.getClazz()|| !currentMethod.getName().equals("<init>")) {
                throw new Error("java.lang.IllegalAccessError");
            }
        }
        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        OperandStack stack = frame.getOperandStack();
        switch (descriptor.charAt(0)) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                int i = stack.popInt();
                HeapObject ref = stack.popRef();
                if (ref== null) {
                    throw new Error("java.lang.NullPointerException");
                }
                ref.getFields().setInt(slotId,i);
                break;
            case 'F':
                float f = stack.popFloat();
                ref = stack.popRef();
                if (ref== null) {
                    throw new Error("java.lang.NullPointerException");
                }
                ref.getFields().setFloat(slotId, f);
                break;
            case 'J':
                long l = stack.popLong();
                ref = stack.popRef();
                if (ref== null) {
                    throw new Error("java.lang.NullPointerException");
                }
                ref.getFields().setLong(slotId, l);
                break;
            case 'D':
                double d = stack.popDouble();
                ref = stack.popRef();
                if (ref== null) {
                    throw new Error("java.lang.NullPointerException");
                }
                ref.getFields().setDouble(slotId, d);
                break;
            case 'L':
            case '[':
                HeapObject heapObject = stack.popRef();
                ref = stack.popRef();
                if (ref== null) {
                    throw new Error("java.lang.NullPointerException");
                }
                ref.getFields().setRef(slotId, heapObject);
        }
    }
}
