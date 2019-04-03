package com.example.ishzark.ehsanapp;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends AppCompatActivity {

    private EditText mEditTextSubject;
    private EditText mEditTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendemail);


        //Send Email
        mEditTextSubject = findViewById(R.id.emailSubject);
        mEditTextMsg = findViewById(R.id.emailMsg);

        Button buttonSend = findViewById(R.id.emailSendBtn);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail(){

        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMsg.getText().toString();

        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL, "mailto:n.s.g_911@hotmail.com");
        //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        //intent.putExtra(Intent.EXTRA_TEXT, message);

        //intent.setType("message/rfc822");
        //startActivity(Intent.createChooser(intent, "Choose an email client"));

        String mailto = "mailto:n.s.g_911@hotmail.com"; /*+
                "&subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(message);*/

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(emailIntent);
        }
        catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }
}
