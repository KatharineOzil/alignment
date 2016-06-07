import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;   
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Similarity{
    public static String readFile(String fILE_IN)
    {
        int len = 0;
        StringBuffer str=new StringBuffer("");
        File file = new File(fILE_IN);
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            while( (line = in.readLine()) != null )
            {
                str.append(line);
                len++;            
            }
            in.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str.toString();
    }

    //slide_windows, count the times of String 
    public Map slideWindows(String file, int max){
        file = file.substring(5);
        String key=null;
        int i = 0;
        HashMap<String , Integer> windows = new HashMap<String , Integer>();
        for(i=0; i<file.length()-max+1; i++)
        {
            key = file.substring(i, i+max);
            if(windows.get(key)==null){
                windows.put(key,1);
            }else{
                int n = windows.get(key);
                n += 1;
                windows.put(key,n);
            }
        }
        return windows;
    }

    public int compareFile(Map map1, Map map2){
        int comm = 0;
        Set set = map1.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            //int number1 = (Integer)map1.get(key);
            if(map2.get(key) != null){
                System.out.print(key+" ");
                if((Integer)map1.get(key) < (Integer)map2.get(key))
                    comm += (Integer)map1.get(key);
                else
                    comm += (Integer)map2.get(key);
            }
        }
        return comm;
    } 

    public double result_similarity(String file1, String file2, int comm){
        if(file1.length() < file2.length())
            return (double)comm/file1.length();
        else
            return (double)comm/file2.length();
    }
}


public class Find_Similarity{
    public static void main(String[] argv)
    {
        Similarity r = new Similarity();
        //String file1 = r.readFile(argv[0]);
        //String file2 = r.readFile(argv[1]);
        Map map1 = r.slideWindows(r.readFile(argv[0]), Integer.valueOf(argv[2]));
        Map map2 = r.slideWindows(r.readFile(argv[1]), Integer.valueOf(argv[2]));
        //System.out.print(map1);
        //System.out.println();
        //System.out.print(map2);
        int comm = r.compareFile(map1, map2);
        //System.out.println();
        //System.out.print(comm);
        double similarity = r.result_similarity(r.readFile(argv[0]), r.readFile(argv[1]), r.compareFile(map1, map2));
        String format_similarity = String.format("%.4f", similarity);
        System.out.println();
        System.out.println(argv[0]+" VS "+argv[1]+":   "+format_similarity);
    }
}