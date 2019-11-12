package cs174a;                         // THE BASE PACKAGE FOR YOUR APP MUST BE THIS ONE.  But you may add subpackages.

// DO NOT REMOVE THIS IMPORT.
import cs174a.Testable.*;

/**
 * This is the class that launches your application.
 * DO NOT CHANGE ITS NAME.
 * DO NOT MOVE TO ANY OTHER (SUB)PACKAGE.
 * There's only one "main" method, it should be defined within this Main class, and its signature should not be changed.
 */
public class Main
{
	/**
	 * Program entry point.
	 * DO NOT CHANGE ITS NAME.
	 * DON'T CHANGE THE //!### TAGS EITHER.  If you delete them your program won't run our tests.
	 * No other function should be enclosed by the //!### tags.
	 */
	//!### COMENZAMOS
	public static void main( String[] args )
	{
		App app = new App();            // We need the default constructor of your App implementation.  Make sure such
										// constructor exists.
		app.initializeSystem();         // We'll always call this function before testing your system.
		app.exampleAccessToDB();        // Example on how to connect to the DB.

		// Example tests.  We'll overwrite your Main.main() function with our final tests.
		ResultAccountList result = app.listClosedAccounts();

		System.out.println( "Error code: " + result.errorCode );
		if( result.errorCode != 0 )
			System.out.println( " Error msg: " + result.errorMessage );
		System.out.println( "---------- Accounts ---------" );
		for( Account account : result.accounts )
		{
			System.out.println( "- Account: " + account.id );
			System.out.println( "-    Type: " + account.type );
			if( account.linkedAccount != null )
				System.out.println( "-  Linked: " + account.linkedAccount );
			System.out.println( "- Balance: " + account.balance );
			System.out.println( "-    Open: " + account.open );
			System.out.println( "-----------------------------" );
		}
	}
	//!### FINALIZAMOS
}
