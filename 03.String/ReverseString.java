import java.io.*;

public class ReverseString
{
	public static void main(String[] args) {
		String s="Aniket";

		StringBuffer sb=new StringBuffer(s);

		sb.reverse();
		s=new String(sb);
		System.out.println(s);
	}
}