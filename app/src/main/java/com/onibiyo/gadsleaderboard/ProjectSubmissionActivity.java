package com.onibiyo.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjectSubmissionActivity extends AppCompatActivity {

    EditText mFirstName;
    EditText mLastName;
    EditText mEmail;
    EditText mProjectLink;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mEmail = (EditText) findViewById(R.id.email_address);
        mProjectLink = (EditText) findViewById(R.id.project_link);
        mButton = (Button) findViewById(R.id.btn_submit);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProjectSubmissionActivity.this, "Awesome", Toast.LENGTH_LONG).show();
            }
        });
    }
}
