import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main implements ActionListener {


    // sample client for testing
    public static void main(String[] args) throws IOException {
    	
    	System.out.println("score: " + 12);
    	Scanner readBoi = new Scanner (new File("data.txt"));
    	int hiScore;
    	try {
    		hiScore = readBoi.nextInt();
    		readBoi.close();}
    	catch(Exception e) {
    		readBoi.close();
    		hiScore = 0;
    	}
    			
    	
    	readBoi.close();
    	
        StdDraw.enableDoubleBuffering();
        
        final int screenWidth = 720;
        final int screenHeight = 480;
        final double x0 = screenWidth/2;
        final double y0 = screenHeight/2;
        final double a0 = 90;
        final double size = 10;
        int speed = 150;
        
        
        Snakey bert = new Snakey(x0, y0, a0, size, screenWidth, screenHeight, speed, hiScore); //Initializes/Draws snake turtle object 
        for (int segment = 0; segment <3; segment ++) // Adds 3 segments to snake 
        	bert.addSegment();
        while (bert.collisionCheck()) { // Main Gameloop

        	bert.move();


        	if (bert.leftKeyPress()) //Checking for key inputs to steer Snake
        		bert.turnLeft();
        	if (bert.rightKeyPress())
        		bert.turnRight();
        	if (bert.downKeyPress())
        		bert.turnDown();
        	if (bert.upKeyPress())
        		bert.turnUp();
        }
        
        
        bert.deathScreen(); // Game over message
        if (hiScore < bert.getSegs() -4) {
        	FileWriter writeBoi = new FileWriter("data.txt");
        	writeBoi.write("" + (bert.getSegs()-4));
        	writeBoi.close();}

    }
    
    
    public void keyPressed(KeyEvent e, Snakey snake) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            snake.turnLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            snake.turnRight();
        }
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
   
}
