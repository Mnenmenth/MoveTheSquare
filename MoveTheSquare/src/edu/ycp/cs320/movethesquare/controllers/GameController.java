package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
		
		//dpalmieri-YCPlaptop added checks to see if sqaure is out of bounds
		
		if(square.getX() + model.getSquareDx() > model.getWidth() - square.getWidth()){
			square.setX(model.getWidth()- square.getWidth());
		}
		
		if(square.getY() + model.getSquareDy() > model.getHeight() - square.getHeight() ) {
			square.setY(model.getHeight() - square.getHeight());
		}
		
		if(square.getY() + model.getSquareDy() < 0) {
			square.setY(0);
		}
		
		if(square.getX() + model.getSquareDy() < 0) {
			square.setX(0);
		}
		
	
	}
}
