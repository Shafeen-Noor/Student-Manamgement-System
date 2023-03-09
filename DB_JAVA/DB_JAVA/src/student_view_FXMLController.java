import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class student_view_FXMLController {
     private ObservableList<Student> data;
 @FXML
    private TableColumn<?, ?> Course_ID;

    @FXML
    private TableColumn<?, ?> Guardian_Address;

    @FXML
    private TableColumn<?, ?> Guardian_Name;

    @FXML
    private TableColumn<?, ?> Guardian_relation;

    @FXML
    private TableColumn<?, ?> Permanent_Address;

    @FXML
    private TableColumn<?, ?> Phone_Number;

    @FXML
    private TableColumn<?, ?> Present_Address;

    @FXML
    private TableView<Student> StudentTable;

    @FXML
    private TableColumn<?, ?> Student_CNIC;

    @FXML
    private TableColumn<?, ?> Student_DOB;

    @FXML
    private TableColumn<?, ?> Student_F_CNIC;

    @FXML
    private TableColumn<?, ?> Student_F_Name;

    @FXML
    private TableColumn<?, ?> Student_F_Occupation;

    @FXML
    private TableColumn<?, ?> Student_ID;

    @FXML
    private TableColumn<?, ?> Student_Name;

    @FXML
    private TableColumn<?, ?> Student_Qualification;

    @FXML
    private TableColumn<?, ?> Student_Religion;

    @FXML
    private TableColumn<?, ?> Year_Of_Addmission;

    @FXML
    private Button all;

    @FXML
    private TableColumn<?, ?> batch;

    @FXML
    private TextField batch2;

    @FXML
    private Button crs_btn;

    @FXML
    private TextField crs_id;

    @FXML
    private Button ins_btn;

    @FXML
    private TableColumn<?, ?> mobile;

    @FXML
    private Button std_btn;

    @FXML
    private Button sub_btn;

    @FXML
    private TextField subj_id;

    @FXML
    private TableColumn<?, ?> tel_Number;

    @FXML
    private Button view;

    @FXML
    private Button view_btn;
    
    private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3
    
        private void setTableCell(){
        Course_ID.setCellValueFactory(new PropertyValueFactory<>("crs_id"));
        Student_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
         Student_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
         Student_CNIC.setCellValueFactory(new PropertyValueFactory<>("cnic"));
         Student_F_Name.setCellValueFactory(new PropertyValueFactory<>("f_name"));
         Student_F_CNIC.setCellValueFactory(new PropertyValueFactory<>("f_cnic"));
         Student_F_Occupation.setCellValueFactory(new PropertyValueFactory<>("f_occupation"));
          Phone_Number.setCellValueFactory(new PropertyValueFactory<>("phone"));
          Student_DOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
          Student_Religion.setCellValueFactory(new PropertyValueFactory<>("religion"));
        Present_Address.setCellValueFactory(new PropertyValueFactory<>("present"));       
        Permanent_Address.setCellValueFactory(new PropertyValueFactory<>("permanent"));
        Year_Of_Addmission.setCellValueFactory(new PropertyValueFactory<>("yoa"));
        batch.setCellValueFactory(new PropertyValueFactory<>("batch"));
        Student_Qualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        tel_Number.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        Guardian_Name.setCellValueFactory(new PropertyValueFactory<>("g_name"));
        Guardian_relation.setCellValueFactory(new PropertyValueFactory<>("g_relation"));
        Guardian_Address.setCellValueFactory(new PropertyValueFactory<>("g_address"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
                      
    }


    @FXML
    private void all_table(ActionEvent event) {
    System.out.println("CHAL PARA BHAI");
      data= FXCollections.observableArrayList();
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_STUDENTS";
             PreparedStatement statement = conn.prepareStatement(sql2);

            ResultSet result = statement.executeQuery();
              while(result.next()) {

             data.add(new Student( result.getString("Course_ID"), result.getString("Student_ID") , result.getString("Student_Name") , result.getString("Student_CNIC") , result.getString("Student_F_Name") , result.getString("Student_F_CNIC") , result.getString("Student_F_Occupation") , result.getString("Phone_Number") , result.getString("Student_DOB") , result.getString("Student_Religion") , result.getString("Present_Address") , result.getString("Permanent_Address") , result.getString("Year_Of_Admission") , result.getString("batch") , result.getString("Student_Qualification") , result.getString("tel_Number") , result.getString("Guardian_Name") , result.getString("Guardian_relation") , result.getString("Guardian_Address") , result.getString("mobile") ));
             


              }
              
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        StudentTable.setItems(data);
        setTableCell();

    }

    @FXML
    void crs_btn_clicked(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("course_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ins_btn_clicked(ActionEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("Instructor_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void std_btn_clicked(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("Student_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void subj_btn_clicked(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("subject_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void view_btn_clicked(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void view_table(ActionEvent event) {
       
         data= FXCollections.observableArrayList();
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql3 = "select *from TABLE_STUDENTS,TABLE_SUBJECTS where TABLE_STUDENTS.Course_ID=? AND TABLE_STUDENTS.batch=? AND TABLE_SUBJECTS.Subject_ID=?;";
             PreparedStatement statement = conn.prepareStatement(sql3);
             statement.setString(2,batch.getText());
            statement.setString(1,crs_id.getText());
            statement.setString(3,subj_id.getText());
            

            ResultSet result = statement.executeQuery();
              while(result.next()) {

             data.add(new Student( result.getString("Course_ID"), result.getString("Student_ID") , result.getString("Student_Name") , result.getString("Student_CNIC") , result.getString("Student_F_Name") , result.getString("Student_F_CNIC") , result.getString("Student_F_Occupation") , result.getString("Phone_Number") , result.getString("Student_DOB") , result.getString("Student_Religion") , result.getString("Present_Address") , result.getString("Permanent_Address") , result.getString("Year_Of_Admission") , result.getString("batch") , result.getString("Student_Qualification") , result.getString("tel_Number") , result.getString("Guardian_Name") , result.getString("Guardian_relation") , result.getString("Guardian_Address") , result.getString("mobile") ));
             


              }
              
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        StudentTable.setItems(data);
        setTableCell();

    }

}
