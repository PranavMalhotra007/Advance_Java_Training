package OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		List<String>list = new ArrayList<>();
		for(int i=0;i<5;i++) {
			String s = sc.next();
			list.add(s);
		}
		long count = list.stream()
					.filter(s->s.length()>5)
					.count();
		System.out.println(count);
	}
}
