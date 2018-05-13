package com.epam.task1.util;

import com.epam.task1.model.entity.*;

import java.util.Random;
import java.util.UUID;

/**
 * Class {@code {@link com.epam.task1.logic.AerodromeLogic}} is used to generate whole aerodromes
 */
public class AerodromeGenerator {
    private static final int MAX_AERODROME_SIZE = 10;
    private static final int MAX_SEATING_CAPACITY = 400;
    private static final int MIN_SEATING_CAPACITY = 10;
    private static final int MAX_CARRYING_CAPACITY = 10000;
    private static final int MIN_CARRYING_CAPACITY = 1000;
    private static final int MIN_CREW_COUNT = 1;
    private static final int MAX_CREW_COUNT = 25;
    private static final float MIN_FUEL_CONSUMPTION = 50f;
    private static final float MAX_FUEL_CONSUMPTION = 5000f;
    private static final int MIN_FLIGHT_RANGE = 1000;
    private static final int MAX_FLIGHT_RANGE = 15000;
    private static final int MIN_CARGO_VOLUME = 200;
    private static final int MAX_CARGO_VOLUME = 5000;


    public Aerodrome generateAerodrome() {
        Aerodrome aerodrome = new Aerodrome();
        Random random = new Random();
        int aerodromeSize = random.nextInt(MAX_AERODROME_SIZE) + 1;
        for (int i = 0; i < aerodromeSize; i++) {
            if (random.nextBoolean()) {
                aerodrome.addPlane(generatePlane(PlaneTypes.AIRLINER));
            } else {
                aerodrome.addPlane(generatePlane(PlaneTypes.CARGOPLANE));
            }
        }
        return aerodrome;
    }

    public Plane generatePlane(PlaneTypes planeType) {
        Plane plane = null;
        switch (planeType) {
            case AIRLINER:
                plane = generateAirliner();
                break;
            case CARGOPLANE:
                plane = generateCargoPlane();
                break;
        }
        return plane;
    }


    private Airliner generateAirliner() {
        StringBuilder name = new StringBuilder("Airliner№");
        UUID id = UUID.randomUUID();
        name.append(id);
        Random random = new Random();
        int seatingCapacity = random.nextInt(MAX_SEATING_CAPACITY) + MIN_SEATING_CAPACITY;
        int carryingCapacity = random.nextInt(MAX_CARRYING_CAPACITY) + MIN_CARRYING_CAPACITY;
        int crewCount = random.nextInt(MAX_CREW_COUNT) + MIN_CREW_COUNT;
        float fuelConsumption = MIN_FUEL_CONSUMPTION + random.nextFloat() * (MAX_FUEL_CONSUMPTION - MIN_FUEL_CONSUMPTION);
        int flightRange = random.nextInt(MAX_FLIGHT_RANGE) + MIN_FLIGHT_RANGE;
        Airliner temp = new Airliner(name.toString());
        temp.setCarryingCapacity(carryingCapacity);
        temp.setCrewCount(crewCount);
        temp.setFlightRange(flightRange);
        temp.setFuelConsumption(fuelConsumption);
        temp.setSeatingCapacity(seatingCapacity);
        return temp;
    }

    private CargoPlane generateCargoPlane() {
        StringBuilder name = new StringBuilder("CargoPlane№");
        UUID id = UUID.randomUUID();
        name.append(id);
        Random random = new Random();
        int carryingCapacity = random.nextInt(MAX_CARRYING_CAPACITY) + MIN_CARRYING_CAPACITY;
        int crewCount = random.nextInt(MAX_CREW_COUNT) + MIN_CREW_COUNT;
        float fuelConsumption = MIN_FUEL_CONSUMPTION + random.nextFloat() * (MAX_FUEL_CONSUMPTION - MIN_FUEL_CONSUMPTION);
        int flightRange = random.nextInt(MAX_FLIGHT_RANGE) + MIN_FLIGHT_RANGE;
        int cargoVolume = random.nextInt(MAX_CARGO_VOLUME) + MIN_CARGO_VOLUME;
        CargoPlane temp = new CargoPlane(name.toString());
        temp.setCarryingCapacity(carryingCapacity);
        temp.setCrewCount(crewCount);
        temp.setFlightRange(flightRange);
        temp.setFuelConsumption(fuelConsumption);
        temp.setCargoVolume(cargoVolume);
        return temp;
    }
}
