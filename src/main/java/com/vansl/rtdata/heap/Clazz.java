package com.vansl.rtdata.heap;

import com.vansl.classfile.ClassFile;
import lombok.Data;

/**
 * @author: vansl
 * 放进方法区内的类
 * @create: 19-3-14 上午1:58
 */
@Data
public class Clazz {

    private int accessFlags;                    // 类访问标志
    private String className;                   // 类名
    private String superClassName;              // 超类名
    private String[] interfaceNames;            // 接口名
    private RuntimeConstantPool constantPool;   // 运行时常量池引用
    private Field[] fields;                     // 字段表
    private Method[] methods;                   // 方法表
    private ClassLoader classLoader;            // 类加载器引用
    private Clazz superClass;
    private Clazz[] interfaces;
    private int staticSlotCount;                // 类变量空间大小
    private int instanceSlotCount;              // 实例变量空间大小
    private Slots staticVars;                   // 静态变量

    /**
     * @description 把class file转换成clazz对象
     * @date 2019-03-14 13:03:41
     **/
    public Clazz(ClassFile classFile) {
        accessFlags = classFile.getAccessFlags();
        className = classFile.getClassName();
        superClassName = classFile.getSuperClassName();
        interfaceNames = (String[]) classFile.getInterfaceNames().toArray();
        constantPool = new RuntimeConstantPool(this, classFile.getConstantPool());
        fields = Field.newFields(this, classFile.getFields());
        methods = Method.newMethods(this, classFile.getMethods());
    }

    public boolean isAccessibleTo(Clazz otherClass) {
        return isPublic() || getPackageName().equals(otherClass.getPackageName());
    }

    public String getPackageName() {
        int lastIndex = className.lastIndexOf('/');
        if (lastIndex!=-1) {
            return className.substring(0,lastIndex);
        }
        return "";
    }

    public boolean isPublic() {
        return (accessFlags&AccessFlags.ACC_PUBLIC.getFlag()) != 0;
    }

    public boolean isFinal() {
        return (accessFlags&AccessFlags.ACC_FINAL.getFlag()) != 0;
    }

    public boolean isSuper() {
        return (accessFlags&AccessFlags.ACC_SUPER.getFlag()) != 0;
    }

    public boolean isInterface() {
        return (accessFlags&AccessFlags.ACC_INTERFACE.getFlag()) != 0;
    }

    public boolean isAbstract() {
        return (accessFlags&AccessFlags.ACC_ABSTRACT.getFlag()) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & AccessFlags.ACC_SYNTHETIC.getFlag()) != 0;
    }

    public boolean isAnnotation() {
        return (accessFlags & AccessFlags.ACC_ANNOTATION.getFlag()) != 0;
    }

    public boolean isEnum() {
        return (accessFlags & AccessFlags.ACC_ENUM.getFlag()) != 0;
    }

}
