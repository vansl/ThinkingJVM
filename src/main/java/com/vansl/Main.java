package com.vansl;

import com.beust.jcommander.JCommander;
import com.vansl.command.Command;

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
            command.setClassName(parameters.get(0));
            command.setArgs(parameters.subList(1,parameters.size()));
            startJVM(command);
        }
    }
    private static void startJVM(Command command) {
        System.out.printf("classpath: %s\nclass: %s\nargs: %s",
                command.getCpOption(),
                command.getClassName(),
                command.getArgs()
        );
    }
}
