package com.example.vistaappartment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ParticipateInForum extends AppCompatActivity {

    private EditText editTextPost;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        // Initialize views
        editTextPost = findViewById(R.id.editTextPost);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set click listener for submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
            }
        });
    }

    private void submitPost() {
        // Get the entered post text
        String postText = editTextPost.getText().toString().trim();

        // Validate the post text
        if (postText.isEmpty()) {
            Toast.makeText(this, "Please enter your post", Toast.LENGTH_SHORT).show();
        } else {
            // TODO: Save the post to the forum or perform other actions
            // ...

            // Show a success message
            Toast.makeText(this, "Post submitted successfully", Toast.LENGTH_SHORT).show();

            // Clear the input field
            editTextPost.setText("");
        }
    }
}
