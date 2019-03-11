package com.vansl.classfile.constantpool;

import com.vansl.classfile.ClassReader;

import java.io.IOException;

/**
 * @description 常量抽象类
 * @date 2019-03-10 12:24:13
 **/
abstract class ConstantInfo {

    private short tag;

    public abstract void readInfo(ClassReader classReader) ;

}
