import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @version 3.1 09/11/15 11:32:15
 *
 * @author TODO
 */

@RunWith(JUnit4.class)

public class LCAjavatest {

	@Test
	public void testTree() {
		LCAjava tree = new LCAjava();
		tree.root = new Node(1);
		tree.root.l = new Node(2);
		tree.root.r = new Node(3);
		tree.root.l.l = new Node(4);
		tree.root.l.r = new Node(5);
		tree.root.r.l = new Node(6);
		tree.root.r.r = new Node(7);
		
		int expectedAnswer = 1;
		assertEquals("",expectedAnswer, tree.findLCA(3, 4));
		
		expectedAnswer= 2;
		assertEquals("",expectedAnswer, tree.findLCA(5, 4));
		
		expectedAnswer =-1;
		assertEquals("null",expectedAnswer, tree.findLCA(8,3));
	}
	
	@Test
	public void testEmpty() {
	LCAjava tree = new LCAjava();
	int expectedAnswer = -1;
	assertEquals("",expectedAnswer, tree.findLCA(1, 2));
		
	}
	

	
}