import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel{
	int myindex;
	
	public Player(int myi){
		myindex = myi;
	}
	
	public void setIndex(int myi) {
		myindex = myi;
	}
	
	public int getindex() {
		return myindex;
	}
	
	public int move(int direction) {
		if (direction == 1) {
			myindex -= 50;
		} else if (direction == -1) {
			myindex += 50;
		} else if (direction == -2) {
			myindex -= 1;
		} else if (direction == 2) {
			myindex += 1;
		}
		return myindex;
	}
	
	public int moveup() {
		return 1;
	}
	
	public int movedown() {
		return -1;	
	}
	
	public int moveleft() {
		return -2;
	}
	
	public int moveright() {
		return 2;
	}
	
	public boolean checkCollision() {
		int a = 1;
		return  a <= 1;
	}
	
	public void setindex(int index) {
		myindex = index;
	}
}
