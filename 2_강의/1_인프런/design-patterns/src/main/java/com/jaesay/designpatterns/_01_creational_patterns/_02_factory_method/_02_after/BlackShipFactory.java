package com.jaesay.designpatterns._01_creational_patterns._02_factory_method._02_after;

public class BlackShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
