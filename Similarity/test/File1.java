import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  
import java.util.regex.*;

class readFile{
    /*public static void deleteWhite(String fileName){
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./")));
        String str;
        while((str=br.readLine())!=null) {
        String s =str;
        s.replace("\\s","");
        }
    }*/
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            //System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll("\\s","");
                System.out.println(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }


}

public class File1{
    public static void main(String[] args){
        readFile R = new readFile();
        R.readFileByLines(args[0]);
    }
}