package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 3. Diet Tracking Page
public class DietTrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_diet_tracking_activity);

        EditText mealsField = findViewById(R.id.meals);
        EditText caloriesConsumedField = findViewById(R.id.calories_consumed);
        EditText waterIntakeField = findViewById(R.id.water_intake);
        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(DietTrackingActivity.this, SummaryActivity.class);
            intent.putExtra("meals", mealsField.getText().toString());
            intent.putExtra("calories_consumed", caloriesConsumedField.getText().toString());
            intent.putExtra("water_intake", waterIntakeField.getText().toString());
            startActivity(intent);
        });
    }
}