
public class JavaLCADAG {
	public class treeNode {
		treeNode parent, childLeft, childRight;
		int data;

		treeNode(int data, treeNode parent, treeNode childLeft, treeNode childRight) {
			this.data = data;
			this.parent = parent;
			this.childLeft = childLeft;
			this.childRight = childRight;
		}
	
	}

	public class binaryTree {
		treeNode head;

		binaryTree() {
			head = null;
		}

		public int getKey(treeNode theNode) {
			if (theNode != null)
				return theNode.data;
			return -1;
		}

		public void add(int data, treeNode parent, boolean isLeft) {
			treeNode newNode = new treeNode(data, parent, null, null);
			if (head == null) { 
				head = newNode;
				return;
			}
			if (isLeft)
				parent.childLeft = newNode;
			else
				parent.childRight = newNode;
		}
	}
}
