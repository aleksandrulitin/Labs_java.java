import java.io.*;

public class Main {
    public static void main(String[] args) {
        Bank data = new Bank();

        try(FileReader reader = new FileReader("in_accounts.txt"))
        {
            int c;
            String client = "";
            while((c = reader.read())!=-1) {
                if((char)c == '\r')
                    continue;

                if((char)c == '\n')
                {
                    if(client.length() > 1)
                        data.LoadClient(client);
                    client = "";
                    continue;
                }
                client += (char)c;
            }

            if(client.length() > 1)
                data.LoadClient(client);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
			System.exit(0);
        }

        GUI bank = new GUI(data);

        bank.Start();
        bank.Close();

        System.exit(0);
    }
}