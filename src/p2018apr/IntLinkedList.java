package p2018apr;

/*
 * Design an int type singly linkedlist class, and then implement some functions 
 * using the self designed class.
 * 
 * 1. Append an element into the linkedlist
 * 2. Remove the tail element from a linkedlist
 * 3. Remove all element in the linkedlist that is greater than a target value
 */

class Node
{
	int value;
	Node next;
	public Node(int value) {
		this.value = value;
    }
}

public class IntLinkedList {
	Node head = null;
	
	/**
	 * append option #1
	 */
	public void append(int value) {
        
        Node lastNode = head;
        
        if (lastNode != null)
        {
        	while (lastNode.next != null) {
        		lastNode = lastNode.next;
        	}
        }
        if (lastNode == null) {
            head = new Node(value);
        } else {
            lastNode.next = new Node(value);
        }
    }
	
	/**
	 * append option #2
	 */
    public void append2(int value) 
    {
        //create a new node first
        Node temp = new Node(value);
 
        // If the list is empty, the new node become head 
        if (head == null) {
            head = temp;
        }
        else {
            //append the new node after last node
            Node last = head; 
            while (last.next != null) { 
                last = last.next; 
            }
            last.next = temp; 
        }
    }
    
	public void removeTailNode() {
        if (head == null) {
            return;
        }
        Node tmpNode = head;
        Node nodeBeforeLast = head;
        if(head.next == null)
        {
        	//delete the head as head is the only node in the list
        	head = null;
        }
        while (tmpNode.next != null) {
        	nodeBeforeLast = tmpNode;
            tmpNode = tmpNode.next;
        }
        if (nodeBeforeLast != null)
        {
        	nodeBeforeLast.next = null;
        }
        
    }
	
	/**
	 *  delete option #1
	 * @param value int value
	 */
	public void deleteNodeAboveValue(int value) {
        if(head == null){
            return;
        }

        Node prevNode = null;
        Node currNode = head;
        while (currNode != null) {
        	if(currNode.value > value)
        	{
        		//head;
        		if(currNode == head)
        		{        			
        			head = head.next;        			 
        		}
        		//tail or in the middle
        		else
        		{
        			prevNode.next = currNode.next;
        		}
        	}
        	else
        	{
        		prevNode = currNode;
        	}
        	
        	currNode = currNode.next;
            
        }

    }
	
	
	/**
	 * delete option #2
	 * using another list, simple to implement,but need extra space
	 */
	public void deleteNodeAboveValue1(int value)
	{
		if(head == null){
            return;
        }
		IntLinkedList myList = new IntLinkedList();
		
        Node currNode = head;

        while (currNode != null) {
        	if(currNode.value <= value)
        	{
        		myList.append(currNode.value);
        	}
        	currNode = currNode.next;
        }        
        head = myList.head;
	}
	
	/**
	 * delete option #3
	 * adding a helper node before head to make logic clearer
	 * similar to other general cases of using two pointers for linked list
	 * no worry about the memory for the node, non-referenced object will be GC'ed
	 * in c or c++,then need to handle memory releasing
	 */
	
	public void deleteNodeAboveValue2(int val) {
		Node helper = new Node(0);
	    helper.next = head;
	    Node p = helper;
	 
	    while(p.next != null){
	        if(p.next.value > val){
	        	Node next = p.next;
	            p.next = next.next; 
	        }else{
	            p = p.next;
	        }
	    }
	    
	    head = helper.next;
	   
	}
	
	public void print() {
        System.out.println("");
        if(head == null){
            System.out.print("empty list");
            return;
        }
        Node tmpNode = head;
        while (tmpNode != null) {
            System.out.print(tmpNode.value + " -> ");
            tmpNode = tmpNode.next;
        }
        //System.out.print("null");
    }
	
	public static void main(String[] args) {
		
		 test1();
		 test2();
		 test3();
		 test4();
		 test5();
    }
	
	public static void test1()
	{
		IntLinkedList myList = new IntLinkedList();
        myList.print();
        myList.append(3);
        myList.append(5);
        myList.append(1);
        myList.append(1);
        myList.append(1);
        myList.append(1);
        myList.append(1);
        myList.append(7);
        myList.append(1);
        myList.append(3);
        myList.append(5);
        myList.append(1);
        myList.append(6);
        myList.append(1);
        myList.print();        
        
        myList.deleteNodeAboveValue2(4);        
        myList.print();
        
        myList.deleteNodeAboveValue2(1);
        myList.print();
        
        System.out.println("\n-----------------------------------------------------");
	}
	
	public static void test2()
	{
		IntLinkedList myList = new IntLinkedList();
	    myList.print();
	    myList.append(4);
	    myList.append(5);
	    myList.append(1);
	    myList.print();
	    myList.deleteNodeAboveValue(1);
	    myList.print();
	    System.out.println("\n-----------------------------------------------------");
	}
	public static void test3()
	{
        IntLinkedList myList = new IntLinkedList();
        myList.print();
        myList.append(15);
        myList.append(7);
        myList.append(1);
        myList.append(3);
        myList.append(5);
        myList.append(7);
        myList.append(7);
        myList.append(1);
        myList.print();
        myList.deleteNodeAboveValue(3);
        myList.print();
        
        myList.removeTailNode();
        myList.print();
        System.out.println("\n-----------------------------------------------------");
	}
	public static void test4()
	{
        IntLinkedList myList = new IntLinkedList();
        myList.print();
        myList.append(15);
        myList.append(7);
        myList.append(1);
        myList.append(3);
        myList.append(5);
        myList.append(1);
        myList.append(6);
        myList.append(1);
        myList.print();
        myList.deleteNodeAboveValue(14);
        myList.print();
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.append(1);
        myList.append(6);
        myList.append(1);
        myList.print();
        myList.deleteNodeAboveValue(3);
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.deleteNodeAboveValue(13);
        myList.print();
        System.out.println("\n-----------------------------------------------------");
	}
	
	/**
	 * test append2
	 */
	public static void test5()
	{
        IntLinkedList myList = new IntLinkedList();
        myList.print();
        myList.append2(15);
        myList.append2(7);
        myList.append2(1);
        myList.append2(3);
        myList.append2(5);
        myList.append2(1);
        myList.append2(6);
        myList.append2(1);
        myList.print();
        myList.deleteNodeAboveValue(14);
        myList.print();
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.append(1);
        myList.append(6);
        myList.append2(1);
        myList.print();
        myList.deleteNodeAboveValue(3);
        myList.print();
        myList.removeTailNode();        
        myList.print();
        myList.deleteNodeAboveValue(13);
        myList.print();
        System.out.println("\n-----------------------------------------------------");
	}

}
