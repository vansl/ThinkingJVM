package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.*;


/**
 * @description 运行时常量池
 * 存放：1. 字面量 2. 符号引用
 * @date 2019-03-14 15:08:24
 **/
public class RuntimeConstantPool {

    Clazz clazz;
    Object[] constants;

    /**
     * @description 把class文件常量池转换为运行时常量池
     * @date 2019-03-14 15:20:54
     **/
    public RuntimeConstantPool(Clazz clazz, ConstantPool cfConstantPool) {
        int cpCount = cfConstantPool.getConstantPoolCount();
        this.clazz = clazz;
        constants = new Object[cpCount];
        // 索引0为无效索引
        for (int i=1;i<cpCount;i++) {
            ConstantInfo constantInfo = cfConstantPool.getConstantInfo(cpCount);
            // 字面量
            if (constantInfo instanceof ConstantIntegerInfo) {
                constants[i] = ((ConstantIntegerInfo)constantInfo).getVal();
            }
            if (constantInfo instanceof ConstantFloatInfo) {
                constants[i] = ((ConstantFloatInfo)constantInfo).getVal();
            }
            // long 和 double 在常量池中占据两个位置
            if (constantInfo instanceof ConstantLongInfo) {
                constants[i] = ((ConstantLongInfo)constantInfo).getHighVal();
                constants[i] = ((ConstantLongInfo)constantInfo).getLowVal();
            }
            if (constantInfo instanceof ConstantDoubleInfo) {
                constants[i] = ((ConstantDoubleInfo) constantInfo).getHighVal();
                constants[i] = ((ConstantDoubleInfo) constantInfo).getLowVal();
            }
            if (constantInfo instanceof ConstantStringInfo) {
                int stringIndex = ((ConstantStringInfo) constantInfo).getStringIndex();
                constants[i] = cfConstantPool.getUtf8(stringIndex);
            }
            // 符号引用
            if (constantInfo instanceof ConstantClassInfo) {
                constants[i] = new ClassRef(this,(ConstantClassInfo) constantInfo);
            }
            if (constantInfo instanceof ConstantFieldrefInfo) {
                constants[i] = new FieldRef(this,(ConstantFieldrefInfo)constantInfo);
            }
            if (constantInfo instanceof ConstantMethodrefInfo) {
                constants[i] = new MethodRef(this,(ConstantMethodrefInfo)constantInfo);
            }
            if (constantInfo instanceof ConstantInterfaceMethodrefInfo) {
                constants[i] = new InterfaceMethodRef(this,(ConstantInterfaceMethodrefInfo) constantInfo);
            }
        }
    }

    public Object getConstant(int index) {
        if (constants[index]!=null) {
            return constants[index];
        }
        throw new Error("No constants at "+index);
    }

}
