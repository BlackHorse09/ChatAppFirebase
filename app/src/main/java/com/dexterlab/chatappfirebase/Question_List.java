package com.dexterlab.chatappfirebase;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Question_List extends ArrayAdapter<Post> {
    private Activity context;
    private List<Post> questionList;

    public Question_List(Activity context,List<Post> questionList) {
        super(context,R.layout.list_item,questionList);
        this.context = context;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View questionListView = inflater.inflate(R.layout.list_item,null,true);
        TextView textView = (TextView) questionListView.findViewById(R.id.question_list);

        Post post = questionList.get(position);
        textView.setText(post.getQuestion());

        return questionListView;

    }
}
