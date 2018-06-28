package com.dexterlab.chatappfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Example extends AppCompatActivity {

    EditText editAnswer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        editAnswer = (EditText) findViewById(R.id.answer);

        button = (Button) findViewById(R.id.postAnswer);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Example.this,Answer.class);
//                intent.putExtra("answer",editAnswer.getText().toString());
//                setResult(RESULT_OK, intent);
//                finish();
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
