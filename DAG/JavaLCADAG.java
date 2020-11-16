import java.util.*;

public class JavaLCADAG {
	public static final int FOUND_A = -2;
	public static final int FOUND_B = -3;

	public JavaLCADAG() {
}
	class treeNode {
			public ArrayList<treeNode> children;
			public int data;

			treeNode(int data) {
				children = new ArrayList<treeNode>();
				this.data = data;
			}
		}

	public class DAG {
		treeNode head = null;

		
		public void addtreeNode(int data, ArrayList<treeNode> parents) {
			treeNode thetreeNode = new treeNode(data);
			if (head == null)
				head = thetreeNode;
			if (parents != null)
				for (treeNode parenttreeNode : parents)
					if (parenttreeNode != null)
						parenttreeNode.children.add(thetreeNode);
		}

		public treeNode gettreeNodeWithKey(int data) {
			if (head != null) {
				return gettreeNodeRec(data, head);
			}
			return null;
		}

		private treeNode gettreeNodeRec(int data, treeNode treeNode) {
			for (treeNode child : treeNode.children) {
				treeNode theRettreeNode = gettreeNodeRec(data, child);
				if (theRettreeNode != null)
					return theRettreeNode;
			}
			if (treeNode.data == data)
				return treeNode;
			return null;
		}

		public String printChildren(treeNode treeNode) {
			String children = "";
			for (treeNode child : treeNode.children)
				children += child.data + "  ";
			return children;
		}

		public ArrayList<treeNode> getChildren(treeNode treeNode) {
			if (treeNode != null)
				return treeNode.children;
			return null;
		}

		class treeNode {
			public ArrayList<treeNode> children;
			public int data;

			treeNode(int data) {
				children = new ArrayList<treeNode>();
				this.data = data;
			}
		}
	}
	private static int bothInSubtreeOf(DAG.treeNode currenttreeNode, int keyA, int keyB) {
		int currenttreeNodeVal = currenttreeNode.data;
		boolean foundA = false;
		boolean foundB = false;
		for (int i = 0; i < currenttreeNode.children.size(); i++) {
			int subTreeOf = bothInSubtreeOf(currenttreeNode.children.get(i), keyA, keyB);
			if (subTreeOf >= 0) {
				return subTreeOf;
			} else {
				if (subTreeOf == FOUND_B)
					foundB = true;
				if (subTreeOf == FOUND_A)
					foundA = true;
			}
		}
		if (foundA && foundB)
			return currenttreeNodeVal;
		if (foundA && currenttreeNodeVal == keyB)
			return currenttreeNodeVal;
		if (foundB && currenttreeNodeVal == keyA)
			return currenttreeNodeVal;

		if (foundA)
			return FOUND_A;
		if (foundB)
			return FOUND_B;

		if (currenttreeNodeVal == keyA && currenttreeNodeVal == keyB)
			return currenttreeNodeVal;

		if (currenttreeNodeVal == keyA)
			return FOUND_A;
		if (currenttreeNodeVal == keyB)
			return FOUND_B;

		return -1;

	}
	public static int getDAG_LCA(DAG theDAG, int keyA, int keyB) {

		DAG.treeNode currenttreeNode = theDAG.head;

		int thetreeNodeKey = bothInSubtreeOf(currenttreeNode, keyA, keyB);
		if (thetreeNodeKey < 0)
			return -1;
		return thetreeNodeKey;
	}
}
