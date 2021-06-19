import java.util.*;
import java.io.*;
import java.net.*;

public class Client{

Socket socket;
DataInputStream din;
DataOutputStream dout;
ServerSocket serverSocket;

ClientConnection clientConnection;

boolean b=true;

public static void main( String[] args ){

Client client=new Client();

}

public Client(){

try{

 socket=new Socket("127.0.0.1",5000);

clientConnection=new ClientConnection(socket,this);

clientConnection.start();
 
listenForInput();

}catch(Exception e){


}

}

public void listenForInput(){

Scanner console=new Scanner(System.in);

while(b){

while( !console.hasNextLine() ){

try{

Thread.sleep(1);

}catch(Exception e){}

}

String input=console.nextLine();

if( input.equals("quit") ){

break;

}

clientConnection.sendMessageToServer(input);

}

clientConnection.close();

}

void close(){

try{

din.close();
dout.close();
socket.close();

}catch(Exception e){}

}}
