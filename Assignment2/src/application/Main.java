package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	ArrayList<Student> students = new ArrayList<>();

	public class Student implements Comparable<Student> {
		int ID;
		String name;

		Student(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public int compareTo(Student o) {
			if (this.ID == o.ID) {
				return 0;
			} else if (this.ID > o.ID) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	@Override
	public void start(Stage primaryStage) {
		Text lb = new Text("ID number sorter");
		lb.setLayoutX(110);
		lb.setLayoutY(100);
		Pane root = new Pane();
		Button loadBtn = new Button("Load");
		loadBtn.setLayoutX(50);
		loadBtn.setLayoutY(200);
		loadBtn.setPrefSize(60, 50);
		loadBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					FileReader fr = new FileReader("unsortedStudents.txt");
					BufferedReader br = new BufferedReader(fr);
					String line = null;
					while ((line = br.readLine()) != null) {
						String[] data = line.split(" ");
						Student std = new Student(Integer.parseInt(data[0]), data[1]);
						students.add(std);
					}
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Button saveBtn = new Button("Save");
		saveBtn.setLayoutX(200);
		saveBtn.setLayoutY(200);
		saveBtn.setPrefSize(60, 50);
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					FileWriter fw = new FileWriter("StudentsSortedByID.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (Student std : students) {
						bw.write(std.ID + " " + std.name + "\n");
					}
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Button sortBtn = new Button("Sort");
		sortBtn.setLayoutX(125);
		sortBtn.setLayoutY(200);
		sortBtn.setPrefSize(60, 50);
		sortBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Collections.sort(students);
			}
		});
		root.getChildren().addAll(saveBtn, loadBtn, sortBtn);
		root.getChildren().add(lb);
		Scene scene = new Scene(root, 300, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
