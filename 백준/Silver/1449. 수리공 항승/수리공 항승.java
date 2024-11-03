import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] t = br.readLine().split(" ");
		int  N = Integer.parseInt(t[0]);
		int  L = Integer.parseInt(t[1]);
		int pos[] = new int[1001];
		int tape=0;
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			pos[Integer.parseInt(input[i])] = 1;
		}


		for(int i=1;i<=1000;i++) {
			if(pos[i]!= 0) {
				i+=L-1;
				tape++;
			}
		}

		System.out.println(tape);
	}

}