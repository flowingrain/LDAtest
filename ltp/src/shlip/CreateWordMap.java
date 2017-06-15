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
 * ������������ĸȫ��д
 * ������һ������ĸСд
 */
public class CreateWordMap {
	public void createMap(String path,String map) throws IOException{
		//String path="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonContent\\";
		//String map="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonMap.txt";
		//String map1="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonMap1.txt";
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
			//fromFile=new File(path+(i+1)+".txt");
			//wordmapһ��һ��termһ�����,�ո�ָ�
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
		 FileWriter mapWriter = new FileWriter(new File(map),true);
		 int mapCount=setor.size();
		 mapWriter.write(mapCount+"\n");
		 for(int i=0;i<mapCount;i++)
		 {
			 //��Ŵ�1��ʼ
			 mapWriter.write(setor.iterator()+" "+(i+1)+"\n");
		 }
	}
	public static void main(String[] args) throws IOException
	{
		String path="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonContent\\";
		String map="F:\\���ݼ�\\����΢����ת�����ݼ�\\JsonMap.txt";
		CreateWordMap cwp=new CreateWordMap();
		cwp.createMap(path, map);
	}
}