package com.app;

import java.text.DecimalFormat;

public class SOLIDExample {
    public static void main(String[] args) {
        System.out.println("SOLIDExample");
    }

}
//Single Responsible Principle: Only one reason to change
class Read{
    public void read(){
        System.out.println("Reading");
    }
}
class Write{
    public void write(){
        System.out.println("Writing");
    }
}

class SExample {
    public static void main(String[] args) {
        Read read = new Read();
        read.read();

        Write write = new Write();
        write.write();
    }

}

//Open-Close principle: Open for extension but close for modification
interface Shape{
    public void area();
}

class Circle implements Shape{
    int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public void area(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Area of Circle: "+ df.format(Math.PI * radius * radius));
    }
}

class Rectangle implements Shape{
    int width, height;

    public Rectangle(int w, int h){
        this.width = w;
        this.height = h;
    }

    @Override
    public void area(){
        System.out.println("Area of Rectangle: "+ width*height);
    }
}

class OCExample{
    public static void main(String[] args) {
        Shape shape = new Circle(12);
        shape.area();

        Shape shape1 = new Rectangle(10,20);
        shape1.area();
    }
}

//LisKov Substitution Principle: Subclass should be replaced by their Parents class
// without breaking functionality
interface Eat{
    void eat();

}
interface Fly extends Eat{
    void fly();
}

class FlyingBird implements Fly{
    @Override
    public void eat(){
        System.out.println("Eating");
    }

    @Override
    public void fly(){
        System.out.println("Flying");
    }
}

class Ostrich implements Eat{
    @Override
    public void eat(){
        System.out.println("Eating");
    }
}
class LiskovExample{
    public static final synchronized void main(String...args) {
        Fly fly = new FlyingBird();
        fly.fly();
        fly.eat();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Eat eat = new Ostrich();
        eat.eat();
    }
}

//Interface Segregation Principle: Don't force the classes to implement interface
//which doesn't use

interface Work{
    public void work();
}
interface Eats extends Work{
    public void eat();
}

class Robot implements Work{
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

class Human implements Eats{

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }

    @Override
    public void work() {
        System.out.println("Human is working...");
    }
}
class IExample{
    public static  void main(String... args) {
        Work work = new Robot();
        work.work();

        Eats human = new Human();
        human.eat();
        human.work();
    }
}

//Dependency Inversion Principle: High level modules should not depends
//on low level modules

interface Notification{
    public void notification();
}

class EmailNotification implements Notification{
    @Override
    public void notification() {
        System.out.println("Email notification");
    }
}
class SmsNotification implements Notification{
    @Override
    public void notification() {
        System.out.println("SMS notification");
    }
}

class NotificationManager{
    public Notification notification;
    public NotificationManager(Notification notification){
        this.notification = notification;
    }

    public void setNotification(){
       notification.notification();
    }
}

class DIPExample{
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager(new EmailNotification());
        notificationManager.setNotification();

        NotificationManager notificationManager1 = new NotificationManager(new SmsNotification());
        notificationManager1.setNotification();
    }
}




