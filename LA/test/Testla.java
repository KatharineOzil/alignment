class LocalAlignment
{
	public char[] LCS(char str1[], char str2[]){
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

		char[] result = new char[30];
		int a = 0;

		for( j = 0; j < maxLen; j++){
			if(max[j] > 0){
				for(i = maxIndex[j]-max[j]+1; i <= maxIndex[j]; i++){
					result[a]=str1[i];
					a++;
				}
				//result[a+1]=' ';
				System.out.println();
			}
		}
		return result;
	}
}

public class Testla{
	public static void main(String[] argv){
		char[] a = {'T','C','G','T','C','A','G'};
		char[] b = {'T','C','A','A','C','A','G'};
		LocalAlignment la = new LocalAlignment();
		System.out.println(la.LCS(a,b));
	}
}