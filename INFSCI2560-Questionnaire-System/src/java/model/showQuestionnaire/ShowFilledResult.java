/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.showQuestionnaire;
/**
 *
 * @author duxia
 */
public class ShowFilledResult {
    int questionID;
    StringBuffer result;
    
    public int getQuestionID(){
        return questionID;
    }
    public void setQuestionID(int id){
        questionID = id;
    }
    public StringBuffer getResult(){
        return result;
    }
    public void setResult(StringBuffer rs){
        result = rs;
    }
}
