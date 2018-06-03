import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;
import java.io.*;
import java.util.Scanner;
import javafx.scene.paint.Color;
import javafx.geometry.*;
public class Map extends Pane{
	private int unit=40;
	private int size;
	private int[][] map;
	private Position start;
	Map(String s){
		try{
			Scanner scanner = new Scanner(new File(s));
			size=Integer.parseInt(scanner.next());
			map=new int[size][size];
			int i=0;
			int j=0;
			while(scanner.hasNext()){
				String f=scanner.next();
				map[j][i]=Integer.parseInt(f);
				if(map[j][i]==2){
					start=new Position(j,i);
				}
				j++;

				if(j==size){
					j=0;
					i++;
				}
			}
		}
		catch(FileNotFoundException e){}
		Draw();
	}
	public void Draw(){
		GridPane pane = new GridPane();
		pane.setStyle("-fx-background-color: black; -fx-alignment: center;");
		Rectangle rectangle;
		for(int i=0; i<size;i++){
			for(int j=0;j<size;j++){
				if(map[i][j]==1){
					rectangle = new Rectangle(i*unit,j*unit,unit-1,unit-1);
					rectangle.setFill(Color.BROWN);
					pane.add(rectangle,i,j);
				}
				else{
					rectangle = new Rectangle(i*unit,j*unit,unit-1,unit-1);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);
					pane.add(rectangle,i,j);
				}
			}
		}
		getChildren().add(pane);
	}
	public int[][] getMap(){
		return map;
	}
	public int getSize(){
		return size;
	}
	public int getUnit(){
		return unit;
	}
	public Position getStartPosition(){
		return start;
	}
}