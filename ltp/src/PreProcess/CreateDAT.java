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
		 * DAT�ļ���һ��Ϊ�ĵ���
		 * �ڶ��п�ʼ��ÿ��Ϊһ���ĵ���ȥ��ͣ�ôʺ��term��
		 * term����ظ�
		 * ����Ȩ��ͨ���ظ���ģ���л�ü���
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
		String srcPath="F:\\���ݼ�\\����΢����ת�����ݼ�\\SegJsonExclude\\";
		String datFile="F:\\���ݼ�\\����΢����ת�����ݼ�\\weiboDat.txt";
		CreateDAT cd=new CreateDAT();
		cd.CreateWeiboDAT(srcPath, datFile);
	}
}