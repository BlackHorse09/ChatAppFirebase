package com.dexterlab.chatappfirebase;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Answer extends AppCompatActivity {

    TextView textView,textAnswer;
    String question,text,answerTopost;
    Button answer,save;
    String key,value,strEditText;
    EditText adminKey;
    SharedPreferences myprefs;
    DatabaseReference databaseAnswer;

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                strEditText = data.getStringExtra("answer");
//                answer.setVisibility(View.INVISIBLE);
//                textAnswer.setVisibility(View.VISIBLE);
//                textAnswer.setText(strEditText);
//
//            }
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        question = getIntent().getStringExtra("question");
        answerTopost = getIntent().getStringExtra("answer");

        answer = (Button) findViewById(R.id.adminKey);
        textAnswer = (TextView) findViewById(R.id.answer);
        textAnswer.setText(answerTopost);

        //save = (Button) findViewById(R.id.save);
        textView = (TextView) findViewById(R.id.textQuestion);
        textView.setText(question);


//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        String string = prefs.getString("st","");
//        editanswer.setText(string);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ADMIN KEY");
        builder.setMessage("Please enter the admin key to answer the above question");

        adminKey = new EditText(this);
        builder.setView(adminKey);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String text = adminKey.getText().toString().toUpperCase();

                if (text.equals("ADMIN")) {
                    Intent intent = new Intent(Answer.this,Example.class);
                    startActivityForResult(intent,1);
//                    editanswer.setVisibility(View.VISIBLE);
                }

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        final AlertDialog alertDialog = builder.create();

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text = editanswer.getText().toString();
//                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Answer.this);
//                SharedPreferences.Editor editor = prefs.edit();
//                editor.putString("st",text);
//                editor.apply();
//            }
//        });
//

    }
}
