import java.util.*;
import java.io.*;
import java.net.*;

public class Client1{

static String msg;

public static void main( String[] args ){

Socket socket;
BufferedReader bufferedReader;
PrintWriter out;

Scanner in=new Scanner(System.in);

try{

socket=new Socket("127.0.0.1",5001);

out=new PrintWriter( socket.getOutputStream() );

bufferedReader=new BufferedReader( new InputStreamReader(socket.getInputStream()) );

Thread thread=new Thread( new Runnable(){

public void run(){

while(true){

msg=in.nextLine();

out.println(msg);
out.flush();

}

}

} );

thread.start();

Thread thread1=new Thread( new Runnable(){

public void run(){

while(true){

try{

msg=bufferedReader.readLine();

System.out.println("Server: "+msg);
//out.flush();

}catch(Exception e){


}



}

}

} );

thread1.start();

}catch(IOException e){

}

}

}
