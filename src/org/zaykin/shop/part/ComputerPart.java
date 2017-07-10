package org.zaykin.shop.part;

/**
 * Created by a on 09.07.2017.
 */
public enum ComputerPart {
    CPU(50f,"CPU"), RAM(20f,"RAM Modules"), GC(100,"Graphics Card"), PS(30,"Power Supply"), MB(70,"Motherboard"), DVD(15,"CD/DVD drive"), HDD(40,"Hard Driver"), PCI(10,"PCI-Device"), CASE(20,"PC Block"), MINI_CASE(50,"Mini-PC Block");

    private float price;
    private String fullName;
    ComputerPart(float price, String fullName) {
        this.price = price;
        this.fullName = fullName;
    }

    public float getPrice() {
        return price;
    }

    public String getFullName() {
        return fullName;
    }

}
