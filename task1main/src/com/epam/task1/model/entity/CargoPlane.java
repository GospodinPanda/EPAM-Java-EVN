package com.epam.task1.model.entity;

import java.util.Objects;

/**
 * Is an extension of {@code Plane} that is used to store CargoPlane entity
 *
 * @author SomSom
 */
public class CargoPlane extends Plane {
    private float cargoVolume;

    public CargoPlane(String model) {
        super(model);
    }

    public CargoPlane(String model, int crewCount, int carryingCapacity, float fuelConsumption, int flightRange, float cargoVolume) {
        super(model, crewCount, carryingCapacity, fuelConsumption, flightRange);
        this.cargoVolume = cargoVolume;
    }

    public float getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(float cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return Float.compare(that.cargoVolume, cargoVolume) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), cargoVolume);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " cargoVolume=" + cargoVolume;
    }
}
