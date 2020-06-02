package xyz.oreganoli.base;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlaceDao {
    @Query("SELECT * FROM place")
    public List<Place> get_all();
    @Insert
    public void insert(Place place);
}
