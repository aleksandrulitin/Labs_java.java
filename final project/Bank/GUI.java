
import javax.swing.*;
import java.io.*;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int client = 0;
	private static int amount = 0;
	private static Bank bank = null;

	private JPanel contents = null;
	private String[] options = {
					"Deposit money to this account",
					"Withdraw money from this account",
					"Transfer money from this account to another",
					"Check the account information",
					"Go to another account",
					"Exit", };


	private boolean formatValidate(String string)
	{
		int i = 0;
		while(i < string.length() && string.charAt(i++) != '.');
		if(i == string.length())
			return false;
		if(string.length() - i == 2)
			return true;

		return false;
	}

	private boolean getAmount(String TITLE, String ACTION) {

		Object input = JOptionPane.showInputDialog(GUI.this,
				"How much would you like to " +
						ACTION +
						" account #" +
						Integer.toString(client) +
						" (Format: 0.00)",
				TITLE,
				JOptionPane.QUESTION_MESSAGE);

		if (input == null)
			return false;

		if(formatValidate(input.toString()) == false)
		{
			showError("Input", "Invalid format");
			return getAmount(TITLE, ACTION);
		}

		float f = 0;
		try
		{
			f = Float.parseFloat(input.toString());
		}
		catch (NumberFormatException e)
		{
			showError("Input", "Invalid amount");
			return getAmount(TITLE, ACTION);
		}

		amount = (int)(f * 100);
		return true;
	}

	private void Deposit() {
		if(getAmount("Deposit", "deposit to") == false)
			return;

		String result = "rejected";
		if(bank.Deposit(client, amount) == true)
			result = "completed";

		showMessage("Transaction " + result, "Deposit");
	}

	private void Withdraw() {

		if(getAmount("Withdraw", "withdraw from") == false)
			return;

		String result = "rejected";
		if(bank.Withdraw(client, amount) == true)
			result = "completed";

		showMessage("Transaction " + result, "Withdraw");
	}

	private boolean Transfer() {
		Object string = JOptionPane.showInputDialog(GUI.this,
				"Please enter the account id of the account you wish to transfer to",
				"Transfer",
				JOptionPane.QUESTION_MESSAGE);

		if(string == null)
			return false;

		int ID = 0;

		try {
			ID = Integer.parseInt(string.toString());
		}
		catch (NumberFormatException e) {
			showError("Transfer", "Invalid ID");
			return Transfer();
		}

		if(bank.validateID(ID) == false)
		{
			showError("Transfer", "ID does not exist");
			return Transfer();
		}

		if(getAmount("Transfer", "transfer to account #" + Integer.toString(ID) + " from") == false)
			return false;

		String result = "rejected";
		if(bank.Transfer(client, ID, amount) == true)
			result = "completed";

		showMessage("Transaction " + result, "Transfer");
		return true;
	}

	private void Check() {
		int balance = bank.getBalance(client);
		int overdraft = bank.getOverdraft(client);

		showMessage(
				"The current balance is $"+
						Integer.toString(balance / 100)+
						"."+
						Integer.toString(balance % 100)+
						" (Your overdraft maximum is $"+
						Integer.toString(overdraft)+
						")",

				"Account information");
		return;
	}


	private void parseOption(String option)
	{
		if(option == options[0])
		{ Deposit(); return; }
		if(option == options[1])
		{ Withdraw(); return; }
		if(option == options[2])
		{ Transfer(); return; }
		if(option == options[3])
		{ Check(); return; }
		if(option == options[4])
		{ client = getID(); return; }
		if(option == options[5])
		{ Close(); }
	}

	private void getOption(int ID)
	{
		Object result = JOptionPane.showInputDialog(
				GUI.this,
				"What would you like to do with this account?",
				"Checking Account #" + Integer.toString(ID),
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if(result == null)
			Close();

		parseOption(result.toString());
		getOption(client);
	}
	
	private void showMessage(String MESSAGE, String TITLE)
	{
		JOptionPane.showMessageDialog(GUI.this,
				MESSAGE,
				TITLE,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	private boolean showWarning(String TITLE, String WARNING)
	{
		int result = JOptionPane.showConfirmDialog(GUI.this,
				WARNING,
				TITLE,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if(result == JOptionPane.YES_OPTION)
			return true;

		return false;
	}
	private void showError(String TITLE, String ERROR)
	{
		JOptionPane.showMessageDialog(GUI.this,
				ERROR,
				TITLE,
				JOptionPane.ERROR_MESSAGE);
	}

	private int getID()
	{
		Object string = JOptionPane.showInputDialog(GUI.this,
				"Please enter the account id of the account you wish to access",
				"Authorization",
				JOptionPane.QUESTION_MESSAGE);
		if(string == null)
			Close();

		int ID = 0;

		try {
			ID = Integer.parseInt(string.toString());
		}
		catch (NumberFormatException e)
		{
			showError("Authorization", "Invalid ID");
			ID = getID();
		}

		if(bank.validateID(ID) == false)
		{
			showError("Authorization", "ID does not exist");
			ID = getID();
		}

		return ID;
	}


	public GUI(Bank data)
	{
		super("Bank");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents = new JPanel();
		setContentPane(contents);
		setVisible(false);
		bank = data;
	}

	public void Start()
	{
		client = getID();
		getOption(client);
	}

	public void Close()
	{
		bank.Close();
	}
}
