package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_summary_activity);

        TextView summaryText = findViewById(R.id.summary_text);
        Button editButton = findViewById(R.id.edit_button);

        // Retrieve data passed from ExerciseTrackingActivity
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String weight = getIntent().getStringExtra("weight");
        String height = getIntent().getStringExtra("height");
        String exerciseType = getIntent().getStringExtra("exercise_type");
        String duration = getIntent().getStringExtra("duration");
        String caloriesBurned = getIntent().getStringExtra("calories_burned");
        String meals = getIntent().getStringExtra("meals");
        String caloriesConsumed = getIntent().getStringExtra("calories_consumed");
        String waterIntake = getIntent().getStringExtra("water_intake");

        // Log data to ensure it's passed correctly
        Log.d("SummaryActivity", "name: " + name);
        Log.d("SummaryActivity", "age: " + age);

        // Handle null or missing values by providing default values
        if (name == null) name = "No Name";
        if (age == null) age = "Not Provided";
        if (weight == null) weight = "Not Provided";
        if (height == null) height = "Not Provided";
        if (exerciseType == null) exerciseType = "Not Provided";
        if (duration == null) duration = "0";
        if (caloriesBurned == null) caloriesBurned = "0";
        if (meals == null) meals = "Not Provided";
        if (caloriesConsumed == null) caloriesConsumed = "0";
        if (waterIntake == null) waterIntake = "0";

        // Build summary
        StringBuilder summaryBuilder = new StringBuilder();
        summaryBuilder.append("Name: ").append(name).append("\n");
        summaryBuilder.append("Age: ").append(age).append("\n");
        summaryBuilder.append("Weight: ").append(weight).append("\n");
        summaryBuilder.append("Height: ").append(height).append("\n");
        summaryBuilder.append("Exercise: ").append(exerciseType).append("\n");
        summaryBuilder.append("Duration: ").append(duration).append(" mins\n");
        summaryBuilder.append("Calories Burned: ").append(caloriesBurned).append("\n");
        summaryBuilder.append("Meals: ").append(meals).append("\n");
        summaryBuilder.append("Calories Consumed: ").append(caloriesConsumed).append("\n");
        summaryBuilder.append("Water Intake: ").append(waterIntake).append(" L");

        // Display summary text
        summaryText.setText(summaryBuilder.toString());

        // Button to edit the profile
        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryActivity.this, UserActivity.class);
            startActivity(intent);
        });
    }
}
