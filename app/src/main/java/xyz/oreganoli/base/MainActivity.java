package xyz.oreganoli.base;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ThreadPoolExecutor executor;
    PlaceDatabase placeDb;
    BlockingQueue<List<Place>> places = new LinkedBlockingQueue<>();
    Random rand;
    EditText communeInput;
    EditText countyInput;
    EditText provinceInput;
    EditText countryInput;
    EditText continentInput;
    LinearLayout list;
    static String[] random_continents = {"Africa", "Europe"};
    static String[] random_countries = {"Burkina Faso", "Luxembourg", "Transnistria", "South Africa", "Tanzania", "France"};
    static String[] random_provinces = {"South", "North", "East", "West"};
    static String[] random_counties = {"Some Urban County", "Some Suburbs", "Some Rural County"};
    static String[] random_cities = {"Ouagadougou", "Grenoble", "Tiraspol", "Dar es Salaam"};
    private void getWidgets() {
        communeInput = findViewById(R.id.communeInput);
        countyInput = findViewById(R.id.countyInput);
        provinceInput = findViewById(R.id.provinceInput);
        countryInput = findViewById(R.id.countryInput);
        continentInput = findViewById(R.id.continentInput);
        list = findViewById(R.id.list);
    }
    void renderList() {
        list.removeAllViews();
        try {
            for (Place each : places.take()) {
                TextView text = new TextView(this);
                text.setText(each.commune + ", " + each.county + ", " + each.province + ", " + each.country + ", " + each.continent);
                list.addView(text);
            }
        } catch (InterruptedException ex) {
            Toast.makeText(this, "Threading error!", Toast.LENGTH_LONG).show();
        }
    }

    public void insert(View view) {
        Place place = new Place();
        place.commune = communeInput.getText().toString();
        place.county = countyInput.getText().toString();
        place.province = provinceInput.getText().toString();
        place.country = countryInput.getText().toString();
        place.continent = continentInput.getText().toString();
        if (place.commune.isEmpty()) {
            place.commune = random_cities[rand.nextInt(random_cities.length)];
        }
        if (place.county.isEmpty()) {
            place.county = random_counties[rand.nextInt(random_counties.length)];
        }
        if (place.province.isEmpty()) {
            place.province = random_provinces[rand.nextInt(random_provinces.length)];
        }
        if (place.country.isEmpty()) {
            place.country = random_countries[rand.nextInt(random_countries.length)];
        }
        if (place.continent.isEmpty()) {
            place.continent = random_continents[rand.nextInt(random_continents.length)];
        }
        executor.execute(new InsertOrder(placeDb.getPlaceDao(), place, places));
        communeInput.setText("");
        countyInput.setText("");
        provinceInput.setText("");
        countryInput.setText("");
        continentInput.setText("");
        renderList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();
        getWidgets();
        executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        placeDb = Room.databaseBuilder(getApplicationContext(), PlaceDatabase.class, "placeDB")
                .build();
        executor.execute(new ReadOrder(placeDb.getPlaceDao(), places));
        renderList();
    }
}
