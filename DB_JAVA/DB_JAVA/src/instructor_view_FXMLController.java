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

public class instructor_view_FXMLController {
     private ObservableList<Instructor> data3;
      @FXML
    private TableView<Instructor> InstructorTable;

    @FXML
    private TableColumn<?, ?> Date_Of_Join;

    @FXML
    private TableColumn<?, ?> Instructor_Address;

    @FXML
    private TableColumn<?, ?> Instructor_CNIC;

    @FXML
    private TableColumn<?, ?> Instructor_DOB;

    @FXML
    private TableColumn<?, ?> Instructor_F_Name;

    @FXML
    private TableColumn<?, ?> Instructor_Gender;

    @FXML
    private TableColumn<?, ?> Instructor_ID;

    @FXML
    private TableColumn<?, ?> Instructor_Name;

    @FXML
    private TableColumn<?, ?> Instructor_Phone;

    @FXML
    private TableColumn<?, ?> Instructor_Qualification;

    @FXML
    private TableColumn<?, ?> Instructor_Salary;

    @FXML
    private TableColumn<?, ?> Instructor_Scale;

    @FXML
    private TableColumn<?, ?> Instructor_designation;

    @FXML
    private TableColumn<?, ?> Subject_ID;

    @FXML
    private Button all;

    @FXML
    private Button crs_btn;

    @FXML
    private TextField crs_id;

    @FXML
    private TextField exp;

    @FXML
    private Button ins_btn;

    @FXML
    private Button std_btn;

    @FXML
    private Button sub_btn;

    @FXML
    private TextField subj_id;

    @FXML
    private Button view;

    @FXML
    private Button view_btn;
    
     private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3
    
    
     private void setTableCell(){
        Subject_ID.setCellValueFactory(new PropertyValueFactory<>("sub_id"));
        Instructor_ID.setCellValueFactory(new PropertyValueFactory<>("ins_id"));
        Instructor_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Instructor_F_Name.setCellValueFactory(new PropertyValueFactory<>("f_name"));
        Instructor_CNIC.setCellValueFactory(new PropertyValueFactory<>("cnic"));
        Instructor_DOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        Instructor_Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Instructor_Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Date_Of_Join.setCellValueFactory(new PropertyValueFactory<>("doj"));
        Instructor_Qualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        Instructor_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        Instructor_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        Instructor_Scale.setCellValueFactory(new PropertyValueFactory<>("scale"));
        Instructor_Salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        
       
        
    }



    @FXML
    private void all_table(ActionEvent event) {
      System.out.println("CHAL PARA BHAI");
      data3= FXCollections.observableArrayList();
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql3 = "select *from TABLE_INSTRUCTORS";
             PreparedStatement statement = conn.prepareStatement(sql3);

            ResultSet result2 = statement.executeQuery();
              while(result2.next()) {
             
             data3.add(new Instructor( result2.getString("Subject_ID"),result2.getString("Instructor_ID") ,result2.getString("Instructor_Name"),result2.getString("Instructor_F_Name"), result2.getString("Instructor_CNIC"), result2.getString("Instructor_DOB"),result2.getString("Instructor_Phone") ,result2.getString("Instructor_Address") ,   result2.getString("Date_Of_Join"),result2.getString("Instructor_Qualification") , result2.getString("Instructor_Gender") ,result2.getString("Instructor_designation") ,result2.getString("Instructor_Scale") ,result2.getString("Instructor_Salary") ));
             
              }
              
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("done");
        InstructorTable.setItems(data3);
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

    }

}
