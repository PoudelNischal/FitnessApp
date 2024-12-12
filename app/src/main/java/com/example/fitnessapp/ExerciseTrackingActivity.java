package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseTrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_exercise_tracking_activity);

        // Get user profile data passed from UserActivity
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String weight = getIntent().getStringExtra("weight");
        String height = getIntent().getStringExtra("height");

        EditText exerciseTypeField = findViewById(R.id.exercise_type);
        EditText durationField = findViewById(R.id.duration);
        EditText caloriesBurnedField = findViewById(R.id.calories_burned);
        EditText mealsField = findViewById(R.id.meals);
        EditText caloriesConsumedField = findViewById(R.id.calories_consumed);
        EditText waterIntakeField = findViewById(R.id.water_intake);

        Button finishButton = findViewById(R.id.finish_button);

        finishButton.setOnClickListener(v -> {
            // Collect exercise and meal data
            String exerciseType = exerciseTypeField.getText().toString();
            String duration = durationField.getText().toString();
            String caloriesBurned = caloriesBurnedField.getText().toString();
            String meals = mealsField.getText().toString();
            String caloriesConsumed = caloriesConsumedField.getText().toString();
            String waterIntake = waterIntakeField.getText().toString();

            // Pass all data to SummaryActivity
            Intent intent = new Intent(ExerciseTrackingActivity.this, SummaryActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            intent.putExtra("weight", weight);
            intent.putExtra("height", height);
            intent.putExtra("exercise_type", exerciseType);
            intent.putExtra("duration", duration);
            intent.putExtra("calories_burned", caloriesBurned);
            intent.putExtra("meals", meals);
            intent.putExtra("calories_consumed", caloriesConsumed);
            intent.putExtra("water_intake", waterIntake);
            startActivity(intent);
        });
    }
}
