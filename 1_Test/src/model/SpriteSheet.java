package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage spriteSheet;

	public SpriteSheet() {

		try {
			this.spriteSheet = ImageIO.read(new File("../SpriteSheet.png"));
		} catch (IOException e) {
			System.out.println("Failure loading SpriteSheet");
			System.exit(0);
		}

	}

	public BufferedImage crop(int x, int y, int size) {
		return spriteSheet.getSubimage(x * size, y * size, size, size);
	}

}
