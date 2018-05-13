package com.epam.task1.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aerodrome {

    private List<Plane> planes;

    public Aerodrome() {
        planes = new ArrayList<>();
    }

    public Aerodrome(Aerodrome aerodrome) {
        this.planes = aerodrome.planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void removePlane(int index) {
        planes.remove(index);
    }

    public void removePlane(Plane plane) {
        planes.remove(plane);
    }


    public int getSize() {
        return planes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aerodrome)) return false;
        Aerodrome aerodrome = (Aerodrome) o;
        return Objects.equals(getPlanes(), aerodrome.getPlanes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlanes());
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " planes:" + planes;
    }
}
