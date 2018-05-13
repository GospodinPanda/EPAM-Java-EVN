package com.epam.task1.model.entity;

import java.util.Objects;

/**
 * Class {@code Plane} is used to store Plane entity
 *
 * @author SomSom
 */
public class Plane implements Comparable<Plane> {
    private String model;
    private int crewCount;
    private int carryingCapacity;
    private float fuelConsumption;
    private int flightRange;

    public Plane() {
        this.model = "unknown";
    }

    public Plane(String model) {
        this.model = model;
    }

    public Plane(String model, int crewCount, int carryingCapacity, float fuelConsumption, int flightRange) {
        this.model = model;
        this.crewCount = crewCount;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.flightRange = flightRange;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public void setCrewCount(int crewCount) {
        this.crewCount = crewCount;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }


    @Override
    public int compareTo(Plane o) {
      return Float.compare(this.getFlightRange(),o.getFlightRange());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return crewCount == plane.crewCount &&
                carryingCapacity == plane.carryingCapacity &&
                Float.compare(plane.fuelConsumption, fuelConsumption) == 0 &&
                Float.compare(plane.flightRange, flightRange) == 0 &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result=31*result + model.hashCode();
        result=31*result + crewCount;
        result=31*result + carryingCapacity;
        result=31*result + flightRange;
        result=31*result + Float.floatToIntBits(fuelConsumption);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + '\'' +
                ", crewCount=" + crewCount +
                ", carryingCapacity=" + carryingCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", flightRange=" + flightRange + " ";
    }
}
