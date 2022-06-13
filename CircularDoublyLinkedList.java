package com.kiddy.dataStructure;

public class CircularDoublyLinkedList<T> {

	/*
	 *@Author LwinPhyoAung(codeCat)
	 *@CircularDoublyLinkedList
	 *
	 *@Methods :	addAtStart(T val) :
	 *				addAtEnd(T val) :
	 *				add(T val) :
	 *				insert(int pos,T val) :
	 *					
	 *				removeAtStart() :
	 *				removeAtEnd() :
	 *				remove(int pos) :
	 *
	 *				get(int pos) : Node
	 *				contain(T val) : boolean
	 *				size() : int
	 *				isEmpty() : boolean
	 *				display() :
	 *				displayReverse() :
	 *				
	 */
	
	public class Node{
		
		Node next;
		Node previous;
		T val;
		
		Node(T val){
			this.val = val;
		}
		
		public String toString() {
			// TODO Auto-generated method stub
			return ""+val;
		}
		
		
	}
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public CircularDoublyLinkedList(){
		
		size = 0;
		
	}
	
	public void addAtStart(T val){
		
		Node newNode = new Node(val);
		if(isEmpty()){
			//Empty List
			head = newNode;
			tail = newNode;
			head.previous = tail;
			tail.next = head;
		}else{
			
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
			head.previous = tail;
			tail.next = head;
			
		}
		size += 1;
		
	}
	
	public void addAtEnd(T val){
		
		Node newNode = new Node(val);
		if(isEmpty()){
			
			// Empyt List
			head = newNode;
			tail = newNode;
			head.previous = tail;
			tail.next = head;
			
		}else{
			
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = head;
			head.previous = tail;
			
		}
		size += 1;
		
	}
	
	public void add(T val){
		
		if(isEmpty()){
			// Empty List
			addAtStart(val);
		}else{
			
			addAtEnd(val); 
			
		}
		
	}
	
	public void insert(int pos, T val){
		
		if(pos <= 0){
			addAtStart(val); 
		}else if(pos >= (size - 1)){
			addAtEnd(val); 
		}else{
			
			Node newNode = new Node(val);
			Node currentNode = head;
			for(int i = 1; i <= pos; i++){
				currentNode = currentNode.next;
			}
			Node pre = currentNode.previous;
			newNode.next = currentNode;
			newNode.previous = pre;
			pre.next = newNode;
			currentNode.previous = newNode;
			size += 1;
			
		}
		
	}
	
	public void removeAtStart(){
		
		if(isEmpty()){
			//Empty List
			System.out.println("List is Empty");
			return;
		}else if(size == 1){
			head = null;
			tail = null;
		}else{
			
			head = head.next;
			head.previous = tail;
			tail.next = head;
			
		}
		size -= 1;
		
	}
	
	public void removeAtEnd(){
		
		if(isEmpty()){
			System.out.println("List is Empty");
			return;
		}else if(size == 1){
			head = null;
			tail = null;
		}else{
			tail = tail.previous;
			tail.next = head;
			head.previous = tail;
		}
		size -= 1;
		
	}
	
	public void remove(int pos){
		
		if(pos <= 0){
			removeAtStart(); 
		}else if(pos >= (size - 1)){
			removeAtEnd(); 
		}else{
			
			if(isEmpty()){
				System.out.println("List is Empty");
				return;
			}
			
			Node currentNode = null;
			int middlePos = size / 2;
			
			if(pos <= middlePos){
				
				currentNode = head;
				
				for (int i = 1; i <= pos; i++) {
					currentNode = currentNode.next;
				}
				
				
			}else if(pos >= middlePos){
				
				currentNode = tail;
				
				for (int i = (size-2); i >= pos; i--) {
					currentNode = currentNode.previous;
				}
				
			}
			
			currentNode.next.previous = currentNode.previous;
			currentNode.previous.next = currentNode.next;
			size-=1;
			
		}
		
	}
	
	public Node get(int pos){
		
		if(isEmpty()){
			System.out.println("List is Empty");
			return null;
		}
		
		if(pos >= size){
			return null;
		}
		
		Node currentNode = head;
		for (int i = 0; i < pos; i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode;
		
	}
	
	public boolean contain(T val){
		
		Node temp = head;
		do{
			if(temp.val.equals(val)){
				return true;
			}
			temp = temp.next;
		}while(temp != head);
		
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void display(){
		
		if(isEmpty()){
			System.out.println("[ ]");
			return;
		}
		
		String result = " [";
		Node temp = head;
		do{
			result += temp.val + ", ";
			temp = temp.next;
		}while(temp != head);
		result += "] ";
		System.out.println(result);
		
	}
	
	public void displayReverse(){
		
		if(isEmpty()){
			System.out.println("[ ]");
			return;
		}
		
		Node temp = tail;
		String result = " [";
		do{
			result += temp.val +  ", ";
			temp = temp.previous;
		}while(temp != tail);
		result += "] ";
		System.out.println(result);
		
	}
	
}
