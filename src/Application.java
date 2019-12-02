//imports:
import java.util.Scanner;
import java.security.MessageDigest;
import TreePackage.BinarySearchTreeI;
import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.LinkedQueue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
/*
 * This class will prompt the user for a file to hash, it will instantiate a DataReader and instantiate and execute a MerkleTree 
 * 
 * @author Denys Ladden
 * @version Nov 26, 2019
 * MerkleTree Project
 * Fall 2019
 */
public class Application {
	
	private static Scanner sc = new Scanner(System.in);
	private static String input;

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MerkleTree merkT = new MerkleTree();
		
		System.out.println("Please Enter a File Name to Hash Here:");
		input = sc.next();
		
		
		LinkedQueue <String> hashQueue = new LinkedQueue <String>();
		LinkedStack <String> nodeStack = new LinkedStack <String>();
		LinkedQueue <DataBlock> dataBlockQueue = new LinkedQueue <DataBlock>();
		DataReader dataReader = new DataReader (input, dataBlockQueue);
		
		
		
	while(dataBlockQueue.isEmpty() == false) {
		
		DataBlock d = dataBlockQueue.dequeue();
		merkT.leavesHash(d, hashQueue, nodeStack);
		
		System.out.println(merkT.getresult());
		
	}//end while
		
	while(hashQueue.isEmpty() == false) {
		
		String head = hashQueue.dequeue();
		
		if(hashQueue.isEmpty() == false) {
			String tail = hashQueue.dequeue();
			String NULL = head + tail;
			
			merkT.compRoot(NULL, hashQueue, nodeStack);
			System.out.println(merkT.getresult());
			
		}
		else {
			nodeStack.push(head);
			while(nodeStack.isEmpty() == false) {
				merkT.MerkleT.add(nodeStack.pop());
			}
		}
		
		
	}//end while
	
		
		
	}//end main

}//end class
