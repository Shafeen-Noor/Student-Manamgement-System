import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.table.DefaultTableModel;

public class Course_view_FXMLController {
    
    private ObservableList<Course> data;
    
    @FXML
    private TableColumn<?, ?> Course_Name;

    @FXML
    private TableColumn<?, ?> Coursse_ID;

    @FXML
    private TableColumn<?, ?> Duration;

    @FXML
    private TableColumn<?, ?> Required_Qualification;

    @FXML
    private TableColumn<?, ?> Total_Seats;
    
    @FXML
    private TableView<Course> table;

    @FXML
    private Button all;



    @FXML
    private Button crs_btn;

    @FXML
    private TextField duration; 

    @FXML
    private Button ins_btn;

    @FXML
    private TextField qualification;

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
    

    
    public void initialize(URL url, ResourceBundle rb) {
      
   

    }
   
  
    private void setTableCell(){
        Coursse_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Course_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        Total_Seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        Required_Qualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
    }

    
    @FXML
    private void all_table(ActionEvent event) {
      System.out.println("CHAL PARA BHAI");
      data= FXCollections.observableArrayList();
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_COURSES";
             PreparedStatement statement = conn.prepareStatement(sql2);

            ResultSet result = statement.executeQuery();
              while(result.next()) {
             String id=(result.getString("Course_ID"));
             String name=(result.getString("Course_Name"));
             String duration=(result.getString("Duration"));
             String seats=(result.getString("Total_Seats"));
             String qualification=(result.getString("Required_Qualification"));
             data.add(new Course(id,name,duration,seats,qualification));
             


              }
              
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        table.setItems(data);
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

