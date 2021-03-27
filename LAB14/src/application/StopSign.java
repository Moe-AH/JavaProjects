package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StopSign extends Application {
	@Override
	public void start(Stage primaryStage) {
		StackPane stackPane = new StackPane();
		
		Polygon sign = new Polygon();
		sign.setFill(Color.RED);
		sign.setStrokeWidth(10);
		sign.setStroke(Color.BLACK);
		sign.setRotate(22.5);

		double w = 500, h = 500;
		double centerX = w / 2;
		double centerY = h / 2;
		double radius = Math.min(w, h)/2;
		
		ObservableList<Double> list = sign.getPoints();
		
		for (int i = 0; i < 8; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
		}
		
		stackPane.getChildren().add(sign);
		
		Text text = new Text("STOP");
		text.setFont(Font.font("Times new Roman", FontWeight.BOLD, 160));
		text.setFill(Color.WHITE);
		stackPane.getChildren().add(text);

		Scene scene = new Scene(stackPane, w, h);
		primaryStage.setTitle("LAB14");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
