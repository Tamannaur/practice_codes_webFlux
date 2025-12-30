package com.app.design.solid;
//Single Responsibility Principle
public class SExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Report report = new Report();

        userService.addUser("Tamannar");
        report.generateReport();
    }
}

class UserService{
    public void addUser(String name){
        System.out.println("Adding user "+name);
    }
}
class Report{
    public void generateReport(){
        System.out.println("Report is generated");
    }

}