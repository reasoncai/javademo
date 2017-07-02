package com.cai.javademo.enmu;

/**
 * Created by reason on 17/7/1.
 */
public class CurrencyOrder {
    public static void main(String[] args) {
        for(Currency currency : Currency.values()){
            System.out.println(currency +", ordinal "+currency.ordinal());
        }
    }
}
