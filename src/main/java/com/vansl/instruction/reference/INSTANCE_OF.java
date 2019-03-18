package com.vansl.instruction.reference;

import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.heap.ClassRef;
import com.vansl.rtdata.heap.Clazz;
import com.vansl.rtdata.heap.HeapObject;
import com.vansl.rtdata.heap.RuntimeConstantPool;

/**
 * @author: vansl
 * 判断对象是否是某个类的实例
 * @create: 19-3-16 上午1:33
 */
public class INSTANCE_OF extends Index16Instruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        HeapObject ref = stack.popRef();
        if (ref == null) {
            stack.pushInt(0);
            return;
        }
        RuntimeConstantPool cp = frame.getMethod().getClazz().getConstantPool();
        ClassRef classRef = (ClassRef) cp.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        if (ref.isInstanceOf(clazz)) {
            stack.pushInt(1);
        } else {
            stack.pushInt(0);
        }
    }
}
