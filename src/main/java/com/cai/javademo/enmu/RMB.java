package com.cai.javademo.enmu;

/**
 * Created by reason on 17/7/1.
 */
public class RMB {
    private Currency currency;
    public RMB(Currency currency){
        this.currency = currency;
    }
    public void describe(){
        System.out.print("This rmb is ");
        switch (currency){
            case ONE:
                System.out.println("1 yuan");
                break;
            case TEN:
                System.out.println("10 yuan");
                break;
            case TWENTY:
                System.out.println("20 yuan");
                break;
            case FIFTY:
                System.out.println("50 yuan");
                break;
            case ONE_HUNDRED:
                System.out.println("100 yuan");
        }
    }

    public static void main(String[] args) {
        RMB rmb = new RMB(Currency.TWENTY);
        RMB rmb2 = new RMB(Currency.ONE_HUNDRED);
        rmb.describe();
        rmb2.describe();
    }
}
