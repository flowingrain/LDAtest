package PreProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 * ������������ĸȫ��д
 * ������һ������ĸСд
 */
public class CreateWordMap {
	public void createMap(String path,String map) throws IOException{
		File file=new File(path);
		File[] tempList=file.listFiles();
		int fileNum=tempList.length;
		String temp=null;
		File fromFile;
		BufferedReader fromReader;
		Set<String> setor=new HashSet<String>();
		Boolean addFlag=false;
		BufferedReader mapReader;
		//���㿪ʼ����setor��
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
			System.out.println("���ڴ����ļ�"+i);
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
	               		 * ����ʱ��ӵĻ����п��ܴ���һ�������ԱȽϴ���ļ�ʱ������ͬһ����
	               		 * �����Ļ���wordmapֻ��Ҫ��һ��
	               		 * �ĵ�ĩβд��
	               		 */                	
                		setor.add(srcStr[j]);
                		System.out.println(srcStr[j]+"����wordmap");
                	}
                }
			}
		}
		/*
		 * mapWriterд�����ļ�
		 */
		 //FileWriter mapWriter = new FileWriter(new File(map),true);
		 BufferedWriter mapWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(map)), "UTF-8"));
		 int mapCount=setor.size();
		 mapWriter.append(mapCount+"\n");//BufferedWriter��append�൱��FileWriter��true��
		 //String word=setor.iterator();
		 Iterator<String> word = setor.iterator();
		/* for(int i=0;i<mapCount;i++)
		 {
			 //��Ŵ�1��ʼ
			 
			 mapWriter.write(setor.iterator().toString()+" "+(i+1)+"\n");
		 }*/
		 int i=0;
		 while(word.hasNext())
		 {
			 mapWriter.append(word.next()+" "+(i++)+"\n");
		 }
		 mapWriter.close();
	}
	public static void main(String[] args) throws IOException
	{
		String path="F:\\���ݼ�\\����΢����ת�����ݼ�\\SegJsonExclude\\";
		String map="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonMap.txt";
		CreateWordMap cwp=new CreateWordMap();
		cwp.createMap(path, map);
	}
}