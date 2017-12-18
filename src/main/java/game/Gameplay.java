package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	private boolean play = false;
	private int score = 0;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 320;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private Timer timer;
	private int delay = 8;
	
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();	
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//border
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(690, 0, 3, 592);
		
		//player
		g.setColor(Color.green);
		g.fillRect( playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.YELLOW);
		g.fillOval(ballposX, ballposY, 20, 20);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		
		if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
			ballYdir = -ballYdir;
		}
		
		ballposX += ballXdir;
		ballposY += ballYdir;
		
		if(ballposX < 0) {
			ballposX = 0;
			ballXdir = -ballXdir;
		}
		if(ballposY < 0) {
			ballposY = 0;
			ballYdir = -ballYdir;
		}
		if(ballposX > 670) {
			ballposX = 670;
			ballXdir = -ballXdir;
		}
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <= 10) {
				playerX = 10;
			}else {
				moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 580) {
				playerX = 580;
			}else {
				moveRight();
			}
		}
	}

	private void moveRight() {
		play = true;
		playerX += 15;
	}

	private void moveLeft() {
		play = true;
		playerX -= 15;
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
