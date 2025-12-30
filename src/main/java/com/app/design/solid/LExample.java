package com.app.design.solid;
//Liskov Substitution Principle
public class LExample {
    public static void main(String[] args) {
        FlyingBird bird = new Peacock();
        Bird bird1 = new Ostrich();
        bird1.eat();
        bird.eat();
        bird.fly();
    }
}
interface Bird{
    void eat();
}
interface FlyingBird extends Bird{
    void fly();
}

class Peacock implements FlyingBird{
    @Override
    public void eat() {
        System.out.println("Carrot eat");
    }
    @Override
    public void fly() {
        System.out.println("Carrot fly");
    }
}

class Ostrich implements Bird{
    @Override
    public void eat(){
        System.out.println("Ostrich eat");
    }
}