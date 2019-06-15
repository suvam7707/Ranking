package ranking;

import java.io.*;
import java.util.*;

public class Ranking {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		String[] dim=str.split("\\s");
		int a=Integer.parseInt(dim[0]);
		int b=Integer.parseInt(dim[1]);
		int[][] rank= new int[a][b];
		ArrayList<String[]> r=new ArrayList<String[]>();
		for(int i=0;i<a;i++) {
			str=br.readLine();
			r.add(str.split("\\s"));
			for(int j=0;j<b;j++)
				rank[i][j]=Integer.parseInt(r.get(i)[j]);
		}
		str=br.readLine();
		int c=Integer.parseInt(str);
		int[][] que=new int[c][2];
		ArrayList<String[]> q=new ArrayList<String[]>();
		for(int i=0;i<c;i++) {
			str=br.readLine();
			q.add(str.split("\\s"));
			for(int j=0;j<2;j++)
				que[i][j]=Integer.parseInt(q.get(i)[j]);
		}
		int[] res=new int[c];
		int sum,count;
		for(int index=0;index<c;index++) {
			count=0;
			for(int i=0;i<a;i++) {
				for(int j=0;j<b;j++) {
					if(rank[i][j]<=que[index][1]) {
						for(int k=i+1;k<a;k++) {
							for(int l=0;l<b;l++) {
								sum=rank[i][j]+rank[k][l];
								if(sum>=que[index][0] && sum<=que[index][1])
									count++;
							}
						}
					}
				}	
			}
			res[index]=count;
		}
		System.out.println(Arrays.deepToString(rank));
		System.out.println(Arrays.deepToString(que));
		System.out.println(Arrays.toString(res));
	}

}
