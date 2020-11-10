package datastructure.hashing;

public class HashTable {

	String[] hashArray;
	int arraySize;
	int size = 0; // counter for the number of elements in the hash table

	public HashTable(int noOfSlots) {
		if (isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize = noOfSlots;
		} else {
			int primeCount = getNextPrime(noOfSlots);
			hashArray = new String[primeCount];
			arraySize = primeCount;

			System.out.println("Hash Table size given " + noOfSlots + " is not prime.");
			System.out.println("Hash Table size changed to " + primeCount);
		}
	}

	private boolean isPrime(int num) {
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private int getNextPrime(int num) {
		for (int i = num; true; i++) {
			if (isPrime(i))
				return i;
		}
	}

	// it will retuen index position to insert
	private int hashfunc1(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		if (hashVal < 0) {
			hashVal = hashVal + arraySize;
		}
		return hashVal; // ideal index position to insert the word.
	}

	// it will retuen steps size
	private int hashfunc2(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;

		if (hashVal < 0) {
			hashVal += arraySize;
		}

		return 3 - hashVal % 3; // no choosen here like 3 must be smaller than arraysize
	}

	public void insert(String word) {
		int hashVal = hashfunc1(word);
		int stepSize = hashfunc2(word);

		while (hashArray[hashVal] != null) {
			hashVal = hashVal + stepSize;
			hashVal = hashVal % arraySize;
		}
		hashArray[hashVal] = word;
		System.out.println("inseted word " + word);
		size++;
	}

	public String find(String word) {
		int hashVal = hashfunc1(word);
		int stepSize = hashfunc2(word);

		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].equals(word))
				return hashArray[hashVal];
			hashVal = hashVal + stepSize;
			hashVal = hashVal % arraySize;
		}
		return hashArray[hashVal];
	}
	
	public void displayTable() {
		System.out.println("Table :");
		for(int i=0; i<arraySize; i++) {
			if(hashArray[i]!=null) {
				System.out.print(hashArray[i]+"  ");
			}else {
				System.out.print("**");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		HashTable table = new HashTable(19);
		table.insert("apple");
		table.insert("hello");
		table.insert("feeling");
		table.insert("water");
		table.insert("africa");
		table.insert("speed");
		table.insert("phone");
		table.insert("September");
		table.insert("Michael");
		table.insert("Milk");
		table.insert("Huge");
		table.insert("Dogs");
		
		table.displayTable();

//		System.out.println("**********Finding Elemnts********");
//		System.out.println(table.find("apple"));
//		System.out.println(table.find("Zebra"));
//		System.out.println(table.find("feeling"));
//		System.out.println(table.find("water"));
//		System.out.println(table.find("africa"));

	}

}
