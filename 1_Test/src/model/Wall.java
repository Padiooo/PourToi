package model;

import java.awt.image.BufferedImage;

public class Wall {

	private int posX;
	private int posY;
	private BufferedImage img = null;

	public Wall(int posX, int posY, BufferedImage img) {

		this.posX = posX;
		this.posY = posY;
		this.img = img;
	}

	/************ Normal Getters and Setters ************/

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
