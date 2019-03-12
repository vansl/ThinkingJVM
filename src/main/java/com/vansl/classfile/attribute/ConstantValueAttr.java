package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

/**
 * @description 用于表示常量表达式的值
 * @date 2019-03-10 19:38:02
 **/
class ConstantValueAttribute extends AttributeInfo {

    private int constantValueIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        constantValueIndex = classReader.readU2();
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
