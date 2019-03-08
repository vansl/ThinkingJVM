package com.vansl;

import com.beust.jcommander.JCommander;
import com.vansl.classpath.Classpath;
import com.vansl.command.Command;
import com.vansl.util.IOUtil;

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
            System.out.println("java version \"0.0.1\"");
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
        byte[] classBytes = classpath.readClass(mainClassName);
        if (classBytes == null) {
            System.out.printf("Error: Could not find or load main class ",mainClassName);
            System.exit(1);
        }
        System.out.println(IOUtil.bytesToHex(classBytes));
    }
}
