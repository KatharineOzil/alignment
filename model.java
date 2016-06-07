import java.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;   
import java.util.ArrayList;
import java.io.PrintStream;
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.String;

public class model
{
	public static void main(String[] args)
	{
		new FrameInOut();
	}
}

class FrameInOut extends Frame implements ActionListener
{
	JButton btn1,btn2,btn3,btn4,btn5,open1,open2,confirm_sim,confirm_ga,confirm_la;
	JTextArea ta,ta0,ta1,ta2,ta3;
	JPanel p0,p1,p2,p3,p4;
	String file1, file2, filename1, filename2;

	FrameInOut()
	{
		super("序列处理工具");

		/*初始化各个按钮*/
		btn1=new JButton("简易相似度");
		btn2=new JButton("局部比对");
		btn3=new JButton("全局比对");
		btn4=new JButton("帮助");
		btn5=new JButton("退出");
		open1=new JButton("选择序列1");
		open2=new JButton("选择序列2");
		confirm_sim=new JButton("进行相似度计算");
		confirm_la=new JButton("进行局部比对");
		confirm_ga=new JButton("进行全局比对");

		/*初始化文本域*/
		/*初始化文本域的大小，行列数*/
		ta =new JTextArea(1,1);
		ta0=new JTextArea(10,40);
		ta1=new JTextArea(10,25);
		ta2=new JTextArea(10,25);
		ta3=new JTextArea(10,50);
		ta0.setLineWrap(true);
		ta1.setLineWrap(true);
		ta2.setLineWrap(true);
		ta3.setLineWrap(true);

		/*初始化面板，将个空间加入容器*/
		p0=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();

		p0.add(btn1);
		p0.add(btn2);
		p0.add(btn3);
		p0.add(btn4);
		p0.add(btn5);
		p1.add(ta);
		ta.append("请选择所需功能");
		p1.setPreferredSize(new Dimension(300, 50));
		p4.setPreferredSize(new Dimension(700,50));
		ta.setFont(new Font("楷体",Font.PLAIN,20));  

		add(p0);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setLayout(new FlowLayout());
		
		/*各个按钮注册事件监听器*/
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		open1.addActionListener(this);
		open2.addActionListener(this);
		confirm_sim.addActionListener(this);
		confirm_ga.addActionListener(this);
		confirm_la.addActionListener(this);

		setSize(700,600);//设置界面尺寸
		setVisible(true);
	}

	public String fileChoose(){
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		if(file.isDirectory()){
			System.out.println("文件夹:"+file.getAbsolutePath());
		}else if(file.isFile()){
			System.out.println("文件:"+file.getAbsolutePath());
		}
		return jfc.getSelectedFile().getName();

	}

/*重载ActionListener接口的方法，实现各按钮名副其实的功能*/
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			ta.setText(null);
			ta.append("简易相似度");
			p2.removeAll();
			p3.removeAll();
			p4.removeAll();
			p2.add(ta1);
			p2.add(ta2);
			ta1.setText(null);
			ta2.setText(null);
			p3.add(open1);
			p3.add(open2);
			p4.add(confirm_sim);
			p2.revalidate(); 
			p3.revalidate(); 
			p4.revalidate(); 
		}

		if(e.getSource()==btn2)
		{
			ta.setText(null);
			ta.append("局部比对");
			p2.removeAll();
			p3.removeAll();
			p4.removeAll();
			p2.add(ta1);
			p2.add(ta2);
			ta1.setText(null);
			ta2.setText(null);
			p3.add(open1);
			p3.add(open2);
			p4.add(confirm_la);
			p2.revalidate(); 
			p3.revalidate(); 
			p4.revalidate(); 
		}

		if(e.getSource()==btn3)
		{
			ta.setText(null);
			ta.append("全局比对");
			p2.removeAll();
			p3.removeAll();
			p4.removeAll();
			p2.add(ta1);
			p2.add(ta2);
			ta1.setText(null);
			ta2.setText(null);
			p3.add(open1);
			p3.add(open2);
			p4.add(confirm_ga);
			p2.revalidate(); 
			p3.revalidate(); 
			p4.revalidate(); 
		}

		if(e.getSource()==btn4)
		{
			ta.setText(null);
			ta.append("使用说明");
			p2.removeAll();
			p3.removeAll();
			p4.removeAll();
			p2.add(ta0);
			p2.revalidate(); 
			ta0.setText(null);
			ta0.append("本款小工具适用于生物双序列分析。"+"\n");
			ta0.append("主要功能包括序列相似度计算、全局比对和局部比对。"+"\n");
			ta0.append("使用时，点击所需要的功能，在文件选择器中选择两条序列后，点击“确定”按钮即可进行比对。"+"\n"+"\n");
			ta0.append("全局比对"+"\n");
			ta0.append("全局比对寻找的是整个两条字符串之间的相似性。当字符串之间的相似性扩展到整个长度时，是非常有用的。全局比对相对应于在编辑图中寻找顶点到顶点之间的最长局部路径。"+"\n");			
			ta0.append("\n");
			ta0.append("局部比对"+"\n");
			ta0.append("有些蛋白质序列具有高度保守型。并且在许多生物中有着几乎相同的长度。例如，同源异型框中的同源异型域是非常保守的。这时，就需要思考如何找到这个保守区域同时忽略相似性很低的其他区域。因而，可以使用局部比对进行处理。局部比对相应在编辑图中任意顶点之间的所有路径中寻找一条最长的路径。"+"\n");
			ta0.append("\n"+"简易相似度"+"\n");
			ta0.append("简易相似度用于双长度相近序列。进行序列内内容相似度计算。"+"\n");
			ta0.append("利用了滑动窗口思想对序列进行相似性计算。如果两条序列可能存在密切关系，只为了确认这点的话，完全可以利用相似度来进行验证。而如果要得到是哪些基因导致的相似度高的话，就利用全局比对功能进行。"+"\n");
		}

		if(e.getSource()==btn5)
		{
			dispose();
			System.exit(0);
		}

		if(e.getSource()==open1 || e.getSource()==open2)    //文件选择器
		{
			FileRead f = new FileRead();
			String filename = this.fileChoose();
			if(e.getSource()==open1){
				ta1.setText(null);
				ta1.append(filename+"\n");
				if((f.readFile(filename)).length() >= 200){
					ta1.append((f.readFile(filename)).substring(0,200));
					this.file1 = f.readFile(filename);
				}
				else
					ta1.append(f.readFile(filename));
			}
			else{
				ta2.setText(null);
				ta2.append(filename+"\n");
				if((f.readFile(filename)).length() >= 200){
					ta2.append((f.readFile(filename)).substring(0,200));
					this.file2 = f.readFile(filename);
				}
				else
					ta2.append(f.readFile(filename));
			}
		}

		if(e.getSource()==confirm_sim)
		{
			p3.removeAll();
			p4.removeAll();
			p3.add(ta3);
			ta3.setText(null);
			p3.revalidate();
			FileRead f = new FileRead();
			//String filename1 = this.filename1;
			//String filename2 = this.filename2;
			Similarity s = new Similarity();	
			Map map1 = s.slideWindows(this.file1);
			Map map2 = s.slideWindows(this.file2);
			int comm = s.compareFile(map1, map2);
			double result = s.result_similarity(map1, map2, comm);
			//String similarity = Double.toString(result);
			String format_similarity = String.format("%.4f", result);
			ta3.append(format_similarity);
		}

		if(e.getSource()==confirm_la)
		{
			p3.removeAll();
			p4.removeAll();
			p3.add(ta3);
			ta3.setText(null);
			p3.revalidate();
			FileRead f = new FileRead();
			LocalAlignment lA=new LocalAlignment();	
			char[] file1 = f.stringtoChar(this.file1);			
			char[] file2 = f.stringtoChar(this.file2);
			ta3.append(lA.LCS(file1,file2));
		}

		if(e.getSource()==confirm_ga)
		{
			p3.removeAll();
			p4.removeAll();
			p3.add(ta3);
			ta3.setText(null);
			p3.revalidate();
			FileRead f = new FileRead();
			GlobalAlignment gA = new GlobalAlignment();
			char[] file1 = f.stringtoChar(this.file1);			
			char[] file2 = f.stringtoChar(this.file2);
			gA.lcs(file1, file2, file1.length, file2.length);
			ta3.append(gA.result);
		}
	}
}

/*class StreamToTextArea extends JFrame {
    //declare PrintStream and JTextArea
    private static PrintStream ps = null;
  	
  	//FrameInOut fio = new FrameInOut();
    private JTextArea ta3 = new JTextArea();  //constructor
    
    public StreamToTextArea() {
 		setSize(310, 180);
	    getContentPane().add(ta3);
        //this is the trick: overload the println(String)
        //method of the PrintStream
        //and redirect anything sent to this to the text box
    	ps = new PrintStream(System.out) {
    		public void println(String x) {
    			ta3.append(x + "\n");
    		}
    	};
    }

	public PrintStream getPs() {
		return ps;
    }
}*/


class FileRead
{
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
}

class Similarity
{
    //slide_windows, count the times of String 
    public Map slideWindows(String file){
    	int max = 5;
        //file = file.substring(5);
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
                if((Integer)map1.get(key) < (Integer)map2.get(key))
                    comm += (Integer)map1.get(key);
                else
                    comm += (Integer)map2.get(key);
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
        
        if(file_len1 < file_len2)
            return (double)comm/file_len1;
        else
            return (double)comm/file_len2;
    }
}

class GlobalAlignment
{
	String result = "";

	public void lcs(char v[], char w[], int n, int m)
    {
        int i, j;
        int maxlen = m > n ? m : n;
    	int b[][] = new int[maxlen+1][maxlen+1];
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
        printLCS(b, v, n, m);
    }

    public void printLCS(int b[][], char v[], int i, int j)
    {
        if(i == 0 || j==0)
            return;
        if(b[i][j] == 0)
        {
            printLCS(b, v, i-1, j-1);
            this.result += v[i-1];
            //System.out.print(v[i-1]);
        }
        else if(b[i][j] == 1)
            printLCS(b, v, i-1, j);
        else
            printLCS(b, v, i, j-1);
    }
}

class LocalAlignment
{
	public String LCS(char str1[], char str2[]){
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

		String a = "";
		for( j = 0; j < maxLen; j++){
			if(max[j] > 0){
				for(i = maxIndex[j]-max[j]+1; i <= maxIndex[j]; i++){
					a = a + str1[i];
					//System.out.print(str1[i]);
				}
				a = a + "\n";
				//System.out.println();
			}
		}
		return a;
	}
}