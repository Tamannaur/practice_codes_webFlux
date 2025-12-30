package com.app.design.designPatterns.structuralDesignPattern.adapter;

import java.security.PublicKey;

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new NormalCoffee();
        Coffee sweetCoffee = new SweetCoffee(coffee);
        Coffee milkCoffee = new MilkCoffee(sweetCoffee);
        Coffee filterCoffe = new FilteringCoffee(milkCoffee);
        filterCoffe.makeCoffee();
    }
}

interface Coffee{
    public  void makeCoffee();
}

class NormalCoffee implements Coffee{
    @Override
    public void makeCoffee() {
        System.out.println("Normal Coffee");
    }
}
abstract class CoffeeDecorator implements Coffee{
    Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public void makeCoffee() {
        coffee.makeCoffee();
    }
}

class SweetCoffee extends CoffeeDecorator{

    public SweetCoffee(Coffee coffee) {
        super(coffee);
    }

    public void makeCoffee() {
        coffee.makeCoffee();
        System.out.println("Added sugar");
    }
}
class MilkCoffee extends CoffeeDecorator {
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        System.out.println("Added milk");
    }
}

class FilteringCoffee extends CoffeeDecorator{

    public FilteringCoffee(Coffee coffee) {
        super(coffee);
    }
    public void makeCoffee() {
        super.makeCoffee();
        System.out.println("Filter coffee");
    }
}
