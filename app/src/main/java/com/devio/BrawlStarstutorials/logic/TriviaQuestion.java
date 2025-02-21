package com.devio.BrawlStarstutorials.logic;

public class TriviaQuestion {
    public static final String CATEGORY_JAVA = "Java";
    private String question, option1, option2, option3, option4, answerNr, category;
    private int levels;

    public TriviaQuestion() {

    }

    public TriviaQuestion(String question, String option1, String option2, String option3, String option4, String answerNr,
                          String category, int levels) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.category = category;
        this.levels = levels;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(String answerNr) {
        this.answerNr = answerNr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
}
