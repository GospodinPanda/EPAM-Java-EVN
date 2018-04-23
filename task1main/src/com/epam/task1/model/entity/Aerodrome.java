package com.epam.task1.model.entity;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        return getClass().getName() +
                " planes:" + planes;
    }
}
