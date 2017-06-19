package linkedlist;

public class MergeSortForLinkedList {
	
	public MergeSortForLinkedList() {}
	
	public Node mergeSort(Node root) {
		if(root == null || root.next == null) {
			return root;
		}
		Node firstHalf = root;
		Node secondHalf = root.next;
		while((secondHalf != null) && secondHalf.next != null ) {
			root = root.next;
			secondHalf = secondHalf.next.next;
		}
		secondHalf = root.next;
		root.next = null;
		return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	}
	
	public Node merge(Node firstHalf, Node secondHalf) {
		Node result = new Node(0);
		Node pointer = result;
		while(firstHalf != null && secondHalf != null) {
			
			if(firstHalf.value <= secondHalf.value) {
				pointer.next = firstHalf;
				pointer = pointer.next;
				firstHalf = firstHalf.next;
			} else {
				pointer.next = secondHalf;
				pointer = pointer.next;
				secondHalf = secondHalf.next;
			}
		}
		pointer.next = (firstHalf == null) ? secondHalf: firstHalf;
		return result.next;
	}
	
	
	public static void main (String[] args) {
		Node input = new Node(10);
		input.next = new Node(60);
		input.next.next = new Node(40);
		input.next.next.next = new Node(20);
		MergeSortForLinkedList mergeSort = new MergeSortForLinkedList();
		Node result = mergeSort.mergeSort(input);
		while(result != null) {
			System.out.println(result.value);
			result = result.next;
		}
		
	}

}
