import javafx.scene.shape.Circle;
public class MyPlayer implements Player{
	private Circle Circle;
	private Map map;
	private Position position;
	private int unit;
	public MyPlayer(Map m){
		map = m;
		unit = map.getUnit();
		position = map.getStartPosition();
		Circle = new Circle(position.getX()*unit+20,position.getY()*unit+20,20);
		map.getChildren().add(Circle);
	}
	@Override
	public Position getPosition(){
		return position;
	}
	@Override
	public void moveRight(){
		if((position.getX()+1<=map.getSize()-1)&&((map.getMap())[position.getX()+1][position.getY()]!=1)){
			map.getChildren().remove(Circle);
			position.setX(position.getX()+1);
			Circle=new Circle(position.getX()*unit+20,position.getY()*unit+20,20);
			map.getChildren().add(Circle);
		}
	}
	@Override
	public void moveLeft(){
		if((position.getX()-1>=0)&&((map.getMap())[position.getX()-1][position.getY()]!=1)){
			map.getChildren().remove(Circle);
			position.setX(position.getX()-1);
			Circle=new Circle(position.getX()*unit+20,position.getY()*unit+20,20);
			map.getChildren().add(Circle);
		}
	}
	@Override
	public void moveUp(){
		if((position.getY()-1>=0)&&((map.getMap())[position.getX()][position.getY()-1]!=1)){
			map.getChildren().remove(Circle);
			position.setY(position.getY()-1);
			Circle=new Circle(position.getX()*unit+20,position.getY()*unit+20,20);
			map.getChildren().add(Circle);
		}
	}
	@Override
	public void moveDown(){
		if((position.getY()+1<=map.getSize()-1)&&((map.getMap())[position.getX()][position.getY()+1]!=1)){
			map.getChildren().remove(Circle);
			position.setY(position.getY()+1);
			Circle=new Circle(position.getX()*unit+20,position.getY()*unit+20,20);
			map.getChildren().add(Circle);
		}
	}
}