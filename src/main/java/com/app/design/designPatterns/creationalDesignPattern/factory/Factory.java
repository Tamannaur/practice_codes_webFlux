package com.app.design.designPatterns.creationalDesignPattern.factory;


//Used to create object without exposing the creation logic
//Rather than creating object by directly calling constructor we create via factory method
//And call the interface
public class Factory {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("circle",11,10);
        System.out.println(shape.area());

        Shape shape1 = ShapeFactory.getShape("rectangle",11,10);
        System.out.println(shape1.area());


    }
}

interface Shape{
    double area();
}

class  Circle implements Shape{
    int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return  Math.PI * radius * radius;
    }
}

class Rectangle implements Shape{
    int width;
    int height;
    public Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }
}
class ShapeFactory{
    public static Shape getShape(String type, int a, int b){
        if(type.equalsIgnoreCase("circle")){
            return new Circle(a);
        }
        else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle(a,b);
        }
        throw  new IllegalArgumentException("Unknown shape type"+type);
    }
}