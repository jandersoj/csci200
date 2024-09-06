package edu.unca.csci202;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hash table implemented using an array of LinkedLists,
 * where the LinkedLists are used to implement chaining for collision resolution
 * 
 * @author ksanft
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SimpleHashTable<K,V> implements SimpleHashTableADT<K, V> {

	/**
	 * inner class to hold key:value pairs
	 * 
	 * @param <K> key type
	 * @param <V> value type
	 */
	private class Pair<K,V> {
		K key;
		V value;
		public Pair(K key, V value) {
			this.key=key;
			this.value=value;
		}
		K getKey() {
			return key;
		}
		V getValue() {
			return value;
		}
		public String toString() {
			return key+":"+value;
		}
	}
	
	LinkedList<Pair<K,V>>[] bins;
	int size;
	double loadFactorLimit;
	final double DEFAULT_LOAD_FACTOR_LIMIT = 0.75;
	
	@SuppressWarnings("unchecked")
	public SimpleHashTable(int numberOfBins) {
		// initialize array and linked lists
		bins = (LinkedList<Pair<K,V>>[]) new LinkedList<?>[numberOfBins];
		for (int i=0; i<numberOfBins; i++) {
			bins[i] = new LinkedList<Pair<K,V>>();
		}
		size=0;
		loadFactorLimit=DEFAULT_LOAD_FACTOR_LIMIT;
	}
	
	@Override
	public void put(K key, V value) {
		// implement this method
		
		
		LinkedList<Pair<K,V>> list = bins[(Math.abs(key.hashCode()))%bins.length];
		
		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).key.equals(key)) {
				list.get(i).value = value;
				return;
			} 
		}
		list.add(new Pair<K,V>(key, value));
		size++;		
	}

	/**
	 * double the length of the underlying array
	 */
	@SuppressWarnings("unchecked")
	protected void increaseCapacity() {
		// do not delete this print statement
		System.out.println("increasing capacity...");
	
		LinkedList<Pair<K,V>>[] temp = bins; //making a linkedlist array holding our old stuff
		bins = (LinkedList<Pair<K,V>>[]) new LinkedList<?>[bins.length * 2]; //making our old one into a new one with double capacity
		
		for(int i = 0; i < bins.length; i++) { //instantiating
			bins[i] = new LinkedList<Pair<K,V>>();
		}
		
		for(int i = 0; i<temp.length; i++) {
			
			Iterator<Pair<K, V>> it = temp[i].iterator();

			while(it.hasNext()) {
				Pair<K, V> node = it.next();
				int index = Math.abs(node.key.hashCode()) % bins.length;
				bins[index].add(node); //filling it with our old data
			}
			
		}
	}
	
	@Override
	public V get(K key) {

		LinkedList<Pair<K,V>> list = bins[(Math.abs(key.hashCode()))%bins.length];

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).key.equals(key))
				return list.get(i).value;
		}
		return null;
	}

	@Override
	public V remove(K key) {
		LinkedList<Pair<K,V>> list = bins[(Math.abs(key.hashCode()))%bins.length];

		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).key.equals(key)) {
				V out = list.get(i).value;
				list.remove(i);
				size--;
				return out;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void setLoadFactorLimit(double loadFactorLimit) {
		this.loadFactorLimit=loadFactorLimit;
		// uncomment this when increaseCapacity is implemented:
		while (getCurrentLoadFactor()>loadFactorLimit) {
			increaseCapacity();
		}
	}

	@Override
	public double getLoadFactorLimit() {
		return loadFactorLimit;
	}

	@Override
	public double getCurrentLoadFactor() {
		return (double) size/bins.length;
	}

	public String toString() {
		String out="{";
		for (int i=0; i<bins.length; i++) {
			for (Pair<K,V> pair : bins[i]) {
				out+=pair+", ";
			}
		}
		out+="}";
		return out;
	}
	
	public void printTable() {
		for (int i=0; i<bins.length; i++) {
			System.out.println(i+": "+bins[i]);
		}
	}
}
