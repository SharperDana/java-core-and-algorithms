package GameEx_Final;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

/**
 * This class represents a 2D axis-parallel rectangle in the plane, implementing the GeoShape interface.
 * Supports rendering, movement translation, and AABB collision detection.
 */
public class Rectangle implements GeoShape {

	private int x, y;
	private int dx, dy;
	private int width, height;
	private int[] color;

	/**
	 * Constructs a Rectangle with specified position, dimensions, and RGB color.
	 * 
	 * @param x - X coordinate of the upper-left corner.
	 * @param y - Y coordinate of the upper-left corner.
	 * @param width - width of the rectangle.
	 * @param height - height of the rectangle.
	 * @param r - Red color component (0-255).
	 * @param g - Green color component (0-255).
	 * @param b - Blue color component (0-255).
	 */
	public Rectangle(int x, int y, int width, int height, int r, int g, int b) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = new int[] { r, g, b };
	}

	@Override
	public void draw(Graphics g, Component c) {
		g.setColor(new Color(getRed(), getGreen(), getBlue()));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void setColor(int r, int g, int b) {
		this.color[0] = r;
		this.color[1] = g;
		this.color[2] = b;
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

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
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
	 * Checks if this rectangle intersects with another geometric shape (Circle or Rectangle)
	 * using Axis-Aligned Bounding Box (AABB) collision detection.
	 * 
	 * @param g - the other GeoShape to check collision against.
	 * @return true if the shapes intersect, false otherwise.
	 */
	@Override
	public boolean intersects(GeoShape g) {
		if (g instanceof Circle) {
			Circle c = (Circle) g;
			boolean overlapX = (this.x <= c.getX() + c.getRadius()) && (c.getX() - c.getRadius() <= this.x + this.width);
			boolean overlapY = (this.y <= c.getY() + c.getRadius()) && (c.getY() - c.getRadius() <= this.y + this.height);
			return overlapX && overlapY;
		} else if (g instanceof Rectangle) {
			Rectangle r = (Rectangle) g;
			boolean overlapX = (this.x <= r.getX() + r.getWidth()) && (r.getX() <= this.x + this.width);
			boolean overlapY = (this.y <= r.getY() + r.getHeight()) && (r.getY() <= this.y + this.height);
			return overlapX && overlapY;
		}
		return false;
	}
}