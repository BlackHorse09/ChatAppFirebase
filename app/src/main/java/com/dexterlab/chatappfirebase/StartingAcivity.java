package com.dexterlab.chatappfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingAcivity extends AppCompatActivity {

    Button new_registration,masterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_acivity);

        new_registration = (Button) findViewById(R.id.new_registration);
        masterLogin = (Button) findViewById(R.id.masterLogin);

        new_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartingAcivity.this,Example.class);
                startActivity(intent);
            }
        });

        masterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartingAcivity.this,MasterGroup.class);
                startActivity(intent);

            }
        });

    }
}
