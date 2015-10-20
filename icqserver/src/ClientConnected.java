import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by marina on 01.04.2015.
 */
public class ClientConnected extends Thread {

    Socket s;

    ClientConnected(Socket s)  {
        this.s = s;
        this.start();
    }

    @Override
    public void run() {

        System.out.println("client connected... " + s.getLocalPort() + " Local port --- Inet port " + s.getPort());

        while (true) {

            BufferedReader read = null;
            PrintWriter out = null;
            BufferedReader write = null;

            try {
                read = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 out = new PrintWriter(s.getOutputStream(), true);
                write = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String readIn = null;


            try {
                readIn = read.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(readIn + "   " + Thread.currentThread());

            out.println("s ::::" + readIn);
            out.println("s ::: " + write);
//            try {
//                read.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }
    }

}
//ArrayList<Connection> ar=...;
//        ServerSocket ss=...;
//        while (true){
//        ar.add(new Connection(ss.accept()));
//        }
//
//class Connection implements Runnable{
//    Connection(Socket s){
//
//    }
//}