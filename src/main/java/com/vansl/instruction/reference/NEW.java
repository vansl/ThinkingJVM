package com.vansl.instruction.reference;

import com.vansl.classfile.constantpool.ConstantPool;
import com.vansl.instruction.base.Index16Instruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.heap.ClassRef;
import com.vansl.rtdata.heap.Clazz;
import com.vansl.rtdata.heap.HeapObject;
import com.vansl.rtdata.heap.RuntimeConstantPool;

/**
 * @description 创建（非数组）类实例指令
 * @date 2019-03-15 20:37:20
 **/
public class NEW extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        // 获取当前类的运行时常量池
        RuntimeConstantPool constantPool = frame.getMethod().getClazz().getConstantPool();
        // 获取类符号引用
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        // 解析类符号引用
        Clazz clazz = classRef.resolvedClass();
        // TODO 初始化类
        if (clazz.isInterface() || clazz.isAbstract()) {
            throw new Error("java.lang.InstantiationError");
        }
        // 创建对象
        HeapObject ref = clazz.newObject();
        // 推入操作数栈顶
        frame.getOperandStack().pushRef(ref);
    }
}
