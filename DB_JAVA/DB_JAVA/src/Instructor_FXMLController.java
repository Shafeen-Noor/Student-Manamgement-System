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
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class Instructor_FXMLController implements Initializable {
     @FXML
    private Button crs_btn;

    @FXML
    private Button ins_add_btn;

    @FXML
    private TextField ins_address;

    @FXML
    private Button ins_btn;

    @FXML
    private TextField ins_cnic;

    @FXML
    private TextField ins_design;

    @FXML
    private TextField ins_dob;

    @FXML
    private TextField ins_father;

    @FXML
    private TextField ins_gender;

    @FXML
    private TextField ins_id;

    @FXML
    private TextField ins_join_date;

    @FXML
    private TextField ins_name;

    @FXML
    private TextField ins_phone;

    @FXML
    private TextField ins_quali;

    @FXML
    private TextField ins_salary;

    @FXML
    private TextField ins_scale;

    @FXML
    private TextField search_ins;

    @FXML
    private Button srd_btn;

    @FXML
    private TextField sub_id;

    @FXML
    private Button subj_btn;

    @FXML
    private Button update_btn;

    @FXML
    private Button view_bottom_btn;

    @FXML
    private Button view_btn;


  
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
    private void sub_btn_clicked(ActionEvent event) throws IOException {
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
    void ins_add_clicked(ActionEvent event) {
            String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql4 = "Insert into TABLE_INSTRUCTORS(Subject_ID,Instructor_ID,  Instructor_Name,  Instructor_CNIC, Instructor_DOB,"
                     + " Instructor_Gender, "
                     + " Instructor_Phone,Instructor_Address,Instructor_F_Name, Date_Of_Join, Instructor_Qualification,"
                     + "Instructor_designation, "
                     + "Instructor_Scale,Instructor_Salary ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement statement = conn.prepareStatement(sql4);
            statement.setString(1,sub_id.getText());
            statement.setString(2,ins_id.getText());
            statement.setString(3,ins_name.getText());
            statement.setString(4,ins_cnic.getText());
            statement.setString(5,ins_dob.getText());
            statement.setString(6,ins_gender.getText());
            statement.setString(7,ins_phone.getText());
            statement.setString(8,ins_address.getText());
            statement.setString(9,ins_father.getText());
            statement.setString(10,ins_join_date.getText());
            statement.setString(11,ins_quali.getText());
            statement.setString(12,ins_design.getText());
            statement.setString(13,ins_scale.getText());
            statement.setString(14,ins_salary.getText());
            
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        
    }
    
        @FXML
    void update_btn_clicked(ActionEvent event) {
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql5 = "UPDATE TABLE_INSTRUCTORS set Subject_ID=?,  Instructor_Name=?,  Instructor_CNIC=?, Instructor_DOB=?, Instructor_Gender=?, "
                     + " Instructor_Phone=?,Instructor_Address=?,Instructor_F_Name=?, Date_Of_Join=?, Instructor_Qualification=?,"
                     + "Instructor_designation=?, "
                     + "Instructor_Scale=?,Instructor_Salary=?   where Instructor_ID=? ";
             
         PreparedStatement statement = conn.prepareStatement(sql5);
            statement.setString(1,sub_id.getText());
            statement.setString(2,ins_name.getText());
            statement.setString(3,ins_cnic.getText());
            statement.setString(4,ins_dob.getText());
            statement.setString(5,ins_gender.getText());
            statement.setString(6,ins_phone.getText());
            statement.setString(7,ins_address.getText());
            statement.setString(8,ins_father.getText());
            statement.setString(9,ins_join_date.getText());
            statement.setString(10,ins_quali.getText());
            statement.setString(11,ins_design.getText());
            statement.setString(12,ins_scale.getText());
            statement.setString(13,ins_salary.getText());
            statement.setString(14,ins_id.getText());
            
            
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    
    @FXML
    void view_bottom_clicked(ActionEvent event) throws IOException {
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql3 = "select * from TABLE_INSTRUCTORS where Instructor_ID=?";
             PreparedStatement statement = conn.prepareStatement(sql3);
             statement.setString(1, search_ins.getText());
             System.out.println(sql3);
 
            ResultSet result2 = statement.executeQuery();
              while(result2.next()) {
             ins_id.setText(result2.getString("Instructor_ID"));
             sub_id.setText(result2.getString("Subject_ID"));
             ins_name.setText(result2.getString("Instructor_Name"));
             ins_cnic.setText(result2.getString("Instructor_CNIC"));
             ins_dob.setText(result2.getString("Instructor_DOB"));
             ins_gender.setText(result2.getString("Instructor_Gender"));
             ins_phone.setText(result2.getString("Instructor_Phone"));
             ins_address.setText(result2.getString("Instructor_Address"));
             ins_father.setText(result2.getString("Instructor_F_Name"));
             ins_join_date.setText(result2.getString("Date_Of_Join"));
             ins_quali.setText(result2.getString("Instructor_Qualification"));
             ins_design.setText(result2.getString("Instructor_designation"));
             ins_scale.setText(result2.getString("Instructor_Scale"));
             ins_salary.setText(result2.getString("Instructor_Salary"));}
            System.out.println("done");
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    } 
        

