package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 120;
	private int ballPosY = 320;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	public Gameplay() {
		map = new MapGenerator(3, 7);
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
		
		//bricks
		map.draw((Graphics2D) g);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//Score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);
		
		if(totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("YOU WON, Score: " + score, 200, 300);
			g.drawString("press Enter to restart", 200, 350);
		}
		
		if(ballPosY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("YOU DIED, Score: " + score, 200, 300);
			g.drawString("press Enter to restart", 200, 350);
		}
		
		//pedal
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		g.setColor(Color.yellow);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	} 
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		
		if(play) {
			if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 80))) {
				ballYdir = -ballYdir;
			}
			
			for(int i = 0; i < map.map.length; i++) {
				for(int j = 0; j < map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
					
						Rectangle brick = new Rectangle(j * map.brickWidth +80, 
														i * map.brickHeight + 50, 
														map.brickWidth, map.brickHeight);
						Rectangle ball = new Rectangle(ballPosX, ballPosY, 20, 20);
						if(ball.intersects(brick)) {
							map.setValue(0, i, j);
							totalBricks--;
							score += 5;
							
							if(ballPosX + 19 <= brick.x || ballPosX + 1 >= brick.x + brick.width ) {
								ballXdir = -ballXdir;
							}else {
								ballYdir = -ballYdir;
							}
							
						}
					}
				}
			}
			
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			
			if(ballPosX < 0){
				ballXdir = -ballXdir;
			}
			if(ballPosY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballPosX > 670) {
				ballXdir = -ballXdir;
			}
			
		}
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}else {
				moveLeft();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				ballPosX = 120;
				ballPosY = 320;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;
				totalBricks = 21;
				map = new MapGenerator(3, 7);
				
				repaint();
			}
		}

	}

	private void moveLeft() {
		play = true;
		playerX -= 20;
	}



	private void moveRight() {
		play = true;
		playerX += 20;
	}



	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}

}
