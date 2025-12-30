package com.app.design.designPatterns.structuralDesignPattern.adapter;

//Convert one interface to another interface
//Like it will acts as bridge between old code to new code
//Eg, Traveling to US and there mobile adapter socket is different so
//instead of buying new charger we can buy adapter
//Today I changed for PayPal and tomorrow if I change for other payment method
//then also client code code will same like paymentService.pay()
public class Adapter {
    public static void main(String[] args) {
        PaymentService paymentService = new PayPalAdapter(new PayPalPayment());
        paymentService.pay(100);
    }
}

interface PaymentService{
    public void pay(double amount);
}

class PayPalPayment{
    public void makePayment(double amount){
        System.out.println("Payment made by PayPal, amount $"+amount);
    }
}

class PayPalAdapter implements PaymentService{
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment){
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void pay(double amount) {
        payPalPayment.makePayment(amount);
    }
}

