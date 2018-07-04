package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import model.Player;
import model.Wall;
import view.Fenetre;
import view.Panneau;

public class Controller implements Observer {

	private Fenetre fenetre;
	private Model model;
	private boolean alive = true;

	public Controller() {
		setUpMap();
	}

	public void setUpMap() {
		
		this.model = new Model();
		this.fenetre = new Fenetre(new Panneau(model));
		this.fenetre.getManager().addObserver(this);
		fenetre.getPan().repaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Failure launching game at Controller setUpMap()");
			System.exit(0);
		}
		fenetre.getPan().setSetup(false);
		game();
	}

	public void game() {

		Player one = model.getPlayerOne();
		Player two = model.getPlayerTwo();

		while (alive) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Failure sleep during the game at Controller game()");
				System.exit(0);
			}
			one.move();
			two.move();

			if (checkReachingOut(one)) {
				one.rollBack();
			}
			if (checkReachingOut(two)) {
				two.rollBack();
			}

				if ((checkColision(one, two) && checkColision(two, one))	// if both hit ennemy wall
						|| (checkColision(one, one) && checkColision(two, two))) {	// if both hit their own walls
					// Both died
					fenetre.getPan().setEndGame(3);
					alive = false;

					// checking collision of one with two's wall, or one and his own walls
				} else if (checkColision(one, two)
						|| checkColision(one, one)) {
					// one died
					//modelRestart.settwoScore(model.gettwoScore() + 1);
					fenetre.getPan().setEndGame(2);
					alive = false;

					// checking collision of two with one's wall, or two and his own walls
				} else if (checkColision(two, one)
						|| checkColision(two, two)) {
					// two died
					//modelRestart.setoneScore(model.getoneScore() + 1);
					fenetre.getPan().setEndGame(1);
					alive = false;
				}

			fenetre.getPan().repaint();
		}
		try {
			Thread.sleep(100);
			fenetre.getPan().repaint();
		} catch (InterruptedException e) {
			System.out.println("Failure at the end of a game");
			System.exit(0);
		}
		restart();

	}

	@Override
	public void update(Observable o, Object arg) {

		char key = fenetre.getManager().getLetter();

		if (key == 'q' || key == 'd') {
			if (key == 'q') {
				model.getPlayerOne().changeDirection(-1);
			} else
				model.getPlayerOne().changeDirection(1);
		} else if (key == 'k' || key == 'm') {
			if (key == 'k') {
				model.getPlayerTwo().changeDirection(-1);
			} else
				model.getPlayerTwo().changeDirection(1);
		}
	}

	public boolean checkColision(Player one, Player two) {

		int x = one.getPosX();
		int y = one.getPosY();
		ArrayList<Wall> wall = two.getWall();
		for (Wall wall2 : wall) {
			if (x == wall2.getPosX() && y == wall2.getPosY()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkReachingOut(Player player) {

		int x = player.getX();
		int y = player.getY();
		if (x < 1 || y < 1 || x > 13 || y > 8) {
			return true;
		}
		return false;
	}

	public void restart() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Failure relaoding the game at Controller restart()");
			System.exit(0);
		}
		this.fenetre.getManager().deleteObservers();
		this.fenetre.setVisible(false); //you can't see me!
		this.fenetre.dispose(); 		//Destroy the JFrame object
		this.fenetre = null;
		this.model = null;
		alive = true;
		
				
		setUpMap();
	}

	/************ Normal Getters and Setters ************/

	public Fenetre getFenetre() {
		return fenetre;
	}

	public Model getModel() {
		return model;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
