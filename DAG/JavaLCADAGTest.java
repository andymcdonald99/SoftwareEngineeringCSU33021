import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;



class JavaLCADAGTest {
	
	//The tree being used:
		/*
		  		 0
		  	  /	   \
		  	 1		2
		  	/  \   /  \
		 3	4    5	   6
		 
	Test to see if tree is built correctly */
	@Test
	public void treeTest() {
		JavaLCADAG theLCA = new JavaLCADAG();
		JavaLCADAG.DAG theDAG = theLCA.new DAG();
		theDAG.addtreeNode(0, null);
		theDAG.addtreeNode(1, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.head)));
		theDAG.addtreeNode(2, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.head)));
		theDAG.addtreeNode(3, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(1))));
		theDAG.addtreeNode(4, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(1))));
		theDAG.addtreeNode(5, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(2))));
		theDAG.addtreeNode(6, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(2))));
	
		
	
	}
	@Test
	public void testDAG_LCAonDAG() {
		/*
		 * 	  0
		 *  ↙   ↘
		 * 1	 2
		 * ↓ ↘  ↙ ↘
		 * ↓  3 → 4
		 * ↓ ↙   ↙
		 * 5   ↙
		 * ↓ ↙
		 * 6
		 * 
		 */
		JavaLCADAG theLCA = new JavaLCADAG();
		JavaLCADAG.DAG theDAG = theLCA.new DAG();
		theDAG.addtreeNode(0, null);
		theDAG.addtreeNode(1, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.head)));
		theDAG.addtreeNode(2, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.head)));
		theDAG.addtreeNode(3, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(1),theDAG.gettreeNodeWithKey(2))));
		theDAG.addtreeNode(4, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(3),theDAG.gettreeNodeWithKey(2))));
		theDAG.addtreeNode(5, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(3),theDAG.gettreeNodeWithKey(1))));
		theDAG.addtreeNode(6, new ArrayList<JavaLCADAG.DAG.treeNode>(Arrays.asList(theDAG.gettreeNodeWithKey(4),theDAG.gettreeNodeWithKey(5))));
		
		assert(JavaLCADAG.getDAG_LCA(theDAG, 1, 2) == 0);
		assert(JavaLCADAG.getDAG_LCA(theDAG, 3, 5) == 3);
		
		assert(JavaLCADAG.getDAG_LCA(theDAG, 5, 6) == 5);
		assert(JavaLCADAG.getDAG_LCA(theDAG, 4, 5) == 3);
	
	}
}
