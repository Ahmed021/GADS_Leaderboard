package com.onibiyo.gadsleaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.onibiyo.gadsleaderboard.fragment.ConfirmDialogFragment;
import com.onibiyo.gadsleaderboard.model.Submission;
import com.onibiyo.gadsleaderboard.services.SubmitInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionActivity extends AppCompatActivity implements ConfirmDialogFragment.OnClickListener{

    private Submission mSubmission = new Submission();
    AlertDialog mConfirmationDialog;
    String TAG = "submitResponse";
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mProjectUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);


//        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        EditText txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        EditText txtLastName = (EditText) findViewById(R.id.txtLastName);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtProjectUrl = (EditText) findViewById(R.id.txtProjectUrl);

        mFirstName = txtFirstName.getText().toString().trim();
        mLastName = txtLastName.getText().toString().trim();
        mEmail = txtFirstName.getText().toString().trim();
        mProjectUrl = txtFirstName.getText().toString().trim();

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSubmission.setFirstName(mFirstName);
                mSubmission.setLastName(mLastName);
                mSubmission.setEmail(mEmail);
                mSubmission.setProjectUrl(mProjectUrl);

                boolean isFormFilled =
                        mSubmission.getFirstName().length() > 0 &&
                        mSubmission.getLastName().length() > 0 &&
                        mSubmission.getEmail().length() > 0 &&
                        mSubmission.getProjectUrl().length() > 0;

                if (!isFormFilled) {
                    showConfirmDialog();
                    AlertDialog.Builder  builder= new AlertDialog.Builder(SubmissionActivity.this);
                    View v = getLayoutInflater().inflate(R.layout.dialog_confirm, null);
                    builder.setView(v);

                    mConfirmationDialog = builder.create();
                    mConfirmationDialog.show();

                    findViewById(R.id.btn_close)
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mConfirmationDialog.dismiss();
                                }
                            });

                    findViewById(R.id.btn_yes)
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    try {
                                        postDetails(mFirstName, mLastName, mEmail, mProjectUrl);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(SubmissionActivity.this, "Please fill all fields correctly..", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        findViewById(R.id.btn_back)
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(SubmissionActivity.this, LeaderBoardActivity.class));
//                    }
//                });
    }

    private void postDetails(String txtFirstName, String txtLastName,
                             String txtEmail, String txtProjectUrl) throws IOException{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SubmitInterface submitInterface = retrofit.create(SubmitInterface.class);

        Call<Void> call = submitInterface.postProjectData(txtFirstName, txtLastName, txtEmail, txtProjectUrl);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i(TAG, "onResponse: " + response.code());
                AlertDialog.Builder builder = new AlertDialog.Builder(SubmissionActivity.this);
                LayoutInflater layoutInflater = SubmissionActivity.this.getLayoutInflater();
                View v = layoutInflater.inflate(R.layout.dialog_submit_result, null);
                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();
                mConfirmationDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i(TAG, "onResponse: " + t.getMessage());
                AlertDialog.Builder builder = new AlertDialog.Builder(SubmissionActivity.this);
                LayoutInflater layoutInflater = SubmissionActivity.this.getLayoutInflater();
                View v = layoutInflater.inflate(R.layout.dialog_failure, null);
                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();
                mConfirmationDialog.dismiss();
            }
        });
    }

    private void showConfirmDialog() {
    }

    @Override
    public void onConfirm(ConfirmDialogFragment confirmDialogFragment) {
    }

    @Override
    public void onDismiss(ConfirmDialogFragment confirmDialogFragment) {
    }
}
