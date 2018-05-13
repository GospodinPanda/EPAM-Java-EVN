package com.epam.task1.controller;

import com.epam.task1.exception.InputLogicException;
import com.epam.task1.exception.PlaneNotFoundException;
import com.epam.task1.logic.AerodromeLogic;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.util.AerodromeGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
        AerodromeGenerator generator = new AerodromeGenerator();
        Aerodrome aerodrome = generator.generateAerodrome();
        AerodromeLogic aerodromeLogic = new AerodromeLogic();
        LOGGER.log(Level.INFO,aerodrome.toString());
        try {
            LOGGER.log(Level.INFO,"Cargo volume is: " + aerodromeLogic.countTotalCargoVolume(aerodrome));
            LOGGER.log(Level.INFO,"Carrying capacity is: " + aerodromeLogic.countTotalCarryingCapacity(aerodrome));
            LOGGER.log(Level.INFO,"Seat capacity: " + aerodromeLogic.countTotalSeatingCapacityIncludingCrew(aerodrome));
            aerodromeLogic.sortOnFlightRange(aerodrome);
            LOGGER.log(Level.INFO,aerodrome.toString());
            LOGGER.log(Level.INFO,aerodromeLogic.findPlaneWithFuelConsumption(aerodrome, 50, 500));
        } catch (InputLogicException e) {
            LOGGER.log(Level.ERROR,"Input data is wrong. It should be positive "+e);

        } catch (PlaneNotFoundException e) {
            LOGGER.log(Level.ERROR,"Plane not found "+e);
        }
    }
}
