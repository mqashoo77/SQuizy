package com.example.squiz;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Handler;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private final List<String> questionList;
    private final Context context;
    private final RecyclerView recyclerView;

    int score=0;
    int totalQuestion = QuestionAnswer.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    public QuestionAdapter(List<String> questionList, Context context, RecyclerView recyclerView) {
        this.questionList = questionList;
        this.context = context;
        this.recyclerView = recyclerView;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView totalQuestionsTextView;
        TextView questionTextView;
        Button ansA, ansB, ansC, ansD;
        Button submitBtn;


        public ViewHolder(View itemView) {
            super(itemView);
            totalQuestionsTextView = findViewById(R.id.total_question);
            questionTextView = findViewById(R.id.question);
            ansA = findViewById(R.id.ans_A);
            ansB = findViewById(R.id.ans_B);
            ansC = findViewById(R.id.ans_C);
            ansD = findViewById(R.id.ans_D);
            submitBtn = findViewById(R.id.submit_btn);

            ansA.setOnClickListener(this);
            ansB.setOnClickListener(this);
            ansC.setOnClickListener(this);
            ansD.setOnClickListener(this);
            submitBtn.setOnClickListener(this);

            totalQuestionsTextView.setText("Total questions : "+totalQuestion);

            loadNewQuestion();




        }

        @Override
        public void onClick(View view) {

            ansA.setBackgroundColor(Color.WHITE);
            ansB.setBackgroundColor(Color.WHITE);
            ansC.setBackgroundColor(Color.WHITE);
            ansD.setBackgroundColor(Color.WHITE);

            Button clickedButton = (Button) view;
            if(clickedButton.getId()==R.id.submit_btn){
                if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                    score++;
                }
                currentQuestionIndex++;
                loadNewQuestion();


            }else{
                //choices button clicked
                selectedAnswer  = clickedButton.getText().toString();
                clickedButton.setBackgroundColor(Color.rgb(0, 201, 167));

            }

        }

        void loadNewQuestion(){

            if(currentQuestionIndex == totalQuestion ){
                finishQuiz();
                return;
            }

            questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
            ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
            ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
            ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
            ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        }

        void finishQuiz(){
            String passStatus = "";
            if(score > totalQuestion*0.60){
                passStatus = "Passed";
            }else{
                passStatus = "Failed";
            }

            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score+" out of "+ totalQuestion)
                    .setPositiveButton("الذهاب للصفحة الرئيسية",(dialogInterface, i) -> restartQuiz() )
                    .setCancelable(false)
                    .show();


        }

        void restartQuiz(){
            score = 0;
            currentQuestionIndex =0;
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        }

        public void bind(Question question, ViewHolder holder) {
            currentAnswers = question.getAnswers();

            txtQuestion.setText(question.getQuestion());
            imageView.setImageResource(question.getImage());

            for (int i = 0; i < currentAnswers.getAnswers().length; i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setText(currentAnswers.getAnswers()[i]);
            }
            radioGroup.setOnCheckedChangeListener(null);
        }

        private void openSuccessfulDialog() {
            dialog.setContentView(R.layout.correct_answer_layout_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }

        private void openWrongDialog() {
            dialog.setContentView(R.layout.wrong_answer_layout_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }
    }
}
