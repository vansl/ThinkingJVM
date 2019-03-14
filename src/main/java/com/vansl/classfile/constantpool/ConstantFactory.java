package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

public class ConstantFactory {

    public static ConstantInfo newConstant(short tag,ClassReader classReader,ConstantPool constantPool) {
        ConstantInfo constantInfo;
        switch (tag) {
            case 3:
                constantInfo = new ConstantIntegerInfo();
                break;
            case 4:
                constantInfo = new ConstantFloatInfo();
                break;
            case 5:
                constantInfo = new ConstantLongInfo();
                break;
            case 6:
                constantInfo = new ConstantDoubleInfo();
                break;
            case 1:
                constantInfo = new ConstantUtf8Info();
                break;
            case 8:
                constantInfo = new ConstantStringInfo();
                break;
            case 7:
                constantInfo = new ConstantClassInfo(constantPool);
                break;
            case 9:
                constantInfo = new ConstantFieldrefInfo(constantPool);
                break;
            case 10:
                constantInfo = new ConstantMethodrefInfo(constantPool);
                break;
            case 11:
                constantInfo = new ConstantInterfaceMethodrefInfo(constantPool);
                break;
            case 12:
                constantInfo = new ConstantNameAndTypeInfo();
                break;
            case 16:
                constantInfo = new ConstantMethodTypeInfo();
                break;
            case 15:
                constantInfo = new ConstantMethodHandleInfo();
                break;
            case 18:
                constantInfo = new ConstantInvokeDynamicInfo();
                break;
            default:
                throw new Error("java.lang.ClassFormatError: constant pool tag");
        }
        constantInfo.readInfo(classReader);
        return constantInfo;
    }
}
