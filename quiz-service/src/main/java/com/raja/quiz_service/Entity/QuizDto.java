package com.raja.quiz_service.Entity;

public class QuizDto {
    String categoryName;
    Integer NumQuestion;
    String Title;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getNumQuestion() {
        return NumQuestion;
    }

    public void setNumQuestion(Integer numQuestion) {
        NumQuestion = numQuestion;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
