
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Student_FXMLController implements Initializable {

    @FXML
    private TextField batch;
    @FXML
    private Button add;

    @FXML
    private Button btn_ins;

    @FXML
    private TextField cnic;

    @FXML
    private TextField cnic_search;

    @FXML
    private TextField course_id;

    @FXML
    private Button crs_btn;

    @FXML
    private TextField dob;

    @FXML
    private TextField f_cnic;

    @FXML
    private TextField f_occupattion;

    @FXML
    private TextField father_name;

    @FXML
    private TextField gaurdian_address;

    @FXML
    private TextField gaurdian_name;

    @FXML
    private TextField gaurdian_relation;

    @FXML
    private TextField mob_number;

    @FXML
    private TextField name;

    @FXML
    private TextField permanent_address;

    @FXML
    private TextField present_address;

    @FXML
    private TextField qualification;

    @FXML
    private TextField religion;

    @FXML
    private Button search;

    @FXML
    private Button std_btn;

    @FXML
    private TextField student_id;

    @FXML
    private Button subj_btn;

    @FXML
    private TextField tel_number;

    @FXML
    private Button update;

    @FXML
    private Button view_btn;
        private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    void add_clicked(ActionEvent event) {

              String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "Insert into TABLE_STUDENTS(\n" +
            "batch   ,\n" +
            "Course_ID   ,\n" +
            "Student_ID ,\n" +
            "Student_Name  ,\n" +
            "Student_CNIC   ,\n" +
            "Student_F_Name   ,\n" +
            "Student_F_CNIC   ,\n" +
            "Student_F_Occupation   ,\n" +
            "Phone_Number ,\n" +
            "mobile ,\n" +
            "Student_DOB  ,\n" +
            "Student_Religion  ,\n" +
            "Present_Address   ,\n" +
            "Permanent_Address   ,\n" +
            "Guardian_Name   ,\n" +
            "Guardian_Address   ,\n" +
            "Guardian_relation,\n" +
            "Year_Of_Admission,\n" +
                     
            " Student_Qualification) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATETIME(),?)";
         PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,batch.getText());
            statement.setString(2,course_id.getText());
            statement.setString(3,student_id.getText());
            statement.setString(4,name.getText());
            statement.setString(5,cnic.getText());
            statement.setString(6,father_name.getText());
            statement.setString(7,f_cnic.getText());
            statement.setString(8,f_occupattion.getText());
            statement.setString(9,tel_number.getText());
            statement.setString(10,mob_number.getText());
            statement.setString(11,dob.getText());
            statement.setString(12,religion.getText());
            statement.setString(13,present_address.getText());
            statement.setString(14,permanent_address.getText());
            statement.setString(15,gaurdian_name.getText());
            statement.setString(16,gaurdian_address.getText());
            statement.setString(17,gaurdian_relation.getText());
            statement.setString(18,qualification.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

        
        
        
        

    @FXML
    void btn_ins_actn(ActionEvent event)throws IOException {
           root = FXMLLoader.load(getClass().getResource("Instructor_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void crs_btn_clk(ActionEvent event) throws IOException{
         root = FXMLLoader.load(getClass().getResource("course_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }



    @FXML
    void std_btn_clicked(ActionEvent event)throws IOException {
          root = FXMLLoader.load(getClass().getResource("Student_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void subj_btn_clk(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("subject_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void update_clicked(ActionEvent event) throws ParseException {
        
        
              String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "UPDATE TABLE_STUDENTS set batch=?   ,\n" +
            "Course_ID=?   ,\n" +
            "Student_Name=?  ,\n" +
            "Student_CNIC=?   ,\n" +
            "Student_F_Name=?   ,\n" +
            "Student_F_CNIC=?   ,\n" +
            "Student_F_Occupation=?   ,\n" +
            "Phone_Number=? ,\n" +
            "mobile=? ,\n" +
            "Student_DOB=?  ,\n" +
            "Student_Religion=?  ,\n" +
            "Present_Address=?   ,\n" +
            "Permanent_Address=?   ,\n" +
            "Guardian_Name=?   ,\n" +
            "Guardian_Address=? ,\n" +
            "Guardian_relation=?,\n" +
            " Student_Qualification=? where Student_ID=? ";
         PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,batch.getText());
            statement.setString(2,course_id.getText());
            statement.setString(3,name.getText());
            statement.setString(4,cnic.getText());
            statement.setString(5,father_name.getText());
            statement.setString(6,f_cnic.getText());
            statement.setString(7,f_occupattion.getText());
            statement.setString(8,tel_number.getText());
            statement.setString(9,mob_number.getText());
            statement.setString(10,dob.getText());
            statement.setString(11,religion.getText());
            statement.setString(12,present_address.getText());
            statement.setString(13,permanent_address.getText());
            statement.setString(14,gaurdian_name.getText());
            statement.setString(15,gaurdian_address.getText());
            statement.setString(16,gaurdian_relation.getText());
            statement.setString(17,qualification.getText());
            statement.setString(18,student_id.getText());
            statement.executeUpdate();
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        

    }

    @FXML
    void view_btn_cliked(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
        @FXML
    void search_btn_cliked(ActionEvent event) {
        
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_APPLICANTS where Applicant_CNIC=?";
             PreparedStatement statement = conn.prepareStatement(sql2);
             statement.setString(1, cnic_search.getText());
 
            ResultSet result = statement.executeQuery();
              while(result.next()) {
             name.setText(result.getString("Applicant_Name"));
             cnic.setText(result.getString("Applicant_CNIC"));
             father_name.setText(result.getString("Applicant_F_Name"));
             f_cnic.setText(result.getString("Applicant_F_CNIC"));
              f_occupattion.setText(result.getString("Applicant_F_Occupation"));
              mob_number.setText(result.getString("mob_Number"));
               tel_number.setText(result.getString("tel_Number"));
               Date date = result.getDate("Applicant_DOB");
             dob.setText(date.toString());
             religion.setText(result.getString("Applicant_Religion"));
             present_address.setText(result.getString("Present_Address"));
             permanent_address.setText(result.getString("Permanent_Address"));
             gaurdian_name.setText(result.getString("guardian_name"));
             gaurdian_address.setText(result.getString("guardian_adress"));
             gaurdian_relation.setText(result.getString("guardian_relation"));
             qualification.setText(result.getString("Applicant_Qualification")); }
            
   
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    

    }


