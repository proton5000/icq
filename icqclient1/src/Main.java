import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by marina on 01.04.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Client started...");

        Socket fromserver = new Socket("127.0.0.1", 5002);

        //System.out.println("Connecting to... lockalhost");

        System.out.println("client connected... " + fromserver.getLocalPort() + " Local port --- Inet port " + fromserver.getPort());



        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));

        PrintWriter out = new PrintWriter(new OutputStreamWriter(fromserver.getOutputStream()), true);

        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser, fserver;

        while ((fuser = inu.readLine()) != null) {
            out.println("c ::: " + fuser);
            //out.flush();
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}