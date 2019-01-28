package cn.stylefeng.guns.modular.system;

import cn.stylefeng.guns.modular.system.service.*;
import java.util.concurrent.*;
import java.net.*;
import java.io.*;
import cn.stylefeng.guns.*;

public class SocketServer {
	ICabinetService iCabinetService;

	public void startServer(final int port) throws IOException {
		ServerSocket server = new ServerSocket(port);
		System.out.println("server将一直等待连接的到来");
		ExecutorService threadPool = Executors.newFixedThreadPool(50);
		while (true) {
			Socket socket = server.accept();
			Runnable runnable = () -> {
				try {
					//OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
					InputStream input = socket.getInputStream();
					byte[] bytes = new byte[1024];
					String temps = new String(bytes, 0, 1024);
					System.out.println("demo:"+temps);
					int len = 0;
					while ((len = input.read(bytes)) != -1) {
						String temp = new String(bytes, 0, len);
						if (temp.contains("#") && temp.contains("!")) {
							temp = temp.substring(temp.indexOf("#")+1, temp.indexOf("!"));
							//System.out.println("temp:"+temp);
							 this.handle(temp);
							//OutputStream writer= socket.getOutputStream();
							//writer.write(temp.getBytes());
							//writer.flush();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			};
			threadPool.submit(runnable);

		}
	}

	private void handle(final String data) {
		this.iCabinetService = (ICabinetService) SpringContextUtil.getBean("iCabinetService");
		try {
			this.iCabinetService.saveOrUpdateCabinetInfo(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
