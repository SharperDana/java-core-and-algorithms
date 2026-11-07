package GameEx_Final;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
/**
 * This class represents a 2D circle in the plane.
 */
public class Circle implements GeoShape {

	private int x, y, Dx, Dy, radius, color[];

	public Circle(int x, int y, int radius, int r, int g, int b) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = new int[3];
		this.color[0] = r;
		this.color[1] = g;
		this.color[2] = b;
	}
	
	@Override
	public void draw(Graphics g, Component c) {
			g.setColor(new Color( getRed(), getGreen(), getBlue()));
			g.fillOval(getX(), getY(), getRadius(), getRadius());
			g.setColor(new Color(0,0,0));
			g.drawOval(getX(), getY(), getRadius(), getRadius());
		
	}

	@Override
	public int getRed() {
		return this.color[0];
	}

	@Override
	public int getGreen() {
		return this.color[1];
	}

	@Override
	public int getBlue() {package GameEx_Final;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

/**
 * This class represents a 2D circle in the plane, implementing the GeoShape interface.
 * Supports rendering, movement translation, and collision detection (intersection).
 */
public class Circle implements GeoShape {

	private int x, y;
	private int dx, dy;
	private int radius;
	private int[] color;

	/**
	 * Constructs a Circle with specified position, radius, and RGB color.
	 * 
	 * @param x - X coordinate of the circle.
	 * @param y - Y coordinate of the circle.
	 * @param radius - radius (bounding size) of the circle.
	 * @param r - Red color component (0-255).
	 * @param g - Green color component (0-255).
	 * @param b - Blue color component (0-255).
	 */
	public Circle(int x, int y, int radius, int r, int g, int b) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = new int[] { r, g, b };
	}

	@Override
	public void draw(Graphics g, Component c) {
		g.setColor(new Color(getRed(), getGreen(), getBlue()));
		g.fillOval(getX(), getY(), getRadius(), getRadius());
		g.setColor(Color.BLACK);
		g.drawOval(getX(), getY(), getRadius(), getRadius());
	}

	@Override
	public int getRed() {
		return this.color[0];
	}

	@Override
	public int getGreen() {
		return this.color[1];
	}

	@Override
	public int getBlue() {
		return this.color[2];
	}

	@Override
	public void setColor(int r, int g, int b) {
		this.color[0] = r;
		this.color[1] = g;
		this.color[2] = b;
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public void translateX() {
		this.x += this.dx;
	}

	@Override
	public void translateY() {
		this.y += this.dy;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getDx() {
		return this.dx;
	}

	@Override
	public void setDx(int dx) {
		this.dx = dx;
	}

	@Override
	public int getDy() {
		return this.dy;
	}

	@Override
	public void setDy(int dy) {
		this.dy = dy;
	}

	/**
	 * Checks if this circle intersects with another geometric shape (Circle or Rectangle).
	 * 
	 * @param g - the other GeoShape to check collision against.
	 * @return true if the shapes intersect, false otherwise.
	 */
	@Override
	public boolean intersects(GeoShape g) {
		if (g instanceof Circle) {
			Circle c = (Circle) g;
			int deltaX = c.getX() - this.x;
			int deltaY = c.getY() - this.y;
			int radiusSum = c.getRadius() + this.radius;

			// Using squared distance to avoid expensive Math.sqrt() calculation
			return (deltaX * deltaX + deltaY * deltaY) < (radiusSum * radiusSum);
		} else if (g instanceof Rectangle) {
			Rectangle r = (Rectangle) g;
			boolean overlapX = (r.getX() <= this.x + this.radius) && (this.x - this.radius <= r.getX() + r.getWidth());
			boolean overlapY = (r.getY() <= this.y + this.radius) && (this.y - this.radius <= r.getY() + r.getHeight());
			return overlapX && overlapY;
		}
		return false;
	}
}