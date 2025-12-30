package com.app.problems;

import java.time.LocalDateTime;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.addOrder("abc123", new Order(150.0, 1, LocalDateTime.now().minusDays(3)));
        orderService.addOrder("abc123", new Order(180.0, 2, LocalDateTime.now().plusDays(1)));

        CustomerResponse res = orderService.findLatestCustomer("abc123");
        res.print();
    }
}

class OrderService {
    Map<String, List<Order>> map = new TreeMap<>();

    public void addOrder(String customerId, Order order) {
//        List<Order> list = map.get(customerId);
//        list.add(order);
//        map.put(customerId, list);

        map.computeIfAbsent(customerId, v -> new ArrayList<>()).add(order);
    }

    public CustomerResponse findLatestCustomer(String customerId) {
        List<Order> orders = map.get(customerId);
        if (orders == null) return null;
        double amounts = orders.stream().mapToDouble(Order::getAmount).sum();
        LocalDateTime time = orders.stream().map(Order::getOrderDate)
                .skip(orders.size() - 1)
                .findFirst().orElse(LocalDateTime.now());
        return new CustomerResponse(amounts, time);
    }
}

class CustomerResponse {
    double amount;
    LocalDateTime orderDate;

    public CustomerResponse(double amount, LocalDateTime orderDate) {
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public void print() {
        System.out.println("amount:" + amount);
        System.out.println("orderDate:" + orderDate);
    }
}


class Order {
    private double amount;
    private int orderId;
    private LocalDateTime orderDate;

    public Order(double amount, int orderId, LocalDateTime orderDate) {
        this.amount = amount;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }
}