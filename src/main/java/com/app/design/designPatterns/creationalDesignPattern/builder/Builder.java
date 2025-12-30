package com.app.design.designPatterns.creationalDesignPattern.builder;

public class Builder {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .setAge(27)
                .setName("Tamannur")
                .build();
        System.out.println(student.getName()+": "+student.getAge());
    }
}

class Student {
    private String name;
    private int age;
    public Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public static class StudentBuilder{
        private String name;
        private int age;

        public StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

}
