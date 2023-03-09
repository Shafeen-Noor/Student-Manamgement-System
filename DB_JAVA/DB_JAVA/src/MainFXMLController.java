/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MainFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button stu_btn;

    @FXML
    private Button ins_btn;

    public Button btn_student_clicked;

    private Stage stage; //1
    private Scene scene; //2
    private Parent root; //3

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
/*
    @FXML
    void btn_student_clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student_FXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("STUDENTS");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load");
        }

    }
    */

 @FXML
    public void btn_student_clicked(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("Student_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    /*@FXML
    private void btn_inst_clicked(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Instructor_FXML.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("INSTRUCTOR");
            stage.setScene(new Scene(root2));
            stage.show();
            
        } catch (Exception e) {
            System.out.println("can't load");
        }
    
    }  */
    
    
    public void btn_inst_clicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Instructor_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

  /*  @FXML
    private void btn_course_clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("course_FXML.fxml"));
            Parent root3 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("COURSES");
            stage.setScene(new Scene(root3));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load");
        }
    }
*/
    public void btn_course_clicked(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("course_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
  /*  
    @FXML
    private void btn_subj_clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("subject_FXML.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SUBJECTS");
            stage.setScene(new Scene(root4));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load");
        }
    }
    */
    public void btn_subj_clicked(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("subject_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
/*
    @FXML
    private void btn_view_clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view_FXML.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("VIEW");
            stage.setScene(new Scene(root5));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load");
        }
    }  
*/
    public void btn_view_clicked(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("view_FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
