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
    ResultSet rs = null;

    String sql = "";
    int autoKey = 0;

    private QuestionnaireModel qModel;

    public QuestionnaireDao() {
        //connect to database and select the record
        connection = DbConnection.getConnection();
    }



    public List<QuestionnaireModel> GetQuestonnaireListFromLogDB() {

        List<QuestionnaireModel> QuestionnaireList = new ArrayList<QuestionnaireModel>();

        Connection connection;
        PreparedStatement preparedStatement;


        try {
            connection = DbConnection.getConnection();

            String sql = "SELECT * FROM infsci2560'";

            preparedStatement = connection.prepareStatement(sql);
            //here should have 3 variables to distinguish where are the entry from( security question, login ,reset password....)
//            String SysSource = "[hostile]";
//            preparedStatement.setString(1, SysSource);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                while (true) {     
                    
                    if(!rs.next())
                    {
                        break;
                    }

                }
            }

            return QuestionnaireList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int WriteQuestionnaireToDB() {
        Connection connection;
        PreparedStatement preparedStatement;

     

        try {
            connection = DbConnection.getConnection();

            String sql = "  ";

            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
            preparedStatement.executeUpdate();

            return 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
