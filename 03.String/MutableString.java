import java.io.*;

public class MutableString
{
	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Hello");
		System.out.println(s);
		s.append("TCA");
		System.out.println(s);


		StringBuilder t=new StringBuilder("Hello");
		System.out.println(t);
		t.append("TCA");
		System.out.println(t);
	}
}