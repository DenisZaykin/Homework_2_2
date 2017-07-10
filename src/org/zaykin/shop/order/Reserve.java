package org.zaykin.shop.order;

import org.zaykin.shop.calc.ReserveCalc;
import org.zaykin.shop.exception.InvalidParameterException;
import org.zaykin.shop.part.ComputerPart;
import org.zaykin.shop.validator.ReserveValidator;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by a on 09.07.2017.
 */
public class Reserve {

    public static final Random RANDOM = new Random(10000);
    private final String orderId;
    private final String clientId;
    private final String name;
    private final int quantity;
    private ArrayList<ComputerPart> component= new ArrayList<>();
    public static final int MIN_LENGTH = 4;
    public static final int MAX_LENGTH = 20;
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 10;

    public Reserve (String clientId, String name, int quantity) throws InvalidParameterException{
        this.orderId = String.valueOf(RANDOM.nextInt(99999));
        this.clientId = clientId;
        this.name = name.length()>=MIN_LENGTH && name.length()<=MAX_LENGTH?name:"Client #"+orderId;
        if (quantity>=MIN_QUANTITY && quantity<=MAX_QUANTITY) {
            this.quantity = quantity;
        }
        else {
            throw new InvalidParameterException("Quantity should be between 1 and 10");
        }

    }

    public String getOrderId() {
        return orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void newComponent(ComputerPart... computerPart) {
        if (ReserveValidator.isValid(this, computerPart))
            for (ComputerPart tempPart:computerPart) {
                component.add(tempPart);
            }
    }

    public ArrayList<ComputerPart> getComponent() {
        return component;
    }

    public void printOrder() {
        System.out.println("["+getOrderId()+": "+getClientId()+": "+getName()+": "+getQuantity()+"]");
    }

    public void printCheck() {
        System.out.println();
        System.out.println("*********************************");
        System.out.println(String.format("Order: %s", getOrderId()));
        System.out.println(String.format("Client: %s", getClientId()));
        System.out.println(String.format("Name: %s", getName()));
        System.out.println("---------------------------------");
        for (ComputerPart tempComponent:getComponent()) {
            System.out.println(String.format("%-20s %5.2f $",tempComponent.getFullName(), tempComponent.getPrice()));
        }
        System.out.println("---------------------------------");
        System.out.println(String.format("%-20s %5.2f $", "Subtotal:", ReserveCalc.subTotal(this)));
        System.out.println(String.format("%-20s %d", "Quantity:", getQuantity()));
        System.out.println("---------------------------------");
        System.out.println(String.format("%-20s %5.2f $", "Total:", ReserveCalc.Total(this)));
        System.out.println("*********************************");
    }

}
