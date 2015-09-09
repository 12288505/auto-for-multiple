package tools.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketIO {

	public static DataInputStream getInput(Socket socket) throws IOException {

		// 接收缓存区大小，socket获取输入流之前设置
		InputStream input = socket.getInputStream();
		BufferedInputStream bufferstream = new BufferedInputStream(input);
		return new DataInputStream(bufferstream);
	}

	public static DataOutputStream getOutput(Socket socket) throws IOException {

		// 发送缓存区大小，socket获取输出流之前设置
		OutputStream output = socket.getOutputStream();
		BufferedOutputStream bufferoutstream = new BufferedOutputStream(output);
		return new DataOutputStream(bufferoutstream);
	}
}
