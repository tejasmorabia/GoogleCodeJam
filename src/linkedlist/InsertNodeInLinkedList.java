package linkedlist;

import java.io.IOException;

public class InsertNodeInLinkedList {
	Node root;
	
	public InsertNodeInLinkedList() {}
	
	public void insert(int value) {
		Node newVal = new Node(value);
		if(root == null || root.value >= value) {
			newVal.next = root;
			this.root = newVal;
			return;
		}
		
		while(root.next != null && root.next.value < value) {
			root = root.next;
		}
		newVal.next = root.next;
		root.next = newVal;
	}
	
	
	public static void main(String[] args) throws IOException {
		Node root = new Node(10);
		root.next = new Node(20);
		root.next.next = new Node(30);
		root.next.next.next = new Node(40);
		root.next.next.next.next=null;
		
		InsertNodeInLinkedList insert = new InsertNodeInLinkedList();
		insert.root = root;
		insert.insert(5);
		while(insert.root != null) {
			System.out.println(insert.root.value);
			insert.root = insert.root.next;
		}

	}

}
