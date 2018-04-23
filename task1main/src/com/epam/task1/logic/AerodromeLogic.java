package com.epam.task1.logic;

import com.epam.task1.exception.InputLogicException;
import com.epam.task1.exception.PlaneNotFoundException;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.model.entity.Airliner;
import com.epam.task1.model.entity.CargoPlane;
import com.epam.task1.model.entity.Plane;

import java.util.Collections;
import java.util.List;

public class AerodromeLogic {

    public int countTotalCarryingCapacity(Aerodrome aerodrome) {
        int totalCapacity = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            totalCapacity += currentPlane.getCarryingCapacity();
        }
        return totalCapacity;
    }

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
        return totalCapacity;
    }

    public int countTotalSeatingCapacityWithoutCrew(Aerodrome aerodrome) {
        int totalCapacity = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane instanceof Airliner) {
                totalCapacity += ((Airliner) currentPlane).getSeatingCapacity();
            }
        }
        return totalCapacity;
    }

    public float countTotalCargoVolume(Aerodrome aerodrome) {
        float totalVolume = 0;
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane instanceof CargoPlane) {
                totalVolume += ((CargoPlane) currentPlane).getCargoVolume();
            }
        }
        return totalVolume;
    }


    public void sortOnFlightRange(Aerodrome aerodrome) {
        Collections.sort(aerodrome.getPlanes());
    }


    public Plane findPlaneWithFuelConsumption(Aerodrome aerodrome, float from, float towards) throws InputLogicException, PlaneNotFoundException {
        if (from < 0.0f || towards < 0.0f) {
            throw new InputLogicException("fuel limits can't be negative");
        }
        List<Plane> planeList = aerodrome.getPlanes();
        for (Plane currentPlane : planeList) {
            if (currentPlane.getFuelConsumption() > from && currentPlane.getFuelConsumption() < towards) {
                return currentPlane;
            }
        }
        throw new PlaneNotFoundException();
    }

}
