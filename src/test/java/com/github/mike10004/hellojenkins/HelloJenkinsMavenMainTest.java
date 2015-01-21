package com.github.mike10004.hellojenkins;

import com.google.common.base.Splitter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelloJenkinsMavenMainTest {
    
    @Test
    public void testPrintProperties() {
        System.out.println("printProperties");
        StringWriter bucket = new StringWriter();
        String output;
        try (PrintWriter out = new PrintWriter(bucket)) {
            HelloJenkinsMavenMain instance = new HelloJenkinsMavenMain();
            instance.printProperties(out);
            output = bucket.toString();
        }
        Iterable<String> lines = Splitter.on(System.lineSeparator()).split(output);
        Set<String> propertiesPrinted = new TreeSet<>();
        for (String line : lines) {
            String propertyName = Splitter.on(" -> ").split(line).iterator().next();
            propertiesPrinted.add(propertyName);
        }
        assertTrue(propertiesPrinted.contains("line.separator"));
        assertTrue(propertiesPrinted.contains("path.separator"));
        assertTrue(propertiesPrinted.contains("os.arch"));
        assertTrue(propertiesPrinted.contains("os.name"));
        System.out.format("%d system property lines printed%n", propertiesPrinted.size());
    }

    @Test
    public void testAddOne() {
        System.out.println("addOne");
        int value = 123;
        HelloJenkinsMavenMain instance = new HelloJenkinsMavenMain();
        int expResult = value + 1;
        int result = instance.addOne(value);
        System.out.format("addOne(%d) = %s%n", value, result);
        assertEquals(expResult, result);
        
        try {
            instance.addOne(Integer.MAX_VALUE);
            fail("should have thrown illegal argument exception");
        } catch (IllegalArgumentException expected) {
            System.out.println("caught exception on argument " + Integer.MAX_VALUE);
        }
    }

}
