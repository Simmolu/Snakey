public class Snakey {
	
	
	private int segments;
	private Turtle[] snakeSegs;
	private Turtle head;
	private Turtle tail;
	private int turtlespeed;
	private Turtle food;
	private double screenwidth;
	private double screenheight;
	private Turtle scoreboard;
	private int highscore;
	// private Turtle background;

	public Snakey(double x0, double y0, double a0, double turtleSize, int width, int height, int speed, int highScore) {
		segments = 1;
		screenwidth = x0*2;
		screenheight = y0*2;
		head = new Turtle(x0, y0, a0, turtleSize);
		tail = head;
		snakeSegs = new Turtle [100];
		snakeSegs[0] = head;
		head.ScreenTitle("Snake");
		head.setCanvasSize(width, height);
        head.setXscale (0, width);
        head.setYscale(0, height);
        turtlespeed = speed;
        head.drawBody();
        head.show();
        highscore = highScore;
        
        
        Turtle foods = new Turtle (generateRandom(x0), generateRandom(y0), 180, 10);
        this.food = foods;
        food.setColor(255, 0, 0);
        food.drawBody();
        food.show();
        
        scoreboard = new Turtle(620.0, 380.0, 180.0, turtleSize);
        scoreboard.drawText(620, 380, "HIGHSCORE: " + highscore);
        scoreboard.show();
        
		/*
		 * Turtle back = new Turtle (x0, y0, a0, turtleSize); background = back;
		 * 
		 * background.drawPic("background.jpg");
		 */
        
	} 
	
	public boolean collisionCheck() {
		
		boolean check = true;
		double headX = head.getXPos();
		double headY = head.getYPos();
		double foodX = food.getXPos();
		double foodY = food.getYPos();
		
		if (headX == 0)
			return check = false;
		else if (headX == this.screenwidth)
			return check = false;
		else if (headY == this.screenheight)
			return check = false;
		else if (headY == 0)
			return check = false;
		
	
		if (this.segments == 1)
			return check;
		
		if ((Math.sqrt(Math.pow(headX-foodX, 2) + Math.pow(headY-foodY, 2))) < 15) {
			eaten(this.screenwidth, this.screenheight);
			addSegment();
			System.out.println("omnom");
			}
			
		
		
		for (int i = 1; i < segments; i++) {
			
			Turtle currentSeg = snakeSegs[i];
			double segX = currentSeg.getXPos();
			double segY = currentSeg.getYPos();
			
			
			if ((Math.sqrt(Math.pow(headX-segX, 2) + Math.pow(headY-segY, 2))) < 7)
				check = false;
		}
		
		return check;
		
	}
	
	
	
	public void move() {
		head.clearScreen();
		double oldX = head.getXPos();
		double oldY = head.getYPos();
			
		for (int i = 0; i<segments; i ++) {
			if (i == 0) {
				head.moveTurtleForward(i);
				head.drawBody();
				//head.show();
				continue;
			}
			
			Turtle currentSneg = snakeSegs[i];
			double tempX = currentSneg.getXPos();
			double tempY = currentSneg.getYPos();
			currentSneg.placeTurtle(oldX, oldY);
        	currentSneg.drawBody();
        	oldX = tempX;
        	oldY = tempY;
		}
		food.drawBody();
		scoreboard.drawText(620, 380, "HIGHSCORE: " + highscore);
		head.show();
		head.pause(turtlespeed);
	}
	
	public void turnUp() {
		head.setAngle(90);
	}
	
	public void turnRight() {
		head.setAngle(0);
	}
	public void turnLeft() {
		head.setAngle(180);
	}
	
	public void turnDown() {
		head.setAngle(270);
	}
	
	public void addSegment() {
		this.segments += 1;
		int angle = (int)tail.getDirection();
		double xPos = tail.getXPos();
		double yPos = tail.getYPos();
		double size = tail.getSize();
		
		double newXPos = 0;
		double newYPos = 0;
		
		switch (angle){
			case(90):{
				newXPos = xPos;
				newYPos = yPos - 2*size;break;}
			case(0): {
				newYPos = yPos;
				newXPos = xPos - 2*size;break;}
			case(180): {
				newYPos = yPos;
				newXPos = xPos + 2*size;break;}
			case(270): {
				newXPos = xPos;
				newYPos = yPos + 2*size;break;}
		}
		
		Turtle segment = new Turtle (newXPos, newYPos, angle, size);
		this.tail = segment;
		snakeSegs [segments-1] = segment;
	}
	
	
	public boolean mousePress() {
		return StdDraw.isMousePressed();
	}
	
	public boolean leftKeyPress() {
		return StdDraw.isKeyPressed(65);
	}
	public boolean rightKeyPress() {
		return StdDraw.isKeyPressed(68);
	}
	
	public boolean upKeyPress() {
		return StdDraw.isKeyPressed(87);
	}
	
	public boolean downKeyPress() {
		return StdDraw.isKeyPressed(83);
	}
	
	public void getHeadCoords() {
		double xPos = head.getXPos();
		double yPos = head.getYPos();
		System.out.println(xPos + "," + yPos);
	}
	
	public int getSegs() {
		return this.segments;
	}
	
	public double generateRandom (double value) {
		double randVal = Math.ceil(Math.random()*value);
		if (value-randVal < 100)
			randVal -= 150;
		return randVal;
	}
	
	public void eaten(double x, double y) {
		food.clearScreen();
		double newXpos = generateRandom(x);
		double newYpos = generateRandom(y);
		food.placeTurtle(newXpos, newYpos);
		food.drawBody();
		food.show();
		
	}
	
	public void deathScreen() {
		head.clearScreen();
		String finalScore = ("GAME OVER.\n FINAL SCORE: " + (this.segments -4));
		head.drawText((int)this.screenwidth/2, (int)this.screenheight/2, finalScore);
		head.show();
	}

}
