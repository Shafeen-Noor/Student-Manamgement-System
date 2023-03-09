/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Course_FXMLController implements Initializable {
    @FXML
    private TextField search_course;
    @FXML
    private Button std_btn;
    @FXML
    private Button ins_btn;
    @FXML
    private Button crs_btn;
    @FXML
    private Button subj_btn;
    @FXML
    private Button view_btn;
    @FXML
    private TextField crs_id;
    @FXML
    private TextField crs_name;
    @FXML
    private TextField crs_duration;
    @FXML
    private TextField crs_seats;
    @FXML
    private TextField crs_qualifi;
    
    private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void std_btn_clicked(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("Student_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ins_btn_clicked(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("Instructor_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void crs_btn_clicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("course_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void subj_btn_clicked(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("subject_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void view_btn_clicked(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void crs_id_clicked(ActionEvent event) {
    }

    @FXML
    private void crs_name_clicked(ActionEvent event) {
    }

    @FXML
    private void crs_dutation_clicked(ActionEvent event) {
    }

    @FXML
    private void crs_seats_clicked(ActionEvent event) {
    }

    @FXML
    private void crs_qualifi_clicked(ActionEvent event) {
    }

    @FXML
    private void cor_update_btn(ActionEvent event) {
        
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "UPDATE TABLE_COURSES set  Course_Name=?, Total_Seats=?," +
"Duration =?,\n" +
"Required_Qualification =?  where Course_ID=? ";
         PreparedStatement statement = conn.prepareStatement(sql2);
            statement.setString(1,crs_name.getText());
            statement.setString(2,crs_seats.getText());
            statement.setString(3,crs_duration.getText());
            statement.setString(4,crs_qualifi.getText());
            statement.setString(5,crs_id.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void cor_add_btn(ActionEvent event) {
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "Insert into TABLE_COURSES(\n" +
            "Course_ID   ,\n" +
            "Course_Name  ,\n" +
            "Total_Seats   ,\n" +
            "Duration   ,\n" +
            "Required_Qualification   )\n" +
            " values(?,?,?,?,?)";
         PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,crs_id.getText());
            statement.setString(2,crs_name.getText());
            statement.setString(3,crs_seats.getText());
            statement.setString(4,crs_duration.getText());
            statement.setString(5,crs_qualifi.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        

    }

    @FXML
    private void cor_view_btn(ActionEvent event) throws IOException {
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_COURSES where Course_ID=?";
             PreparedStatement statement = conn.prepareStatement(sql2);
             statement.setString(1, search_course.getText());
              System.out.println(sql2);

            ResultSet result = statement.executeQuery();
              while(result.next()) {
             crs_id.setText(result.getString("Course_ID"));
             crs_name.setText(result.getString("Course_Name"));
             crs_duration.setText(result.getString("Duration"));
             crs_seats.setText(result.getString("Total_Seats"));
             crs_qualifi.setText(result.getString("Required_Qualification"));}
              
   
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    }
    

