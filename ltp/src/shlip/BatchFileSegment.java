package shlip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.hit.ir.ltp4j.Segmentor;
//import sun.nio.ch.IOUtil;

public class BatchFileSegment {
		public  void SegFiles(String srcPath,String desPath) {
			// /MyTest/
			if (Segmentor.create("F:\\ltp\\ltp_data\\cws.model") < 0) {
				System.err.println("load failed");
				return;
			}
			//读取待分词文件
			String temp=null;
			PrintWriter pw=null;
			BufferedReader reader=null;
			//File srcPath=
			File file=new File(srcPath);
			File[] tempList=file.listFiles();
			int fileNum=tempList.length;
			System.out.print(fileNum);
			for(int i=0;i<fileNum;i++)
			{
				try{
					 	reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcPath+i+".txt"),"UTF-8")); 
			            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(desPath+i+".txt"), "UTF-8"), true);
			            long start = System.currentTimeMillis()  ;
			            int allCount =0 ;
			            int TotalSize = 0;
			            Set<String> set = new HashSet<String>();
			            while((temp=reader.readLine())!=null){
			                temp = temp.trim();
			                allCount+=temp.length();
		                    List<String> words=new ArrayList<String>();
		                    int size=Segmentor.segment(temp, words);
		                    TotalSize+=size;
		                    for(int j=0;j<size;j++)
		                    {
		                    	System.out.print(words.get(j));
		                    	pw.print(words.get(j)+" ");
		        				if (j == size - 1) 
		        				{
		        					System.out.println();
		        				} 
		        				else 
		        				{
		        					System.out.print("\t");
		        				}
		                    }
			            }
			            long end = System.currentTimeMillis() ;
			            System.out.println("文件"+i+"共" + TotalSize + "个term，" + set.size() + "个不同的词，共 "
			                    +allCount+" 个字符，每秒处理了:"+(allCount*1000.0/(end-start)));
				} catch(IOException e)
				{
				    e.printStackTrace();
				}finally{
					   if (null != reader) {
			                try {
			                    reader.close();
			                } catch (IOException e) {
			                    e.printStackTrace();
			                }
			            }
			            if (null != pw) {
			                pw.close();
			            }
				}
			}
			Segmentor.release();
		}
		public static void main(String[] args)
		{
			BatchFileSegment bfs=new BatchFileSegment();
			String srcPath="F:\\数据集\\新浪微博带转发数据集\\JsonContent\\";
			String desPath="F:\\数据集\\新浪微博带转发数据集\\SegJson\\";
			bfs.SegFiles(srcPath, desPath);
		}
}