
import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.scene.shape.Circle;
import java.util.ArrayList;


public class BotPlayer implements Player{
	public Map map ;
	public Position position;
	public Circle ball;
	public int unit;
	public int x,y;
	public Food food;
	public BotPlayer(Map map){
		this.map = map;
		this.unit = map.getUnit();
		this.position = map.getStartPosition();
		this.ball = new Circle(position.getX()*unit+unit / 2,position.getY()*unit+unit/2, unit/2);
		this.map.getChildren().add(ball);
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run(){
					try{
						Thread.sleep(100);
						}
					catch(InterruptedException e){	
						}
					x=food.getPosition().getX();
					y=food.getPosition().getY();
					ArrayList<Integer> al = new ArrayList<>();
					for(int i = 0;i<=map.getSize()-1;i++){
						int x =0;
						while(x!=map.getSize()-1){
							al.add(0);//Right
							x++;
							if(x==map.getSize()-1)
								al.add(1);//Down
							}
							int y=map.getSize()-1;
							while(y!=0){
								al.add(2);//Left
								y--;
								if(y==0)
									al.add(1);
							}
						}
						for(int i:al){
						Platform.runLater(new Runnable(){
							@Override
							public void run(){
							if(i==0 && !position.equals(new Position(x,y))){
								moveRight();
							}
							else if(i==1&&!position.equals(new Position(x,y))){
								moveDown();
							}
							else if(i==2&&!position.equals(new Position(x,y))){
								moveLeft();
							}
							}
						});
						try{
							Thread.sleep(100);
							}
						catch(InterruptedException e){}
				}
			}
		});
		Thread thread1 = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){}
				while(true){
					int x = food.getPosition().getX();
					int y = food.getPosition().getY();
					int x1 = position.getX();
					int y1 = position.getY();
					ArrayList<Integer> al = new ArrayList<>();
					if(position.getX()>x){
						while(x!=x1){
							al.add(1);
							x1--;//0 Right 1 Left 2 Down 3 Up
						}
					}
					else if(position.getX()<x){
						while(x!=x1){
							al.add(0);
							x1++;//0 Right 1 Left 2 Down 3 Up
						}
					}
					else if(position.getY()>y){
						while(y!=y1){
							al.add(3);
							y1--;//0 Right 1 Left 2 Down 3 Up
						}
					}
					else if(position.getY()<y){
						while(y!=y1){
							al.add(2);
							y1++;//0 Right 1 Left 2 Down 3 Up
						}
					}
					for(int i : al){
					Platform.runLater(new Runnable(){
						public void run(){
							
								if(i==0)
									moveRight();
								else if(i==1)
									moveLeft();
								else if(i==2)
									moveDown();
								else if(i==3)
									moveUp();
							
						}
					});
					try{
						Thread.sleep(30);
					}catch(Exception e){}
					}
				}
			}
		});
		thread1.start();//Set scene if thread.start() Snake if thread1.start Algorithm
	}
	@Override
	public Position getPosition(){
		return position;
	}
	@Override
	public void moveRight(){
		if((position.getX()+1<=map.getSize()-1)&&((map.getMap())[position.getX()+1][position.getY()]!=1)){
            ball.setCenterX(ball.getCenterX() + map.getUnit());
            position.setX(position.getX() + 1);
		}
	}
	@Override
	public void moveLeft(){
		if((position.getX()-1>=0)&&((map.getMap())[position.getX()-1][position.getY()]!=1)){
            ball.setCenterX(ball.getCenterX() - map.getUnit());
            position.setX(position.getX() - 1);
		}
	}
	@Override
	public void feed(Food food){
		this.food=food;
	}
	@Override
	public void moveUp(){
		if((position.getY()-1>=0)&&((map.getMap())[position.getX()][position.getY()-1]!=1)){
            ball.setCenterY(ball.getCenterY() - map.getUnit());
            position.setY(position.getY() - 1);
		}
	}
	@Override
	public void moveDown(){
		if((position.getY()+1<=map.getSize()-1)&&((map.getMap())[position.getX()][position.getY()+1]!=1)){
			ball.setCenterY(ball.getCenterY() + map.getUnit());
            position.setY(position.getY() + 1);
		}
	}
}