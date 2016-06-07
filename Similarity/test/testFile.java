import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class pushhash{
    public static void slide_win(){
        int i = 0;
        
    }
}

class ReadFile extends pushhash{
   public static void readFileByChars(String fileName, int max) {  
        File file = new File(fileName);  
        Reader reader = null;  
        try { 
            // 一次读多个字符  
            char[] tempchars = new char[100];  
            //String tempchars = "";
            int charread = 10;  
            reader = new InputStreamReader(new FileInputStream(fileName));  
            System.out.println(reader.read(tempchars));
            //while(reader.read(tempchars) != -1)
            //{  
            for (int i = 0; i < max; i++) {       
                System.out.print(tempchars[i]); 
            }
        }catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  } 
            }
        }  
    }        
}

public class testFile{
    public static void main(String[] args){
        ReadFile T = new ReadFile();
        T.readFileByChars(args[0],  Integer.valueOf(args[1]));
    }
}