package com.dexterlab.chatappfirebase;

public class Post {
    String question,id,answer;

    public Post() {

    }
    public Post(String id,String question,String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public String getId() {
        return id;
    }
    public String getAnswer() {
        return answer;
    }
}
