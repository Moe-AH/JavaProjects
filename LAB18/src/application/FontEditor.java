package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FontEditor extends Application {
	FontWeight fontWeight = FontWeight.NORMAL;
	FontPosture fontPosture = FontPosture.REGULAR;
	ArrayList<Integer> size = new ArrayList<>();
	BorderPane root = new BorderPane();
	VBox sliders = new VBox();
	HBox fontOptions = new HBox();
	Text txt = new Text("JavaFX Programming");
	ComboBox<String> fonts = new ComboBox<>();
	ComboBox<Integer> sizes = new ComboBox<>();
	Slider redSlider = new Slider(0, 255, 0);
	Slider greenSlider = new Slider(0, 255, 0);
	Slider blueSlider = new Slider(0, 255, 0);
	Slider opacitySlider = new Slider(0, 1, 1);
	CheckBox boldCB = new CheckBox("Bold");
	CheckBox italicsCB = new CheckBox("Italics");
	Label r = new Label("R");
	Label g = new Label("G");
	Label b = new Label("B");
	Label o = new Label("O");
	int redValue = 0;
	int greenValue = 0;
	int blueValue = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root, 720, 480);
		primaryStage.setScene(scene);
		primaryStage.show();

		for (int i = 0; i <= 100; i++) {
			size.add(i);
		}
		sizes.setOnAction(new HandlerClass());
		sizes.getItems().addAll(size);
		fonts.getItems().addAll(Font.getFontNames());
		fonts.setOnAction(new HandlerClass());
		sizes.setValue(40);
		txt.setFont(Font.font("Arial", 40));
		root.setLeft(fonts);
		root.setRight(sizes);
		root.setBottom(sliders);
		root.setTop(fontOptions);
		root.setCenter(txt);
		fontOptions.setAlignment(Pos.CENTER);
		sliders.getChildren().addAll(r, redSlider, g, greenSlider, b, blueSlider, o, opacitySlider);
		fontOptions.getChildren().addAll(boldCB, italicsCB);
		fonts.setPrefWidth(150);
		sizes.setPrefWidth(75);
		redSlider.setShowTickMarks(true);
		redSlider.setMajorTickUnit(10);
		redSlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {	
				redValue = newValue.intValue();
				txt.setFill(Color.rgb(redValue, greenValue, blueValue));
			}
		});
		greenSlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {	
				greenValue =  newValue.intValue();
				txt.setFill(Color.rgb(redValue, greenValue, blueValue));
			}
		});
		blueSlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {	
				blueValue = newValue.intValue();
				txt.setFill(Color.rgb(redValue, greenValue, blueValue));
			}
		});
		opacitySlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {	
				txt.setOpacity((double) newValue);
			}
		});
		
		boldCB.setOnAction(new HandlerClass());

		italicsCB.setOnAction(new HandlerClass());
	}

	class HandlerClass implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {

			if (boldCB.isSelected())
				fontWeight = FontWeight.BOLD;
			else
				fontWeight = FontWeight.NORMAL;
			if (italicsCB.isSelected())
				fontPosture = FontPosture.ITALIC;
			else
				fontPosture = FontPosture.REGULAR;

			txt.setFont(Font.font(fonts.getValue(), fontWeight, fontPosture, sizes.getValue()));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
