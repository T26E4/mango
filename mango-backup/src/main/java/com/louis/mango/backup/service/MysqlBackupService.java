package com.louis.mango.backup.service;

/**
 * mysql 命令行备份恢复服务
 * @author Administrator
 *
 */
public interface MysqlBackupService {
	/**
	 * 备份
	 * @param host     地址可以是本机也可以是远程，
	 * @param userName 数据库用户名
	 * @param password 数据库密码
	 * @param backupFolderPath  备份的路径
	 * @param fileName  备份的文件名
	 * @param database  需要备份的数据库名称
	 * @return
	 * @throws Exception
	 */
	boolean backup(String host,String userName,String password,String backupFolderPath,String fileName,String database) throws Exception;
	
	
	/**
	 * 回复数据库
	 * @param restoreFilePath   数据据库备份的脚本
	 * @param host  数据库IP
	 * @param userName 用户名
	 * @param password 密码
	 * @param database 数据库名
	 * @return
	 * @throws Exception
	 */
	boolean restore(String restoreFilePath,String host,String userName,String password,String database) throws Exception;
}
