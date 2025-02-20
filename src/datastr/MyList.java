package datastr;

public class MyList {

	//mainīgie
	private char[] list;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	//noklusētais konstruktors
	public MyList() {
		list = new char[size];
	}
	
	//argumenta konstruktors
	public MyList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		list = new char[size];		
	}
	
	private boolean isFull() {
		//garais if pieraksts ar pārbaudi
		/*if(size == counter) {
			return true;
		}
		else
		{
			return false;
		}
		*/
		
		//īsais if pieraksts ar pārbaudi
		//return (size == counter) ? true : false;
		
		//pavisam īsa forma, ja ir true vai false
		return (size == counter);
	}
	
	private boolean isEmpty()
	{
		//garais if pieraksts ar pārbaudi
		/*if(counter == 0) {
			return true;
		}
		else
		{
			return false;
		}*/
		
		//īsais if pieraksts ar pārbaudi
		//return (counter == 0) ? true : false;
		
		//pavisam īsa forma, ja ir true vai false
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	
	private void resize() {
		if(size < 100)
		{
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5); //135.7 -> 135
		}
		
		char[] listNew = new char[size];
		
		for(int i = 0 ; i < counter; i++) {
			listNew[i] = list[i];	
		}
		
		list = listNew;
		
		System.gc();
			
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		
		list[counter] = element;
		counter++;
		
		//list[counter++] = element;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

