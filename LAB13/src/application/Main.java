package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();
				int randomNum = rand.nextInt(10);
				TextField text = new TextField();
				text.setText(""+randomNum);
				text.setEditable(false);
				text.setAlignment(Pos.CENTER);
				text.setPrefHeight(100);
				text.setPrefWidth(100);
				grid.add(text, i, j);
			}
		}
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}