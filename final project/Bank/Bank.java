import java.io.FileWriter;
import java.io.IOException;

class Client
{
    int ID;
    int balance;
    int overdraft;
    String name;

    Client()
    {
        ID = 0;
        balance = 0;
        overdraft = 0;
        name = "";
    }
}

public class Bank
{
    private static Client[] database;
    private static int clients;
    private static int LIMIT;

    Bank()
    {
        database = new Client[32];
        LIMIT = 1000000000;
        clients = 0;
    }

    private int getClientByID(int ID){
        for(int i = 0; i < clients; i++) {
            if(database[i].ID == ID)
                return i;
        }
        return -1;
    }


    public boolean validateID(int ID)
    {
        if(getClientByID(ID) < 0)
            return false;
        return true;
    }

    public int getBalance(int ID)
    {
        int i = getClientByID(ID);
        return database[i].balance;
    }

    public int getOverdraft(int ID)
    {
        int i = getClientByID(ID);
        return database[i].overdraft;
    }

    public boolean Withdraw(int ID, int AMOUNT)
    {
        int i = getClientByID(ID);
        if(database[i].overdraft * 100 < AMOUNT)
            return false;
        if(database[i].balance < AMOUNT)
            return false;

        database[i].balance -= AMOUNT;
        return true;
    }

    public boolean Deposit(int ID, int AMOUNT)
    {
        int i = getClientByID(ID);
        if(i < 0)
            return false;
        if(database[i].balance + AMOUNT > LIMIT || database[i].balance + AMOUNT < 0)
            return false;

        database[i].balance += AMOUNT;
        return true;
    }

    public boolean Transfer(int FROM, int TO, int AMOUNT)
    {
        int i = getClientByID(FROM);
        int j = getClientByID(TO);

        if(i < 0 || j < 0)
            return false;
        if(Withdraw(FROM, AMOUNT) == false)
            return false;

        if(Deposit(TO, AMOUNT) == false) {
            Deposit(FROM, AMOUNT);
            return false;
        }

        return true;
    };

    protected static void LoadClient(String data)
    {
        database[clients] = new Client();
        String ID = ""; int pos = 0;
        while(data.charAt(pos) != ' ')
        {
            ID += data.charAt(pos++);
        }
        database[clients].ID = Integer.parseInt(ID);

        pos += 2;
        while(data.charAt(pos) != '"')
        {
            database[clients].name += data.charAt(pos++);
        }
        pos += 2;

        String dollars = "";
        while(data.charAt(pos) != ' ')
        {
            dollars += data.charAt(pos++);
        }
        database[clients].balance = Integer.parseInt(dollars) * 100;
        pos += 1;

        String cents = "";
        while(data.charAt(pos) != ' ')
        {
            cents += data.charAt(pos++);
        }
        database[clients].balance += Integer.parseInt(cents);
        pos += 1;

        String overdraft = "";
        while(pos < data.length())
        {
            overdraft += data.charAt(pos++);
        }
        database[clients].overdraft = Integer.parseInt(overdraft);
        clients++;
    }

    public void Close()
    {
        try(FileWriter writer = new FileWriter("out_accounts.txt", false))
        {
            for(int i = 0; i < clients; i++)
            {
                writer.write(
                            Integer.toString(database[i].ID)+
                                " \""+
                                    database[i].name +
                                    "\" "+
                                    Integer.toString(database[i].balance / 100)+
                                    " "+
                                    Integer.toString(database[i].balance % 100)+
                                    " "+
                                    Integer.toString(database[i].overdraft)
                );
                if(clients - i > 1) writer.append("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }
}
