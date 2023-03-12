import java.rmi.Naming;
import java.util.Scanner;

public class ShareClient {
    public static void main (String args[])
    {
        try {
//            String target = (args.length == 0) ? "Ireland" : args[0];
            ShareServer cities = (ShareServer) Naming.lookup("//localhost/Stock market");
//            String capital = cities.getCapital(target);
//            System.out.println(capital);

            /**
             * Write a simple command line client program that can be used to interact with the server as follows
             * login to the server and get an access token
             * download and print out a summary of all the Shares available on the system
             * topup the trading account on the server with some funds
             * then make some share purchases and sales
             * download and print out the ShareHolding at various times during the interaction with the server
             */


        }
        catch (Exception e) {}
    }
}
