package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

public class ConstantFactory {

    public static ConstantInfo newConstant(short tag,ClassReader classReader) {
        ConstantInfo constantInfo;
        ConstantTag constantTag = ConstantTag.getByTag(tag);
        if (constantTag==null) {
            throw new Error("java.lang.ClassFormatError:constant tag");
        }
        switch (constantTag) {
            case INTEGER:
                constantInfo = new ConstantIntegerInfo();
                break;
            case FLOAT:
                constantInfo = new ConstantFloatInfo();
                break;
            case LONG:
                constantInfo = new ConstantLongInfo();
                break;
            case DOUBLE:
                constantInfo = new ConstantDoubleInfo();
                break;
            case UTF8:
                constantInfo = new ConstantUtf8Info();
                break;
            case STRING:
                constantInfo = new ConstantStringInfo();
                break;
            case CLASS:
                constantInfo = new ConstantClassInfo();
                break;
            case FIELDREF:
                constantInfo = new ConstantFieldrefInfo();
                break;
            case METHODREF:
                constantInfo = new ConstantMethodrefInfo();
                break;
            case INTEFFACE_METHODREF:
                constantInfo = new ConstantInterfaceMethodrefInfo();
                break;
            case NAME_AND_TYPE:
                constantInfo = new ConstantNameAndTypeInfo();
                break;
            case METHOD_TYPE:
                constantInfo = new ConstantMethodTypeInfo();
                break;
            case METHOD_HANDLE:
                constantInfo = new ConstantMethodHandleInfo();
                break;
            case INVOKE_DYNAMIC:
                constantInfo = new ConstantInvokeDynamicInfo();
                break;
            default:
                throw new Error("java.lang.ClassFormatError: constant pool tag");
        }
        constantInfo.readInfo(classReader);
        return constantInfo;
    }
}
