package cs174a;                                             // Any package is OK.

// You may have as many imports as you need.
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;

/**
 * The most important class for your application.
 * DO NOT CHANGE ITS SIGNATURE.
 */
public class App implements Testable
{
	private OracleConnection _connection;                   // Example connection object to your DB.

	/**
	 * Default constructor.
	 * DO NOT REMOVE.
	 */
	App()
	{
		// TODO: Any actions you need.
	}

	/**
	 * This is an example access operation to the DB.
	 */
	void exampleAccessToDB()
	{
		// Statement and ResultSet are AutoCloseable and closed automatically.
		try( Statement statement = _connection.createStatement() )
		{
			try( ResultSet resultSet = statement.executeQuery( "select owner, table_name from all_tables" ) )
			{
				while( resultSet.next() )
					System.out.println( resultSet.getString( 1 ) + " " + resultSet.getString( 2 ) + " " );
			}
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	////////////////////////////// Implement all of the methods given in the interface /////////////////////////////////
	// Check the Testable.java interface for the function signatures and descriptions.

	@Override
	public void initializeSystem()
	{
		// Some constants to connect to your DB.
		final String DB_URL = "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/orcl";
		final String DB_USER = "c##TAluis";
		final String DB_PASSWORD = "MyOraclePassw0rd";

		// Initialize your system.  Probably setting up the DB connection.
		Properties info = new Properties();
		info.put( OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER );
		info.put( OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD );
		info.put( OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20" );

		try
		{
			OracleDataSource ods = new OracleDataSource();
			ods.setURL( DB_URL );
			ods.setConnectionProperties( info );
			_connection = (OracleConnection) ods.getConnection();

			// Get the JDBC driver name and version.
			DatabaseMetaData dbmd = _connection.getMetaData();
			System.out.println( "Driver Name: " + dbmd.getDriverName() );
			System.out.println( "Driver Version: " + dbmd.getDriverVersion() );

			// Print some connection properties.
			System.out.println( "Default Row Prefetch Value is: " + _connection.getDefaultRowPrefetch() );
			System.out.println( "Database Username is: " + _connection.getUserName() );
			System.out.println();
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	/**
	 * Example of one of the testable functions.  Here, the object was populated by hand.  You must populate the returned
	 * objects with information coming from your DB tables.
	 */
	@Override
	public ResultAccountList listClosedAccounts()
	{
		// Example of result object to be returned.
		Account[] closedAccounts = new Account[2];
		closedAccounts[0] = new Account();
		closedAccounts[0].id = "Checking 1";       // A checking account.
		closedAccounts[0].balance = 0.009;
		closedAccounts[0].linkedAccount = null;
		closedAccounts[0].open = false;
		closedAccounts[0].type = AccountType.INTEREST_CHECKING;

		closedAccounts[1] = new Account();
		closedAccounts[1].id = "Pocket 1";          // A pocket account.
		closedAccounts[1].balance = 0.0;
		closedAccounts[1].linkedAccount = "Checking 1";
		closedAccounts[1].open = false;
		closedAccounts[1].type = AccountType.POCKET;

		ResultAccountList resultAccountList = new ResultAccountList();
		resultAccountList.errorCode = 0;            // No error.
		resultAccountList.accounts = closedAccounts;
		resultAccountList.errorMessage = null;

		return resultAccountList;
	}
}
