
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
}
