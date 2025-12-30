package com.app.problems;

import java.lang.reflect.Field;

public class ReflectionBreak {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        StudentReflection obj = new StudentReflection(1, "Tamannaur");

        obj.print();

        Field field = StudentReflection.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"Aktar");
        obj.print();
    }

}
final class StudentReflection{
    private int id;
    private String name;

    public StudentReflection(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println(id);
        System.out.println(name);
    }
}
