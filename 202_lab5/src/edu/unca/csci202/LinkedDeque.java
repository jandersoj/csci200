package edu.unca.csci202;
import java.util.NoSuchElementException;

/**
 * Lab5 - Linked Deque class
 * 
 * 02/23/2024
 * 
 *@author Josie Anderson
 * @author Jamie Nale
 * 
 */


/**
 * Implementation of linked double-ended queue
 * uses dummy (aka sentinel) nodes at head and tail
 * 
 * @author Josie Anderson
 * @author Jamie Nale
 * 
 */
public class LinkedDeque<E> implements Deque<E> {
    
    
    private DNode<E> head;
    private DNode<E> tail;
    
    /**
        Constructor, creates both a dummy head and a dummy tail.
     */
    public LinkedDeque() {
        head = new DNode<>();
        tail = new DNode<>();
        head.setNext(tail);
        tail.setPrevious(head);
    }
    
    /**
     @return returns true if the deque is empty
     */
    public boolean isEmpty() {
        return head.getNext() == tail;
    }
    
    /**
     Remove all elements from the deque.
     */
    public void clear() {
        head.setNext(tail);
        tail.setPrevious(head);
    }
    
    
/**
 * adds a given E element to the end (head) of the queue
 * 
 * @param element - takes in an element to add to the head end of the queue
 * 
 */
    public void addFirst(E element) {
    	
    	DNode<E> newEl = new DNode<>(element);
    	DNode<E> prevNext = head.getNext();
    	
    	head.setNext(newEl);
    	newEl.setPrevious(head);
    		
    	if(isEmpty()) {
    		tail.setPrevious(newEl);
    		newEl.setNext(tail);
    	} else {
       		newEl.setNext(prevNext);
       		prevNext.setPrevious(newEl);
    	}
    	
//    	System.out.println("Added first: "+element); //TEST
    }
/**
 * Removes the first element in the queue    
 */
    public E removeFirst() {
    	
    	if(!isEmpty()) {
    		
    		DNode<E> removed = head.getNext();
	    	DNode<E> newFirst = removed.getNext();
	    		
	    	head.setNext(newFirst);
	    	newFirst.setPrevious(head);
	    	   
//	    	System.out.println("Removed first: "+removed.getData()); //TEST
	    	return removed.getData();
	    	
    	} else {
    		return null;
    	}
    	
    }
/**
 * Gets the first elememt in the queue
 * @return Node at the front of the queue    
 */
    public E getFirst() {
    	DNode<E> gotFirst = head.getNext();
    	
//    	System.out.println("Got first: "+ gotFirst.getData()); //TEST
    	
        return gotFirst.getData();
    }
/**
 * Removes the first occurrence of passed node object
 * @param Node object
 * @return boolean - If the remove has occured ? true : false     
 */
    public boolean removeFirstOccurrence(E obj) {
    	
    	if(!isEmpty()) {
    		
        	E removed;
        	DNode<E> prevToRemoved;
        	DNode<E> nextToRemoved;
        	
        	DNode<E> current = head;
        	
	    	while (current != tail) {
	    		if(current.getData() == obj) {
	    			removed = current.getData(); //this is not necessary
	    			
	    			prevToRemoved = current.getPrevious();
	    			nextToRemoved = current.getNext();
	    			
	    			prevToRemoved.setNext(nextToRemoved);  
	    			nextToRemoved.setPrevious(prevToRemoved);
	    			
//	    			System.out.println("Removed first "+obj+"."); //TEST
	    			
	    			return true;
	    		}else{
	    			current = current.getNext();
	    		}
	    	}
    	}
    	return false;
    }
/**
 * Add a node to the tail of the queue
 * @param E element    
 */
    public void addLast(E element) {
    	
    	DNode<E> newEl = new DNode<>(element);
		DNode<E> prevLast = tail.getPrevious();
	
		tail.setPrevious(newEl);
		newEl.setNext(tail);
		
		if(isEmpty()) {
			head.setNext(newEl);
			newEl.setPrevious(head);
		} else {
	   		newEl.setPrevious(prevLast);
	   		prevLast.setNext(newEl);
		}
//		System.out.println("Added last: "+element); //TEST
    }
    
/**
 * Removes the tail node of the queue
 * @return E - element    
 */
    public E removeLast() {
    	
    	if(!isEmpty()) {
    	
	    	DNode<E> removed = tail.getPrevious();
	    	DNode<E> newLast = removed.getPrevious();
	   	
	    	tail.setPrevious(newLast);
	    	newLast.setNext(tail);
	
//	    	System.out.println("Removed last: "+removed.getData()); //TEST
	    	
	    	return removed.getData();
    	
    	} else {
    		return null;
    	}
    }
    
/**
 * Gets the last element in the queue
 * @return E - element    
 */
    public E getLast() {
    	DNode<E> gotLast = tail.getPrevious();
    	
//    	System.out.println("Got last: "+ gotLast.getData()); //TEST
    	
        return gotLast.getData();
        }
    
/**
 * Removes the first occurrence of the passed starting from the tail
 * @param E - object
 * @return boolean - the removal has occured ? true : false    
 */
    public boolean removeLastOccurrence(E obj) {
    	
    	if(!isEmpty()) {
    		
        	E removed;
        	DNode<E> prevToRemoved;
        	DNode<E> nextToRemoved;
        	
        	DNode<E> current = tail;
        	
	    	while (current != head) {
	    		if(current.getData() == obj) {
	    			removed = current.getData(); //this is not necessary
	    			
	    			prevToRemoved = current.getPrevious();
	    			nextToRemoved = current.getNext();
	    			
	    			prevToRemoved.setNext(nextToRemoved);  
	    			nextToRemoved.setPrevious(prevToRemoved);
	    			
//	    			System.out.println("Removed last "+obj+"."); //TEST
	    			
	    			return true;
	    		}else{
	    			current = current.getPrevious();
	    		}
	    	}
    	}
        return false;
    }
    
    
    // methods to print the deque are provided:
    // do not modify these methods
    /**
     Print the contents of the deque from front (head) to back (tail)
     */
    public void printForward() {
        System.out.println("The deque printed forward:");
        DNode<E> current = head.getNext();
        while (current != tail) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
    
    /**
     Print the contents of the deque backwards (from back/tail to front/head)
     */
    public void printBackward() {
        System.out.println("The deque printed backward:");
        DNode<E> current = tail.getPrevious();
        while (current != head) {
            System.out.println(current.getData());
            current = current.getPrevious();
        }
        System.out.println();
    }
    
}
