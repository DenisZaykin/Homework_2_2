package org.zaykin.shop.validator;

import org.zaykin.shop.order.Reserve;
import org.zaykin.shop.part.ComputerPart;

import java.util.ArrayList;

/**
 * Created by a on 10.07.2017.
 */
public class ReserveValidator {

    public static boolean isValid(Reserve reserve, ComputerPart...newComponent) {
        boolean result = true;

        for(ComputerPart tempPart : reserve.getComponent()) {
            for (ComputerPart tempPart1:newComponent) {
                if (tempPart.equals(tempPart1)) {
                    System.out.println("Component already exists in reserve");
                    result = false;
                    break;
                }
            }
        }

        return result;



    }

}
