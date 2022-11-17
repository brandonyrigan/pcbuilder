package com.pcbuilder.checkout;

/**
 * Created by dev0 on 11/16/22.
 */
public class Payment {

    int creditCarNumber;
    int ccv;
    String customerNameOnCard;

    public Payment(){}
    public Payment(int creditCarNumber, int ccv, String customerNameOnCard) {
        this.creditCarNumber = creditCarNumber;
        this.ccv = ccv;
        this.customerNameOnCard = customerNameOnCard;
    }

    @Override
    public String toString(){
        return "name: " + customerNameOnCard;
    }

}