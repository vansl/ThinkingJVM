package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 表示字段/方法的名称和描述符
 * 字段描述符为字段类型的描述符，方法描述符为参数类型描述符+返回值类型描述符
 * @date 2019-03-10 15:03:45
 **/
public class ConstantNameAndTypeInfo extends ConstantInfo{

    private int nameIndex;
    private int descriptorIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.nameIndex = classReader.readU2();
        this.descriptorIndex = classReader.readU2();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
