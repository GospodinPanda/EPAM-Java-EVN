package com.epam.task1.logic;

import com.epam.task1.exception.InputLogicException;
import com.epam.task1.exception.PlaneNotFoundException;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.model.entity.Airliner;
import com.epam.task1.model.entity.CargoPlane;
import com.epam.task1.model.entity.Plane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Class {@code {@link AerodromeLogic}} is used to work on aerodrome logic
 */
public class AerodromeLogic {
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * @param aerodrome is an aerodrome entity
     * @return total carrying capacity of the given aerodrome
     * @see Aerodrome
     */
    public int countTotalCarryingCapacity(Aerodrome aerodrome) {
        int totalCapacity = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            totalCapacity += currentPlane.getCarryingCapacity();
        }
        LOGGER.log(Level.INFO,"Calculated carrying capacity");
        return totalCapacity;
    }

    /**
     * @param aerodrome is an aerodrome entity
     * @return total seating capacity of the given aerodrome including crew
     * @see Aerodrome
     */
    public int countTotalSeatingCapacityIncludingCrew(Aerodrome aerodrome) {
        int totalCapacity = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane instanceof Airliner) {
                totalCapacity += ((Airliner) currentPlane).getSeatingCapacity() + currentPlane.getCrewCount();
            } else {
                totalCapacity += currentPlane.getCrewCount();
            }
        }
        LOGGER.log(Level.INFO,"Calculated seating capacity with a crew");
        return totalCapacity;
    }

    /**
     * @param aerodrome is an aerodrome entity
     * @return total seating capacity of the given aerodrome except crew
     * @see Aerodrome
     */
    public int countTotalSeatingCapacityWithoutCrew(Aerodrome aerodrome) {
        int totalCapacity = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane instanceof Airliner) {
                totalCapacity += ((Airliner) currentPlane).getSeatingCapacity();
            }
        }
        LOGGER.log(Level.INFO,"Calculated seating capacity without a crew");
        return totalCapacity;
    }

    /**
     * @param aerodrome is an aerodrome entity
     * @return total cargo volume, that all planes could
     * @see Aerodrome
     */
    public float countTotalCargoVolume(Aerodrome aerodrome) {
        float totalVolume = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane instanceof CargoPlane) {
                totalVolume += ((CargoPlane) currentPlane).getCargoVolume();
            }
        }
        LOGGER.log(Level.INFO,"Calculated cargo volume");
        return totalVolume;
    }

    /**
     * Sorts planes in the Aerodrome entity using Collections method sort
     *
     * @param aerodrome is an aerodrome to be sorted
     * @see Aerodrome
     */
    public void sortOnFlightRange(Aerodrome aerodrome) {
        Collections.sort(aerodrome.getPlanes());
        LOGGER.log(Level.INFO,"Sorted planes on flight range");
    }

    /**
     * This method is looking for plane, that meet the requirements about fuel consumption
     *
     * @param aerodrome is aerodrome entity
     * @param from      means the bottom line of fuel consumption
     * @param towards   means the top line of fuel consumption
     * @return Plane, that meet the requirements
     * @throws InputLogicException    could be thrown, when there are arguments below 0.
     * @throws PlaneNotFoundException could be thrown, when there is no such plane at the aerodrome
     * @see Aerodrome
     */
    public Plane findPlaneWithFuelConsumption(Aerodrome aerodrome, float from, float towards) throws InputLogicException, PlaneNotFoundException {
        LOGGER.log(Level.DEBUG,"Param from: "+from+"; Param towards: "+towards);
        if (from < 0.0f || towards < 0.0f) {
            throw new InputLogicException("fuel limits can't be negative");
        }
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane.getFuelConsumption() > from && currentPlane.getFuelConsumption() < towards) {
                LOGGER.log(Level.INFO,"Found a plane with such parameters");
                return currentPlane;
            }
        }
        throw new PlaneNotFoundException();

    }

}
