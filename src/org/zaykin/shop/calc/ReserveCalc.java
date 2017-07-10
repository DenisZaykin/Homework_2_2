package org.zaykin.shop.calc;

import org.zaykin.shop.order.Reserve;
import org.zaykin.shop.part.ComputerPart;

/**
 * Created by a on 10.07.2017.
 */
public class ReserveCalc {

    public static float subTotal (Reserve reserve) {
        float price = 0f;
        for (ComputerPart tempPart:reserve.getComponent()) {
            price += tempPart.getPrice();
        }
        return price;
    }

    public static float Total (Reserve reserve) {
        return subTotal(reserve)*reserve.getQuantity();
    }

}
