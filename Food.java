
public class Food {

	private int screenWidth;
	private int screenHeight;
	private Turtle body;
	
	public Food(int screenWidths, int screenHeights) {
		
		this.screenWidth = screenWidths;
		this.screenHeight = screenHeights;
		
		double randX = generateRandom(screenWidth);
		double randY = generateRandom(screenHeight);
		Turtle food = new Turtle(randX, randY, 180, 5);
		this.body = food;
		food.setColor(255, 0, 0);
		food.drawBody();
		food.show();
		
		
	}
	
	
	

	
	
	
	public double generateRandom (int value) {
		double randVal = Math.ceil(Math.random()*value);
		if (randVal == value)
			randVal -= 50;
		return randVal;
	}

}
