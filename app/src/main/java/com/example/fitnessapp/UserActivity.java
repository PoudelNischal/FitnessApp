package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// 1. User Profile Page
public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        EditText nameField = findViewById(R.id.name);
        EditText ageField = findViewById(R.id.age);
        EditText weightField = findViewById(R.id.weight);
        EditText heightField = findViewById(R.id.height);
        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(v -> {
            // Create an intent to navigate to ExerciseTrackingActivity
            Intent intent = new Intent(UserActivity.this, ExerciseTrackingActivity.class);

            // Pass user details to ExerciseTrackingActivity
            intent.putExtra("name", nameField.getText().toString());
            intent.putExtra("age", ageField.getText().toString());
            intent.putExtra("weight", weightField.getText().toString());
            intent.putExtra("height", heightField.getText().toString());
            startActivity(intent);
        });
    }
}
