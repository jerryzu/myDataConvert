package lab.crazyspark.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class SqlFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if (dir.isDirectory())
			return true;
		if (name.toLowerCase().endsWith(".sql"))
			return true;
		else
			return false;
	}

	public static List<File> listFile(File dir, FilenameFilter ff, boolean recursive) {
		List<File> list = new ArrayList<File>();
		File[] files = dir.listFiles(ff);
		if (files != null && files.length > 0) {
			for (File f : files) {
				// 如果是文件,添加文件到list中
				if (f.isFile()) {
					list.add(f);
				}
				// 获取子目录中的文件,添加子目录中的经过过滤的所有文件添加到list
				else if (recursive) {
					list.addAll(listFile(f, ff, true));
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		File file = new File("/app/work/aml-mini/");
		List<File> files = listFile(file, new SqlFileFilter(), true);
		for (File s : files) {
			System.out.println(s);
		}
	}
}