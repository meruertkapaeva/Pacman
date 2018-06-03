import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;
public class Game extends Application {
	private static String[] arguments;
	public void start(Stage stage)throws Exception{
		Map map=new Map(arguments[0]);
		BotPlayer myPlayer=new BotPlayer(map);
		Food food=new Food(map,myPlayer);
			myPlayer.feed(food);
		Pane pane=new Pane();
		pane.setOnKeyPressed(e->{
				switch(e.getCode()){
					case DOWN:myPlayer.moveDown();break;
					case RIGHT:myPlayer.moveRight();break;
					case LEFT:myPlayer.moveLeft();break;
					case UP:myPlayer.moveUp();break;
				}
		});
		pane.getChildren().add(map);
	String music = "C:\\Users\\Acer\\Desktop\\pacman.mp3";
	Media m = new Media(new File(music).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer (m);
	mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	mediaPlayer.play();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
		pane.requestFocus();
    }
	public static void main(String[] args){
		arguments=args;
		launch(args);
	}
	
}