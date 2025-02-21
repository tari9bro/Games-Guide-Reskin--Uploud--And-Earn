package com.devio.BrawlStarstutorials.logic;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TriviaQuizHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATBASE_VERSION = 23;

    private SQLiteDatabase db;


    public TriviaQuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATBASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                TriviaQuizContract.QuestionTable.TABLE_NAME + " ( " +
                TriviaQuizContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TriviaQuizContract.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                TriviaQuizContract.QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TriviaQuizContract.QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable() {
        TriviaQuestion q1 = new TriviaQuestion
                ("How old is Shelly in Brawl Stars?", "14", "17", "23", "17", "23",
                        TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q1);
        TriviaQuestion q2 = new TriviaQuestion
                ("How old is Nita  in Brawl Stars?", "55", "25", "50", "17", "17"
                , TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q2);
        TriviaQuestion q3 = new TriviaQuestion
                ("How old is Colt  in Brawl Stars?", "19", "42", "52", "25", "19"
                , TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q3);
        TriviaQuestion q4 = new TriviaQuestion
                ("How old is Bull  in Brawl Stars?", "33", "31", "32", "23", "31"
                , TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q4);
        TriviaQuestion q5 = new TriviaQuestion
                ("How old is Jessie  in Brawl Stars?", "14 ", "13", "12", "11", "11"
                , TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q5);
        TriviaQuestion q6 = new TriviaQuestion
                ("How old is Brock  in Brawl Stars?", "22", "21", "22  ", "33", "21"
                , TriviaQuestion.CATEGORY_JAVA, 1);
        addQuestions(q6);
        TriviaQuestion q11 = new TriviaQuestion
                ("How old is Dynamike  in Brawl Stars?", "33", "35", "62", "66", "62"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q11);
        TriviaQuestion q12 = new TriviaQuestion
                ("How old is Bo  in Brawl Stars?", "11", "22", "26", "66", "26"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q12);

        TriviaQuestion q13 = new TriviaQuestion
                ("How old is  8Bit in Brawl Stars?", "10", "11", "12", "13", "42"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q13);
        TriviaQuestion q14 = new TriviaQuestion
                ("How old is Tick  in Brawl Stars?", "17", "2", "15", "5", "5"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q14);
        TriviaQuestion q15 = new TriviaQuestion
                ("How old is Emz  in Brawl Stars?", "20", "17", "22", "23", "17"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q15);
        TriviaQuestion q16 = new TriviaQuestion
                ("How old is El Primo in Brawl Stars?", "36", "39", "33", "37", "36"
                , TriviaQuestion.CATEGORY_JAVA, 2);
        addQuestions(q16);
        TriviaQuestion q111 = new TriviaQuestion
                ("How old is Barley in Brawl Stars?", "21", "53", "33", "52", "52"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q111);
        TriviaQuestion q112 = new TriviaQuestion
                ("How old is Poco in Brawl Stars?", "150", "51", "12", "53", "150"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q112);
        TriviaQuestion q113 = new TriviaQuestion
                ("How old is Stu  in Brawl Stars?", "43", "32", "12", "22", "22"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q113);
        TriviaQuestion q114 = new TriviaQuestion
                ("How old is Rosa in Brawl Stars?", "32", "23", "33", "22", "32"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q114);
        TriviaQuestion q115 = new TriviaQuestion
                ("How old is Rico  in Brawl Stars?", "7", "5", "17", "22", "17"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q115);
        TriviaQuestion q116 = new TriviaQuestion
                ("How old is Darryl in Brawl Stars?", "51", "55", "52", "53", "52"
                , TriviaQuestion.CATEGORY_JAVA, 3);
        addQuestions(q116);
        TriviaQuestion q45 = new TriviaQuestion
                ("How old is Penny in Brawl Stars?", "11", "15", "13", "14", "15"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q45);
        TriviaQuestion q46 = new TriviaQuestion
                ("How old is Carl in Brawl Stars?", "63", "77", "14", "17", "14"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q46);
        TriviaQuestion q47 = new TriviaQuestion
                ("How old is Jacky in Brawl Stars?", "27", "75", "53", "77", "27"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q47);
        TriviaQuestion q48 = new TriviaQuestion
                ("How old is Piper in Brawl Stars?", "11", "24", "23", "32", "24"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q48);
        TriviaQuestion q4a7 = new TriviaQuestion
                ("How old is Pam in Brawl Stars?", "42", "57", "53", "24", "42"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q4a7);
        TriviaQuestion q4a8 = new TriviaQuestion
                ("How old is Frank in Brawl Stars?", "105", "150", "55", "5", "150"
                , TriviaQuestion.CATEGORY_JAVA, 4);
        addQuestions(q4a8);
        TriviaQuestion q465 = new TriviaQuestion
                ("How old is Bibi in Brawl Stars?", "10", "15", "28", "18", "28"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q465);
        TriviaQuestion q466 = new TriviaQuestion
                ("How old is Bea  in Brawl Stars?", "11", "20", "14", "15", "20"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q466);
        TriviaQuestion q467 = new TriviaQuestion
                ("How old is Nani in Brawl Stars?", "26", "13", "11", "15", "26"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q467);
        TriviaQuestion q468 = new TriviaQuestion
                ("How old is Edgar  in Brawl Stars?", "17", "13", "14", "12 ", "17"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q468);
        TriviaQuestion q4607 = new TriviaQuestion
                ("How old is Griff in Brawl Stars?", "12 ", "16", "67", "13", "67"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q4607);
        TriviaQuestion q4608 = new TriviaQuestion
                ("How old is Grom in Brawl Stars?", "16", "31", "12 ", "14", "31"
                , TriviaQuestion.CATEGORY_JAVA, 5);
        addQuestions(q4608);
        TriviaQuestion qa465 = new TriviaQuestion
                ("How old is Bonnie  in Brawl Stars?", "16", "7", "12 ", "14", "7"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa465);
        TriviaQuestion qa466 = new TriviaQuestion
                ("How old is Mortis  in Brawl Stars?", "300", "12 ", "14", "15", "300"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa466);
        TriviaQuestion qa467 = new TriviaQuestion
                ("How old is Tara in Brawl Stars?", "12 ", "14", "13", "28", "28"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa467);
        TriviaQuestion qa468 = new TriviaQuestion
                ("How old is Gene in Brawl Stars?", "9", "9999", "999", "99", "9999"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa468);
        TriviaQuestion qa4607 = new TriviaQuestion
                ("How old is Max in Brawl Stars?", "17", "26", "13", "12 ", "26"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa4607);
        TriviaQuestion qa4608 = new TriviaQuestion
                ("How old is Mr P in Brawl Stars?", "13", "14", "12 ", "16", "16"
                , TriviaQuestion.CATEGORY_JAVA, 6);
        addQuestions(qa4608);

//@todo above are questions and 4 suggestion and the last one is the true answer these are the quiz Qs & As

    }

    private void addQuestions(TriviaQuestion question) {

        ContentValues cv = new ContentValues();
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_OPTION4, question.getOption4());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_CATEGORY, question.getCategory());
        cv.put(TriviaQuizContract.QuestionTable.COLUMN_LEVELS_ID, question.getLevels());
        db.insert(TriviaQuizContract.QuestionTable.TABLE_NAME, null, cv);

    }

    @SuppressLint("Range")
    public ArrayList<TriviaQuestion> getAllQuestions() {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();


        String[] Projection = {

                TriviaQuizContract.QuestionTable._ID,
                TriviaQuizContract.QuestionTable.COLUMN_QUESTION,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION1,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION2,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION3,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION4,
                TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR
        };


        Cursor c = db.query(TriviaQuizContract.QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    @SuppressLint("Range")
    public ArrayList<TriviaQuestion> getQuestionsWithCategory(String Category) {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();


        String[] Projection = {

                TriviaQuizContract.QuestionTable._ID,
                TriviaQuizContract.QuestionTable.COLUMN_QUESTION,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION1,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION2,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION3,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION4,
                TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR,
                TriviaQuizContract.QuestionTable.COLUMN_CATEGORY
        };

        String selection = TriviaQuizContract.QuestionTable.COLUMN_CATEGORY + " = ? ";
        String[] selectionArgs = {Category};


        Cursor c = db.query(TriviaQuizContract.QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }


    @SuppressLint("Range")
    public ArrayList<TriviaQuestion> getQuestionsByLevelsAndCategory(String Category, int LevelsID) {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();


        String[] Projection = {

                TriviaQuizContract.QuestionTable._ID,
                TriviaQuizContract.QuestionTable.COLUMN_QUESTION,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION1,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION2,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION3,
                TriviaQuizContract.QuestionTable.COLUMN_OPTION4,
                TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR,
                TriviaQuizContract.QuestionTable.COLUMN_CATEGORY,
                TriviaQuizContract.QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = TriviaQuizContract.QuestionTable.COLUMN_LEVELS_ID + " = ? "
                + " AND " + TriviaQuizContract.QuestionTable.COLUMN_CATEGORY + " = ? ";

        String[] selectionArgs = new String[]{String.valueOf(LevelsID), Category};


        Cursor c = db.query(TriviaQuizContract.QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_CATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(TriviaQuizContract.QuestionTable.COLUMN_LEVELS_ID)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

}


