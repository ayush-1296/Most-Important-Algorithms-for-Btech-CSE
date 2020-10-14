package apps;

import java.io.IOException;
import java.util.Scanner;
import structures.Node;

public class Radixsort {
	Node<String> masterListRear;

	Node<String>[] buckets;

	int radix=10;

	public Radixsort() {
		masterListRear = null;
		buckets = null;
	}
	
	public Node<String> sort(Scanner sc) 
	throws IOException {
		if (!sc.hasNext()) return null;
		
		radix = sc.nextInt();
		buckets = (Node<String>[])new Node[radix];
		
		createMasterListFromInput(sc);
		
		int maxDigits = getMaxDigits();
		
		for (int i=0; i < maxDigits; i++) {
			scatter(i);
			gather();
		}
	
		return masterListRear;
	}
	

	public void createMasterListFromInput(Scanner sc) 
	throws IOException {
		while(sc.hasNext()) {
			String a = sc.next();
			if (masterListRear == null) { 
				masterListRear = new Node<String> (a,null);
				masterListRear.next=masterListRear;
			}
			else { 
				masterListRear.next= new Node<String> (a,masterListRear.next);
				masterListRear=masterListRear.next;
			}
		}
	}

	public int getMaxDigits() {
		int maxDigits = masterListRear.data.length();
		Node<String> ptr = masterListRear.next;
		while (ptr != masterListRear) {
			int length = ptr.data.length();
			if (length > maxDigits) 
				maxDigits = length;
			ptr = ptr.next;
		}
		return maxDigits;
	}

	public void scatter(int pass) {
		Node<String> ptr = null;
		do {
			ptr = masterListRear.next;
			masterListRear.next=ptr.next;
			int digit=0;
			int a = ptr.data.length()-1-pass;
			if (a<0) digit=0;
			else digit = Character.digit(ptr.data.charAt(a), radix);
			if (buckets[digit] == null) { 
				buckets[digit] = ptr;
				buckets[digit].next=ptr;
			}
			else { 
				ptr.next=buckets[digit].next;
				buckets[digit].next=ptr;
				buckets[digit]=ptr;
			} 
		} while (ptr != masterListRear);
		masterListRear=null;
	}


	public void gather() {
		for (int i=0; i<buckets.length; i++) { 
			if(buckets[i]!=null) {
				if (masterListRear==null)
					masterListRear=buckets[i];
				else { 
					Node<String> ptr = masterListRear.next;
					masterListRear.next=buckets[i].next;
					buckets[i].next=ptr;
					masterListRear=buckets[i];
				}
			}
			buckets[i]=null;
		}
	}		
}
