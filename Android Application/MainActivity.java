package com.example.hukamnamaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hukamnamaapp.viewmodel.HukamnamaViewModel;
import com.example.hukamnamaapp.model.Hukamnama;

public class MainActivity extends AppCompatActivity {
    private TextView textDate, textPunjabi, textEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDate = findViewById(R.id.textDate);
        textPunjabi = findViewById(R.id.textPunjabi);
        textEnglish = findViewById(R.id.textEnglish);

        HukamnamaViewModel viewModel = new ViewModelProvider(this).get(HukamnamaViewModel.class);
        viewModel.getHukamnama().observe(this, hukamnama -> {
            if (hukamnama != null) {
                textDate.setText("Date: " + hukamnama.getDate());
                textPunjabi.setText("Punjabi: " + hukamnama.getPunjabi());
                textEnglish.setText("English: " + hukamnama.getEnglish());
            } else {
                textDate.setText("Error loading Hukamnama");
            }
        });
    }
}
