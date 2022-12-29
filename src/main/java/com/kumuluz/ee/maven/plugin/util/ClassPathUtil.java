package com.kumuluz.ee.maven.plugin.util;

import java.io.File;

public class ClassPathUtil {
    public static String javaCmd() {
        String javaHome = System.getenv("JAVA_HOME");
        String javaCmd = System.getProperty("JAVACMD");

        if (javaCmd == null || javaCmd.isEmpty()) {
            if (javaHome != null && !javaHome.isEmpty()) {
                File javaBin = new File(javaHome, "jre/sh/java");
                if (javaBin.isFile() && javaBin.canExecute()) {
                    // IBM's JDK on AIX uses strange locations for the executables
                    javaCmd = javaBin.getAbsolutePath();
                } else {
                    javaBin = new File(javaHome, "bin/java");
                    if (javaBin.isFile() && javaBin.canExecute()) {
                        javaCmd = javaBin.getAbsolutePath();
                    }
                }
            } else {
                javaCmd = "java";
            }
        }
        return javaCmd;
    }

    public static void main(String[] args) {
        System.out.println(javaCmd());
    }
}
