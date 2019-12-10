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
		App app = new App();
		String s1 = app.initializeSystem();
		String s2 = app.dropTables();
		String s3 = app.createTables();

		String s4 = app.setDate( 2011, 3, 2011 );

		String s5 = app.createCheckingSavingsAccount( AccountType.SAVINGS, "29107", 34000, "209378521", "Kelvin Costner", "Santa Cruz #3579" );
		String s6 = app.createCustomer("29107", "212116070", "Li Kung", "2 Peoples Rd Beijing" );
		String s7 = app.createCustomer("29107", "210389768", "Olive Stoner", "6689 El Colegio #151" );
		String s8 = app.deposit("29107", 34000.0 );
		String s9 = app.showBalance( "29107" );

		String s10 = app.createPocketAccount( "43947", "29107", 30, "212116070" );
		String s11 = app.topUp( "43947", 30.0 );

		String s12 = app.createCheckingSavingsAccount( AccountType.STUDENT_CHECKING, "12121", 1200, "207843218", "David Copperfill", "1357 State St" );
		String s13 = app.createPocketAccount("53027", "12121", 50, "207843218" );

		String s14 = app.payFriend( "53027", "43947", 50 );
		String s15 = app.listClosedAccounts();

		System.out.println( "////////////////////////////// Printing the results ///////////////////////////////////" );
		System.out.println( s1 );
		System.out.println( s2 );
		System.out.println( s3 );
		System.out.println( s4 );
		System.out.println( s5 );
		System.out.println( s6 );
		System.out.println( s7 );
		System.out.println( s8 );
		System.out.println( s9 );
		System.out.println( s10 );
		System.out.println( s11 );
		System.out.println( s12 );
		System.out.println( s13 );
		System.out.println( s14 );
		System.out.println( s15 );

	}
	//!### FINALIZAMOS
}
