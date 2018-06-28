package com.dexterlab.chatappfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editPost,editAnswer;
    Button postButton;
    DatabaseReference databsePost;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPost = (EditText) findViewById(R.id.post_question);
        editAnswer = (EditText) findViewById(R.id.editAnswer);
        editAnswer.setVisibility(View.INVISIBLE);

        postButton = (Button) findViewById(R.id.postButton);
        databsePost = FirebaseDatabase.getInstance().getReference().child("Post");
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });
    }

    private void addPost() {
        String question = editPost.getText().toString();
        String answer = editAnswer.getText().toString();
        if (!TextUtils.isEmpty(question)) {
            String id = databsePost.push().getKey();
            Post post = new Post(id,question,answer);
            databsePost.child(id).setValue(post);
            Toast.makeText(MainActivity.this,"Question posted",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,QuestionList.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(MainActivity.this,"Please enter any question to post",Toast.LENGTH_SHORT).show();
        }
    }
}
