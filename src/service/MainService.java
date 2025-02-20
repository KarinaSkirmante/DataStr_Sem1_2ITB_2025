package service;

import java.util.Arrays;

import datastr.MyList;
import model.Student;

public class MainService {

	public static void main(String[] args)  {
		MyList<Character> listForChar = new MyList<Character>(3);
		listForChar.add('a');//a
		listForChar.add('b');//a b
		listForChar.add('c');//a b c 
		listForChar.add('d');//a b c d <-izpildot šo, vajadzētu palielināties sarakstam
		try
		{
			listForChar.print();//a b c d
			listForChar.add('Z', 1);//a Z b c d
			listForChar.print();//a Z b c d
			
			listForChar.remove(0);//a tiek izdzests
			listForChar.print();//Z b c d
			
			listForChar.add('c');//Z b c d c
			System.out.println(listForChar.get(1));//b
			System.out.println(Arrays.toString(listForChar.searchElement('c')));//[2, 4]
			
			listForChar.sort();
			listForChar.print();//b c c d Z
			
			listForChar.makeEmpty();
			listForChar.print();//nekā nebūs
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("--ADD t -----");
		listForChar.add('t');//t
		try
		{
			listForChar.print();//t
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("-----------------------------------");
		
		MyList<Integer> listForInt = new MyList<Integer>(3);
		listForInt.add(2);
		listForInt.add(4);
		listForInt.add(10);
		listForInt.add(5);
		try
		{
			listForInt.print();
			listForInt.add(100, 1);
			listForInt.print();//2 100 4 10 5
			
			listForInt.remove(0);//2 tiek izdzests
			listForInt.print();//100 4 10 5
			
			listForInt.add(4);//100 4 10 5 4
			System.out.println(listForInt.get(1));//4
			System.out.println(Arrays.toString(listForInt.searchElement(4)));//[1, 4]
			
			listForInt.sort();
			listForInt.print();
			
			listForInt.makeEmpty();
			listForInt.print();//nekā nebūs
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("--ADD 5 -----");
		listForInt.add(5);//t
		try
		{
			listForInt.print();//t
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
		System.out.println("-----------------------------------");
		MyList<Student> listForStudent = new MyList<Student>(1);
		
		Student st1 = new Student();
		Student st2 = new Student("Janis", "Berzins");
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		
		listForStudent.add(st1);
		listForStudent.add(st2);
		
		try
		{
			listForStudent.print();//Testa, Janis
			listForStudent.add(st3, 0);
			listForStudent.print();//Anna Paula, Testa, Janis
			
			System.out.println(listForStudent.get(0));//Anna Paula
			System.out.println(Arrays.toString(listForStudent.searchElement(st2)));//[2]
			
			listForStudent.sort();//būs problēma
			listForStudent.print();
			
			listForStudent.remove(1);
			listForStudent.print();//Janis, Test
			
			listForStudent.makeEmpty();
			listForStudent.print();//nekā nebūs
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("--ADD new student -----");
		listForStudent.add(new Student("Roberts", "Gudrais"));
		try
		{
			listForStudent.print();//Roberts
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
