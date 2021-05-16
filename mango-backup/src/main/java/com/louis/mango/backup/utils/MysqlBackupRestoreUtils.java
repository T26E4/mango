package com.louis.mango.backup.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MysqlBackupRestoreUtils {

	/**
	 * 备份
	 * @param host
	 * @param userName
	 * @param password
	 * @param backupFolderPath
	 * @param fileName
	 * @param database
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static boolean  backup(String host,String userName,String password,String backupFolderPath,String fileName,String database) throws IOException, InterruptedException {
		File backupFolderFile = new File(backupFolderPath);
		if (!backupFolderFile.exists()) {
			// 如果目录不存在则创建
			backupFolderFile.mkdirs();
		}
		if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
			backupFolderPath = backupFolderPath + File.separator;
		}
		// 拼接命令行的命令
		String backupFilePath = backupFolderPath + fileName;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
		stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
		stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database).append(" \n");
		// 调用外部执行 exe 文件的 Java API
		Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
		
		// 标准输入流（必须写在 waitFor 之前）
//		String inStr = consumeInputStream(process.getInputStream());
		// 标准错误流（必须写在 waitFor 之前）
		String errStr = consumeInputStream(process.getErrorStream());
		new ProcessClearStream(process.getInputStream(), "INFO").start();
		new ProcessClearStream(process.getErrorStream(), "ERROR").start();
		if (process.waitFor() == 0) {
			// 0 表示线程正常终止
			System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
			return true;
		}
		System.out.println("数据备份失败" + errStr);
		return false;
	}
	
	private static String[] getCommand(String command) {
		String os = System.getProperty("os.name");  
		String shell = "/bin/bash";
		String c = "-c";
		if(os.toLowerCase().startsWith("win")){  
			shell = "cmd";
			c = "/c";
		}  
		String[] cmd = { shell, c, command };
		return cmd;
	}
	
	/**
     * 消费inputstream，并返回
     */
    public static String consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            sb.append(s);
        }
        return sb.toString();
    }
    
    /**
     * 还原数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
	public static boolean restore(String restoreFilePath, String host, String userName, String password, String database)
			throws Exception {
		File restoreFile = new File(restoreFilePath);
		if (restoreFile.isDirectory()) {
			for (File file : restoreFile.listFiles()) {
				if (file.exists() && file.getPath().endsWith(".sql")) {
					restoreFilePath = file.getAbsolutePath();
					break;
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
		stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
		try {
			Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
			if (process.waitFor() == 0) {
				System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}


class ProcessClearStream extends Thread {
	private InputStream inputStream;
	private String type;
 
	ProcessClearStream(InputStream inputStream, String type) {
		this.inputStream = inputStream;
		this.type = type;
	}
 
	public void run() {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader br = new BufferedReader(inputStreamReader);
			// 打印信息
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(type + ">" + line);
			}
			// 不打印信息
//			 while (br.readLine() != null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}