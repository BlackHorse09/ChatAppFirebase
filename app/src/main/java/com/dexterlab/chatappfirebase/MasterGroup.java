package com.dexterlab.chatappfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterGroup extends AppCompatActivity {

    Button viewButton,postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_group);

        viewButton = (Button) findViewById(R.id.viewButton);
        postButton = (Button) findViewById(R.id.postButton);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasterGroup.this,QuestionList.class);
                startActivity(intent);
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasterGroup.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
