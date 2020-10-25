package com.artyushin.hw082;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner languageSpinner;
    String selectedlanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.languageSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                selectedlanguage = languageSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, selectedlanguage,Toast.LENGTH_LONG).show();
                switch (selectedlanguage) {
                    case "Russian":
                        russian();
                        break;
                    case "English":
                        english();
                        break;
                    case "Finnish":
                        finnish();
                        break;
                    case "Английский":
                        english();
                        break;
                    case "Русский":
                        russian();
                        break;
                    case "Финский":
                        finnish();
                        break;
                    case "Venäjä":
                        russian();
                        break;
                    case "Englanti":
                        english();
                        break;
                    case "Suomalainen":
                        finnish();
                        break;
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void russian() {
        Locale locale = new Locale("ru");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void english() {
        Locale locale = new Locale("en");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void finnish() {
        Locale locale = new Locale("fi");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }


}