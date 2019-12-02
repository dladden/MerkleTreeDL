//imports:
import java.security.MessageDigest;
import TreePackage.BinarySearchTreeI;
import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.LinkedQueue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
/*
 * This class will read the file and divide it into DataBlocks
 * 
 * @author Denys Ladden
 * @version Nov 28, 2019
 * MerkleTree Project
 * Fall 2019
 */
public class DataReader {

	/*
	 * DataReader empty constoctor
	 */
	public DataReader() {
		
	}//end constroctor
	
	public DataReader(String s, LinkedQueue <DataBlock> q) {
		String input = null;
		
	try {
		BufferedReader reader = new BufferedReader(new FileReader(s));
		DataBlock block = new DataBlock(input);
		
		while ((input = reader.readLine())!= null) {
		
			q.enqueue(block);
		}
		reader.close();
	}//end try
	catch(IOException e) {
		
	}//end catch
	
	}//end DataReader
	
	
	
	
}//end calss
