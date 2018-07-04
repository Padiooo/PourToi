package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public final class TronnJDBC {
	/** The instance. */
	private static TronnJDBC instance;
	/** The login. */
	private static String user = "root";
	/** The password. */
	private static String password = "root";
	/** The url. */
	private static String url = "jdbc:mysql://localhost/tronn?useSSL=false&serverTimezone=UTC";
	/** The connection. */
	private Connection connection;
	/** The statement. */
	private Statement statement;

	/**
	 * Instantiates a new boulder dash BDD connector.
	 */
	private TronnJDBC() {
		this.open();
	}

	/**
	 * Gets the single instance of BoulderDashBDDConnector.
	 *
	 * @return single instance of BoulderDashBDDConnector
	 */
	public static TronnJDBC getInstance() {
		if (instance == null) {
			setInstance(new TronnJDBC());
		}
		return instance;
	}

	/**
	 * Sets the instance.
	 *
	 * @param instance
	 *            the new instance
	 */
	private static void setInstance(final TronnJDBC instance) {
		TronnJDBC.instance = instance;
	}

	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(TronnJDBC.url, TronnJDBC.user,
					TronnJDBC.password);
			this.statement = this.connection.createStatement();
			return true;
		} catch (final SQLException exception) {
			System.out.println("Failure connection to Database");
			System.exit(0);
		}
		return false;
	}
	
	public ResultSetMetaData UpdateWin(String color) {

		ResultSet result;
		ResultSetMetaData resultMeta = null;
		
		try {
			result = statement.executeQuery("CALL SelectColor(\"" + color + "\")");
			resultMeta = result.getMetaData();
			
			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() + "\t |");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMeta;
	}

	/************ Normal Getters and Setters ************/

	public Connection getConnection() {
		return this.connection;
	}

	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

}
