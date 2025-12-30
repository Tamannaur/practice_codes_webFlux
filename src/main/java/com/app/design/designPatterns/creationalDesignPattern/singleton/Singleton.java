package com.app.design.designPatterns.creationalDesignPattern.singleton;

//Singleton design ensure that only one object instance will be used within the whole project.
//Means global point of access to that objetc
public class Singleton {
    public static void main(String[] args) {
        Student student = Student.getInstance(1,"Tamannaur");
        Student s2 = Student.getInstance(2,"Aktar");

        System.out.println(student.equals(s2));
        System.out.println(student.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(student.getName()+", "+s2.getName());
        System.out.println(student.getId()+", "+s2.getId());

    }
}

class Student{
    int id;
    String name;

    private Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    private static volatile Student studentInstance;
    public static Student getInstance(int id, String name){
        if(studentInstance == null){
            synchronized(Student.class){
                if(studentInstance == null){
                    studentInstance = new Student(id, name);
                }
            }
        }
        return studentInstance;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
