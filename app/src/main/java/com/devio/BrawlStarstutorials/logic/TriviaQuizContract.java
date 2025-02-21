package com.devio.BrawlStarstutorials.logic;

import android.provider.BaseColumns;

public final class TriviaQuizContract {


    public TriviaQuizContract() {
    }

    public static class QuestionTable implements BaseColumns {

        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_LEVELS_ID = "levels_id";
    }


}
