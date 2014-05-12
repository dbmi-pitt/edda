package edu.pitt.dbmi.edda.ldatests;

public class BitTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numTopics = 7;
		int numberOfOneBits = Integer.bitCount(numTopics);
		System.out.println(numTopics + "  ==> " + numberOfOneBits);

		
		int bigNumber = Integer.MAX_VALUE;
		numberOfOneBits = Integer.bitCount(bigNumber);
		System.out.println(bigNumber + "  ==> " + numberOfOneBits);
	
		int topicMask = 0;
		int topicBits = 0;
	    numTopics = 13;
		if (Integer.bitCount(numTopics) == 1) {
			// exact power of 2
			topicMask = numTopics - 1;
			topicBits = Integer.bitCount(topicMask);
		}
		else {
			// otherwise add an extra bit
			int highestOneBit = Integer.highestOneBit(numTopics);
			topicMask = highestOneBit  * 2 - 1;
			topicBits = Integer.bitCount(topicMask);
		}
		System.out.println("Topic Mask :" + topicMask) ;
		System.out.println("Topic Bits :" + topicBits) ;
	
	}

}
