package com.pcbuilder.checkout;

/**
 * Created by dev0 on 11/16/22.
 */
public class Payment {

    Long creditCarNumber;
    Integer ccv;
    String customerNameOnCard;

    public Payment(){}
    public Payment(Long creditCarNumber, Integer ccv, String customerNameOnCard) {
        this.creditCarNumber = creditCarNumber;
        this.ccv = ccv;
        this.customerNameOnCard = customerNameOnCard;
    }

    @Override
    public String toString(){
        return "name: " + customerNameOnCard;
    }

}