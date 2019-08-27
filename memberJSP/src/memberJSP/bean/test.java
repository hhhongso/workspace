package memberJSP.bean;

import java.util.ArrayList;
import java.util.List;

public class test {

public static void main(String[] args) {
	List<Object> list = new ArrayList<Object>();
	String name = "김가나다";
	String age = "25";
	
	list.add(name);
	
	System.out.println(list.get(0));
}
}
