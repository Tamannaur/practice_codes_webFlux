package com.app.solid;

//Interface Segregation Principle: Don't force the classes to implement interface
//which doesn't use
public class IExample {
    public static void main(String[] args) {
        Work r = new Robot();

        Eat e = new Human();

        r.work();
        e.eat();
        e.work();
    }
}
interface Work{
    void work();
}
interface Eat extends Work{
    void eat();
}

class Robot implements Work{
    @Override
    public void work() {
        System.out.println("Robot work");
    }
}

class Human implements Eat{
    @Override
    public void eat() {
        System.out.println("Human eat");
    }
    @Override
    public void work() {
        System.out.println("Human work");
    }
}

