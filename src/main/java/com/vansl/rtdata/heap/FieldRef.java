package com.vansl.rtdata.heap;

import com.vansl.classfile.constantpool.ConstantFieldrefInfo;

public class FieldRef extends MemberRef{

    Field field;        // 解析后的字段引用缓存

    public FieldRef(RuntimeConstantPool constantPool, ConstantFieldrefInfo constantFieldrefInfo) {
        this.constantPool = constantPool;
        copyMemberRefInfo(constantFieldrefInfo);
    }

    public Field resolvedField() {
        if (field==null) {
            resolveFieldRef();
        }
        return field;
    }

    /**
     * @description 解析字段符号引用
     * @date 2019-03-15 20:12:06
     **/
    public void resolveFieldRef() {
        Clazz d = constantPool.clazz;
        // 解析类符号引用
        Clazz c = resolvedClass();
        // 递归查找
        Field field = lookupField(c, name, descriptor);
        if (field == null) {
            throw new Error("java.lang.NoSuchFieldError");
        }
        if (!field.isAccessibleTo(d)) {
            throw new Error("java.lang.IllegalAccessError");
        }
        this.field = field;
    }

    private Field lookupField(Clazz c, String name,String descriptor) {
        for (Field field:c.getFields()) {
            if (field.name.equals(name) && field.descriptor.equals(descriptor)) {
                return field;
            }
        }
        for (Clazz interfaceClass:c.getInterfaces()) {
            Field field = lookupField(interfaceClass,name,descriptor);
            if (field!=null){
                return field;
            }
        }
        if (c.getSuperClass()!=null) {
            return lookupField(c.getSuperClass(), name, descriptor);
        }
        return null;
    }

}
