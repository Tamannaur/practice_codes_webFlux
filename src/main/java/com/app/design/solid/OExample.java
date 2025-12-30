package com.app.design.solid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;

//Open-close principle
public class OExample {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        Shape shape = new Circle(2);
        System.out.println(df.format(shape.area()));

        Shape shape1 = new Rectangle(2,5);
        System.out.println(df.format(shape1.area()));
    }
}

interface Shape{
    public double area();
}

@Data
@AllArgsConstructor
@Builder
class Circle implements Shape{
    int radius;
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
@Data
@AllArgsConstructor
@Builder
class Rectangle implements Shape{
    int width, height;

    @Override
    public double area(){
        return  width * height;
    }
}
