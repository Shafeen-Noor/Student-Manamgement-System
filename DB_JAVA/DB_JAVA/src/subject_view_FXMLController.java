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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class subject_view_FXMLController {

    private ObservableList<Subject> data2;
    @FXML
    private TableView<Subject> SubjectTable;

    @FXML
    private TableColumn<?, ?> Subject_Description;

    @FXML
    private TableColumn<?, ?> Subject_ID;

    @FXML
    private TableColumn<?, ?> Subject_Name;

    @FXML
    private Button all;

    @FXML
    private ComboBox<?> combo;

    @FXML
    private Button crs_btn;

    @FXML
    private TextField crs_id;

    @FXML
    private Button ins_btn;

    @FXML
    private Button std_btn;

    @FXML
    private Button sub_btn;

    @FXML
    private Button view;

    @FXML
    private Button view_btn;
    
      private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3

    private void setTableCell(){
        Subject_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Subject_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Subject_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
       
    }
    @FXML
    private void all_table(ActionEvent event) {
        System.out.println("CHAL PARA BHAI");
        data2= FXCollections.observableArrayList();
        String ConnectionURL = "jdbc:sqlserver://DESKTOP-JGKINI5\\SQLEXPRESS;databaseName=VOCATIONAL_TRAINING_INSTITUTE;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try(Connection conn = DriverManager.getConnection(ConnectionURL)){
             String sql2 = "select * from TABLE_SUBJECTS";
             PreparedStatement statement = conn.prepareStatement(sql2);
            ResultSet result = statement.executeQuery();
              while(result.next()) {
             data2.add(new Subject(result.getString("Subject_ID"),result.getString("Subject_Name"),result.getString("Subject_Description")));
             
              }
              
            System.out.println("done");
   
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        SubjectTable.setItems(data2);
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
    void select(ActionEvent event) {

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
