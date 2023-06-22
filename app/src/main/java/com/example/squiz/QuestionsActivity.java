package com.example.squiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        RecyclerView recyclerView = findViewById(R.id.question_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list of questions

        List<String> questionList = Arrays.asList(QuestionAnswer.questions);

        QuestionAdapter questionAdapter = new QuestionAdapter(questionList, this, recyclerView);
        recyclerView.setAdapter(questionAdapter);
    }

}