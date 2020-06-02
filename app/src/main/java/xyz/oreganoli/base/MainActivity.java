package xyz.oreganoli.base;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText communeInput;
    EditText countyInput;
    EditText provinceInput;
    EditText countryInput;
    EditText continentInput;
    LinearLayout list;

    private void getWidgets() {
        communeInput = findViewById(R.id.communeInput);
        countyInput = findViewById(R.id.countyInput);
        provinceInput = findViewById(R.id.provinceInput);
        countryInput = findViewById(R.id.countryInput);
        continentInput = findViewById(R.id.continentInput);
        list = findViewById(R.id.list);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();
    }
}
