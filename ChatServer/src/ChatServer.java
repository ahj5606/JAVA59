import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket s_socket= new ServerSocket(8888);
			 Socket c_socket = s_socket.accept();
			 
			 OutputStream output_data = c_socket.getOutputStream();
			 String sendDataString = "환영 합니다.";
			 output_data.write(sendDataString.getBytes());
			 
			 s_socket.close();
			 c_socket.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
