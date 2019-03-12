package com.vansl.classfile.attribute;

import com.vansl.classfile.ClassReader;

class MarkerAttribute extends AttributeInfo {

    @Override
    public void readInfo(ClassReader classReader) {
        // do nothing
    }
}

/**
 * @description 用于标记类、接口、字段或方法已经不建议使用
 * 编译器等工具可以根据Deprecated属性输出警告信息
 * @date 2019-03-10 17:26:28
 **/
class DeprecatedAttribute extends MarkerAttribute {
}

/**
 * @description 用于标记源文件中不存在，以支持嵌套类和嵌套接口
 * @date 2019-03-10 17:27:05
 **/
class SyntheticAttribute extends MarkerAttribute {
}
