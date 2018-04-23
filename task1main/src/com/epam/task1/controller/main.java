package com.epam.task1.controller;

import com.epam.task1.exception.InputLogicException;
import com.epam.task1.exception.PlaneNotFoundException;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.logic.AerodromeLogic;
import com.epam.task1.util.AerodromeGenerator;

public class Main {
    public static void main(String[] args) {
        AerodromeGenerator generator = new AerodromeGenerator();
        Aerodrome aerodrome = generator.generateAerodrome();
        AerodromeLogic aerodromeLogic =new AerodromeLogic();

        System.out.println(aerodrome.toString());
        try {
            System.out.println("Cargo volume is: " + aerodromeLogic.countTotalCargoVolume(aerodrome));
            System.out.println("Carrying capacity is: " + aerodromeLogic.countTotalCarryingCapacity(aerodrome));
            System.out.println("Seat capacity: " + aerodromeLogic.countTotalSeatingCapacityIncludingCrew(aerodrome));
            aerodromeLogic.sortOnFlightRange(aerodrome);
            System.out.println(aerodrome.toString());
            System.out.println(aerodromeLogic.findPlaneWithFuelConsumption(aerodrome, 50, 5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
