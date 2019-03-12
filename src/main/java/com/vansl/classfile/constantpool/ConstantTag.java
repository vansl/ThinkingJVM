package com.vansl.classfile.constantpool;

public enum ConstantTag {

    CLASS(7),
    FIELDREF(9),
    METHODREF(10),
    INTEFFACE_METHODREF(11),
    STRING(8),
    INTEGER(3),
    FLOAT(4),
    LONG(5),
    DOUBLE(6),
    NAME_AND_TYPE(12),
    UTF8(1),
    METHOD_HANDLE(15),
    METHOD_TYPE(16),
    INVOKE_DYNAMIC(18);

    short tag;

    ConstantTag(int tag) {
        this.tag = (short) tag;
    }

    public short getTag() {
        return tag;
    }

    public static ConstantTag getByTag(short tag) {
        for (ConstantTag constantTag:values()) {
            if (constantTag.getTag() == tag) {
                return constantTag;
            }
        }
        return null;
    }
}
