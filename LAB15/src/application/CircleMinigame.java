package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleMinigame extends Application {
	CirclePane root = new CirclePane();

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("LAB15");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public class CirclePane extends Pane {
		Circle o = new Circle();

		public CirclePane() {
			getChildren().add(o);
			o.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			o.setStroke(Color.BLACK);
			o.setStrokeWidth(5);
			o.setCenterX(Math.random() * 500);
			o.setCenterY(Math.random() * 500);
			o.setRadius(20);
			o.setOnMouseClicked(e ->{
				root.setPosition();
			});
		}
		public void setPosition() {
			o.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			o.setStroke(Color.BLACK);
			o.setStrokeWidth(5);
			o.setCenterX(Math.random() * 500);
			o.setCenterY(Math.random() * 500);
			o.setRadius(20);
			o.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					root.setPosition();			
				}
			});
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
