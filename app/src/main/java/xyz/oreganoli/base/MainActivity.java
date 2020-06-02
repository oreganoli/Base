package xyz.oreganoli.base;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText communeInput;
    EditText countyInput;
    EditText provinceInput;
    EditText countryInput;
    EditText continentInput;
    Spinner criterion;
    EditText searchInput;
    CheckBox oneRow;
    LinearLayout list;

    private void getWidgets() {
        communeInput = findViewById(R.id.communeInput);
        countyInput = findViewById(R.id.countyInput);
        provinceInput = findViewById(R.id.provinceInput);
        countryInput = findViewById(R.id.countryInput);
        continentInput = findViewById(R.id.continentInput);
        criterion = findViewById(R.id.criterion);
        searchInput = findViewById(R.id.searchInput);
        oneRow = findViewById(R.id.oneRow);
        list = findViewById(R.id.list);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();
    }
}
