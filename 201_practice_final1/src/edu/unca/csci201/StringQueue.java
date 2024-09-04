package edu.unca.csci201;

public class StringQueue {

	protected String data;
	
	public StringQueue() {
		data = "";
	}

	public void enqueue(String newString) {
		data = data + newString + ":";
//		but i need to figure out how to get rid of this ugly little colon at the end!!
//		could maybe do a little what I'm doing with deQueue there first hmmmm tbd
	}
	

	public String dequeue() {
		int firstColon = data.indexOf(':');
		String deQueued = data.substring(0, firstColon);

		data = data.substring(firstColon + 1, data.length());
		
		return deQueued;
	}
//	
	public int count() {
		int j = 0;
		for(int i=0; i<data.length(); i++) {
			if(data.charAt(i) == ':') {
				j++;
			}
		}
		
		return j;
//		once i get that extra colon out of here it'll have to be j+1
	}
	
	public static void main(String[] args) {
		StringQueue q = new StringQueue();
		q.enqueue("A"); // The String A is in the queue
//		System.out.println(q.data);
		q.enqueue("BB"); // A is at the front, then BB
//		System.out.println(q.data);
		q.enqueue("C"); // A is at the front, then BB, then C
		System.out.println(q.data);
		System.out.println(q.count()); // 3
		String s = q.dequeue(); // returns "A", now BB is front, then C
		System.out.println(s); // prints A
		System.out.println(q.count()); // 2
		q.enqueue("D");
		q.enqueue("EEEE");
		
		System.out.println(q.data);

		s = q.dequeue()+q.dequeue()+q.dequeue()+q.dequeue();
		System.out.println(s); // BBCDEEEE
		System.out.println(q.count()); // 0

	}

//	so it works! the only thing is that pesky colon tacked onto the end. i think could use a reverse indexOf.
}
