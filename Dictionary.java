import java.util.*;
import java.io.*;


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
	Node nodeMakeNode(int num) {
		Node myNode;
		myNode = new Node();
		myNode.wordCode = num;
		myNode.next = null;
		return myNode;
	}
	
	Node fidTail() {
		Node curr;
		curr = front;
		while(curr != null) {
			curr = curr.next;
		}
		return curr;
	}
	
}



public class Dictionary {
	
	static int makeWordCode(String s) {
		
		String sLow = s.toLowerCase();
		int wordCode = 0;
		if (s.length() >= 3) {
			wordCode = ((sLow.charAt(0) - 'a') * 26^2) + ((sLow.charAt(1) - 'a') * 26^1) + ((sLow.charAt(2) - 'a') * 26^0);
		}
		else if (s.length() == 2) {
			wordCode = ((sLow.charAt(0) - 'a') * 26^2) + ((sLow.charAt(1) - 'a') * 26^1) + 0;
		}
		else {
			wordCode = ((sLow.charAt(0) - 'a') * 26^2) + 0 + 0;
		}

		return wordCode;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\mikel\\C\\DictionaryLL\\src\\sampleDict.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String word = reader.next();
			/*word must be converted into integer*/
			System.out.println(word.toLowerCase());
			System.out.println(makeWordCode(word.toLowerCase()));
		}
	}

}
