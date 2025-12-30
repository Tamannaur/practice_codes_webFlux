package com.app.design.designPatterns.creationalDesignPattern.abstractFactoryDesignPattern;

//It is a design pattern that provides an interface that groups all related objects
//without specifying the concrete classes to the client
public class AbstractFactory {
    public static void main(String[] args) {
        GUIButton guiButton = new WindowsGUIButton();
        Button button = guiButton.createButton();
        button.paint();

        GUIButton guiButton2 = new LinuxGUIButton();
        Button b2 = guiButton2.createButton();
        b2.paint();
    }
}

interface Button{
    public void paint();
}

class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}

class LinuxButton implements Button{
    @Override
    public void paint() {
        System.out.println("Linux Button");
    }
}
//abstract factory
interface GUIButton{
    public Button createButton();
}
class  WindowsGUIButton implements GUIButton{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class LinuxGUIButton implements GUIButton{
    @Override
    public Button createButton(){
        return new LinuxButton();
    }
}

