package xyz.oreganoli.base;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Place {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String commune = "";
    public String county = "";
    public String province = "";
    public String country = "";
    public String continent = "";
}
