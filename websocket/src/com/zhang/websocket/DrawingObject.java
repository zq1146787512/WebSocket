package com.zhang.websocket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;


public class DrawingObject {
	private static String MESSAGE_NAME="DrawingObject";
	private Shape shape;	
	private Point center;
	private  int radius=0;
	private Color color;
	
	public DrawingObject(Shape shape,Point center,int radius,Color color){
		this.center=center;
		this.color=color;
		this.radius=radius;
		this.shape=shape;
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw(Graphics g){
		g.setColor(this.color);
		switch (shape) {
		case CIRCLE:
			g.fillOval(center.x-radius,center.y-radius, 2*radius, 2*radius);
			break;
			
        case PENTAGON:
        	Polygon triangle=new Polygon();
        	triangle.addPoint(center.x, center.y-radius);
        	triangle.addPoint(center.x+radius, center.y+radius);
        	triangle.addPoint(center.x-radius, center.y+radius);
			g.fillPolygon(triangle);
			break; 	
        case SQUARE:
        	Polygon square=new Polygon();
        	square.addPoint(center.x-radius, center.y-radius);
        	square.addPoint(center.x+radius, center.y-radius);
        	square.addPoint(center.x+radius, center.y+radius);
        	square.addPoint(center.x-radius, center.y+radius);
			g.fillPolygon(square);
			break; 
        case TRIANGLE:
        	Polygon pentagon=new Polygon();
        	pentagon.addPoint(center.x, center.y-radius);
        	pentagon.addPoint(center.x+radius, center.y-(radius/5));
        	pentagon.addPoint(center.x+(3*radius/5), center.y+radius);
        	pentagon.addPoint(center.x-(3*radius/5), center.y+radius);
        	pentagon.addPoint(center.x-radius, center.y-(radius/5));
			g.fillPolygon(pentagon);
		default:
			g.fillOval(center.x-5, center.y-5, 10, 10);
			break;
		}
	}
	

	
	

}
