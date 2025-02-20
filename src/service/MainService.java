package service;

import java.util.Arrays;

import datastr.MyList;

public class MainService {

	public static void main(String[] args)  {
		MyList listForChar = new MyList(3);
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

	}

}
