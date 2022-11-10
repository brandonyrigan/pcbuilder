package com.pcbuilder.client;

import com.pcbuilder.session.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Hello PC Builder" );
        run();
    }

    public static void run(){
        startCustomerSession();
    }
    public static void startCustomerSession(){
        new Session();
    }
}