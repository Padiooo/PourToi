package view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Model;
import model.Player;
import model.Wall;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 1L;

	private Model model;


	private boolean setup = true;
	private int endGame;

	public Panneau(Model model) {
		this.model = model;
	}

	public void paintComponent(Graphics g) {

		// shorter call
		Player one = model.getPlayerOne();
		Player two = model.getPlayerTwo();
		
		if (setup) { // setting the Map at it's beginning

			g.clearRect(0, 0, getWidth(), getHeight());
			
			// display the map
			
			try {
				g.drawImage(ImageIO.read(new File("../Map.png")), 0, 0, null);
			} catch (IOException e) {
				System.out.println("Failure loading Map");
				System.exit(0);
			}
			
			// put players
			g.drawImage(one.getImgPlayer(), one.getPosX(), one.getPosY(), null);
			g.drawImage(two.getImgPlayer(), two.getPosX(), two.getPosY(), null);

			// scores
			g.setColor(Color.red);
			g.drawString(model.getPlayerOneScore(), getWidth() / 4, 430);
			g.setColor(Color.blue);
			g.drawString(model.getPlayerTwoScore(), 3 * getWidth() / 4, 430);

			// tells who won 
		} else if (endGame != 0) {
			switch (endGame) {
			case 1: // Red won
				g.setColor(Color.red);
				g.drawString("WON", getWidth() / 2 - 15, 430);
				endGame = 0;
				break;
			case 2: // Blue won
				g.setColor(Color.blue);
				g.drawString("WON", getWidth() / 2 - 15, 430);
				endGame = 0;
				break;
			case 3: // Draw
				g.setColor(Color.black);
				g.drawString("DRAW", getWidth() / 2 - 15, 430);
				endGame = 0;
				break;
			default:
				break;
			}

			// display walls			
		} else {

			g.drawImage(two.getImgPlayer(), two.getPosX(), two.getPosY(), null);
			g.drawImage(one.getImgPlayer(), one.getPosX(), one.getPosY(), null);

			ArrayList<Wall> wallRed = one.getWall();
			ArrayList<Wall> wallBlue = two.getWall();

			for (Wall wall : wallRed) {
				g.drawImage(wall.getImg(), wall.getPosX(), wall.getPosY(), null);
			}
			for (Wall wall : wallBlue) {
				g.drawImage(wall.getImg(), wall.getPosX(), wall.getPosY(), null);
			}
		}

	}

	public boolean isSetup() {
		return setup;
	}

	public void setSetup(boolean setup) {
		this.setup = setup;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public int getEndGame() {
		return endGame;
	}

	public void setEndGame(int endGame) {
		this.endGame = endGame;
	}

}
