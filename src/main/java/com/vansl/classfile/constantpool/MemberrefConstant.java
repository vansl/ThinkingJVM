package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 表示字段符号引用/普通方法符号引用/接口方法符号引用
 * @date 2019-03-10 15:18:54
 **/
class ConstantMemberefInfo extends ConstantInfo{

    private int classIndex;         // 指向CONSTANT_Class_info常量
    private int nameAndTypeIndex;   // 指向CONSTANT_NameAndType_info常量

    @Override
    public void readInfo(ClassReader classReader) {
        this.classIndex = classReader.readU2();
        this.nameAndTypeIndex = classReader.readU2();
    }

}


class ConstantFieldrefInfo extends ConstantMemberefInfo {
}


class ConstantMethodrefInfo extends ConstantMemberefInfo {
}


class ConstantInterfaceMethodrefInfo extends ConstantMemberefInfo {
}
