package com.vansl.command;

import com.beust.jcommander.Parameter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Command {

    public static String HELP_MSG = "Usage: java [-options] class [args...]\n" +
            "         (to execute a class)\n" +
            "or  java [-options] -jar jarfile [args...]\n" +
            "         (to execute a jar file)";

    @Parameter(names = {"-version"},description = "版本信息")
    private boolean versionFlag;

    @Parameter(names = {"-help"},description = "帮助信息")
    private boolean helpFlag;

    @Parameter(names = {"-classpath","-cp"},description = "用户类路径选项")
    private String cpOption;

    @Parameter(names = {"-Xjre"},description = "启动类路径选项")
    private String XjreOption;

    @Parameter(description = "剩余的参数")
    private List<String> parameters = new ArrayList<String>();
    private String mainClassName;
    private List<String> args;
}

