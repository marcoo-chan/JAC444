// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/01/2020
//
// Workshop 5
// Main.java

package application;

import javafx.application.Application;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Main extends Application 
{
    private Group group;
    private TextArea displayTextArea;
    
    private TextField stdIDTextField;
    private TextField fNameTextField;
    private TextField lNameTextField;
    private TextArea coursesTextArea;
    private ArrayList<Student> students;

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    { 
        students = ReadStdInfo.loadStudents(); //UNSERIALIZE DATA FILE (students.txt)
        
        group = new Group();
        group.setLayoutY(15);
        
        FlowPane pane = new FlowPane(); //ADD STUDENTS WINDOW
        pane.setStyle("-fx-border-color: black");
        pane.setLayoutX(50);
        pane.setLayoutY(35);
        pane.setPrefHeight(250); 
        group.getChildren().add(pane);
        
        Label title = new Label("Add Students"); //ADD STUDENTS LABEL
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setLayoutX(190);
        Label title2 = new Label("Display Students"); //DISPLAY STUDENTS LABEL
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title2.setLayoutX(625);
        group.getChildren().addAll(title, title2);
        
        Scene scene = new Scene(group, 950, 350); //APP SIZE (X AXIS, Y AXIS)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Seneca Student Management | Marco Chan Lab 5"); //APP TITLE
        primaryStage.setResizable(false); //NON-RESIZABLE APP WINDOW
        primaryStage.show();
        
        Label inputLabel1 = new Label("Student ID:"); //ID LABEL
        inputLabel1.setLayoutX(80);
        inputLabel1.setLayoutY(73); 
        Label inputLabel2 = new Label("First Name:"); //FIRST NAME LABEL
        inputLabel2.setLayoutX(80);
        inputLabel2.setLayoutY(103);
        Label inputLabel3 = new Label("Last Name:"); //LAST NAME LABEL
        inputLabel3.setLayoutX(80);
        inputLabel3.setLayoutY(133);
        Label inputLabel4 = new Label("Courses:"); //COURSES LABEL
        inputLabel4.setLayoutX(80);
        inputLabel4.setLayoutY(183);
        group.getChildren().addAll(inputLabel1, inputLabel2, inputLabel3, inputLabel4);
        
        TextField inputField1 = new TextField(); //ID TEXT FIELD
        inputField1.setPrefWidth(210);
        inputField1.setLayoutX(170);
        inputField1.setLayoutY(70);
        stdIDTextField = inputField1;
        TextField inputField2 = new TextField(); //FIRST NAME TEXT FIELD
        inputField2.setPrefWidth(210);
        inputField2.setLayoutX(170);
        inputField2.setLayoutY(100);
        fNameTextField = inputField2;
        TextField inputField3 = new TextField(); //LAST NAME TEXT FIELD
        inputField3.setPrefWidth(210);
        inputField3.setLayoutX(170);
        inputField3.setLayoutY(130);
        lNameTextField = inputField3;
        TextArea inputField4 = new TextArea(); //COURSES TEXT AREA
        inputField4.setPrefWidth(210);
        inputField4.setPrefHeight(60);
        inputField4.setLayoutX(170);
        inputField4.setLayoutY(162);
        coursesTextArea = inputField4;
        group.getChildren().addAll(inputField1, inputField2, inputField3, inputField4);
        
        TextArea inputField5 = new TextArea(); //DISPLAY STUDENTS WINDOW
        inputField5.setPrefWidth(400);
        inputField5.setPrefHeight(250);
        inputField5.setLayoutX(500);
        inputField5.setLayoutY(35);
        displayTextArea = inputField5;
        displayTextArea.setEditable(false); //NON-EDITABLE STUDENT DISPLAY WINDOW
        displayTextArea.setStyle("-fx-border-color: black");
        
        group.getChildren().add(inputField5);
        
        String students = "";
        int COUNT = 1;
        
        for (Student student: this.students) //LOOP THROUGH STUDENT OBJECTS
        {
        	students += "STUDENT# " + COUNT + " "; //STUDENT COUNT
            students += student.toString(); //STUDENT DATA TO STRING TO DISPLAY WINDOW
            COUNT++;
        }
        
        displayTextArea.setText(students);
        displayTextArea.appendText(""); 
        
        Button addStudent = new Button("Add Student");
        addStudent.setPrefWidth(310);
        addStudent.setLayoutX(80);
        addStudent.setLayoutY(250);
        
        addStudent.setOnAction( e -> 
        {
        	addNewStudent(storeStudentInfo());
			
			stdIDTextField.setText(""); //CLEAR STUDENT ID FIELD AFTER ADDING
	        fNameTextField.setText(""); //CLEAR FIRST NAME FIELD AFTER ADDING
	        lNameTextField.setText(""); //CLEAR LAST NAME FIELD AFTER ADDING
	        coursesTextArea.setText(""); //CLEAR COURSE FIELD AFTER ADDING
		});
                
        group.getChildren().add(addStudent);
    }

    private Student storeStudentInfo() 
    {
        int stdID = Integer.parseInt(stdIDTextField.getText()); //GET STUDENT ID VIA GETTEXT()
        String firstName = fNameTextField.getText(); //GET FIRST NAME VIA GETTEXT()
        String lastName = lNameTextField.getText(); //GET LAST NAME VIA GETTEXT()
        ArrayList<String> courses = new ArrayList<String>(); //SAVE COURSE(S) INTO AN ARRAY STRING []
        
        for (String course: coursesTextArea.getText().split(",")) //COMMA DELIMETER WHEN ENTERING MORE THAN ONE COURSE 
        {
            courses.add(course);
        }
        
        return new Student(stdID, firstName, lastName, courses); //RETURN NEW STUDENT OBJECT
    }

    private void addNewStudent(Student student) 
    {
        students.add(student);
        displayStudents();        
        SetStdInfo.saveStudents(students); //SERIALIZE STUDENT INFO
    }

    private void displayStudents() 
    {
        String students = "";
        int COUNT = 1;
        
        for (Student student: this.students) //LOOP THROUGH STUDENT OBJECTS
        {
        	students += "STUDENT#: " + COUNT + " "; //STUDENT COUNT
            students += student.toString(); //STUDENT DATA TO STRING TO DISPLAY WINDOW
            COUNT++;
        }
        
        displayTextArea.setText(students); 
        displayTextArea.appendText(""); 
    }
}
