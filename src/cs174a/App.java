package cs174a;                                             // THE BASE PACKAGE FOR YOUR APP MUST BE THIS ONE.  But you may add subpackages.

// You may have as many imports as you need.
import java.sql.*;
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
	 * This is an example of DDL.
	 */
	void exampleCreateTable()
	{
		try( Statement statement = _connection.createStatement() )
		{
			statement.executeUpdate( "create table Parts2(" +
					"    pid int," +
					"    pname varchar(20)," +
					"    color varchar(20)," +
					"    primary key (pid)" +
					")" );
			System.out.println( "Parts2 table has been successfully created!" );
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	/**
	 * This is an example of inserting rows into a table.
	 */
	void exampleInsertIntoTable()
	{
		try( PreparedStatement preparedStatement = _connection.prepareStatement( "insert into Parts2( pid, pname, color ) values ( ?, ?, ? )" ) )
		{
			int[] ids = {10, 11, 12, 13};
			String[] names = {"Part A", "Part B", "Part C", "Part C"};
			String[] colors = {"red", "red", "green", "green"};
			for( int i = 0; i < ids.length; i++ )
			{
				preparedStatement.clearParameters();                        // Filling in the blanks.
				preparedStatement.setInt( 1, ids[i] );
				preparedStatement.setString( 2, names[i] );
				preparedStatement.setString( 3, colors[i] );

				preparedStatement.executeUpdate();
			}
			System.out.println( "Parts2 table has been successfully populated!" );
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	/**
	 * This is an example access operation to the DB.
	 */
	void exampleAccessTable()
	{
		// Statement and ResultSet are AutoCloseable and closed automatically.
		try( Statement statement = _connection.createStatement() )
		{
			try( ResultSet resultSet = statement.executeQuery( "select * from Parts2" ) )
			{
				while( resultSet.next() )
					System.out.println( resultSet.getInt( "pid" ) + " " + resultSet.getString( "pname" ) + " " + resultSet.getString( "color" ) );
			}
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	/**
	 * This is an example of destroying a table.
	 */
	void exampleDetroyTable()
	{
		try( Statement statement = _connection.createStatement() )
		{
			int numberOfDeletedRows = statement.executeUpdate( "delete from Parts2" );
			System.out.println( "Deleted " + numberOfDeletedRows + " rows from Table2" );

			statement.executeUpdate( "drop table Parts2" );
			System.out.println( "Parts2 table has been successfully destroyed!" );
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	void finalizeSystem()
	{
		// Here, we destroy connection or any other objects we created when the class was instantiated.
		try
		{
			_connection.close();
			System.out.println( "Connection has been closed!" );
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
		}
	}

	////////////////////////////// Implement all of the methods given in the interface /////////////////////////////////
	// Check the Testable.java interface for the function signatures and descriptions.

	@Override
	public String initializeSystem()
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

			return "0";
		}
		catch( SQLException e )
		{
			System.err.println( e.getMessage() );
			return "1";
		}
	}

	/**
	 * Example of one of the testable functions.
	 */
	@Override
	public String listClosedAccounts()
	{
		return "0 it works!";
	}

	/**
	 * Another example.
	 */
	@Override
	public String createCheckingSavingsAccount( AccountType accountType, String id, double initialBalance, String tin, String name, String address )
	{
		return "0 " + id + " " + accountType + " " + initialBalance + " " + tin;
	}
}
