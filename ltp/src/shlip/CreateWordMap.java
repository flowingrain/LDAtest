package shlip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
/*
 * 函数单词首字母全大写
 * 变量第一个首字母小写
 */
public class CreateWordMap {
	public void createMap(String path,String map) throws IOException{
		//String path="F:\\数据集\\新浪微博带转发数据集\\JsonContent\\";
		//String map="F:\\数据集\\新浪微博带转发数据集\\JsonMap.txt";
		//String map1="F:\\数据集\\新浪微博带转发数据集\\JsonMap1.txt";
		File file=new File(path);
		File[] tempList=file.listFiles();
		int fileNum=tempList.length;
		String temp=null;
		File fromFile;
		BufferedReader fromReader;
		Set<String> setor=new HashSet<String>();
		Boolean addFlag=false;
		BufferedReader mapReader;
		//从零开始构造setor吧
		/*mapReader=new BufferedReader(new InputStreamReader(new FileInputStream(map),"UTF-8"));
		while((temp=mapReader.readLine())!=null)
		{
			String[] mapStr=temp.split(" ");
			//setor.add(temp);
			setor.add(mapStr[0]);
		}
		System.out.println("WordMap set over ");*/
		for(int i=0;i<fileNum;i++)
		{
			//fromFile=new File(path+(i+1)+".txt");
			//wordmap一行一个term一个序号,空格分割
			/*if(addFlag)
			{
				mapReader=new BufferedReader(new InputStreamReader(new FileInputStream(map),"UTF-8"));
				while((temp=mapReader.readLine())!=null)
				{
					String[] mapStr=temp.split(" ");
					//setor.add(temp);
					setor.add(mapStr[0]);
				}
				System.out.println("WordMap set over for file"+(i+1));
			}*/
			fromReader=new BufferedReader(new InputStreamReader(new FileInputStream(path+i+".txt"),"UTF-8"));
			while((temp=fromReader.readLine())!=null)
			{
				String t = temp.trim();  
                if(t.equals("") )
                {  
                    continue;  
                }
            
                String[] srcStr = temp.split(" ");
                int srcLen=srcStr.length;
                for(int j=0;j<srcLen;j++)
                {
                	if(!setor.contains(srcStr[j]))
                	{
                		/*
	               		 * 不即时添加的话，有可能处理一个差异性比较大的文件时多次添加同一个词
	               		 * 这样的话，wordmap只需要读一次
	               		 * 文档末尾写回
	               		 */                	
                		setor.add(srcStr[j]);
                		System.out.println(srcStr[j]+"加入wordmap");
                	}
                }
			}
		}
		/*
		 * mapWriter写入新文件
		 */
		 FileWriter mapWriter = new FileWriter(new File(map),true);
		 int mapCount=setor.size();
		 mapWriter.write(mapCount+"\n");
		 for(int i=0;i<mapCount;i++)
		 {
			 //序号从1开始
			 mapWriter.write(setor.iterator()+" "+(i+1)+"\n");
		 }
	}
	public static void main(String[] args) throws IOException
	{
		String path="F:\\数据集\\新浪微博带转发数据集\\JsonContent\\";
		String map="F:\\数据集\\新浪微博带转发数据集\\JsonMap.txt";
		CreateWordMap cwp=new CreateWordMap();
		cwp.createMap(path, map);
	}
}