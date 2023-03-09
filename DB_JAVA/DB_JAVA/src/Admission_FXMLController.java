import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.stage.FileChooser;

public class Admission_FXMLController {

    @FXML
    private Button browse;

    @FXML
    private TextField cnic;

    @FXML
    private TextField course1;

    @FXML
    private TextField course2;

    @FXML
    private TextField dob;

    @FXML
    private TextField f_cnic;

    @FXML
    private TextField father_name;

    @FXML
    private TextField father_occupation;

    @FXML
    private TextField gaurdian_name;

    @FXML
    private TextField guardian_address;

    @FXML
    private TextField guardian_relation;

    @FXML
    private TextField image_path;

    @FXML
    private TextField matric_division;

    @FXML
    private TextField matric_obt_marks;

    @FXML
    private TextField matric_passing_year;

    @FXML
    private TextField matric_school;

    @FXML
    private TextField matric_total_marks;

    @FXML
    private TextField middle_division;

    @FXML
    private TextField middle_obt_marks;

    @FXML
    private TextField middle_passing_year;

    @FXML
    private TextField middle_school;

    @FXML
    private TextField middle_total_marks;

    @FXML
    private TextField mob_number;

    @FXML
    private Label msg;

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
    private Button submit;

    @FXML
    private TextField tel_number;

    @FXML
    void BrowseActionHandler(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile!=null){
            image_path.setText(selectedFile.getName());
        }

    }

    @FXML
    void SubmitActionHAndler(ActionEvent event) {
        
        
         String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=project;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql = "Insert into TABLE_APPLICANTS(Course1_name  ,Course2_name  ,Applicant_Name  ,Applicant_CNIC  ,Applicant_F_Name  ,Applicant_F_CNIC  ,Applicant_F_Occupation  ,mob_Number,tel_Number  ,Applicant_DOB ,Applicant_Religion  ,Present_Address  ,Permanent_Address  ,guardian_name  ,guardian_adress  ,middle_school ,middle_passing_year ,middle_total_marks ,middle_obtained_marks ,middle_division ,matric_school ,matric_passing_year ,matric_total_marks ,matric_obtained_marks ,matric_division , Applicant_Qualification,imagedata,applying_date)+"
                     + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATETIME,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,course1.getText());
            statement.setString(2,course2.getText());
            statement.setString(3,name.getText());
            statement.setString(4,cnic.getText());
            statement.setString(5,father_name.getText());
            statement.setString(6,f_cnic.getText());
            statement.setString(7,father_occupation.getText());
            statement.setString(8,mob_number.getText());
            statement.setString(9,tel_number.getText());
            statement.setString(10,dob.getText());
            statement.setString(11,religion.getText());
            statement.setString(12,present_address.getText());
            statement.setString(13,permanent_address.getText());
            statement.setString(14,gaurdian_name.getText());
            statement.setString(15,guardian_address.getText());
            statement.setString(16,middle_school.getText());
            statement.setString(17,middle_passing_year.getText());
            statement.setString(18,middle_total_marks.getText());
            statement.setString(19,middle_obt_marks.getText());
            statement.setString(20,middle_division.getText());
            statement.setString(21,matric_school.getText());
            statement.setString(22,matric_passing_year.getText());
            statement.setString(23,matric_total_marks.getText());
            statement.setString(24,matric_obt_marks.getText());
            statement.setString(25,matric_division.getText());
            statement.setString(26,qualification.getText());
            statement.setString(27,"BulkColumn from Openrowset( Bulk '?', Single_Blob) as ProductPicture"+ image_path.getText());
            
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
