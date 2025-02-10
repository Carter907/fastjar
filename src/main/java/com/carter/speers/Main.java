package com.carter.speers;

import javax.tools.*;
import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] pwd = new File(".").listFiles(pathname -> pathname.getName().endsWith(".java"));
        File[] files1 = pwd == null ? new File[]{} : pwd;

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();

        fileManager.close();

        java.util.spi.ToolProvider jarTool =
                java.util.spi.ToolProvider.findFirst("jar").orElseThrow();
        List<String> jarArgs = List.of("--create",  "--file", args[1] == null ? "app" :
                        args[1] + ".jar",
        "--main-class", args[0] == null ? "Main" : args[0], "-C", System.getProperty("user.dir"),
                ".");
        System.out.println(jarArgs);

        jarTool.run(System.out, System.err, jarArgs.toArray(new String[]{}));
    }
}