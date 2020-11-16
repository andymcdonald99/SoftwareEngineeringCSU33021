
public class JavaLCADAG {
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
}
