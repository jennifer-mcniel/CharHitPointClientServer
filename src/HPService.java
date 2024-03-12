import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 Executes Simple Bank Access Protocol commands
 from a socket.
 */
public class HPService implements Runnable
{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private CharacterList characterList;

    /**
     Constructs a service object that processes commands
     from a socket for a bank.
     @param aSocket the socket
     @param aCharacterList the bank
     */
    public HPService(Socket aSocket, CharacterList aCharacterList)
    {
        s = aSocket;
        characterList = aCharacterList;
    }

    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     Executes all commands until the QUIT command or the
     end of input.
     */
    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

    /**
     Executes a single command.
     @param command the command to execute
     */
    public void executeCommand(String command)
    {
        int account = in.nextInt();
        if (command.equals("HEAL"))
        {
            double amount = in.nextDouble();
            characterList.heal(account, amount);
        }
        else if (command.equals("DAMAGE"))
        {
            double amount = in.nextDouble();
            characterList.damage(account, amount);
        }
        else if (command.equals("RESTORE"))
        {
            characterList.restore(account);
        }
        else if (command.equals("INCREASEMAX"))
        {
            double amount = in.nextDouble();
            characterList.increaseMax(account, amount);
        }
        else if (!command.equals("CURRENT"))
        {
            out.println("Invalid command");
            out.flush();
            return;
        }

        out.println(account + " " + characterList.getCurrentHP(account));
        out.flush();
    }
}