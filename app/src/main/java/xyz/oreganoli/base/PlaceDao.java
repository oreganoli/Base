package xyz.oreganoli.base;

import java.util.ArrayList;

public class PlaceDao {
    private ArrayList<Place> places = new ArrayList<>(); // in memory for now
    public ArrayList<Place> get_all() {
        return places;
    }
    public void insert(Place place) {
        places.add(place);
    }
}
