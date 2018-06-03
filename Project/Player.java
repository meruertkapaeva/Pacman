public interface Player{
	public Position getPosition();
	public void feed(Food food);
	public void moveRight();
	public void moveLeft();
	public void moveDown();
	public void moveUp();
}