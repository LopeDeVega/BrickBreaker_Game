package breaker;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class BrickBreaker extends JPanel implements Runnable, KeyListener, ActionListener {
	
	private static final BrickBreaker ClasePrincipal = null;
	//declaring boolean variables(false)/ it keep the paddle waiting till I press the key
	static boolean right = false;
	static boolean left = false;
	
	
	//balls variables/position on  the screen
	private int ballX = 110;
	private int ballY = 218;
 	
	//balls paddle/position on the screen
	private int batX = 260;
	private int batY = 339;
	
	//bricks variables/ position on the screen
	private int brickX = 70;
	private int brickY = 50;
	
	//move variables
	private int moveX = -1;
	private int moveY = -1;
	
	 private int count = 0;
	
	private Image image;
	private Image image1;

	
	JButton button;
	
	private boolean bricksOver = false;
	private boolean ballFallDown = false;
	
	//string variable
	private String status;
	
	

	//Creating the ball
	Rectangle Ball = new Rectangle(ballX, ballY, 11, 11);
	
	//Creating the paddle
	Rectangle Bat = new Rectangle (batX, batY, 90, 15);
	
	//Creating a array of 12 elements/bricks
	Rectangle[] Brick = new Rectangle[30];
	
	//constructor
	public BrickBreaker() {
		
	
		
	}


	
	public static void main (String[] arg) {
		
		
		System.out.println("Pruebas");
		
		
		//Creating the Frame
		JFrame fr = new JFrame();
		
		BrickBreaker game = new BrickBreaker();
		//creating a button
		JButton button = new JButton(" Restart ");
		JButton button2 = new JButton(" Close the Game ");
		
		
		
		//Frame's features 
		fr.setSize(502,640);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.setTitle(" Brick Breaker ");
		
		
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.add(game);
			
				//emplacing the button.
				fr.add(button, BorderLayout.SOUTH);
				
				
		//adding a Thread		
		Thread G = new Thread(game);
			G.start();
		
		//Adding KeyListener
		game.addKeyListener(game);
		
		game.setFocusable(true);
		
		//making the button works
		button.addActionListener(game);
		
		
		
		

		        	
		}
		
	
	
	public void paint (Graphics g) {
		
		
		//background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500,355);
		
		//ball color
		g.setColor(Color.yellow);
		g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
		
		//score
		g.setColor(Color.WHITE);
		g.setFont(new Font("Broadway", Font.BOLD, 28));
		g.drawString("Score " + count, 200, 30);
	
		
				
		//creating the paddle
		g.setColor(Color.GREEN);
		g.fill3DRect(Bat.x, Bat.y, Bat.width, Bat.height, true);
		
		//blue area
		g.setColor(Color.ORANGE);
		g.fillRect(0, 355, 550, 330);
		
		//setting the text
		g.setColor(Color.BLACK);
		g.setFont(new Font("Broadway", Font.BOLD, 35));
		g.drawString("ATARI GAMES", 30, 430 );
		
		//setting the text
		g.setColor(Color.BLUE);
		g.setFont(new Font("Broadway", Font.BOLD, 35));
		g.drawString(" Brick Breaker ", 180, 470 );
		
		//border
		g.setColor(Color.RED);
		g.drawRect(0, 0, 495, 354);
		
				
		//creating the 12 bricks
		for(int i = 0; i < Brick.length; ++i) {
			
			
			if(Brick[i] !=null) {
				
				g.fill3DRect(Brick[i].x, Brick[i].y, Brick[i].width, Brick[i].height, true);
			}
			
		}
		
		
		
		//it print the status(GAME OVER)/using this font/in that position.
		//also print on the screen YOU WIN (bricksOver)
		if (ballFallDown == true || bricksOver == true) {
			
			Font f = new Font("Elephant", Font.BOLD, 20);
			g.setFont(f);
			g.setColor(Color.MAGENTA);
			g.drawString(status, 170 ,200);
			
			ballFallDown = false;
			
			
		}
		
	
	}
	
	
	

	
	public void run() {
		//it sets the brick 
		for (int i = 0; i < Brick.length; ++i ) {
			
			
			Brick[i] = new Rectangle(brickX, brickY, 30, 10);
						
				//if to set the bricks on the screen
				if(i==10) {
					
					brickX =141;
					brickY = 79;
					
				}

				if(i==15) {
					
					brickX = 180;
					brickY = 110;
				}
				
				
				if(i==15) {
				
				brickX = 0;
				brickY = 90;
			}
		
				//separation between bricks 31 pixels 
				brickX +=31;

		
		}
		
		//moving the ball
		while(true) {
				
				//when ball hit the bricks
				for(int i = 0; i<Brick.length; ++i) {
					
					if(Brick[i] != null) {
						
						if(Brick[i].intersects(Ball)) {
							
							Brick[i] = null;
							//send the ball away in another direction
							moveY = -moveY;
							
							count+=5;
							
						}
					}
				}
			
				//print the message when user get that score
			if(count == 150) {
				
				
				bricksOver = true;
				
				status = " YOU WIN!!!!! ";
				
				
				
				
				repaint ();
				
			}
				
			//refresh the screen/if not the screen it not moving
			repaint();
			
			//moving the ball
			Ball.x += moveX;
			Ball.y += moveY;
			
				
				//ball rebound the walls (X side)
					if(Ball.x <= 0 || Ball.x + Ball.height >= 495) {
						
						moveX = -moveX;
					}
					//ball rebound the walls (X side)
					if(Ball.y <= 0 ) {
						
						moveY = -moveY;
					}
					
					//when the wall pass the down bound 
					if(Ball.y >=360) {
						
						ballFallDown = true;
							
							status = " GAME OVER ";
							
				
							
							repaint();
						
					}
			
			//Giving the paddle right and left movements 
			if(left == true) {
					
				//Paddles's speed
				Bat.x -=3;
				right = false;
			}
			
			if(right == true) {
				
				//paddles speed 
				Bat.x +=3;
				left = false;
			}
			
			
			//Keeping the paddle into the bounds
			//left bound
			if(Bat.x <= 4) {
				
				Bat.x = 4;
				
				
				//right bound
			}else if(Bat.x >= 415) {
				
				Bat.x = 415;
			}
			
			//reflexion  the ball when it touch the paddle
			if(Ball.intersects(Bat)) {
				
				moveY = -moveY;
				
			}
			
			
			try {
				
				
				Thread.sleep(10);
				
			}catch(Exception e) {
				
				
			}
		}
		
		
		
	}



	//move the paddle// setting the Keys for the paddle
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
			//code for left move 
			if (keyCode == KeyEvent.VK_LEFT) {
				
				left = true;
			}
			
			if (keyCode == KeyEvent.VK_RIGHT) {
				
				right = true;
			}
			
			
					
	}
				
			
	
	public void keyReleased(KeyEvent e) {
		
		//stop the paddle movements when I release the key
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT) {
			
			left = false;
		}
		
		
		if (keyCode == KeyEvent.VK_RIGHT) {
			
			right = false;
		}
		
		
	}




	public void keyTyped(KeyEvent e) {
		
		
	}




	public void actionPerformed(ActionEvent e) {

		
		 //To restart the game again 
 	   ClasePrincipal.main (null); 
 	   
 	  
		
	}
	
	
}


	

	


