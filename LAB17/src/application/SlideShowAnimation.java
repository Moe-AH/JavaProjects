package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;



public class SlideShowAnimation extends Application {
	String[] str = { "file:img.jpg", "file:img2.jpg", "file:img3.jpg" };
	int count = 0;
	@Override
	public void start(Stage primaryStage) {
			BorderPane root = new BorderPane();
			HBox hbox = new HBox();
			Scene scene = new Scene(root,1920,1080);
			StackPane stack = new StackPane();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Button pause = new Button("Pause");
			Button play = new Button("Play");
			ImageView imageView = new ImageView();
			imageView.setImage(new Image(str[count]));
			play.setOnAction(e->{});
			EventHandler<ActionEvent> eventHandler= e ->{
				stack.getChildren().clear();
				System.out.println(count);
				if (++count < str.length) {
					Image img = new Image(str[count]);
					ImageView iv = new ImageView();
					iv.setImage(img);
					stack.getChildren().add(iv);
				}else {
					count = 0;
					Image img = new Image(str[count]);
					ImageView iv = new ImageView();
					iv.setImage(img);
					stack.getChildren().add(iv);
				}
				
			};
			Animation timeline = new Timeline(new KeyFrame(Duration.seconds(2), eventHandler));
			timeline.setCycleCount(-1);
			play.setOnAction(e->{
				timeline.play();
			});
			pause.setOnAction(e->{
				timeline.pause();
			});
			root.setCenter(stack);
			root.setBottom(hbox);
			stack.getChildren().addAll(imageView);
			hbox.getChildren().addAll(play, pause);

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
