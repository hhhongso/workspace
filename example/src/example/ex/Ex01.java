package example.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 0;
		double j = 0; 
		while(i <99) {
			i++; 
			if(i%2 ==0) j += i/(i+1.0);
			else j -= i/(i+1.0);
		}
		System.out.println(j);
	}
}
