package lab.crazyspark;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PathDemo {

	public static void main1(String[] args) throws IOException {
		// 第一种方式，我的工程目录是JavaTest
		System.out.println("第一种方式");
		String path = System.getProperty("user.dir");// 获得项目根目录的绝对路径
		System.out.println(path);
		Properties properties = System.getProperties();
		System.out.println(properties.getProperty("user.dir"));
		// 第二种方式，这里我的文件目录是这样的：JavaTest（工程目录）\resources\武汉大学.kml
		System.out.println("第二种方式");
		File file = new File("resources/武汉大学.kml");
		if (file.exists()) {
			System.out.println(file.getAbsolutePath());// 获取绝对路径
			System.out.println(file.getCanonicalPath());// 获取标准路径
		}
		// 第三种方式，这里我的文件目录是这样的：JavaTest（工程目录）\src\images\me.jpg
		System.out.println("第三种方式");
		System.out.println(PathDemo.class.getResource("/"));// 得到当前类文件的URL目录
		System.out.println(PathDemo.class.getResource(""));// 得到当前类的classpath目录
		System.out.println(PathDemo.class.getResource("./"));
		// 这里访问文件的时候目录前面要加/
		System.out.println(PathDemo.class.getResource("/images/me.jpg"));
		// 第四种方式，这里我的文件目录是这样的：JavaTest（工程目录）\src\images\me.jpg
		System.out.println("第四种方式");
		System.out.println(PathDemo.class.getClassLoader().getResource(""));
		// 这里访问文件的时候目录前面不能加/
		System.out.println(PathDemo.class.getClassLoader().getResource("images/me.jpg"));
	}

	public static void main(String[] args) throws IOException {

		System.out.println("wine-------------------------------------------------");
		String ykexe = "git diff"; // getProperty("ykexe") + " " + tableout; //getproperty("ykexe") 路径 tableout
									// 参数，多个参数用空格隔开
		StringBuilder infoMsg = new StringBuilder();
		StringBuilder errorMsg = new StringBuilder();
		String line = null;
		//while (true) {
			Runtime rn = Runtime.getRuntime();
			Process p = null;
			try {
				p = rn.exec(ykexe);
				try {
					p.waitFor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BufferedReader info = new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
				while ((line = info.readLine()) != null) {
					infoMsg.append(line).append("\n");
				}
				while ((line = error.readLine()) != null) {
					errorMsg.append(line).append("\n");
				}
				if (infoMsg.toString().contains("OK")) {
					System.out.println(infoMsg.toString());
				} else {
					System.out.println(errorMsg.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		//}
	}
}