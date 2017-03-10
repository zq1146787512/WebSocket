package com.zhang.websocket;

public enum Shape {
	CIRCLE,
	TRIANGLE,
	SQUARE,
	PENTAGON;
	
	public String toString(){
		if(this==CIRCLE){
			return "circle";
		}else if(this==TRIANGLE){
			return "triangle";
		}else if(this==SQUARE){
			return "square";
		}else if(this==PENTAGON){
			return "pentagon";
		}else return "unknown";
		
	}
	
	public static Shape fromString(String s){
		for(Shape shape:Shape.values()){
			if(shape.toString().equals(s)){
			return shape;
			}
			
		}
		throw new IllegalArgumentException("Cannot make shape from:"+s);
	}

}
