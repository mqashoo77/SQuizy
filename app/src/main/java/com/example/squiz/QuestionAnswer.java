package com.example.squiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;


public class QuestionAnswer {

//    private final SharedPreferences preferences;
//    private final SharedPreferences.Editor editor;

    public static String questions[]={
            "أي من العناصر التالية يستخدم في صناعة البطاريات؟",
            "رمز عنصر الحديد هو؟",
            "أي من المجموعات التالية في الجدول الدوري تحتوي على الغازات النبيلة؟",
            "يمكن توقع أن العنصر 118 له خواص تشبه؟",
            "رمز عنصر الذهب هو؟"
    };
    public static String answers[][]={
            {"الصوديوم","الكالسيوم","الليثيوم","اليود"},
            {"K","S","H","Fe"},
            {"المجموعة 1","المجموعة 2","المجموعة17","المجموعة 18"},
            {"الفلزات","الغازات النبيلة","أشباه الفلزات","الهالوجينات"},
            {"Au","K","Na","Fe"}
    };
    public static String correctAnswers[]={
            "الليثيوم",
            "Fe",
            "المجموعة 18",
            "الغازات النبيلة",
            "Au"
    };;

//    public QuestionAnswer(Context context) {
//        preferences = PreferenceManager.getDefaultSharedPreferences(context);
//        editor = preferences.edit();
//        if(!preferences.getBoolean("areQuestionsSaved", false)) {
//            addQuestions();
//            saveOnSharedPreferences(Arrays.asList(questions));
//        } else {
//            questions = getFromSharedPreferences();
//        }
//    }
//    private void addQuestions() {

//        questions = new String[]{
//                "أي من العناصر التالية يستخدم في صناعة البطاريات؟",
//                "رمز عنصر الحديد هو؟",
//                "أي من المجموعات التالية في الجدول الدوري تحتوي على الغازات النبيلة؟",
//                "يمكن توقع أن العنصر 118 له خواص تشبه؟",
//                "رمز عنصر الذهب هو؟"
//        };
//
//
//        answers = new String[][] {
//                {"الصوديوم","الكالسيوم","الليثيوم","اليود"},
//                {"K","S","H","Fe"},
//                {"المجموعة 1","المجموعة 2","المجموعة17","المجموعة 18"},
//                {"الفلزات","الغازات النبيلة","أشباه الفلزات","الهالوجينات"},
//                {"Au","K","Na","Fe"}
//        };
//
//         correctAnswers = new String[] {
//                "الليثيوم",
//                "Fe",
//                "المجموعة 18",
//                "الغازات النبيلة",
//                "Au"
//        };
//    }

//    private void saveOnSharedPreferences(List<String> questions) {
//        Gson gson = new Gson();
//        String questionsJson = gson.toJson(questions);
//        editor.putBoolean("areQuestionsSaved", true);
//        editor.putString("questions", questionsJson);
//        editor.commit();
//    }
//
//    private List<String> getFromSharedPreferences() {
//        Gson gson = new Gson();
//        String questionsJson = preferences.getString("questions", null);
////        questions = gson.fromJson(questionsJson, questions);
////        return Arrays.asList(qustions);
//    }





}
