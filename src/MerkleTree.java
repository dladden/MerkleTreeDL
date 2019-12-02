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
 * This class will gnerete the tree and compute the hash function 
 * 
 * @author Denys Ladden
 * @version Nov 28, 2019
 * MerkleTree Project
 * Fall 2019
 */
public class MerkleTree {

	BinarySearchTreeI <String> MerkleT = new BinarySearchTreeI <String>();
	String result;//
	
	/*
	 * Merkle Tree constructor
	 */
	public MerkleTree() {
		
		result = null;
		
	}//end consatructor
	
	
	/*
	 * Leaves Hash will convert byte arrays to Hexadecimal String
	 */
	public void leavesHash (DataBlock d, LinkedQueue <String> queue, LinkedStack <String> stack){
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			
			try {
				StringBuffer hexString = new StringBuffer();
				
				byte[] digest = md.digest();
				md.update(serialise(d));
				for(int i = 0; i<digest.length; i++) {
					hexString.append(Integer.toHexString(0xFF & digest[i]));
					
				}//end for
				setResult(hexString.toString().toLowerCase());
				stack.push(result);
				queue.enqueue(result);
				
			}//end second try
			catch(IOException e) {
				
			}//end ctach
			
		}//end first try for message digest algorithm
		catch (NoSuchAlgorithmException e) {
			
		}
		
	}//end Leaves Hash
	
	
	public void add(String h) {
		MerkleT.add(h);
	}
	
	public void setResult(String n) {
		result = n;
	}//end set result
	
	public String getresult() {
		return result;
	}//end get result
	
	
	
	
	/*
	 * Serialise Converts objects into a stream of bytes
	 */
	public static byte[] serialise (Object object) throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		
		os.writeObject(object);
		os.flush();
		os.close();
		out.close();
		
		return out.toByteArray();
	}//end serialise 
	
	/*
	 * CompRoot Alwows to skip the serialising process if its a hash
	 */
	public void compRoot(String d, LinkedQueue <String> queue, LinkedStack <String> stack) {
	
		MessageDigest md = null;
		String result = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			
		}//end try
		catch (NoSuchAlgorithmException e) {
			
		}//end catch
		
		StringBuffer hexString = new StringBuffer();
		
		byte[] digest = md.digest();
		md.update(d.getBytes());
		for(int i = 0; i<digest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
			
		}//end for
		setResult(hexString.toString().toLowerCase());
		stack.push(result);
		queue.enqueue(result);
		
		
	}//end compute root
	
	
	
	
}//end class
