import java.lang.String;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  

class LocalAlignment{

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

    public char[] stringtoChar(String content){
        char[] ch = content.toCharArray();
        return ch;
    }

	public void LCS(char str1[], char str2[]){
		int len1 = new String(str1).trim().length();
		int len2 = new String(str2).trim().length();
		int maxLen = len1 > len2 ? len1 : len2;
		int c[] = new int[maxLen+1];
		int i = 0;
		int j = 0;
		int max[] = new int[maxLen+1];
		int maxIndex[] = new int[maxLen+1];
		int k = 0;
		
		for(i = 0; i < len2; i++){
			for(j = len1-1; j >= 0; j--){
				if(str2[i] == str1[j]){
					if(i == 0 || j == 0)
						c[j] = 1;
					else
						c[j] = c[j-1]+1;
				}
				else
					c[j] = 0;
				if(c[j] > max[0]){
					max[0] = c[j];
					maxIndex[0] = j;
					for(k = 1; k < maxLen; k++){
						max[k] = 0;
						maxIndex[k] = 0;
					}
				}
				else if(c[j] == max[0]){
					for(k = 1; k < maxLen; k++){
						if(max[k] == 0){
							max[k] = c[j];
							maxIndex[k] = j;
							break;
						}
					}
				}
			}
		}
		for( j = 0; j < maxLen; j++){
			if(max[j] > 0){
				for(i = maxIndex[j]-max[j]+1; i <= maxIndex[j]; i++)
					System.out.print(str1[i]);
				System.out.println();
			}
		}
	}
}

public class LA{
	public static void main(String[] argv){
		LocalAlignment l = new LocalAlignment();
		char[] str1 = l.stringtoChar(l.readFile(argv[0]));
		char[] str2 = l.stringtoChar(l.readFile(argv[1]));
		l.LCS(str1, str2);
	}
}
