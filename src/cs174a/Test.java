/*
 * CS174A Project Test Class.
 * Crated by Im Youngmin on October 29, 2019.
 */
package cs174a;

public class Test
{
	/////////////////////////////////////// Data types used across testing functions ///////////////////////////////////

	/**
	 * Account types.
	 */
	private enum AccountType {
		STUDENT_CHECKINGS,
		INTEREST_CHECKINGS,
		SAVINGS,
		POCKET
	}

	/**
	 * Customer relevant information.
	 */
	private static class Customer {
		String tin;                     // Tax ID number.
		String name;                    // Name.
		String address;                 // Address.
	}

	/**
	 * Bank account relevant information.
	 */
	private static class Account {
		String id;                      // Account ID.
		double balance;                 // Current balance (also, ending balance when account is included in monthly report).
		AccountType type;               // Account type.
		String linkedAccount;           // If account is POCKET, this is the ID of linked account.
		boolean open;                   // Whether the account is open or closed.
	}

	/**
	 * Account extended information including owners and transactions.
	 */
	private static class DetailedAccount extends Account {
		double initialBalance;          // Account initial balance (see Account class for ending monthly balance).
		boolean insuranceWarning;       // True if primary owner's money exceeds $100K.
		Customer[] owners;              // Customers owning this account.
	}

	/**
	 * Generic Result object.
	 */
	private static class Result {
		int errorCode = 0;              // 0 If operation was successful, non-zero otherwise.
		String errorMessage = "";       // If operation failed, use this to provide additional information on what went wrong (useful for debugging).
	}

	/**
	 * Result object for operations that return an account's balance.
	 */
	private static class ResultBalance extends Result {
		double balance;
	}

	/**
	 * Result object for operations that return source and destination account balances.
	 */
	private static class ResultBalances extends Result {
		double balanceFrom;             // Source account balance.
		double balanceTo;               // Destination account balance.
	}

	/**
	 * Result object for operations that return information about written checks.
	 */
	private static class ResultCheck extends ResultBalance {
		int check;                      // Written check number.
	}

	/**
	 * Result object for operations that return to return account's information.
	 */
	private static class ResultAccount extends Result {
		Account account;                // Account information.
		Customer owner;                 // Account owner.
	}

	/**
	 * Result object for operations that return a list of accounts.
	 */
	private static class ResultAccountList extends Result {
		Account[] accounts;              // List of account objects.
	}

	/**
	 * Result object for operations that return a list of customers.
	 */
	private static class ResultCustomerList extends Result {
		Customer[] customers;           // List of customer objects.
	}

	private static class ResultDetailedAccountList extends Result{
		DetailedAccount[] detailedAccounts;     // List of detailed account objects.
	}

	///////////////////////////////////////// Functions for testing your system ////////////////////////////////////////

	/**
	 * Destroy all of the tables in your DB.
	 * @return a generic Result object.
	 */
	public Result dropTables()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Create all of your tables in your DB.
	 * @return a generic Result object.
	 */
	public Result createTables()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Set system's date.
	 * @param year Valid 4-digit year, e.g. 2019.
	 * @param month Valid month, where 1: January, ..., 12: December.
	 * @param day Valid day, from 0 to 31, depending on the month and leap year.
	 * @return a generic Result object.
	 */
	public Result setDate( int year, int month, int day )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Change the logged in user's PIN.
	 * @param oldPin The old 4-digit user's PIN.
	 * @param newPin The new 4-digit user's PIN.
	 * @return a generic Result object.
	 */
	public Result changePin( String oldPin, String newPin )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Log in to manager/teller interface.
	 * @return a generic Result object.
	 */
	public Result managerLogin()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Log in to customer interface.
	 * @param tin Customer's Tax ID number.
	 * @param pin Customer's PIN.
	 * @return a generic Result object.
	 */
	public Result customerLogin( String tin, String pin )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Logout from active manager or customer session.
	 * @return a generic Result object.
	 */
	public Result logout()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Change the annual interest rate to a given account type.
	 * @param accountType One of the types of customer bank accounts.
	 * @param annualRate New non-negative annual interest rate.
	 * @return a generic Result object.
	 */
	public Result setInterest( AccountType accountType, double annualRate )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Create a new checkings or savings account.
	 * @param accountType New account's checkings or savings type.
	 * @param id New account's ID.
	 * @param initialBalance Initial account balance.
	 * @param tin Account's owner Tax ID number - it may belong to an existing or new customer.
	 * @param name If customer is new, this is the customer's name.
	 * @param address If customer is new, this is the customer's address.
	 * @param pin If customer is new, this is the optional customer's PIN.
	 * @return a ResultAccount object with information about new account and owner.
	 */
	public ResultAccount createCheckingsSavingsAccount( AccountType accountType, String id, double initialBalance, String tin, String name, String address, String pin )
	{
		// TODO: Your implementation.
		return new ResultAccount();
	}

	/**
	 * Create a new pocket account.
	 * @param id New account's ID.
	 * @param linkedId Linked savings or checkings account ID.
	 * @param initialTopUp Initial balance to be deducted from linked account and deposited into new pocket account.
	 * @param tin Existing customer's Tax ID number.  He/She will become the new pocket account's owner.
	 * @return a ResultAccount object with information about new account and owner.
	 */
	public ResultAccount createPocketAccount( String id, String linkedId, double initialTopUp, String tin )
	{
		// TODO: Your implementation.
		return new ResultAccount();
	}

	/**
	 * Create a new customer and link them to an existing checkings or saving account.
	 * @param accountId Existing checkings or saving account.
	 * @param tin New customer's Tax ID number.
	 * @param name New customer's name.
	 * @param address New customer's address.
	 * @param pin Optional new customer's PIN.
	 * @return a generic Result object.
	 */
	public Result createCustomer( String accountId, String tin, String name, String address, String pin )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Change the ownership of a checkings or savings account.
	 * @param accountId Existing checkings or savings account ID.
	 * @param tin Existing customer Tax ID number.
	 * @return a generic Result object.
	 */
	public Result setAccountOwnership( String accountId, String tin )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Change the primary owner of a checkings or savings account.
	 * @param accountId Existing checkings or savings account ID.
	 * @param tin Existing customer Tax ID number who will become the account's primary owner.
	 * @return a generic Result object.
	 */
	public Result setAccountPrimaryOwner( String accountId, String tin )
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Deposit a given amount of dollars to an existing checkings or savings account.
	 * @param accountId Account ID.
	 * @param amount Non-negative amount to deposit.
	 * @return a ResultBalance object containing the account's new balance.
	 */
	public ResultBalance deposit( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalance();
	}

	/**
	 * Withdraw a given amount of dollars from an existing savings or checkings account.  If balance goes to $0.01,
	 * then mark account as closed.  If money to be withdrawn is greater than available balance, then operation should
	 * not be allowed.
	 * @param accountId Account ID.
	 * @param amount Non-negative amount to withdraw.
	 * @return a ResultBalance object containing the account's new balance.
	 */
	public ResultBalance withdraw( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalance();
	}

	/**
	 * Withdraw all funds from an existing savings or checking account.
	 * @param accountId Account ID.
	 * @return a ResultBalance object containing the account's new balance.
	 */
	public ResultBalance withdrawAll( String accountId )
	{
		// TODO: Your implementation.
		return new ResultBalance();
	}

	/**
	 * Show an account balance (regardless of type of account).
	 * @param accountId Account ID.
	 * @return a ResultBalance object with the account's current balance.
	 */
	public ResultBalance showBalance( String accountId )
	{
		// TODO: Your implementation.
		return new ResultBalance();
	}

	/**
	 * Wire money from one account to another.
	 * @param from Source account ID.
	 * @param to Destination account ID.
	 * @param amount Non-negative amount to wire.
	 * @return a ResultBalances object with the new balances for the from and to accounts.
	 */
	public ResultBalances wire( String from, String to, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalances();
	}

	/**
	 * Subtract money from a checkings account.
	 * @param accountId Checkings account ID.
	 * @param amount Check's amount.
	 * @return a ResultCheck object containing the check number and the new balance in the checkings account.
	 */
	public ResultCheck writeCheck( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultCheck();
	}

	/**
	 * Move a specified amount of money from the linked checkings/savings account to the pocket account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount to top up.
	 * @return a ResultBalances object with the 'balanceFrom' containing the linked account's new balance, and the 'balanceTo'
	 * with the pocket's account new balance.
	 */
	public ResultBalances topUp( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalances();
	}

	/**
	 * Move a specified amount of money from one pocket account to another pocket account.
	 * @param from Source pocket account ID.
	 * @param to Destination pocket account ID.
	 * @param amount Non-negative amount to pay.
	 * @return a ResultBalances object containing the new balances for both the from and to pocket accounts.
	 */
	public ResultBalances payFriend( String from, String to, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalances();
	}

	/**
	 * Move a specified amount of money from a pocket account back to the linked checkings/savings account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount to collect.
	 * @return a ResultBalances object with the 'balanceFrom' set to the pocket account's new balance, and the 'balanceTo'
	 * with the linked account's new balance (note the order of balances is opposite to topUp).
	 */
	public ResultBalances collect( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalances();
	}

	/**
	 * Subtract money from a pocket account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount used in purchase.
	 * @return a ResultBalance object containing the pocket account's new balance.
	 */
	public ResultBalance purchase( String accountId, double amount )
	{
		// TODO: Your implementation.
		return new ResultBalance();
	}

	/**
	 * Generate list of closed accounts.
	 * @return a ResultAccountList object with all of the closed accounts in a list.
	 */
	public ResultAccountList listClosedAccounts()
	{
		// TODO: Example of result object to be returned.
		Account[] closedAccounts = new Account[2];
		closedAccounts[0] = new Account();
		closedAccounts[0].id = "Checkings 1";       // A checkings account.
		closedAccounts[0].balance = 0.009;
		closedAccounts[0].linkedAccount = null;
		closedAccounts[0].open = false;
		closedAccounts[0].type = AccountType.INTEREST_CHECKINGS;

		closedAccounts[1] = new Account();
		closedAccounts[1].id = "Pocket 1";          // A pocket account.
		closedAccounts[1].balance = 0.0;
		closedAccounts[1].linkedAccount = "Checkings 1";
		closedAccounts[1].open = false;
		closedAccounts[1].type = AccountType.POCKET;

		ResultAccountList resultAccountList = new ResultAccountList();
		resultAccountList.errorCode = 0;            // No error.
		resultAccountList.accounts = closedAccounts;
		resultAccountList.errorMessage = null;

		return resultAccountList;
	}

	/**
	 * Generate list of open and closed accounts for a customer.
	 * @param tin Customer's tax ID number.
	 * @return a ResultAccountList object with all of the customer's accounts.
	 */
	public ResultAccountList customerReport( String tin )
	{
		// TODO: Your implementation.
		return new ResultAccountList();
	}

	/**
	 * Generate Government Drug and Tax Evasion Report.
	 * @return a ResultCustomerList object with a list of customers.
	 */
	public ResultCustomerList generateDTER()
	{
		// TODO: Your implementation.
		return new ResultCustomerList();
	}

	/**
	 * Generate the monthly statement for a given customer.
	 * @param tin Customer's tax ID number.
	 * @return a ResultDetailedAccountList object.
	 */
	public ResultDetailedAccountList generateMonthlyStatement( String tin )
	{
		// TODO: Your implementation.
		return new ResultDetailedAccountList();
	}

	/**
	 * Add interest to all appropriate open accounts.
	 * @return a generic Result object.
	 */
	public Result addInterest()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Remove from the DB all closed accounts and remove all customers who do not own any accounts.
	 * @return a generic Result object.
	 */
	public Result deleteClosedAccountsAndCustomers()
	{
		// TODO: Your implementation.
		return new Result();
	}

	/**
	 * Delete transactions from all accounts.
	 * @return a generic Result object.
	 */
	public Result deleteTransactions()
	{
		// TODO: Your implementation.
		return new Result();
	}

	////////////////////////////////////////////////// The main function ///////////////////////////////////////////////

	public static void main( String[] args )
	{
		// Showing how to retrieve results.
		Test test = new Test();
		ResultAccountList result = test.listClosedAccounts();

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
}
