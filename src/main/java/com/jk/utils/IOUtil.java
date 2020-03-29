package com.jk.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * /*
 * 	获取文件扩展名
	删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	获取操作系统用户目录
	返回文件以指定单位大小表示
	<<解析文件>>
 */

public class IOUtil {

	/**
	 * 获取文件扩展名
	 */
	@SuppressWarnings("resource")
	public static String getSuffix(String str){
		File file = new File(str);
		String name = file.getName();
		return name.substring(name.lastIndexOf("."));
	}
	
	
	/**
	 * 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 */
	public static void deleteFile(String path){
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File file2 : files) {
				if(file2.isFile()){
					file2.delete();
				}else{
					String path2 = file2.getPath();
					deleteFile(path2);
				}
			}
		}else{
			file.delete();
		}
		file.delete();
		System.out.println("递归删除成功");
	}
	
	
	
	/**
	 * 获取操作系统用户目录
	 */
	public static String getSystemFile(){
		String userHome = System.getProperty("user.home");
		return userHome;
	}
	
	
	/**
	 * 返回文件以指定单位大小表示
	 * @param path 
	 */
	public static void getFileLength(String path){
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File file2 : files) {
				String path2 = file2.getPath();
				if(file2.isFile()){
					int length = path2.length();
					System.out.println(path2+"的大小为:"+length+"B1");
					//System.out.println(path+"的大小位:"+(length/1024.0)+"KB")
				}else{
					getFileLength(file2.getPath());
				}
			}
		}else{
			String path2 = file.getPath();
			int length = path2.length();
			System.out.println(path2+"的大小为:"+length+"B2");
			//System.out.println(path+"的大小位:"+(length/1024.0)+"KB")
		}
		/*long length = file.length();
		System.out.println(path+"的大小位:"+length+"B");
		System.out.println(path+"的大小位:"+(length/1024.0)+"KB");*/
	}
	
	
	/**
	 * 解析文件
	 * filePath 文件路径
	 * splitsting 切割符号
	 *  
 	 */
	@SuppressWarnings("resource")
	public static List<Object[]> readFile(String filePath,String splitsting) throws IOException{
		try {
			File file = new File(filePath);
			//按行读取
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			List<Object[]> list = new ArrayList<Object[]>();
			while((str=br.readLine())!=null){
				String[] split = str.split(splitsting);
				list.add(split);
			}
			br.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public static  List<Object[]> reading(String path,String split){
		
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			List<Object[]> list = new ArrayList<Object[]>();
				while((str=br.readLine())!=null){
					String[] split2 = str.split(split);
					list.add(split2);
				}
			br.close();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
