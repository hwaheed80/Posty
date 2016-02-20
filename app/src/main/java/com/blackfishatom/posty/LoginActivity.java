package com.blackfishatom.posty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginCommand(View obj) {
        Toast.makeText(this.getApplicationContext(), "Login clicked", Toast.LENGTH_SHORT).show();
    }

    public void RegisterCommand(View obj) {
        Toast.makeText(this.getApplicationContext(), "Register clicked", Toast.LENGTH_SHORT).show();
    }
}
