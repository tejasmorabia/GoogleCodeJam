package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReverseLinkedList {
	
	public ReverseLinkedList() {}
	
	public Node reverse (Node root, Node prev) {
		if(root == null) {
			return prev;
		}
		Node nextNode = root.next;
		root.next = prev;
		root = reverse(nextNode, root);
		return root;
	}

	public static void main(String[] args) throws IOException {
		Node root = new Node(10);
		root.next = new Node(20);
		root.next.next = new Node(30);
		root.next.next.next = new Node(40);
		root.next.next.next.next=null;
		File f1 = new File("src/recursive/input.txt");
		Scanner s1 = new Scanner(f1);
		String nextLine = null;
		while( (nextLine = s1.nextLine()) != null) {
			System.out.println(nextLine);
		}
		
		ReverseLinkedList list = new ReverseLinkedList();
		Node result = list.reverse(root, null);
		while(result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}
}
