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
        //file = file.substring(5);
        int file_len;
        String key=null;
        int i = 0;
        HashMap<String , Integer> windows = new HashMap<String , Integer>();
        for(i=0; i<file.length()-max+1; i++)
        {
            key = file.substring(i, i+max);
            //System.out.print(key+"  ");
            if(windows.get(key)==null){
                windows.put(key,1);
                //System.out.print(key+" 1"+" ");
            }else{
                int n = windows.get(key);
                n += 1;
                windows.put(key,n);
                //System.out.print(key+" "+n+" ");
            }
            //file_len += 1;
        }
        //this.file_len = file_len;
        return windows;
    }

    public int compareFile(Map map1, Map map2){
        int comm = 0;
        Set set = map1.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            if(map2.get(key) != null){
                //System.out.print(map2.get(key)+" ");
                if((Integer)map1.get(key) < (Integer)map2.get(key)){
                    comm += (Integer)map1.get(key);
                }
                else{
                    comm += (Integer)map2.get(key);
                }
            }
        }
        return comm;
    } 

    public double result_similarity(Map map1, Map map2, int comm){
        int file_len1 = 0;
        Iterator i1 = map1.keySet().iterator();
        while(i1.hasNext()){
            String key = (String)i1.next();
            file_len1 += (Integer)map1.get(key);
        }
        

        int file_len2 = 0;
        Iterator i2 = map2.keySet().iterator();
        while(i2.hasNext()){
            String key = (String)i2.next();
            file_len2 += (Integer)map2.get(key);
        }

        //int sum1 = 0;
        //int sum2 = 0;

        //int file_len1 = map1.values().toArray().length;
        //int file_len2 = map2.values().toArray().length;

        //System.out.println(file_len1);
        //System.out.println(file_len2);
        //System.out.println(comm);

        if(file_len1 < file_len2)
            return (double)comm/file_len1;
        else
            return (double)comm/file_len2;
    }
}


public class Find_Similarity519{
    public static void main(String[] argv)
    {
        Similarity r = new Similarity();
        //String file1 = r.readFile(argv[0]);
        //String file2 = r.readFile(argv[1]);

        Map map1 = r.slideWindows(r.readFile(argv[0]), Integer.valueOf(argv[2]));
        //System.out.println();
        //System.out.print(map1);
        Map map2 = r.slideWindows(r.readFile(argv[1]), Integer.valueOf(argv[2]));
        //System.out.print(map2);
        int comm = r.compareFile(map1, map2);
        //System.out.println();
        //System.out.println(comm);
        double similarity = r.result_similarity(map1, map2, comm);
        String format_similarity = String.format("%.4f", similarity);
        //System.out.println();
        System.out.println(argv[0]+" VS "+argv[1]+":   "+format_similarity);
    }
}
