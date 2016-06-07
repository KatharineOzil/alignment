//测试转换时间


class GlobalAlignment{

   

    public void lcs(int[][] b, char v[], char w[], int n, int m)
    {
        int i, j;
        int s[][] = new int[1000][1000];

        for(i = 0; i <= n; i++)
            s[i][0] = 0;
        for(j=1; j<=m; j++)
            s[0][j] = 0;
        for(i=1; i<=n; i++){
            for(j=1; j<=m; j++)
            {
                if(v[i-1] == w[j-1]){
                    //s[i][j] = max(s[i-1][j], s[i][j-1], s[i-1][j-1]+1);
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

public class GA1{
    public static void main(String[] argv)
    {
        int i=0;
        int j=0;
        int b[][] = new int[1000][1000];
        //String[] v = {"A","C","A","C","A","C","T","A"};
        //String[] w = {"A","G","C","A","C","A","C","A"};

        //int n = v.length;
        //int m = w.length;

        //char v[] = {'A','C','A','C','A','C','T','A'};
        //char w[] = {'A','G','C','A','C','A','C','A'};

        GlobalAlignment g = new GlobalAlignment();
        
        //char[] content1 = g.stringtoChar(g.readFile(argv[0]));
        //char[] content2 = g.stringtoChar(g.readFile(argv[1]));
        //System.out.print(g.stringtoChar(content));
        
        char[] w = {'T','T','G','A','A','G','G','A','T','A','G','A','A','T','A','T','T','T','T','T','A','T','G','T','T','T','A','G','G','T','G','A','T','T','T','T','A','G','T','G','G','T','G','A','T','T','T','T','T','T','T','G','T','A','A','T','A','T','T','G','G','C','A','T','A','A','G','T','G','T','A','T','A','T','A','A','A','T','T','G','A','G','T','G','G','T','T','A','G','T','A','T','A','C','G','G','T','G','T','A','A','A','A','G','T','G','G','T','A','T','A','A','C','G','T','A','T','G','T','A','T','T','A','A','G','A','G','C','T','G','T','T','A','T','A','C','A','A','T','A','C','T','T','G','G','G','G','C','C','G','C','C','G','A','A','T','G','A','G','A','T','A','T','A','G','A','T','A','T','T','A','A','A','A','T','G','T','G','G','A','T','A','A','T','C','G','T','G','G','G','A','G','T','T','A','T','G','C','G','T','A','A','A','T','G','G','C','A','C','A','G','G','G','T','A','T','A','G','A','C','C','G','C','T','G','A','G','G','C','A','A','G','T','G','C','C','G','T','G','A','A','T','A','A','T','G','A','T','G','T','G','A','G','T','G','C','A','T','T','T','G','G','T','A','C','T','G','A','T','T','T','A','G','T','G','A','G','A','A','T','G','G','G','G','C','C','A','T','G','G','T','G','T','G','G','A','A','T','A','T','G','A','A','A','G','T','A','G','G','G','T','A','A','G','T','T','T','G','A','G','A','T','G','G','T','A','T','A','T','A','C','T','G','T','A','G','C','A','T','C','C','G','T','G','T','G','C','G','T','A','T','G','A','C','A','T','A','T','C','A','G','T','A','G','A','A','G','T','G','A','A','G','G','T','G','A','G','T','G','T','G','G','C','A','A','G','T','G','G','C','G','G','T','G','G','T','G','G','T','A','G','T','G','G','T','G','G','T','A','T','A','G','A','G','T','G','G','T','A','G','G','G','T','A','A','G','T','A','T','G','T','A','T','G','T','A','T','T','A','T','T','T','A','C','G','A','T','C','A','T','T','T','G','T','T','A','A','C','G','T','T','T','C','A','A','T','A','T','G','G','A','G','G','G','T','A','G','A','A','C','A','A','C','A','G','T','A','C','A','G','T','G','A','G','T','A','G','G','A','C','A','T','G','G','T','G','G','A','T','G','G','T','A','G','G','G','T','A','A','T','A','G','T','A','G','G','G','T','A','A','G','T','G','G','T','A','G','T','G','G','A','G','T','T','G','G','A','T','A','T','G','G','G','T','A','A','T','T','G','G','A','G','G','G','T','A','A','C','G','G','T','T','A','T','G','G','T','G','G','A','C','G','G','T','G','G','T','T','A','G','T','G','G','T','A','A','G','T','A','G','A','G','A','G','A','T','G','A','T','G','G','A','T','G','G','T','G','G','T','T','G','G','G','A','G','T','G','G','T','A','T','G','G','T','T','G','A','A','T','G','A','G','A','C','A','G','G','G','T','A','A','C','G','A','G','T','G','G','G','G','A','G','G','T','A','G','G','G','T','A','A','T','G','G','A','G','G','G','T','A','G','G','T','T','T','G','G','A','G','A','C','A','G','G','T','T','C','A','T','C','A','G','G','G','T','T','A','G','A','A','T','A','G','G','G','T','A','C','T','G','T','T','A','G','G','A','T','T','G','T','G','T','T','A','G','G','G','T','G','T','G','T','G','G','G','T','G','T','G','G','G','T','G','T','G','G','T','G','T','G','T','G','T','G','G','G','T','G','T','G','G','T','G','T','G','T','G','G','G','T','G','T','G','T'};
        //char[] w = w1.toCharArray();
        char[] v = {'C','C','A','C','A','C','C','A','C','A','C','C','C','A','C','A','C','A','C','C','C','A','C','A','C','A','C','C','A','C','A','C','C','A','C','A','C','A','C','C','A','C','A','C','C','A','C','A','C','C','C','A','C','A','C','A','C','A','C','A','C','A','T','C','C','T','A','A','C','A','C','T','A','C','C','C','T','A','A','C','A','C','A','G','C','C','C','T','A','A','T','C','T','A','A','C','C','C','T','G','G','C','C','A','A','C','C','T','G','T','C','T','C','T','C','A','A','C','T','T','A','C','C','C','T','C','C','A','T','T','A','C','C','C','T','G','C','C','T','C','C','A','C','T','C','G','T','T','A','C','C','C','T','G','T','C','C','C','A','T','T','C','A','A','C','C','A','T','A','C','C','A','C','T','C','C','G','A','A','C','C','A','C','C','A','T','C','C','A','T','C','C','C','T','C','T','A','C','T','T','A','C','T','A','C','C','A','C','T','C','A','C','C','C','A','C','C','G','T','T','A','C','C','C','T','C','C','A','A','T','T','A','C','C','C','A','T','A','T','C','C','A','A','C','C','C','A','C','T','G','C','C','A','C','T','T','A','C','C','C','T','A','C','C','A','T','T','A','C','C','C','T','A','C','C','A','T','C','C','A','C','C','A','T','G','A','C','C','T','A','C','T','C','A','C','C','A','T','A','C','T','G','T','T','C','T','T','C','T','A','C','C','C','A','C','C','A','T','A','T','T','G','A','A','A','C','G','C','T','A','A','C','A','A','A','T','G','A','T','C','G','T','A','A','A','T','A','A','C','A','C','A','C','A','C','G','T','G','C','T','T','A','C','C','C','T','A','C','C','A','C','T','T','T','A','T','A','C','C','A','C','C','A','C','C','A','C','A','T','G','C','C','A','T','A','C','T','C','A','C','C','C','T','C','A','C','T','T','G','T','A','T','A','C','T','G','A','T','T','T','T','A','C','G','T','A','C','G','C','A','C','A','C','G','G','A','T','G','C','T','A','C','A','G','T','A','T','A','T','A','C','C','A','T','C','T','C','A','A','A','C','T','T','A','C','C','C','T','A','C','T','C','T','C','A','G','A','T','T','C','C','A','C','T','T','C','A','C','T','C','C','A','T','G','G','C','C','C','A','T','C','T','C','T','C','A','C','T','G','A','A','T','C','A','G','T','A','C','C','A','A','A','T','G','C','A','C','T','C','A','C','A','T','C','A','T','T','A','T','G','C','A','C','G','G','C','A','C','T','T','G','C','C','T','C','A','G','C','G','G','T','C','T','A','T','A','C','C','C','T','G','T','G','C','C','A','T','T','T','A','C','C','C','A','T','A','A','C','G','C','C','C','A','T','C','A','T','T','A','T','C','C','A','C','A','T','T','T','T','G','A','T','A','T','C','T','A','T','A','T','C','T','C','A','T','T','C','G','G','C','G','G','T','C','C','C','A','A','A','T','A','T','T','G','T','A','T','A','A','C','T','G','C','C','C','T','T','A','A','T','A','C','A','T','A','C','G','T','T','A','T','A','C','C','A','C','T','T','T','T','G','C','A','C','C','A','T','A','T','A','C','T','T','A','C','C','A','C','T','C','C','A','T','T','T','A','T','A','T','A','C','A','C','T','T','A','T','G','T','C'};
        //char[] v = v1.toCharArray();

        int n = new String(v).trim().length();
        int m = new String(w).trim().length();

        g.lcs(b,v,w,n,m);

        /*for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }*/

        g.printLCS(b, v, n, m);

        //System.out.println();
    }
}

