package com.group.doctorappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientRegistrationActivity extends AppCompatActivity {

    private TextView regPageQuestion;

    private TextInputEditText registrationFullName,registrationIdNumber,registrationPhoneNumber,loginEmail,loginPassword;

    private Button regButton;
    private CircleImageView profileImage;
    private Uri resutlUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        regPageQuestion = findViewById(R.id.regPageQuestion);
        regPageQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        registrationFullName = findViewById(R.id.registrationFullName);
        registrationIdNumber = findViewById(R.id.registrationIdNumber);
        registrationPhoneNumber = findViewById(R.id.registrationPhoneNumber);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        regButton = findViewById(R.id.regButton);
        profileImage = findViewById(R.id.profileImage);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(android.content.Intent.ACTION_PICK);
                getIntent().setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = loginEmail.getText().toString().trim();
                final String password = loginPassword.getText().toString().trim();
                final String fullName = registrationFullName.getText().toString().trim();
                final String idNumber = registrationIdNumber.getText().toString().trim();
                final String phoneNumber = registrationPhoneNumber.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    loginEmail.setError("Email is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    loginPassword.setError("Password is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    registrationFullName.setError("Full name is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    registrationIdNumber.setError("Id number is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    registrationPhoneNumber.setError("Phone number is required!");
                    return;
                }
            }
        });
    }


}