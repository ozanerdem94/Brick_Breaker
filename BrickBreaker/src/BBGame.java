
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
import javax.swing.JFrame;

public class BBGame extends JPanel implements KeyListener, ActionListener{

	
	public boolean ply = false;
	public int score = 0;

	public int Bricknmbr = 28;

	public Timer timer;
	public int delay = 8;

	public int plyrX = (int) Math.random();//player is paddle always in x coordinate

	public int bposX = (int) Math.random();//initial x coordinate of ball is random
	public int bposY = (int) Math.random();//initial y coordinate of ball is random

	public int bdirX = -2;//speed of ball in x direction
	public int bdirY = -2;//speed of ball in y direction
	
	public Brickmaker pic;
	

	
	public BBGame() {
		pic = new Brickmaker(4,7);//4 row 7 column
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
			
	}
	
	
	public void paint(Graphics g) {
		
		// background
		g.setColor(Color.BLUE);
		g.fillRect(1, 1, 622, 552);
		
		//mapGenerator
		pic.draw((Graphics2D) g);
		
		
		// borders
		g.setColor(Color.orange);
		g.fillRect(0, 0, 3, 552);
		g.fillRect(0, 0, 622, 3);
		g.fillRect(621, 0, 3, 552);
		
		//score 
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD , 30));
		g.drawString(""+score, 290, 30);
		
		// the paddle
		g.setColor(Color.CYAN);
		g.fillRect(plyrX, 510, 150, 8);
		
		// the ball
		g.setColor(Color.yellow);
		g.fillOval(bposX, bposY, 22, 22);
		
		if (Bricknmbr <= 0&&bdirX==-2&&bdirY==-2) {
			ply = false;
			//bdirX = 0;
			//bdirY = 0;

			g.setColor(Color.GREEN);
			g.setFont(new Font("serif", Font.BOLD , 30));
			g.drawString("Level 1 finished release key 2!", 160, 300);
			
		
			}
		if (Bricknmbr <= 0&&bdirX==-4&&bdirY==-4) {
			ply = false;
			//bdirX = 0;
			//bdirY = 0;

			g.setColor(Color.GREEN);
			g.setFont(new Font("serif", Font.BOLD , 30));
			g.drawString("Level 2 finished release key 3!", 160, 300);
			
		
			}
		if (Bricknmbr <= 0&&bdirX==-6&&bdirY==-6) {
			ply = false;
			//bdirX = 0;
			//bdirY = 0;

			g.setColor(Color.GREEN);
			g.setFont(new Font("serif", Font.BOLD , 30));
			g.drawString("Level 3 finished release key 4!", 260, 300);
			
		
			}
		
		
		if (bposY > 600) {//ball position is less than 600 then below paddle and game over
			ply = false;
			bdirX = 0;
			bdirY = 0;

			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.ITALIC , 40));
			g.drawString("GG , Scores: ", 100, 300);

			g.setFont(new Font("serif", Font.ITALIC , 20));
			g.drawString("Space key to Restart", 250, 370);

		}
		
		g.dispose();
		
	}//paint(Graphics g)
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
		if(ply) {
			
			if(new Rectangle(bposX,bposY,22,22).intersects(new Rectangle(plyrX,510,150,8))) {
				bdirY=-bdirY;
				
			}
			
			A: for(int i =0;i<pic.pic.length;i++) {
				
				for(int j=0; j<pic.pic[0].length;j++) {
					if(pic.pic[i][j]==1) {
						//bricks
						int bX = j*pic.bw+70;
						int bY = i*pic.bh+40;
						int bw = pic.bw;
						int bh = pic.bh;
						//
						Rectangle rect = new Rectangle(bX, bY, bw, bh);//brick
						Rectangle ballrect = new Rectangle(bposX, bposY,22, 22);
						Rectangle brickrect = rect;
						
						
					
						if(ballrect.intersects(brickrect)) {//if ball hits the brick
							pic.setBrickValue(0, i, j);
							Bricknmbr-=1;//total bricks decreased
							score ++;;//score increased
							
							if(bposX+21 <= brickrect.x || bposX+1 >= brickrect.x + brickrect.width) {
								
								bdirX = -bdirX;//opposite x direction
								
							}else {
								bdirY=-bdirY;//opposite y direction
							}
							break A;
							
						}
						
						
						
						
					}
					
				}
				
				
				
			}
			
			
			bposX =bposX + bdirX;
			bposY =bposY + bdirY;
			if(bposX<0) {//if ball hits left wall
				bdirX = -bdirX;
			}
			if(bposY<0) {// if ball hits above wall
				bdirY = -bdirY;
			}
				if(bposX>600) {//if ball hits right wall
					bdirX = -bdirX;
				}
			
			
		}
		
		
		repaint();
		
	}// action Performed end

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {//arrow key left
			if(plyrX<10) {//if at the end of left corner
				plyrX=10;
			}else {
				Left();//invoke function
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {//arrow key right
			if(plyrX>=610) {//if at the end of right corner
				plyrX=610;
			}else {
				Right();//invoke function
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_A) {//A key for left direction and faster paddle
			if(plyrX<10) {//if at the end of left corner
				plyrX=10;
			}else {
				fastPaddleLeft();//invoke function
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {//D key for right direction and faster paddle
			if(plyrX>=610) {//if at the end of right corner
				plyrX=610;
			}else {
				fastPaddleRight();//invoke function
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {// space key for playing again if play is false
			if (!ply) {
				ply = true;
				bposX = (int) Math.random();
				bposY = (int) Math.random();
				bdirX = -4;
				bdirY = -4;
				plyrX = (int) Math.random();
				score = 0;
				Bricknmbr = 28;
				pic = new Brickmaker(4, 7);

				repaint();
			}else if (ply) {//press space for play again
				ply = true;
				bposX = (int) Math.random();
				bposY = (int) Math.random();
				bdirX = -4;
				bdirY = -4;
				plyrX = (int) Math.random();
				score = 0;
				Bricknmbr = 28;
				pic = new Brickmaker(4, 7);

				repaint();
			}
			
		}
	}
	
	
	public void Right() {
		ply = true;
		plyrX+=40;//right movement of paddle
	}

	public void Left() {
		ply=true;
		plyrX	-=40;//left movement of paddle	
				
	}
	public void fastPaddleRight() {
		ply = true;
		plyrX+=80;
	}
	public void fastPaddleLeft() {
		ply=true;
		plyrX	-=80;
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {//for adjusting speed of the ball for other level difficulties
		
		if((e.getKeyCode()==KeyEvent.VK_3)&&Bricknmbr==0&&bdirX==-4&&bdirY==-4) {//for level3 when all bricks gone &level2 finished,release button3
			bdirX=-6;
			bdirY=-6;
		}
		
		if((e.getKeyCode()==KeyEvent.VK_2)&&Bricknmbr==0) {//for level2 when all bricks gone in 1st level, release button2
			bdirX=-4;
			bdirY=-4;
		}
		if((e.getKeyCode()==KeyEvent.VK_4)&&Bricknmbr==0&&bdirX==-6&&bdirY==-6) {//for level4 when all bricks gone &level3 finished,release button4
			bdirX=-8;
			bdirY=-8;
		}
		
	}

}

