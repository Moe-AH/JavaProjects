package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	private long seconds;
	private Timeline clock;
	Label t = new Label("Time: 0s");
	public static final String FRONT_IMAGE = "file:19.png";
	private List<ButtonTile> matchedCards = new ArrayList<ButtonTile>();
	private List<ButtonTile> tiles = new ArrayList<ButtonTile>();
	private List<ButtonTile> completedTiles = new ArrayList<ButtonTile>();
	private List<Integer> scoreList = new ArrayList<Integer>();
	private HBox hBox = new HBox();
	BorderPane bp = new BorderPane();
	GridPane btnGp = new GridPane();
	StackPane sp = new StackPane();
	String[] images = { "file:10.png", "file:11.png", "file:12.png", "file:13.png", "file:14.png", "file:15.png",
			"file:16.png", "file:17.png" };
	Button newBtn = new Button("New game");
	private int moves = 0;
	Label moveslbl = new Label();
	Label hs = new Label("Highscore: ");

	private void loadCards() {
		for (int z = 0; z < 2; z++) {
			for (int i = 0; i < images.length; i++) {
				ImageView backImage = new ImageView(new Image(images[i]));
				ImageView frontImage = new ImageView(new Image(FRONT_IMAGE));
				ButtonTile t = new ButtonTile(images[i], false, frontImage, backImage);
				t.showFrontImage();
				tiles.add(t);
			}
		}
		Collections.shuffle(tiles);
	}

	public void startTimer() {
		clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			seconds++;
			t.setText("Time: " + seconds + "s");

		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	private void createGridPane() {
		for (int i = 0; i < tiles.size(); i++) {
			btnGp.add(tiles.get(i), i % 4, i / 4);
			System.out.println((i % 4) + " : " + (i / 4));
		}
		Shape path = new Rectangle(500, 500);
		sp.getChildren().add(path);
		path.setFill(Color.TRANSPARENT);
		sp.getChildren().add(btnGp);
		bp.setCenter(sp);
	}

	private void reset() {
		matchedCards.clear();
		tiles.clear();
		completedTiles.clear();
		hBox.getChildren().clear();
		bp.getChildren().clear();
		btnGp.getChildren().clear();
		sp.getChildren().clear();
		moveslbl.setText("Moves: ");
		moves = 0;
		seconds = 0;
		clock.play();
		hBox.getChildren().addAll(newBtn, moveslbl, t, hs);
		bp.setBottom(hBox);
	}

	private void addControlButtons() {

		newBtn.setOnAction(e -> {
			reset();
			loadCards();
			createGridPane();
			addMouseClickHandlerToCards();
		});

	}

	private void addMouseClickHandlerToCards() {

		for (int i = 0; i < tiles.size(); i++) {
			ButtonTile tile = tiles.get(i);

			tile.setOnMouseClicked(e -> {
				if (!tile.isShowing()) {
					moves++;
					moveslbl.setText("Moves: " + moves);
					tile.setShowing(true);
					playFlipSound();
					tile.showBackImage();
					matchedCards.add(tile);

					if (matchedCards.size() == 2) {
						if (matchedCards.get(0).getTitle().equals(matchedCards.get(1).getTitle())) {
							matchedCards.get(0).setShowing(true);
							matchedCards.get(1).setShowing(true);
							completedTiles.add(matchedCards.get(0));
							completedTiles.add(matchedCards.get(1));
							System.out.println("matched");
							playSuccessSound();
							matchedCards.clear();
							
							if (completedTiles.size() == tiles.size()) {
								System.out.println("GAME COMPLETED");
								clock.stop();
								scoreList.add(moves);
								hs.setText("Highscore: " + Collections.min(scoreList));
								System.out.println("high score: " + Collections.min(scoreList));
								for (int j = 0; j < scoreList.size(); j++) {
									System.out.println("current score: " + scoreList.get(j));
								}
							}
							
						} else {
							System.out.println("Not matched");
							changeTop();
							playfailSound();
							Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), (event1) -> {
								System.out.println("Delay!");
							}));
							timeline.setCycleCount(1);
							timeline.play();
							timeline.setOnFinished(event1 -> {
								matchedCards.get(0).showFrontImage();
								matchedCards.get(1).showFrontImage();
								matchedCards.get(0).setShowing(false);
								matchedCards.get(1).setShowing(false);
								matchedCards.clear();
								changeTop();
							});
						}
					}
					
				} else {
					System.out.println("meaning card already showing");
				}
			});
		}
	}

	private void changeTop() {
		ObservableList<Node> childs = this.sp.getChildren();
		if (childs.size() > 1) {
			Node topNode = childs.get(childs.size() - 1);
			topNode.toBack();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		hs.setFont(new Font("Arial", 14));
		t.setFont(new Font("Arial", 14));
		moveslbl.setFont(new Font("Arial", 14));
		hBox.setSpacing(10);
		newBtn.setPrefSize(75, 30);
		btnGp.setVgap(10);
		btnGp.setHgap(10);
		startTimer();
		reset();
		addControlButtons();
		loadCards();
		createGridPane();
		addMouseClickHandlerToCards();
		Scene scene = new Scene(bp, 495, 530);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void playFlipSound() {
		String musicFile = "flip.wav";
		File f = new File(musicFile);
		Media sound = new Media(f.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

	private void playSuccessSound() {
		String musicFile = "success.wav";
		File f = new File(musicFile);
		Media sound = new Media(f.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

	private void playfailSound() {
		String musicFile = "fail.wav";
		File f = new File(musicFile);
		Media sound = new Media(f.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

}

class ButtonTile extends Button {
	private String title;
	private boolean isShowing;
	private ImageView backImage;
	private ImageView frontImage;

	public ButtonTile(String title, boolean isShowing, ImageView frontImage, ImageView backImage) {
		super();
		this.title = title;
		this.isShowing = isShowing;
		this.backImage = backImage;
		this.frontImage = frontImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isShowing() {
		return isShowing;
	}

	public void setShowing(boolean isShowing) {
		this.isShowing = isShowing;
	}

	public ImageView getBackImage() {
		return backImage;
	}

	public void setBackImage(ImageView backImage) {
		this.backImage = backImage;
	}

	public ImageView getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(ImageView frontImage) {
		this.frontImage = frontImage;
	}

	public void showBackImage() {
		this.setGraphic(backImage);
	}

	public void showFrontImage() {
		this.setGraphic(frontImage);
	}
}