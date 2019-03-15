package com.vansl.rtdata.heap;

import com.vansl.classfile.MemberInfo;

public class Method extends ClassMember {

    int maxStack;        // 操作数栈大小（由编译器确定）
    int maxLocals;       // 局部变量表大小（由编译器确定）
    byte[] code;         // 字节码

    public static Method[] newMethods(Clazz clazz, MemberInfo[] classFileMethods) {
        Method[] methods = new Method[classFileMethods.length];
        for (int i=0;i<methods.length;i++) {
            methods[i] = new Method();
            methods[i].clazz = clazz;
            methods[i].copyMemberInfo(classFileMethods[i]);
            methods[i].maxStack = classFileMethods[i].getCodeAttribute().getMaxStack();
            methods[i].maxLocals = classFileMethods[i].getCodeAttribute().getMaxLocals();
            methods[i].code = classFileMethods[i].getCodeAttribute().getCode();
        }
        return methods;
    }

    public boolean isSynchronized() {
        return (accessFlags&AccessFlags.ACC_SYNCHRONIZED.getFlag()) != 0;
    }

    public boolean isBridge() {
        return (accessFlags&AccessFlags.ACC_BRIDGE.getFlag()) != 0;
    }

    public boolean isVarargs() {
        return (accessFlags&AccessFlags.ACC_VARARGS.getFlag()) != 0;
    }

    public boolean isNative() {
        return (accessFlags & AccessFlags.ACC_NATIVE.getFlag()) != 0;
    }

    public boolean isAbstract() {
        return (accessFlags & AccessFlags.ACC_ABSTRACT.getFlag()) != 0;
    }

    public boolean isStrict() {
        return (accessFlags & AccessFlags.ACC_STRICT.getFlag()) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & AccessFlags.ACC_SYNTHETIC.getFlag()) != 0;
    }
}
