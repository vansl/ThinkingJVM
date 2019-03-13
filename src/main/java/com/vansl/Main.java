package com.vansl;

import com.beust.jcommander.JCommander;
import com.vansl.classfile.ClassFile;
import com.vansl.classfile.MemberInfo;
import com.vansl.classpath.Classpath;
import com.vansl.command.Command;
import com.vansl.interpreter.Interpreter;
import com.vansl.util.IOUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 参数
        Command command = new Command();
        JCommander.newBuilder()
                .addObject(command)
                .build()
                .parse(args);
        if (command.isVersionFlag()) {
            System.out.println("java version \"0.0.3\"");
        } else if (command.isHelpFlag()){
            System.out.println(Command.HELP_MSG);
        } else {
            List<String> parameters = command.getParameters();
            command.setMainClassName(parameters.get(0));
            command.setArgs(parameters.subList(1,parameters.size()));
            startJVM(command);
        }
    }
    private static void startJVM(Command command) {
        Classpath classpath = new Classpath(command.getXjreOption(),command.getCpOption());
        System.out.printf("classpath: %s\nclass: %s\nargs: %s\n",
                classpath.toString(),
                command.getMainClassName(),
                command.getArgs()
        ) ;
        // Paths类会自动处理路径中的文件名分隔符
        String mainClassName = "/" + command.getMainClassName().replace(".","/");
        byte[] classBytes = new byte[0];
        try {
            classBytes = classpath.readClass(mainClassName);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.printf("Error: Could not find or load main class ",mainClassName);
            System.exit(1);
        }
//        System.out.println(IOUtil.bytesToHex(classBytes));
        ClassFile classFile = loadClass(mainClassName,classpath);
        printClassInfo(classFile);
        MemberInfo mainMethod = getMainMehtod(classFile);
        Interpreter.interpret(mainMethod);
    }

    public static ClassFile loadClass(String className,Classpath classpath) {
        ClassFile classFile = null;
        try {
            byte[] bytes = classpath.readClass(className);
            classFile = ClassFile.readClassFile(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classFile;
    }

    public static void printClassInfo(ClassFile classFile) {
        System.out.printf("version: %s.%s\n",
                classFile.getMajorVersion(),
                classFile.getMinorVersion()
        );
        System.out.printf("constants count: %d\n",classFile.getConstantPool().getConstantPoolCount());
        System.out.printf("this class: %s\n",classFile.getClassName());
        System.out.printf("super class: %s\n",classFile.getSuperClassName());
        System.out.printf("interfaces: %s\n",classFile.getInterfaceNames());
        for(String field:classFile.getFieldNames()) {
            System.out.println("field:"+field);;
        }
        for(String method:classFile.getMethodNames()) {
            System.out.println("method:"+method);;
        }
    }

    /**
     * @description 获取main方法
     * @date 2019-03-13 14:44:57
     **/
    public static MemberInfo getMainMehtod(ClassFile classFile) {
        for (MemberInfo method:classFile.getMethods()) {
            if (method.toString().equals("main,desc:([Ljava/lang/String;)V")) {
                return method;
            }
        }
        return null;
    }
}
