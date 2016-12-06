/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Zhirun Tian
 */
public class QuestionAndSelection {
    private int QuestionnaireID;
    private int QuestionID;
    private String QuestionContent;
    private String Selection1;
    private String Selection2;
    private String Selection3;
    private String Selection4;
    private String Selection5;

    public QuestionAndSelection() {
    }

    public QuestionAndSelection(int QuestionnaireID, int QuestionID, String QuestionContent, String Selection1, String Selection2, String Selection3, String Selection4, String Selection5) {
        this.QuestionnaireID = QuestionnaireID;
        this.QuestionID = QuestionID;
        this.QuestionContent = QuestionContent;
        this.Selection1 = Selection1;
        this.Selection2 = Selection2;
        this.Selection3 = Selection3;
        this.Selection4 = Selection4;
        this.Selection5 = Selection5;
    }
    
    

    public int getQuestionnaireID() {
        return QuestionnaireID;
    }

    public void setQuestionnaireID(int QuestionnaireID) {
        this.QuestionnaireID = QuestionnaireID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String QuestionContent) {
        this.QuestionContent = QuestionContent;
    }

    public String getSelection1() {
        return Selection1;
    }

    public void setSelection1(String Selection1) {
        this.Selection1 = Selection1;
    }

    public String getSelection2() {
        return Selection2;
    }

    public void setSelection2(String Selection2) {
        this.Selection2 = Selection2;
    }

    public String getSelection3() {
        return Selection3;
    }

    public void setSelection3(String Selection3) {
        this.Selection3 = Selection3;
    }

    public String getSelection4() {
        return Selection4;
    }

    public void setSelection4(String Selection4) {
        this.Selection4 = Selection4;
    }

    public String getSelection5() {
        return Selection5;
    }

    public void setSelection5(String Selection5) {
        this.Selection5 = Selection5;
    }
    
    
    
    
    
}
