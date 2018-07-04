package view;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Panneau pan;
	private KeyManager manager;

	public Fenetre(Panneau pan) {
		this.setTitle("Tronn The Evolution");
		this.setSize(606, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		this.setResizable(false);
		this.manager = new KeyManager();
		this.addKeyListener(manager);
		this.setVisible(true);

		this.pan = pan;

	}

	public Panneau getPan() {
		return pan;
	}

	public void setPan(Panneau pan) {
		this.pan = pan;
	}

	public KeyManager getManager() {
		return manager;
	}

	public void setManager(KeyManager manager) {
		this.manager = manager;
	}
}
