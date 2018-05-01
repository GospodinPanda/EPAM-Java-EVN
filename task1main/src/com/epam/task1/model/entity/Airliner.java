package com.epam.task1.model.entity;

import java.util.Objects;

public class Airliner extends Plane {
    private int seatingCapacity;

    public Airliner() {
        super();
    }

    public Airliner(String model) {
        super(model);
    }

    public Airliner(String model, int crewCount, int carryingCapacity, float fuelConsumption, int flightRange, int seatingCapacity) {
        super(model, crewCount, carryingCapacity, fuelConsumption, flightRange);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airliner airliner = (Airliner) o;
        return seatingCapacity == airliner.seatingCapacity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), seatingCapacity);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " seatingCapacity=" + seatingCapacity + " ";
    }
}
