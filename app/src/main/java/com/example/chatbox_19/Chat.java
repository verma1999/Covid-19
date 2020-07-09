package com.example.chatbox_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chat extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    private EditText feedback,username;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        feedback = findViewById(R.id.feedbacktext);
        send = findViewById(R.id.sendButton);
        username = findViewById(R.id.UserName);

        database = FirebaseDatabase.getInstance();
    }

    public void sendFeedback(View view){

        String feedbackInput = feedback.getText().toString();
        String userName = username.getText().toString();
        mDatabase = database.getReference("Users").child(userName);

        mDatabase.child("Name").setValue(userName);
        mDatabase.child("feedback").setValue(feedbackInput).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Chat.this, "FeedBack send Successfully", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Chat.this, "Please Login and Try again", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
