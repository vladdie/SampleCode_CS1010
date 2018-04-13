package linkedList;

import java.util.Scanner;

public class LinkedListDemo {
	
	public static void display(Node head){
		Node start = head;
		while(start != null){
			System.out.println(start.getData());
			start = start.getNext();
		}
	}
	
	public static Node insert(Node head, int data){
		if(head == null){
            head = new Node(data);
            return head;
        }else{
        	Node tail = head;
        	while(tail.getNext() != null){
        		tail = tail.getNext();
        	}
            tail.setNext(new Node(data)); 
            return head;
        }
		
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		Node head = null;
		int N = scan.nextInt();
		
		while(N > 0){
			int ele = scan.nextInt();
			head = insert(head, ele);
		}
		
		display(head);
		scan.close();
	}

}
