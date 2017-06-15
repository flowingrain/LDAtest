package PreProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CreateDAT {
	
	public void CreateWeiboDAT(String srcPath,String datFile ) throws UnsupportedEncodingException, FileNotFoundException
	{
		/*
		 * DAT文件第一行为文档数
		 * 第二行开始，每行为一个文档的去除停用词后的term项
		 * term项可重复
		 * 词项权重通过重复在模型中获得计算
		 */
		File pathFile=new File(srcPath);
		File[] tempList=pathFile.listFiles();
		int fileNum=tempList.length;
		BufferedWriter datWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(datFile)), "UTF-8"));
		String tempStr;
		//for(int i=0;i<fileNum;i++)
		BufferedReader tempReader;
		for(int i=0;i<fileNum;i++)
		{
			//tempStr=tempList[i].toString();
			 tempReader= new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i]),"UTF-8"));
			 
		}		
	}
	
	public static void main(String[] args) throws IOException
	{
		String srcPath="F:\\数据集\\新浪微博带转发数据集\\SegJsonExclude\\";
		String datFile="F:\\数据集\\新浪微博带转发数据集\\weiboDat.txt";
		CreateDAT cd=new CreateDAT();
		cd.CreateWeiboDAT(srcPath, datFile);
	}
}