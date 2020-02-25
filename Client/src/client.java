import java.net.Socket;

public class client {
	public static void main(String[] args) {
		try {
			Socket c_socket = new Socket("127.0.0.1",8888);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
