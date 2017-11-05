import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game{
//--------------------------------------------------------------------------------------------
	static int d1 = 0;
	static int d2 = 0;
	static int score1 = 0;
	static int score2 = 0;
	static Timer timer = new Timer(50, null);
	static int ans;
	static int newindex;
	static int newindex2;
	static int oldindex = 0;
	static int oldindex2 = 0;
	static URL url;
//--------------------------------------------------------------------------------------------
	public static void main(String[] args) throws MalformedURLException{
		
			JFrame theGame = new JFrame();
			theGame.setTitle("Tron");
			theGame.setSize(1000,1000);
			theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ans = 0;
			timer.start();
			
			Random rand = new Random();
			int randcheck;
			randcheck = rand.nextInt(2499);
			int nextrand = rand.nextInt(2499);
			while(nextrand == randcheck) {
				nextrand = rand.nextInt(2499);
			}
//---------------------------------------------------------------------------------------------------------
			JPanel[] panels = new JPanel[2500];
			for (int i = 0; i < 2500; i++) {
				panels[i] = new JPanel();
			}
			
			for (int i = 0; i < 2500; i++) {
				panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
				int randpower = rand.nextInt(1000);
				if (i == randcheck) {
					panels[i].setBackground(Color.blue);
				} else if (i == nextrand) {
					panels[i].setBackground(Color.yellow);
				} else if (randpower <= 1) {
					panels[i].setBackground(Color.green);	
					}
				else {
					panels[i].setBackground(Color.gray);
				}
			}
			
			for (int i = 0; i < 2500; i++) {
				if (i >= 0 && i <= 50) {
					panels[i].setBackground(Color.black);
				} else if (i >= 2451 && i < 2500) {
					panels[i].setBackground(Color.black);
				} else if (i % 50 == 0) {
					panels[i].setBackground(Color.black);
				} else if (i % 50 == 49) {
					panels[i].setBackground(Color.black);
				}
			}
			
			GridLayout gl = new GridLayout(50,50);
					
			Container pane = theGame.getContentPane();
			for (int i = 0; i < 2500; i++) {
				pane.add(panels[i]);
			}
			
			Player one = new Player(randcheck);
			Player two = new Player(nextrand);
			
			pane.setLayout(gl);
			theGame.setVisible(true);
//---------------------------------------------------------------------------------------------------------
			timer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int winner;
					int cflag = 0;
					newindex = one.move(d1);
					newindex2 = two.move(d2);
					switch(d1) {
					case 1:
						oldindex = newindex + 50;
						break;
					case -1:
						oldindex = newindex - 50;
						break;
					case 2:
						oldindex = newindex - 1;
						break;
					case -2: 
						oldindex = newindex + 1;
						break;
					}
					switch(d2) {
					case 1:
						oldindex2 = newindex2 + 50;
						break;
					case -1:
						oldindex2 = newindex2 - 50;
						break;
					case 2:
						oldindex2 = newindex2 - 1;
						break;
					case -2: 
						oldindex2 = newindex2 + 1;
						break;
					}
					
					if (panels[newindex].getBackground() == Color.red || panels[newindex].getBackground() == Color.cyan || panels[newindex].getBackground() == Color.black) {
						winner = 1;
						cflag = 1;
						endGame(winner);
					} else if (panels[newindex2].getBackground() == Color.cyan || panels[newindex2].getBackground() == Color.red || panels[newindex2].getBackground() == Color.black) {
						winner = 2;
						cflag = 1;
						endGame(winner);
					} else if (panels[newindex].getBackground() == Color.yellow) {
						winner = 3;
						cflag = 1;
						endGame(winner);
					}
					
					if (panels[newindex].getBackground() == Color.green) {
						for (int i = 0; i <= 2499; i++) {
							if (panels[i].getBackground() == Color.RED) {
								panels[i].setBackground(Color.gray);
							}
						}
					}
					
					if (panels[newindex2].getBackground() == Color.green) {
						for (int i = 0; i <= 2499; i++) {
							if (panels[i].getBackground() == Color.cyan) {
								panels[i].setBackground(Color.GRAY);
							}
						}
					}
					
					panels[newindex].setBackground(Color.blue);
					panels[newindex2].setBackground(Color.yellow);
					panels[oldindex].setBackground(Color.cyan);
					panels[oldindex2].setBackground(Color.red);
					if (cflag == 1) {
						panels[oldindex].setBackground(Color.gray);
						panels[oldindex2].setBackground(Color.gray);
					}
				}
//---------------------------------------------------------------------------------------------------------
				public void endGame(int wincode) {
					if (wincode == 1) {
						score2++;
						JLabel label = new JLabel("Yellow wins!   " + score1 + " - " + score2);
						label.setFont(new Font("Arial", Font.BOLD, 28));
						JOptionPane.showMessageDialog(null,label,"Game!",JOptionPane.DEFAULT_OPTION);
					}
					else if (wincode == 2) {
						score1++;
						JLabel label = new JLabel("Blue wins!   " + score1 + " - " + score2);
						label.setFont(new Font("Arial", Font.BOLD, 28));
						JOptionPane.showMessageDialog(null,label,"Game!",JOptionPane.DEFAULT_OPTION);
					} else if (wincode == 3) {
						JLabel label = new JLabel("Tie!!!!");
						label.setFont(new Font("Arial", Font.BOLD, 28));
						JOptionPane.showMessageDialog(null,label,"Game!",JOptionPane.DEFAULT_OPTION);
					}
					String strans;
					JLabel label = new JLabel("Do you want to play again? (1 = y, 0 = n)");
					label.setFont(new Font("Arial", Font.BOLD, 28));
					ans = JOptionPane.showConfirmDialog(null, "Want to play again?", "Replay", JOptionPane.YES_NO_OPTION);
					if (ans == 0) {
						d1 = 0;
						d2 = 0;
						
						panels[oldindex].setBackground(Color.gray);
						
						int randc = 0;
						randc = rand.nextInt(2499);
						int nextr = rand.nextInt(2499);
						while(nextr == randc) {
							nextr = rand.nextInt(2499);
						}
							
						for (int i = 0; i < 2500; i++) {
							int randpower = rand.nextInt(1000);
							if (i == randc) {
								panels[i].setBackground(Color.black);
								newindex = i;
								one.setindex(i);
							} else if (i == nextr) {
								panels[i].setBackground(Color.yellow);
								newindex2 = i;
								two.setindex(i);
							} else if (randpower <= 1) {
								panels[i].setBackground(Color.green);	
								}
							else {
								panels[i].setBackground(Color.gray);
							}
						}
						
						for (int i = 0; i < 2500; i++) {
							if (i >= 0 && i <= 50) {
								panels[i].setBackground(Color.black);
							} else if (i >= 2451 && i < 2500) {
								panels[i].setBackground(Color.black);
							} else if (i % 50 == 0) {
								panels[i].setBackground(Color.black);
							} else if (i % 50 == 49) {
								panels[i].setBackground(Color.black);
							}
						}
					} else {
						theGame.dispose();
						timer.stop();
					}
				}
			});
//---------------------------------------------------------------------------------------------------------

			theGame.addKeyListener(new KeyListener() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					int keycode = e.getKeyCode();
					
					if (keycode == KeyEvent.VK_UP) {
						d1 = one.moveup();
					} else if (keycode == KeyEvent.VK_DOWN) {
						d1 = one.movedown();
					} else if (keycode == KeyEvent.VK_LEFT) {
						d1 = one.moveleft();
					} else if (keycode == KeyEvent.VK_RIGHT) {
						d1 = one.moveright();
					}
					
					if (keycode == KeyEvent.VK_W) {
						d2 = two.moveup();
					} else if (keycode == KeyEvent.VK_S) {
						d2 = two.movedown();
					} else if (keycode == KeyEvent.VK_A) {
						d2 = two.moveleft();
					} else if (keycode == KeyEvent.VK_D) {
						d2 = two.moveright();
					}
				}
	
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
	
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
					
			});	
	}
}
