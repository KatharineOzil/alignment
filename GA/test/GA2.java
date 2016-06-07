//测试读文件时间


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

public class GA2{
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
        
        String w1 = "TTGAAGGATAGAATATTTTTATGTTTAGGTGATTTTAGTGGTGATTTTTTTGTAATATTGGCATAAGTGTATATAAATTGAGTGGTTAGTATACGGTGTAAAAGTGGTATAACGTATGTATTAAGAGCTGTTATACAATACTTGGGGCCGCCGAATGAGATATAGATATTAAAATGTGGATAATCGTGGGAGTTATGCGTAAATGGCACAGGGTATAGACCGCTGAGGCAAGTGCCGTGAATAATGATGTGAGTGCATTTGGTACTGATTTAGTGAGAATGGGGCCATGGTGTGGAATATGAAAGTAGGGTAAGTTTGAGATGGTATATACTGTAGCATCCGTGTGCGTATGACATATCAGTAGAAGTGAAGGTGAGTGTGGCAAGTGGCGGTGGTGGTAGTGGTGGTATAGAGTGGTAGGGTAAGTATGTATGTATTATTTACGATCATTTGTTAACGTTTCAATATGGAGGGTAGAACAACAGTACAGTGAGTAGGACATGGTGGATGGTAGGGTAATAGTAGGGTAAGTGGTAGTGGAGTTGGATATGGGTAATTGGAGGGTAACGGTTATGGTGGACGGTGGTTAGTGGTAAGTAGAGAGATGATGGATGGTGGTTGGGAGTGGTATGGTTGAATGAGACAGGGTAACGAGTGGGGAGGTAGGGTAATGGAGGGTAGGTTTGGAGACAGGTTCATCAGGGTTAGAATAGGGTACTGTTAGGATTGTGTTAGGGTGTGTGGGTGTGGGTGTGGTGTGTGTGGGTGTGGTGTGTGGGTGTGT";
        char[] w = w1.toCharArray();
        String v1 = "CCACACCACACCCACACACCCACACACCACACCACACACCACACCACACCCACACACACACATCCTAACACTACCCTAACACAGCCCTAATCTAACCCTGGCCAACCTGTCTCTCAACTTACCCTCCATTACCCTGCCTCCACTCGTTACCCTGTCCCATTCAACCATACCACTCCGAACCACCATCCATCCCTCTACTTACTACCACTCACCCACCGTTACCCTCCAATTACCCATATCCAACCCACTGCCACTTACCCTACCATTACCCTACCATCCACCATGACCTACTCACCATACTGTTCTTCTACCCACCATATTGAAACGCTAACAAATGATCGTAAATAACACACACGTGCTTACCCTACCACTTTATACCACCACCACATGCCATACTCACCCTCACTTGTATACTGATTTTACGTACGCACACGGATGCTACAGTATATACCATCTCAAACTTACCCTACTCTCAGATTCCACTTCACTCCATGGCCCATCTCTCACTGAATCAGTACCAAATGCACTCACATCATTATGCACGGCACTTGCCTCAGCGGTCTATACCCTGTGCCATTTACCCATAACGCCCATCATTATCCACATTTTGATATCTATATCTCATTCGGCGGTCCCAAATATTGTATAACTGCCCTTAATACATACGTTATACCACTTTTGCACCATATACTTACCACTCCATTTATATACACTTATGTC";
        char[] v = v1.toCharArray();

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

