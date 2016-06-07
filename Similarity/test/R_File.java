import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  

class fopenFile{
	public static void ReadFile(String filename){
		BufferedReader bre = null;
		try {
			String file = filename;//文件地址
			bre = new BufferedReader(new FileReader(file));//获取到的bre就是整个文件的缓存流
			while ( bre.read() != -1) {// 判断是否为最后一个字节，若是则结束循环
				System.out.println(bre.read());//输出读到的内容
			};
			bre.close();
		}catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (bre != null) {  
                try {  
                    bre.close();  
                } catch (IOException e1) {  } 
            }
        }  
	}
}

public class R_File{
	public static void main(String[] argv)
	{
		fopenFile R = new fopenFile();
		R.ReadFile(argv[0]);
	}
}