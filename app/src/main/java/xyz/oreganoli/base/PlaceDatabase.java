package xyz.oreganoli.base;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(version = 1, entities = {Place.class})
public abstract class PlaceDatabase extends RoomDatabase {
    abstract public PlaceDao getPlaceDao();
}
