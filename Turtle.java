
import java.awt.Color;

public class Turtle {
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis
    private double size;

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0, double turtleSize) {
        x = x0;
        y = y0;
        angle = a0;
        size = turtleSize;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }
    
    public void drawBody() {
    	StdDraw.filledSquare(this.x, this.y, this.size);
    }
    
    public void moveTurtleForward(int speed) {
    	double step = this.size*2;
    	if (angle == 90)
    		this.y += step;
    	else if (angle == 0)
    		this.x += step;
    	else if (angle == 180)
    		this.x -= step;
    	else if (angle == 270)
    		this.y -= step;
    	StdDraw.pause(speed);
    }
    
    
    public void placeTurtle(double xPos, double yPos) {
    	
    	this.x = xPos;
    	this.y = yPos;
    	
    }

    // copy to onscreen
    public void show() {
        StdDraw.show();
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.pause(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }
    
    public void setAngle(double angle) {
    	this.angle = angle;
    }
    
    public double getXPos () {
    	return this.x;
    }
    
    public double getYPos () {
    	return this.y;
    }
    
    public double getDirection() {
    	return this.angle;
    }
    
    public double getSize() {
    	return this.size;
    }
    
    
    public void clearScreen() {
    	StdDraw.clear();
    }
    
    public void ScreenTitle(String title) {
    	StdDraw.setTitle(title);
    }
    
    public void setColor(int red, int green, int blue) {
    	StdDraw.setPenColor(red, green, blue);
    }

    
    public void drawText(int xPos, int yPos, String text) {
    	StdDraw.text(xPos, yPos, text);
    }
    
    public void drawPic(String file) {
    	StdDraw.picture(x, y, file);
    }
}