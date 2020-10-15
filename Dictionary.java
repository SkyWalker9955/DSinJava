  
import java.util.*;
import java.io.*;

/*
 * Linked List
 */
class Node {
	String word;
	int wordCode;
	String meaning;
	Node next;
}

class LinkMe{
	Node front;
	
	void init() {
		front = null;
	}
	Node makeNode(int num, String word) {
		Node myNode;
		myNode = new Node();
		myNode.word = word;
		myNode.wordCode = num;
		myNode.next = null;
		myNode.meaning = null;
		return myNode;
	}
	
	//find last node
	Node findTail() {
		Node curr;
		curr = front;
		while(curr != null) {
			curr = curr.next;
		}
		return curr;
	}
	
	//inssert funct.
	void insert (int num, String word) {
		Node curr, prev, temp;
		boolean searching;
		if (front == null) {
			front = makeNode(num, word);
		}
		else if (num < front.wordCode) {
			temp = makeNode(num, word);
			temp.next = front;
			front = temp;
		}
		else {
			searching = true;
			curr = front;
			prev = front;
			while (searching == true) {
				if (curr.wordCode == num) {
					//when finds a duplicate, ignores it.
					searching = false;
				}
				else if (curr.wordCode < num) {
					if (curr.next == null) {
						curr.next = makeNode(num, word);
						searching = false;
					}
					else {
						prev = curr;
						curr = curr.next;
					}
				}
				else if (curr.wordCode > num ) {
					temp = makeNode(num, word);
					temp.next = curr;
					prev.next = temp;
					searching = false;
				}
			}
		}
	}//end insert
	
	//print LL
	void printLL() {
		Node curr;
		curr = front;
		while(curr != null) {
			System.out.println(curr.wordCode + "\t" + curr.word);
			curr=curr.next;
		}
	}
}

/*
 * Dictionary class 
 */
public class Dictionary {
	//////////////////////////////////////////////////////////////////////////////////////////////////
	static int makeWordCode(String s) {
		
		String sLow = s.toLowerCase();
		int wordCode = 0;
		if (s.length() >= 3) {
			wordCode = ((sLow.charAt(0) - 'a') * 676) + ((sLow.charAt(1) - 'a') * 26) + ((sLow.charAt(2) - 'a') * 1);
		}
		else if (s.length() == 2) {
			wordCode = ((sLow.charAt(0) - 'a') * 676) + ((sLow.charAt(1) - 'a') * 26) + 0;
		}
		else {
			wordCode = ((sLow.charAt(0) - 'a') * 676) + 0 + 0;
		}

		return wordCode;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) throws FileNotFoundException {
		LinkMe LL = new LinkMe();
		LL.init();
		File file = new File("C:\\Users\\mikel\\eclipse-workspace\\LLscary\\src\\sampleDict.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String word = reader.next();
			int wordCode = makeWordCode(word.toLowerCase());
			LL.insert(wordCode, word.toLowerCase());
		}
		LL.printLL();
		
		//Add word + prompt
		System.out.println("\n\nAdd word: ");
		Scanner input = new Scanner(System.in);
		String newWord = input.nextLine();
		int newWordCode = makeWordCode(newWord.toLowerCase());
		LL.insert(newWordCode, newWord);
		
		LL.printLL();
	}
}
