/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.showQuestionnaire;

import static java.lang.System.out;
import java.sql.*;

/**
 *
 * @author duxia
 */
public class QuestionnaireContent {
    int questionnaireID;
    String questionnaireTitle;
    StringBuffer result;
    
    public int getQuestionnaireID(){
        return questionnaireID;
    }
    public void setQuestionnaireID(int ID){
        questionnaireID=ID;
    }
    public String getQuestionnaireTitle(){
        return questionnaireTitle;
    }
    public void setQuestionnaireTitle(String title){
        questionnaireTitle=title;
    }
    public StringBuffer getResult(){
        return result;
    }
    public void setResult(StringBuffer p){
        result=p;
    }
}
