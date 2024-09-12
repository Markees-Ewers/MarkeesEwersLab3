package edu.westga.cs1302.cms.view;

import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private TextField name;
	@FXML
	private TextField grade;
	@FXML
	private ListView<Student> students;

	@FXML
	private TextField gradeTextField;
	@FXML
	private Button changeGradeButton;

	@FXML
	void addStudent(ActionEvent event) {
		String studentName = this.name.getText();
		try {
			int grade = Integer.parseInt(this.grade.getText());
			Student student = new Student(studentName, grade);
			this.students.getItems().add(student);
			this.name.clear();
			this.grade.clear();
		} catch (NumberFormatException errorThing) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorThing.getMessage() + ". Please re-enter grade and try again.");
			errorPopup.showAndWait();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorObject.getMessage() + ". Please re-enter name and try again.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void removeStudent(ActionEvent event) {
		Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.students.getItems().remove(student);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to remove.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void changeGrade(ActionEvent event) {
	    Student selectedStudent = this.students.getSelectionModel().getSelectedItem();
	    if (selectedStudent != null) {
	        try {
	            int newGrade = Integer.parseInt(this.gradeTextField.getText());
	            selectedStudent.setGrade(newGrade);
	            this.gradeTextField.clear();
	            this.students.refresh();
	        } catch (NumberFormatException ex) {
	            Alert errorPopup = new Alert(Alert.AlertType.ERROR);
	            errorPopup.setContentText("Invalid grade. Please enter a valid number.");
	            errorPopup.showAndWait();
	            this.grade.clear();
	        } catch (IllegalArgumentException go) {
	        	Alert errorPopup = new Alert(Alert.AlertType.ERROR);
	            errorPopup.setContentText(go.getMessage());
	            errorPopup.showAndWait();
	            this.grade.clear();
	        }
	    }
	}

    @FXML
    void initialize() {
    	 assert this.changeGradeButton != null : "fx:id=\"changeGradeButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
         assert this.grade != null : "fx:id=\"grade\" was not injected: check your FXML file 'MainWindow.fxml'.";
         assert this.gradeTextField != null : "fx:id=\"gradeTextField\" was not injected: check your FXML file 'MainWindow.fxml'.";
         assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
         assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";
         this.gradeTextField.setEditable(false);

        this.students.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {  
             this.gradeTextField.setEditable(true);
            } else {
             this.gradeTextField.setEditable(false);
            }
        });
		
	}

}
