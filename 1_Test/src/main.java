import model.dao.*;

public class main {

	public static void main(String[] args) throws InterruptedException {

		// Controller controller = new Controller();

		TronnJDBC conn = TronnJDBC.getInstance();
		conn.UpdateWin("blue");

	}

}
