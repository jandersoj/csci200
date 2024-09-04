package edu.unca.csci201;

public class Column {

	private Disk diskArray[];
	
	public Column() {
		diskArray = new Disk[6];
	}
	
	public boolean insert(Disk disk) {
		//remember that 0 is at the bottom so 
		int i = 0;
		while(i < 7) {
			if (diskArray[i] == null) {
				diskArray[i] = disk;
				return true;
			} else {
				i++;
			}
		}		
		//could link the bool full method into this but idk if i want that
		return false;
	}
	
	public int size() {
		int i;
		int counter = 0;
		for(i = 0; i < 7; i++) {
			if(diskArray[i] != null) {
				counter++;
			}
		}
		return counter; 
	}
	
	public boolean full() {
		if(size() == 6) {
			return true;
		} else return false;
	}
	
	public Disk get(int rowIndex) {
		if(diskArray[rowIndex] == null) {
			return null;
		} else return diskArray[rowIndex];
	}
}
