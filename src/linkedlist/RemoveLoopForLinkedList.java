package linkedlist;

public class RemoveLoopForLinkedList {

	Node root;
	
	public RemoveLoopForLinkedList(Node root) {this.root = root;}
	
	public void detectAndRemoveLoop() {
		Node slow = root;
		Node fast = root.next;
		
		while(slow != null && fast != null && fast.next != null) {
			if(slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow == fast) {
			slow = root;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}
	
	public static void main (String[] args) {
		Node input = new Node(10);
		input.next = new Node(60);
		input.next.next = new Node(40);
		input.next.next.next = new Node(20);
		input.next.next.next.next = input.next;
		System.out.println(input.next.value);
		RemoveLoopForLinkedList removeLoop = new RemoveLoopForLinkedList(input);
		removeLoop.detectAndRemoveLoop();
		while(removeLoop.root != null) {
			System.out.println(removeLoop.root.value);
			removeLoop.root = removeLoop.root.next;
		}
	}
}
