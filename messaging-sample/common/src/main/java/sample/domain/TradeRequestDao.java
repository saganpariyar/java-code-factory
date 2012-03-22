package sample.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TradeRequestDao {

	public void save(TradeRequest tradeRequest) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/new_schema?"
					+ "user=realsuite&password=realsuite");

			// PreparedStatements can use variables and are more efficient
			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into  traderequest (ticker,description) values (?,?)");
			// "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
			// Parameters start with 1
			preparedStatement.setString(1, tradeRequest.getTicker());
			preparedStatement.setString(2, tradeRequest.getDescription());
			preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			// do something
		}
	}

}
