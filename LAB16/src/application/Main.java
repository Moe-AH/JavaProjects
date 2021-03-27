package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
	String[] str = { "file:img.jpg", "file:img2.jpg", "file:img3.jpg" };
	int currentIndex = 0;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 500, 500);
		Circle circ = new Circle(50);
		circ.setFill(new ImagePattern(new Image(str[currentIndex])));
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		hb.getChildren().addAll(next, previous);
		circ.setRadius(200);
		root.setCenter(circ);
		root.setBottom(hb);

		next.setOnAction(e -> {
			if (currentIndex == str.length - 1) {
				next.setDisable(true);
			} else {
				previous.setDisable(false);
				circ.setFill(new ImagePattern(new Image(str[++currentIndex])));
			}
		});

		previous.setOnAction(e -> {
			if (currentIndex <= 0) {
				previous.setDisable(true);
			} else {
				next.setDisable(false);
				circ.setFill(new ImagePattern(new Image(str[--currentIndex])));
			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
