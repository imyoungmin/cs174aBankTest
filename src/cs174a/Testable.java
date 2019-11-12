/*
 * CS174A Project Test Class.
 * Crated by Im YoungMin on October 29, 2019.
 */
package cs174a;                         // Any package is OK.

interface Testable
{
	/////////////////////////////////////// Data types used across testing functions ///////////////////////////////////

	/**
	 * Account types.
	 */
	enum AccountType {
		STUDENT_CHECKING,
		INTEREST_CHECKING,
		SAVINGS,
		POCKET
	}

	/**
	 * Customer relevant information.
	 */
	class Customer {
		String tin;                     // Tax ID number.
		String name;                    // Name.
		String address;                 // Address.
	}

	/**
	 * Bank account relevant information.
	 */
	class Account {
		String id;                      // Account ID.
		double balance;                 // Current balance (also, ending balance when account is included in monthly report).
		AccountType type;               // Account type.
		String linkedAccount;           // If account is POCKET, this is the ID of linked account.
		boolean open;                   // Whether the account is open or closed.
	}

	/**
	 * Account extended information including owners and transactions.
	 */
	class DetailedAccount extends Account {
		double initialBalance;          // Account initial balance (see Account class for ending monthly balance).
		Customer[] owners;              // Customers owning this account.
		double[] transactions;          // Chronologically-sorted list of transactions on this account: positive for adding (e.g. deposits), negative for subtracting (e.g. payments).
	}

	/**
	 * Generic Result object.
	 */
	class Result {
		int errorCode = 0;              // 0 If operation was successful, non-zero otherwise.
		String errorMessage = "";       // If operation failed, use this to provide additional information on what went wrong (useful for debugging).
	}

	/**
	 * Result object for operations that return an account's balance.
	 */
	class ResultBalance extends Result {
		double balance;
	}

	/**
	 * Result object for operations that return source and destination account balances.
	 */
	class ResultBalances extends Result {
		double balanceFrom;             // Source account balance.
		double balanceTo;               // Destination account balance.
	}

	/**
	 * Result object for operations that return to return account's information.
	 */
	class ResultAccount extends Result {
		Account account;                // Account information.
		Customer owner;                 // Account owner.
	}

	/**
	 * Result object for operations that return a list of accounts.
	 */
	class ResultAccountList extends Result {
		Account[] accounts;              // List of account objects.
	}

	/**
	 * Result object for operations that return a list of customers.
	 */
	class ResultCustomerList extends Result {
		Customer[] customers;           // List of customer objects.
	}

	class ResultDetailedAccountList extends Result{
		boolean insuranceWarning;       // True if primary owner's money exceeds $100K.
		DetailedAccount[] detailedAccounts;     // List of detailed account objects.
	}

	/////////////////////////////////////// Functions for initializing your system /////////////////////////////////////

	/**
	 * Set up system, initialize any necessary variables, open connection to DB, etc.
	 * You MUST IMPLEMENT AT LEAST THIS FUNCTION, EVEN IF IT'S EMPTY.
	 */
	void initializeSystem();

	///////////////////////////////////////// Functions for testing your system ////////////////////////////////////////

	/**
	 * Destroy all of the tables in your DB.
	 * @return a generic Result object.
	 */
//	Result dropTables();

	/**
	 * Create all of your tables in your DB.
	 * @return a generic Result object.
	 */
//	Result createTables();

	/**
	 * Set system's date.
	 * @param year Valid 4-digit year, e.g. 2019.
	 * @param month Valid month, where 1: January, ..., 12: December.
	 * @param day Valid day, from 0 to 31, depending on the month and leap year.
	 * @return a generic Result object.
	 */
//	Result setDate( int year, int month, int day );

	/**
	 * Change the logged in user's PIN.
	 * @param oldPin The old 4-digit user's PIN.
	 * @param newPin The new 4-digit user's PIN.
	 * @return a generic Result object.
	 */
//	Result changePin( String oldPin, String newPin );

	/**
	 * Log in to bank teller interface.
	 * @return a generic Result object.
	 */
//	Result bankTellerLogin();

	/**
	 * Log in to customer interface.
	 * @param tin Customer's Tax ID number.
	 * @param pin Customer's PIN.
	 * @return a generic Result object.
	 */
//	Result customerLogin( String tin, String pin );

	/**
	 * Logout from active bank teller or customer session.
	 * @return a generic Result object.
	 */
//	Result logout();

	/**
	 * Change the annual interest rate to a given account type.
	 * @param accountType One of the types of customer bank accounts.
	 * @param annualRate New non-negative annual interest rate.
	 * @return a generic Result object.
	 */
//	Result setInterest( AccountType accountType, double annualRate );

	/**
	 * Create a new checking or savings account.
	 * If customer is new, then their name and address should be provided, with optional PIN.
	 * @param accountType New account's checking or savings type.
	 * @param id New account's ID.
	 * @param initialBalance Initial account balance.
	 * @param tin Account's owner Tax ID number - it may belong to an existing or new customer.
	 * @param name [Optional] If customer is new, this is the customer's name.
	 * @param address [Optional] If customer is new, this is the customer's address.
	 * @param pin [Optional] If customer is new, this is the optional customer's PIN.
	 * @return a ResultAccount object with information about new account and owner.
	 */
//	ResultAccount createCheckingSavingsAccount( AccountType accountType, String id, double initialBalance, String tin, String name, String address, String pin );

	/**
	 * Create a new pocket account.
	 * @param id New account's ID.
	 * @param linkedId Linked savings or checking account ID.
	 * @param initialTopUp Initial balance to be deducted from linked account and deposited into new pocket account.
	 * @param tin Existing customer's Tax ID number.  He/She will become the new pocket account's owner.
	 * @return a ResultAccount object with information about new account and owner.
	 */
//	ResultAccount createPocketAccount( String id, String linkedId, double initialTopUp, String tin );

	/**
	 * Create a new customer and link them to an existing checking or saving account.
	 * @param accountId Existing checking or saving account.
	 * @param tin New customer's Tax ID number.
	 * @param name New customer's name.
	 * @param address New customer's address.
	 * @param pin Optional new customer's PIN.
	 * @return a generic Result object.
	 */
//	Result createCustomer( String accountId, String tin, String name, String address, String pin );

	/**
	 * Change the ownership of a checking or savings account.
	 * @param accountId Existing checking or savings account ID.
	 * @param tin Existing customer Tax ID number.
	 * @return a generic Result object.
	 */
//	Result setAccountOwnership( String accountId, String tin );

	/**
	 * Change the primary owner of a checking or savings account.
	 * @param accountId Existing checking or savings account ID.
	 * @param tin Existing customer Tax ID number who will become the account's primary owner.
	 * @return a generic Result object.
	 */
//	Result setAccountPrimaryOwner( String accountId, String tin );

	/**
	 * Deposit a given amount of dollars to an existing checking or savings account.
	 * @param accountId Account ID.
	 * @param amount Non-negative amount to deposit.
	 * @return a ResultBalance object containing the account's new balance.
	 */
//	ResultBalance deposit( String accountId, double amount );

	/**
	 * Withdraw a given amount of dollars from an existing savings or checking account.  If balance goes to $0.01,
	 * then mark account as closed.  If money to be withdrawn is greater than available balance, then operation should
	 * not be allowed.
	 * @param accountId Account ID.
	 * @param amount Non-negative amount to withdraw.
	 * @return a ResultBalance object containing the account's new balance.
	 */
//	ResultBalance withdraw( String accountId, double amount );

	/**
	 * Withdraw all funds from an existing savings or checking account.
	 * @param accountId Account ID.
	 * @return a ResultBalance object containing the account's new balance.
	 */
//	ResultBalance withdrawAll( String accountId );

	/**
	 * Show an account balance (regardless of type of account).
	 * @param accountId Account ID.
	 * @return a ResultBalance object with the account's current balance.
	 */
//	ResultBalance showBalance( String accountId );

	/**
	 * Wire money from one account to another.
	 * @param from Source account ID.
	 * @param to Destination account ID.
	 * @param amount Non-negative amount to wire.
	 * @return a ResultBalances object with the new balances for the from and to accounts.
	 */
//	ResultBalances wire( String from, String to, double amount );

	/**
	 * Subtract money from a checking account.
	 * @param accountId Checking account ID.
	 * @param checkNumber Check's number.
	 * @param amount Check's amount.
	 * @return a ResultBalance object containing new balance of the checking account.
	 */
//	ResultBalance writeCheck( String accountId, int checkNumber, double amount );

	/**
	 * Move a specified amount of money from the linked checking/savings account to the pocket account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount to top up.
	 * @return a ResultBalances object with the 'balanceFrom' containing the linked account's new balance, and the 'balanceTo'
	 * with the pocket's account new balance.
	 */
//	ResultBalances topUp( String accountId, double amount );

	/**
	 * Move a specified amount of money from one pocket account to another pocket account.
	 * @param from Source pocket account ID.
	 * @param to Destination pocket account ID.
	 * @param amount Non-negative amount to pay.
	 * @return a ResultBalances object containing the new balances for both the from and to pocket accounts.
	 */
//	ResultBalances payFriend( String from, String to, double amount );

	/**
	 * Move a specified amount of money from a pocket account back to the linked checking/savings account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount to collect.
	 * @return a ResultBalances object with the 'balanceFrom' set to the pocket account's new balance, and the 'balanceTo'
	 * with the linked account's new balance (note the order of balances is opposite to topUp).
	 */
//	ResultBalances collect( String accountId, double amount );

	/**
	 * Subtract money from a pocket account.
	 * @param accountId Pocket account ID.
	 * @param amount Non-negative amount used in purchase.
	 * @return a ResultBalance object containing the pocket account's new balance.
	 */
//	ResultBalance purchase( String accountId, double amount );

	/**
	 * Generate list of closed accounts.
	 * @return a ResultAccountList object with all of the closed accounts in a list.
	 */
	public abstract ResultAccountList listClosedAccounts();

	/**
	 * Generate list of open and closed accounts for a customer.
	 * @param tin Customer's tax ID number.
	 * @return a ResultAccountList object with all of the customer's accounts.
	 */
//	ResultAccountList customerReport( String tin );

	/**
	 * Generate Government Drug and Tax Evasion Report.
	 * @return a ResultCustomerList object with a list of customers.
	 */
//	ResultCustomerList generateDTER();

	/**
	 * Generate the monthly statement for a given customer.
	 * @param tin Customer's tax ID number.
	 * @return a ResultDetailedAccountList object.
	 */
//	ResultDetailedAccountList generateMonthlyStatement( String tin );

	/**
	 * Add interest to all appropriate open accounts.
	 * @return a generic Result object.
	 */
//	Result addInterest();

	/**
	 * Remove from the DB all closed accounts and remove all customers who do not own any accounts.
	 * @return a generic Result object.
	 */
//	Result deleteClosedAccountsAndCustomers();

	/**
	 * Delete transactions from all accounts.
	 * @return a generic Result object.
	 */
//	Result deleteTransactions();

	/**
	 * Bulk insertions into your DB from a file with formatted data.
	 * @param filePath Source data file.
	 * @return a generic Result object.
	 */
//	Result loadData( String filePath );
}
