package view;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class KeyManager extends Observable implements KeyListener  {

	private char letter;
	
	public KeyManager() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {	
		this.setLetter(e.getKeyChar());
		setChanged();
		notifyObservers();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
	
}
