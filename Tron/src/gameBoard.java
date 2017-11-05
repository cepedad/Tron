import javax.swing.*;
import java.awt.*;

public class gameBoard {
	JPanel[] panels;
	int mypanels;

	public gameBoard() {
		mypanels = 0;
		JPanel[] panels = new JPanel[0];
	}
	
	public gameBoard(int amount) {
		mypanels = amount;
		JPanel[] panels = new JPanel[mypanels];
		for (int i = 0; i < mypanels; i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(Color.gray);
		}
	}
	
	public JPanel getpanel(int index) {
		return panels[index];
	}
	
	public int getamount() {
		return mypanels;
	}
}
