/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

import DbConnect.DbConnection;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.QuestionnaireModel;

/**
 *
 * @author Zhirun Tian
 */
public class QuestionnaireDao {

    private Connection connection;
    private String nonceval = "";
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "";
    int autoKey = 0;

    public QuestionnaireDao() {
        //connect to database and select the record
        connection = DbConnection.getConnection();
    }


    public int WriteQuestionnaireToDB(String title) {
//        PreparedStatement ps;
        try {
            String sql = "INSERT INTO INFSCI2560.questionnaire (QuestionnaireTitle) values (?)";

            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                return autoKey=rs.getInt(1);
            else
                return 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()) ;
            return -1;
        }  
    }
    
    public int writeQuestionnaireAutherToDB(int questionnaireID, int userID){
         try {
            String sql = "INSERT INTO INFSCI2560.user_questionnaire (UserID, QuestionnaireID) values (?,?)";

//            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, userID);
//            ps.setInt(2, questionnaireID);
//            ps.executeUpdate();
                ps.executeUpdate("INSERT INTO INFSCI2560.user_questionnaire values (\""+userID+"\",\""+questionnaireID+"\")"  );
            
//            ResultSet rs = ps.getGeneratedKeys();
//            if(rs.next())
//                return autoKey=rs.getInt(1);
//            else
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()) ;
            return -1;
        }  
    }

    public String getQuestionnaireTitleFromID(int questionnaireID) {
        PreparedStatement ps;


        try {
            connection = DbConnection.getConnection();

            String sql = "SELECT QuestionnaireTitle FROM INFSCI2560.questionnaire where id = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, questionnaireID);

            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("QuestionnaireTitle");
            }else
                return null;

//            if (!rs.next()) {
//                return null;
//            } else {
//                while (true) {     
//                    
//                    if(!rs.next())
//                    {
//                        break;
//                    }
//
//                }
//            }

//            return QuestionnaireList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
