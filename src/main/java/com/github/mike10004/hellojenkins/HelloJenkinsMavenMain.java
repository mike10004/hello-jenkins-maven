package com.github.mike10004.hellojenkins;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringEscapeUtils;

public class HelloJenkinsMavenMain {

    public HelloJenkinsMavenMain() {
    }

    public void printProperties(PrintWriter out) {
        Set<String> propertyNames = System.getProperties().stringPropertyNames();
        List<String> propertyNamesList = new ArrayList<>(propertyNames);
        Collections.sort(propertyNamesList);
        for (String propertyName : propertyNamesList) {
            String value = System.getProperty(propertyName);
            value = StringEscapeUtils.escapeJava(value);
            out.format("%s -> %s%n", propertyName, value);
        }
    }
            
    public int addOne(int value) throws IllegalArgumentException {
        if (value == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("would overflow because argument is INT_MAX");
        }
        return value + 1;
    }
    
    public static void main(String[] args) {
        HelloJenkinsMavenMain program = new HelloJenkinsMavenMain();
        program.printProperties(new PrintWriter(System.out));
    }
}
