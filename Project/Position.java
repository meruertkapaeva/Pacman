public class Position{
	private int x;
	private int y;
	Position(int x1,int y1){
		x = x1;
		y = y1;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x1){
		x = x1;
	}
	public void setY(int y1){
		y = y1;
	}
	public boolean equals(Position p){
		if(x == p.getX() && y ==p.getY())
			return true;
		return false;
	}
}