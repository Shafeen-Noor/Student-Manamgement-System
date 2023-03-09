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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Subject_FXMLController implements Initializable {


    @FXML
    private Button add2;

    @FXML
    private TextField course_search;

    @FXML
    private Button crs_btn;

    @FXML
    private TextField crs_id2;

    @FXML
    private Button delete;

    @FXML
    private Button ins_btn;

    @FXML
    private Button std_btn;

    @FXML
    private Button subj_btn;

    @FXML
    private TextField subj_desc;

    @FXML
    private TextField subj_id;

    @FXML
    private TextField subj_id2;

    @FXML
    private TextField subj_name;

    @FXML
    private Button view_btn;

 
     private Stage stage; //1
    private Scene scene; //2
    private Parent root; //
    
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
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
    private void subj_id_clicked(ActionEvent event) {
    }

    @FXML
    private void subj_name_clicked(ActionEvent event) {
    }

    @FXML
    private void subj_desc_clicked(ActionEvent event) {
    }

    @FXML
    private void sub_update_clicked(ActionEvent event) {
        
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "UPDATE TABLE_SUBJECTS set  Subject_Name=?, Subject_Description=? where Subject_ID=? ";
         PreparedStatement statement = conn.prepareStatement(sql2);
            statement.setString(3,subj_id.getText());
            statement.setString(1,subj_name.getText());
            statement.setString(2,subj_desc.getText());
            statement.executeUpdate();
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }

    @FXML
    private void sub_view_clicked(ActionEvent event) {
              String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_SUBJECTS where Subject_ID=?";
             PreparedStatement statement = conn.prepareStatement(sql2);
             statement.setString(1, course_search.getText());
              System.out.println(sql2);

            ResultSet result = statement.executeQuery();
              while(result.next()) {
             subj_id.setText(result.getString("Subject_ID"));
             subj_name.setText(result.getString("Subject_Name"));
             subj_desc.setText(result.getString("Subject_Description"));}
              
   
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void sub_add_clicked(ActionEvent event) {
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "Insert into TABLE_SUBJECTS(Subject_ID,Subject_Name, Subject_Description) values(?,?,?)";
         PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,subj_id.getText());
            statement.setString(2,subj_name.getText());
            statement.setString(3,subj_desc.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } 
        
        
    } 
    
    @FXML
    void sub_add2_clicked(ActionEvent event) {
                 String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "Insert into COURSE_SUBJECT (Subject_ID,Course_ID) values(?,?)";
         PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,subj_id2.getText());
            statement.setString(2,crs_id2.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } 
        
        
    }
      @FXML
    void sub_remove_clicked(ActionEvent event) {

                String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql3 = "delete from  COURSE_SUBJECT where Subject_ID=? and Course_ID=?";
         PreparedStatement statement = conn.prepareStatement(sql3);
            statement.setString(1,subj_id2.getText());
            statement.setString(2,crs_id2.getText());
            statement.executeUpdate();

            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
}
