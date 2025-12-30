package com.app.problems;

public class FinallyExample {
    public static void main(String[] args) {
        try {
            return;
        }finally {
            System.out.println("Hello");
        }
    }
}
