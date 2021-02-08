package com.example.firstprogrammingassignmentcs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.firstprogrammingassignmentcs.MESSAGE";
    private FirebaseAnalytics analytics;
    private DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analytics = FirebaseAnalytics.getInstance(this);
        reff = FirebaseDatabase.getInstance().getReference().child("String");
    }
    public void sendMessage(View view) {
        Intent intent = new Intent( this, DisplayMessageActivity.class);
        EditText editText;
        editText = (EditText) findViewById(R.id.editText);
        analytics.logEvent("Message Sent", null);
        String message = editText.getText().toString();
        reff.push().setValue(message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}