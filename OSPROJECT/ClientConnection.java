import java.util.*;
import java.io.*;
import java.net.*;

public class ClientConnection extends Thread{

Socket socket;
Client client;

DataInputStream din;
DataOutputStream dout;

boolean b=true;

ClientConnection clientConnection;

public ClientConnection( Socket socket,Client client ){

this.socket=socket;
this.client=client;

}

public void sendMessageToServer(String input){

try{

dout.writeUTF(input);
dout.flush();

}catch(Exception e){ close(); }

}

public void run(){

try{

din=new DataInputStream( socket.getInputStream() );
 dout=new DataOutputStream( socket.getOutputStream() );

//}catch(Exception e){}

while(b){

try{

while( din.available()==0 ){

try{

Thread.sleep(1);

}catch(Exception e){}

}

String reply=din.readUTF();
System.out.println(reply);

}catch(Exception e){ close(); }

}

}catch(Exception e){ close(); };

}

public void close(){

try{

din.close();
dout.close();
socket.close();

}catch(Exception e){}

}
//}
}
//}



