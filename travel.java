package sort;

import java.lang.*;
import java.util.Scanner; 
import java.io.FileWriter; 
import java.io.IOException;

public class travel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		// read input from input text file
		FileWriter fw=new FileWriter("output.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		int number = sc.nextInt();
		int case_no;
		String incoming,outgoing;
		int no_of_flight;
		
		
		
		for(int i=0; i<number;i++) {
			
			no_of_flight = sc.nextInt();
			
			incoming= sc.next();
			outgoing=sc.next();
			
			sc.reset();
			
			char[][] answer = func(no_of_flight,incoming,outgoing, i);
			
			case_no = i+1;
			String caseno = "Case #"+case_no+":\n";
			
			for(int j=0; j<caseno.length();j++) {
				fw.write(caseno.charAt(j));
			}
			
			for(int k=0;k<no_of_flight;k++) {
				fw.write(answer[k]);
				fw.write("\n");
			}
			
			
			System.out.println(""+(i+1)+" round complete");
		}
		
		sc.close();
		fw.close();

	}
	
	
	
	public static char[][] func(int number , String incoming, String outgoing, int case_no) throws IOException  {
		
		
		char[][] answer = new char[number][number];
		for(int i=0; i<number;i++) {
			for(int j=0;j<number;j++){
				
				if(i==j) {
					answer[i][j] = 'Y';
				}
				else {
					answer[i][j] = calculate(incoming,outgoing,i,j);
				}
			}
		}
		
	
		// store result in outputtxt with case number...
		
		
		
		
		
		
		return answer;
	}
	
	public static char calculate(String incoming,String outgoing , int i, int j) {
		
		int diff = i-j;
		int m = i;
		if(diff == 1 || diff == -1) { 
			if (outgoing.charAt(i) == 'Y' && incoming.charAt(j) == 'Y')
				return 'Y';
			else 
				return 'N';
		}
		
		// connecting flight...
		
		if(i<j) {
			
			
			while(m<j) {
				
				if (outgoing.charAt(m) == 'N' || incoming.charAt(m+1) == 'N')
					return 'N';
				m++;
			}
			return 'Y';
		}
		
		else {
			
			while(m>j) {
				
				if (outgoing.charAt(m) == 'N' || incoming.charAt(m-1) == 'N')
					return 'N';
				m--;
			}
			return 'Y';

		}
		
		
		
}

}