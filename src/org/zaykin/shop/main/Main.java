package org.zaykin.shop.main;

import org.zaykin.shop.exception.InvalidParameterException;
import org.zaykin.shop.order.Reserve;
import org.zaykin.shop.part.ComputerPart;

/**
 * Created by a on 09.07.2017.
 */
public class Main {

    public  static void main(String[] args) {
        Reserve reserve1 = null;
        Reserve reserve2 = null;
        try {
            reserve1 = new Reserve("47123", "Computer Game", 3);
            reserve2 = new Reserve("43712", "Standard PC", 1);
        }
        catch (InvalidParameterException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        reserve1.printOrder();
        reserve2.printOrder();
        reserve1.newComponent(ComputerPart.MB, ComputerPart.CPU, ComputerPart.RAM, ComputerPart.GC, ComputerPart.PS, ComputerPart.HDD, ComputerPart.CASE);
        reserve2.newComponent(ComputerPart.MB, ComputerPart.CPU, ComputerPart.RAM, ComputerPart.GC, ComputerPart.PS, ComputerPart.HDD, ComputerPart.PCI, ComputerPart.DVD, ComputerPart.MINI_CASE);
        reserve1.printCheck();
        reserve2.printCheck();
    }


}
