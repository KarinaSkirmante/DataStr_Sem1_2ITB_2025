package datastr;

public class MyList<Ttype> {

	//mainīgie
	private Ttype[] list;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	//noklusētais konstruktors
	public MyList() {
		list = (Ttype[]) new Object[size];
	}
	
	//argumenta konstruktors
	public MyList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		list = (Ttype[])new Object[size];		
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
		
		Ttype[] listNew = (Ttype[])new Object[size];
		
		for(int i = 0 ; i < counter; i++) {
			listNew[i] = list[i];	
		}
		
		list = listNew;
		
		System.gc();
			
	}
	
	public void add(Ttype element) {
		if(isFull()) {
			resize();
		}
		
		list[counter] = element;
		counter++;
		
		//list[counter++] = element;
	}
	
	public void add(Ttype element, int index) throws Exception {
		if(index < 0 || index > counter)
		{
			//garais pieraksts
			//Exception myExc = new Exception("The index is not accepted");
			//throw myExc;
			//isais pieraksts
			throw new Exception("The index is not accepted");
			
		}
		
		if(isFull()) {
			resize();
		}
		
		
		for(int i = counter; i > index; i--) {
			list[i] = list[i-1];
		}
		
		
		list[index] = element;
		counter++;
		
	}
	
	
	//TODO
	//izveidot funkcijas remove definiciju
	public void remove(int index) throws Exception
	{
	//parbaudit, vai saraksts ir tukss un ja ir, metam iznemumu
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to remove element");
		}
		
	//parbaudit index. Pie nepareiza indeksa izmest iznemumu
		if(index < 0 || index >= counter)
		{
			throw new Exception("The index is not accepted");
		}
	//izveidot for ciklu, ar kuru uzkope virsu dzesamajam elementam
		
		for(int i = index; i < counter-1; i++)
		{
			list[i] = list[i+1];
		}
		
		
	//pedejao elementu uzliek uz atstarpi (sis tiks mainits velak pie template)
	 //list[counter-1] = null;	
	//jasamazina counter par vienu
		counter--;
	}
	
	//TODO
	//funkcija definīcija
	public Ttype get(int index) throws Exception
	{
	//parbaudit, vai saraksts ir tukss un ja ir, metam iznemumu
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to get element");
		}
	//parbaudit index. Pie nepareiza indeksa izmest iznemumu
		if(index < 0 || index >= counter)
		{
			throw new Exception("The index is not accepted");
		}
	//atgriezt elementa vertību pie noteiktā indeksa
		return list[index];
	
	}
	
	public int[] searchElement(Ttype element) throws Exception
	{
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to search element");
		}
		
		int howManyElementsSearched = 0;
		for(int i = 0; i < counter; i++) {
			if(list[i].equals(element))
			{
				howManyElementsSearched++;
			}
		}
		
		int[] indexes = new int[howManyElementsSearched];
		int counterForIndexes = 0;
		for(int i = 0; i < counter; i++)
		{
			if(list[i].equals(element))
			{
				indexes[counterForIndexes] = i;
				counterForIndexes++;
			}
		}
		
		return indexes;
		
	}
	//TODO māja izpildīt: Izveidot funkciju, kas kā argumentu saņem elementu un atgriež nākamo elementu (veikt nepieciešamās pārbaudes);
	
	public void sort() {
		
		for(int i = 0; i < counter; i++) {
			for(int j = 0; j < counter; j++) {
				//if(list[i] > list[j])
				if (   ((Comparable)(list[i])).compareTo(list[j])  == 1 )
				
				{
					swap(i, j);
				}
			}
		}
		
		
	}
	
	private void swap(int index1, int index2) {
		Ttype temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
	
	public void print() throws Exception{ 
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to print elements");
		}
	
		for(int i = 0; i < counter; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	public void makeEmpty()
	{
		if(!isEmpty())
		{
			size = DEFAULT_SIZE;
			counter = 0;
			list = (Ttype[]) new Object[size];
			System.gc();
		}
	}
	
	
}

