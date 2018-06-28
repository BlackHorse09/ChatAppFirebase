package com.dexterlab.chatappfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuestionList extends AppCompatActivity {

    ListView listView;
    List<Post> questionList;
    DatabaseReference databsePost,databaseAnswer;
    EditText editSearch;
    Question_List adapter;
    String item;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        listView = (ListView) findViewById(R.id.listView);



//        editSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                searchItem(charSequence.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

        questionList = new ArrayList<>();
        databsePost = FirebaseDatabase.getInstance().getReference().child("Post");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Post post = questionList.get(i);
                Intent intent = new Intent(QuestionList.this,Answer.class);
                intent.putExtra("question",post.getQuestion());
                intent.putExtra("answer",post.getAnswer());
                startActivity(intent);
            }
        });

        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

//    private void searchItem(String textToSearch) {
//        for (item : questionList)
//            if (item.contains(textToSearch)) {
//                questionList.remove(item);
//
//            }
//    }


    @Override
    protected void onStart() {
        super.onStart();
        databsePost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionList.clear();
                for (DataSnapshot questionSnapshot : dataSnapshot.getChildren()){
                    Post post = questionSnapshot.getValue(Post.class);
                    questionList.add(post);
                }
                adapter = new Question_List(QuestionList.this,questionList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showUpdateDialog (String id,String postAnswer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update,null);
        builder.setView(dialogView);
    }
}
