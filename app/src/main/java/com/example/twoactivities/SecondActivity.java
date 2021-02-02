package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    //define the key for the intent extra
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    //variable to hold the editText
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get reference of the editText
        mReply = findViewById(R.id.editText_second);

        Intent intent = getIntent();

        //string containing the message from the intent extras
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {

        //return text as a string
        String reply = mReply.getText().toString();

        //new intent for the reply message
        Intent replyIntent = new Intent();

        //intent extras come in key/value pairs
        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK,replyIntent);

        finish();

    }
}
