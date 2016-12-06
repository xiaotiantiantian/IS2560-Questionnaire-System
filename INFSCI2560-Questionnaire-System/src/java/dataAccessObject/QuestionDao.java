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

import model.QuestionAndSelection;

/**
 *
 * @author Zhirun Tian
 */
public class QuestionDao {

    private Connection connection;
    private String nonceval = "";
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "";
    int autoKey = 0;

    QuestionDao() {
        connection = DbConnection.getConnection();
    }

    public int WriteQuestionAndSelectionToDB(int questionnaireID, String questionContent, String selection1, String selection2, String selection3, String selection4, String selection5) {
        try {
            String sql = "INSERT INTO INFSCI2560.question (QuestionnaireID, QuestionContent, Selection1, Selection2, Selection3, Selection4, Selection5) vaules (?,?,?,?,?,?,?)";

            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, questionnaireID);
            ps.setString(2, questionContent);
            ps.setString(3, selection1);
            ps.setString(4, selection2);
            ps.setString(5, selection3);
            ps.setString(6, selection4);
            ps.setString(7, selection5);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return autoKey = rs.getInt(1);
            } else {
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public ArrayList<QuestionAndSelection> getQuestionListByQuestionnaireID(int questionnaireID) {
        try {
            String sql = "SELECT QuestionnaireID,QuestionID, QuestionContent, Selection1, Selection2, Selection3, Selection4, Selection5 FROM INFSCI2560.questionnaire where QuestionnaireID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, questionnaireID);

            rs = ps.executeQuery();

            ArrayList<QuestionAndSelection> questionBeanList = new ArrayList<QuestionAndSelection>();

            while (rs.next()) {
                QuestionAndSelection questionBean = new QuestionAndSelection(rs.getInt("QuestonnaireID"),
                        rs.getInt("QuestionID"),
                        rs.getString("QuestionContent"),
                        rs.getString("Selection1"),
                        rs.getString("Selection2"),
                        rs.getString("Selection3"),
                        rs.getString("Selection4"),
                        rs.getString("Selection5"));
                questionBeanList.add(questionBean);

            }
            return questionBeanList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
