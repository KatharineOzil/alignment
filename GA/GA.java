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

class GlobalAlignment{

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


    /*public int max(int a, int b, int c)
    {
        return (a > b? a : b) > c ? (a > b? a : b) : c;
    }*/

    public void lcs(int[][] b, char v[], char w[], int n, int m)
    {
        int i, j;
        //int s[][] = new int[1000][1000];
        int maxlen = m > n ? m : n;
        int s[][] = new int[maxlen+1][maxlen+1];

        for(i = 0; i <= n; i++)
            s[i][0] = 0;
        for(j=1; j<=m; j++)
            s[0][j] = 0;
        for(i=1; i<=n; i++){
            for(j=1; j<=m; j++)
            {
                if(v[i-1] == w[j-1]){
                    s[i][j] = s[i-1][j-1] + 1;
                    b[i][j] = 0; 
                }
                else if(s[i-1][j] >= s[i][j-1]){
                    s[i][j] = s[i-1][j];
                    b[i][j] = 1;
                }
                else{
                    s[i][j] = s[i][j-1];
                    b[i][j] = -1;
                }
            }
        }
    }

    public void printLCS(int b[][], char v[], int i, int j)
    {
        if(i == 0 || j==0)
            return;
        if(b[i][j] == 0)
        {
            printLCS(b, v, i-1, j-1);
            System.out.print(v[i-1]);
        }
        else if(b[i][j] == 1)
            printLCS(b, v, i-1, j);
        else
            printLCS(b, v, i, j-1);
    }

}

public class GA{
    public static void main(String[] argv)
    {
        int i=0;
        int j=0;
        //int b[][] = new int[1000][1000];
        //String[] v = {"A","C","A","C","A","C","T","A"};
        //String[] w = {"A","G","C","A","C","A","C","A"};

        //int n = v.length;
        //int m = w.length;

        //char v[] = {'A','C','A','C','A','C','T','A'};
        //char w[] = {'A','G','C','A','C','A','C','A'};

        GlobalAlignment g = new GlobalAlignment();
        
        char[] content1 = g.stringtoChar(g.readFile(argv[0]));
        char[] content2 = g.stringtoChar(g.readFile(argv[1]));
        
        int n = new String(content1).trim().length();
        int m = new String(content2).trim().length();
        int maxlen = m > n ? m : n;
        int b[][] = new int[maxlen+1][maxlen+1];

        g.lcs(b,content1,content2,n,m);

        /*for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
*/
        g.printLCS(b, content1, n, m);

    }
}

