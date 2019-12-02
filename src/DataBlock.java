//imports:
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
 * This class will represent a block of data for which you want to compute a hash. 
 * 
 * @author Denys Ladden
 * @version Nov 28, 2019
 * MerkleTree Project
 * Fall 2019
 */
public class DataBlock implements java.io.Serializable{

	String data;
	
	public DataBlock() {
		
	}
	
	public DataBlock(String s) {
		
		data = s;
	}
	
}//end DataBlock
