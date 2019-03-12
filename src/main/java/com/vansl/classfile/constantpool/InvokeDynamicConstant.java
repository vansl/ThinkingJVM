package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

/**
 * @description 用于支持新增的invokedynamic指令，下同
 * @date 2019-03-10 16:08:39
 **/
class ConstantInvokeDynamicInfo extends ConstantInfo {

    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.bootstrapMethodAttrIndex = classReader.readU2();
        this.nameAndTypeIndex = classReader.readU2();
    }

    // TODO getBootstrapMethodInfo()
}


class ConstantMethodHandleInfo extends ConstantInfo {

    private short referenceKind;
    private int referenceIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.referenceKind = classReader.readU1();
        this.referenceIndex = classReader.readU2();
    }


    public short getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }
}

class ConstantMethodTypeInfo extends ConstantInfo {

    private int descriptorIndex;

    @Override
    public void readInfo(ClassReader classReader) {
        this.descriptorIndex = classReader.readU2();
    }
}