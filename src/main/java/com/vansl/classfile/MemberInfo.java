package com.vansl.classfile;

import com.vansl.classfile.attribute.AttributeInfo;
import com.vansl.classfile.attribute.CodeAttribute;
import com.vansl.classfile.constantpool.ConstantPool;

/**
 * @description 字段/方法
 * @date 2019-03-10 12:14:49
 **/
public class MemberInfo {

    private ConstantPool constantPool;
    private int accessFlags;            // 访问标志
    private int nameIndex;              // 字段/方法名索引
    private int descriptorIndex;        // 字段/方法描述符索引
    private AttributeInfo[] attributes; // 属性表

    public MemberInfo(ConstantPool constantPool,int accessFlags, int nameIndex, int descriptorIndex, AttributeInfo[] attributes) {
        this.constantPool = constantPool;
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributes = attributes;
    }

    public static MemberInfo[] readMembers(ClassReader classReader, ConstantPool constantPool) {
        int memberCount = classReader.readU2();
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i++) {
            members[i] = new MemberInfo(
                    constantPool,
                    classReader.readU2(),
                    classReader.readU2(),
                    classReader.readU2(),
                    AttributeInfo.readAttributes(classReader,constantPool)
            );
        }
        return members;
    }

    @Override
    public String toString() {
        String memeberName = this.constantPool.getUtf8(nameIndex);
        String memeberDescriptor = this.constantPool.getUtf8(descriptorIndex);
        return memeberName+",desc:"+memeberDescriptor;
    }

    public CodeAttribute getCodeAttribute() {
        for (AttributeInfo attributeInfo:attributes) {
            if (attributeInfo instanceof CodeAttribute) {
                return (CodeAttribute)attributeInfo;
            }
        }
        return null;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public String getName() {
        return constantPool.getUtf8(nameIndex);
    }

    public String getDescriptor() {
        return constantPool.getUtf8(descriptorIndex);
    }
}
