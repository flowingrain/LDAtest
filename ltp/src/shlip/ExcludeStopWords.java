package shlip;

/*
 public static void refineNoun() throws IOException{  
        String filestopwords = "E:/datamining/ICTCLAS50_Windows_32_JNI/Sample/Windows_32_jni_Demo/file/stop_words_ch.txt";//停用詞表  
        File fsw = new File(filestopwords);  
        BufferedReader stopreader = new BufferedReader(new FileReader(fsw));  
        Set <String> setor = new HashSet <String>();  
        String tempt = null;  
        while((tempt = stopreader.readLine()) != null){  
            setor.add(tempt);  
        }  
        System.out.println("set over!");  
        for(int j=0;j<=9;j++){  
            for(int i=10;i<=1999;i++){  
  
                String Outputfilename = "E:/datamining/ICTCLAS50_Windows_32_JNI/Sample/Windows_32_jni_Demo/file/"+j+"/"+"result_"+i+".txt";  
                File file = new File(Outputfilename);  
                  
                  
                if(!file.exists()) continue;  
                  
                  
                  
                BufferedReader reader = new BufferedReader(new FileReader(file));  
                  
                String filenewname = "E:/datamining/ICTCLAS50_Windows_32_JNI/Sample/Windows_32_jni_Demo/file/"+j+"/"+"result_data_"+i+".txt";  
                File fileout = new File(filenewname);  
                FileWriter fw = new FileWriter(fileout);                  
                      
                String tmp = null;  
                try {  
                    while((tmp = reader.readLine()) !=null){  
                        String t = tmp.trim();  
                        if(t.equals("") ){  
                            continue;  
                        }else{  
                            tmp = " "+tmp;  
                        }  
                        //System.out.println(tmpString);  
                        String[] str = tmp.split(" ");  
                        for(int k=0;k<str.length;k++){  
                            int  m = str[k].indexOf("/");  
                              
                            if(m != -1){  
                                String x = str[k].substring(m, str[k].length());  
                                String o = str[k].substring(0, m).replaceAll("[a-zA-Z0-9\\pP‘’“”]*", "");  
                                if(x.indexOf('n') != -1 && !(setor.equals(o))){  
                                    fw.write(o+" ");  
                                    fw.flush();  
                            }else{  
                                k++;  
                            }  
  
                            }  
                        }                             
                    }  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
  
                fw.close();   
                //System.out.println(i+"once over!");  
                  
            }  
        }  
          
    }   
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ExcludeStopWords {
    public static void refineNoun(String srcFile,String desFile) throws IOException{  
        //停用词文件
    	String filestopwords = "F:\\数据集\\stop_words_li.txt";
        BufferedReader stopreader = new BufferedReader(new InputStreamReader(new FileInputStream(filestopwords),"UTF-8"));  
        Set <String> setor = new HashSet <String>();  
        String tempt = null;  
        while((tempt = stopreader.readLine()) != null)
        {  
        	System.out.println(tempt);
            setor.add(tempt);  
        }  
        System.out.println("Stop words set over!");  
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile),"UTF-8")); 
        File outFile = new File(desFile);  
        FileWriter fw = new FileWriter(outFile,true);                  
        String tmp = null;  
        try {  
           while((tmp = reader.readLine()) !=null)
            {  
                String t = tmp.trim();  
                if(t.equals("") )
                {  
                    continue;  
                }
            
                String[] str = tmp.split(" ");  
                for(int k=0;k<str.length;k++)
                {  
                   System.out.println(str[k]);
                	if(!setor.contains(str[k]))
                    {  
                		System.out.println(str[k]+" 不是停用词，已加入文件");
                        fw.write(str[k]+" ");  
                        fw.flush();  
                    }
                    else
                    {  
                    	System.out.println(str[k]+" 为停用词，已去除");
                    	//k++;  
                    	//多加了一次
                    }
                  } 
                fw.write("\n");
                }      
    
        }
        catch (IOException e) 
        {  
            e.printStackTrace();  
        }  
        fw.close();               
    }  
    
    public static void main(String[] args) throws IOException
    {
    	String srcPath="F:\\数据集\\新浪微博带转发数据集\\SegJson\\";
		String desPath="F:\\数据集\\新浪微博带转发数据集\\SegJsonExclude\\";
    	File file=new File(srcPath);
		File[] tempList=file.listFiles();
		int fileNum=tempList.length;
		System.out.print(fileNum);
		for(int i=0;i<fileNum;i++)
		{
			System.out.println("正在处理文件"+i+".txt");
			ExcludeStopWords.refineNoun(srcPath+i+".txt",desPath+i+".txt");
		}
    }
}