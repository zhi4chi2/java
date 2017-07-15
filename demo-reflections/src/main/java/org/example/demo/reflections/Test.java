package org.example.demo.reflections;

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanner;

public class Test {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("org.reflections");
        Set<Class<? extends Scanner>> subTypes = reflections.getSubTypesOf(Scanner.class);
        for (Class<? extends Scanner> clazz : subTypes) {
            // org.reflections.scanners.TypeElementsScanner
            // org.reflections.scanners.TypesScanner
            // org.reflections.scanners.MethodParameterScanner
            // org.reflections.scanners.MethodParameterNamesScanner
            // org.reflections.scanners.MethodAnnotationsScanner
            // org.reflections.scanners.SubTypesScanner
            // org.reflections.scanners.AbstractScanner
            // org.reflections.scanners.TypeAnnotationsScanner
            // org.reflections.scanners.FieldAnnotationsScanner
            // org.reflections.scanners.ResourcesScanner
            // org.reflections.scanners.MemberUsageScanner
            System.out.println(clazz.getName());
        }
    }
}
