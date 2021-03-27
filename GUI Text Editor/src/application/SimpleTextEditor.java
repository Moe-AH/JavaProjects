package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SimpleTextEditor extends Application {
	@Override
	public void start(Stage primaryStage) {

		HBox hb = new HBox();
		Button open = new Button("open");
		Button save = new Button("Save");
		Button clear = new Button("Clear");
		Label lbl = new Label("file: ");
		Label stat = new Label("Status:");
		TextField path = new TextField();
		TextField txt = new TextField();
		txt.setAlignment(Pos.TOP_LEFT);
		txt.setPrefHeight(340);
		open.setOnAction(e -> {
			System.out.println("open button clicked");
			stat.setText("Status: File loaded");
			try {
				BufferedReader br = new BufferedReader(new FileReader(path.getText()));
				txt.setText(br.readLine());
				br.close();
			} catch (FileNotFoundException e1) {
				txt.setText("File not found!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		save.setOnAction(e -> {
			System.out.println("save button clicked");
			try {
				stat.setText("Status: File saved");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path.getText())));
				String tempVariable = txt.getText();
				pw.print(txt.getText());
				pw.flush();
				pw.close();
				txt.setText(tempVariable);
			} catch (IOException e1) {
				txt.setText("File not found!");
			}

		});
		clear.setOnAction(e -> {
			System.out.println("clear button clicked");
			try{
				stat.setText("Status: File cleared");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path.getText())));
				String tempVariable = " ";
				pw.print(" ");
				pw.flush();
				pw.close();
				txt.setText(tempVariable);
			} catch (IOException e1) {
				txt.setText("File not found!");
			}
		});
		hb.getChildren().addAll(lbl, path, open, save, clear);
		BorderPane root = new BorderPane();
		root.setTop(hb);
		root.setCenter(txt);
		root.setBottom(stat);
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test3GUI");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
