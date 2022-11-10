package com.pcbuilder.session;

import com.pcbuilder.checkout.Order;
import com.pcbuilder.checkout.ShoppingCart;
import com.pcbuilder.customer.Customer;
import com.pcbuilder.inventory.Inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Session {

    private UUID uuid;
    private LocalDate sessionStart;
    private LocalDate sessionEnd;

    private Customer customer;
    private Inventory inventory;
    private ShoppingCart shoppingCart;
    private Order order;

    public Session() {}
    public Session(
            LocalDate sessionStart,
            LocalDate sessionEnd,
            Customer customer,
            Inventory inventory,
            ShoppingCart shoppingCart,
            Order order
    ) {
        setUuid();
        setSessionStart();
        setSessionEnd();
    }

    public UUID getUuid() { return uuid; }
    public void setUuid() {
        UUID uuid = UUID.randomUUID();
        this.uuid = uuid;
    }
    public LocalDate getSessionStart() { return this.sessionStart; }
    public void setSessionStart() {
        LocalDate start = LocalDate.from(LocalDateTime.now());
        this.sessionStart = start;
    }
    public LocalDate getSessionEnd() { return sessionEnd; }
    public void setSessionEnd() {
        LocalDate end = LocalDate.from(LocalDateTime.now());
        this.sessionEnd = end;
    }

}