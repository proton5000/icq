import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by proton on 31.03.15.
 */
public class Main {

    static ArrayList<Integer> arrClient = new ArrayList<>();
    static int countClients = 0;

    public static void main (String[] args) throws IOException {

        System.out.println("Server started...");

        ServerSocket socket = new ServerSocket(5002);

        while (true) {
            Socket clientsocket = socket.accept();
            new ClientConnected(clientsocket);

            //System.out.println(clientsocket.isConnected());

            if (!clientsocket.isConnected()) {
                break;
            }

        }

    }

//    public static void main(String[] args) throws IOException {
//        System.out.println("Welcome to Server side");
//        BufferedReader in = null;
//        PrintWriter out = null;
//
//        ServerSocket servers = new ServerSocket(5001);
//        Socket fromclient = null;
//
//        // create server socket
//        try {
//            servers = new ServerSocket(5001);
//        } catch (IOException e) {
//            System.out.println("Couldn't listen to port 5001");
//            System.exit(-1);
//        }
//
//        while (true) {
//            try {
//                System.out.print("Waiting for a client...");
//                fromclient = servers.accept();
//
//                new ClientConnected(servers);
//
//                countClients++;
//                arrClient.add(countClients);
//                System.out.println("Clients online: " + arrClient);
//            } catch (IOException e) {
//                System.out.println("Can't accept");
//                System.exit(-1);
//            }
//            in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
//            out = new PrintWriter(fromclient.getOutputStream(), true);
//            String input, output;
//
//            System.out.println("Wait for messages");
//            while ((input = in.readLine()) != null) {
//                if (input.equalsIgnoreCase("exit")) break;
//                out.println("S ::: " + input);
//                System.out.println(input);
//            }
//
//            out.close();
//            in.close();
//            fromclient.close();
//            servers.close();
//        }
//    }
}

////VerySimpleChatServer
//import java.io.*;
//        import java.net.*;
//        import java.util.*;
//public class VerySimpleChatServer{
//    ArrayList clientOutputStreams;
//    public class ClientHandler implements Runnable{
//        BufferedReader reader;
//        Socket sock;
//        public ClientHandler(Socket clientSocket){
//            try{
//                sock=clientSocket;
//                InputStreamReader isReader=new InputStreamReader(sock.getInputStream());
//            } catch(Exception ex) {ex.printStackTrace();}
//        }
//        public void run(){
//            String message;
//            try{
//                while((message=reader.readLine()) != null){
//                    System.out.println("read " + message);
//                    tellEveryone(message);
//                }
//            } catch(Exception ex) {ex.printStackTrace();}
//        }
//    }
//    public static void main(String[] args){
//        new VerySimpleChatServer().go();
//    }
//    public void go(){
//        clientOutputStreams=new ArrayList();
//        try{
//            ServerSocket serverSock=new ServerSocket(5000);
//            while(true){
//                Socket clientSocket=serverSock.accept();
//                PrintWriter writer=new PrintWriter(clientSocket.getOutputStream());
//                clientOutputStreams.add(writer);
//                Thread t=new Thread(new ClientHandler(clientSocket));
//                t.start();
//                System.out.println("got a connection");
//            }
//        } catch(Exception ex) {ex.printStackTrace();}
//    }
//    public void tellEveryone(String message){
//        Iterator it=clientOutputStreams.iterator();
//        while(it.hasNext()){
//            try{
//                PrintWriter writer=(PrintWriter) it.next();
//                writer.println(message);
//                writer.flush();
//            } catch(Exception ex) {ex.printStackTrace();}
//        }
//    }
//}