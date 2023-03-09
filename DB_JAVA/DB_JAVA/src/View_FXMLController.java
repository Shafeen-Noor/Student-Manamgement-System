/*
view controller class
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class View_FXMLController implements Initializable {

    
    @FXML
    private ComboBox  combo;

    @FXML
    private Button crs_btn;

    @FXML
    private Button ins_btn;

    @FXML
    private Button std_btn;

    @FXML
    private Button sub_btn;

    @FXML
    private Button view_btn;


    private Stage stage; //1
    private Scene scene; //2
    private Parent root; //
    @FXML
    private Button view;
    @FXML
    private Button all;
    @FXML
    private TextField crs_id;


    
    /**
     * Initializes the controller class.
     */
    @FXML
    void select(ActionEvent event) throws IOException {
     combo.getSelectionModel().getSelectedItem().toString();
   //  combo.getValue();
   if(combo.getValue().equals("Course"))
   {
    root = FXMLLoader.load(getClass().getResource("course_view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
   else if(combo.getValue().equals("Student")){
   root = FXMLLoader.load(getClass().getResource("student_view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
   else if(combo.getValue().equals("Instructor")){
   root = FXMLLoader.load(getClass().getResource("instructor_view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
   else if(combo.getValue().equals("Subject")){
   root = FXMLLoader.load(getClass().getResource("subject_view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
        
    }
    
    
    ObservableList<String>
            students = FXCollections.observableArrayList("Student", "Instructor","Course","Subject");
           
    
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
       ObservableList<String>
            list = FXCollections.observableArrayList(
            "Student", "Instructor","Course","Subject");
       combo.setItems(list);
    }
    */
    
    
    public void initialize(URL url, ResourceBundle rb) {
      
         combo.setItems(students);

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
    private void view_table(ActionEvent event) {
    }

    @FXML
    private void all_table(ActionEvent event) {
    }

}