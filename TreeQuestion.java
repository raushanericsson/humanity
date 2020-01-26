


import java.util.*;

class TreeQuestion{

	static Node root;

	static class Node {

		int data;
		Node left,right;

		Node(int data){
			this.data = data;
		}

	}


	public static void main(String[] args){

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		traverseTreeDFS(root);

		traverseTreeBFS(root);

	}


	private static void traverseTreeDFS(Node node){

		System.out.println ( " ** ========= ** ");
		System.out.println ( " Starting InOrder Traversal ");
		inOrder(node);

		System.out.println ( " ** ========= ** ");
		System.out.println ( " Starting PreOrder Traversal ");
		preOrder(node);


		System.out.println ( " ** ========= ** ");
		System.out.println ( " Starting PostOrder Traversal ");
		postOrder(node);


	}

	private static void inOrder(Node node){

		if(node == null)
			return ;
		if(node.left != null){
			inOrder(node.left);
		}
		System.out.println(node.data);
		if(node.right != null){
			inOrder(node.right);
		}

	}

	private static void postOrder(Node node){

		if(node == null)
			return ;
		if(node.left != null){
			postOrder(node.left);
		}
		if(node.right != null){
			postOrder(node.right);
		}
		System.out.println(node.data);

	}

	private static  void preOrder(Node node){

		if(node == null)
			return ;
		System.out.println(node.data);
		if(node.left != null){
			preOrder(node.left);
		}
		if(node.right != null){
			preOrder(node.right);
		}		

	}


	private static void traverseTreeBFS(Node node){

		System.out.println( " BFS of Tree ");

		BFSUtility(node);

		System.out.println( " BFS of Tree Queue");

		BfsQueue(node);



	}


	private static void BFSUtility(Node node){
		// Calculate height of the tree 
		int height = getHeight(node);
		for(int i=1;i<=height;i++){
			printLevel(node,i);
		}

	}

	private static int getHeight(Node node){
		if(node == null){
			return 0;
		}

		return 1 + Math.max(getHeight(node.left),getHeight(node.right));
	}


	private static void printLevel(Node node,int level){

		if(level == 1){
			System.out.println(node.data);
			return ;
		}

		if(node.left != null){
			printLevel(node.left,level-1);
		}
		if(node.right != null){
			printLevel(node.right,level-1);
		}

	}




	private static void BfsQueue(Node node){
		if(node == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();


		queue.add(node);
		while(!queue.isEmpty()){
			Node current_node = queue.remove();
			System.out.println(current_node.data);
			if(current_node.left != null){
				queue.add(current_node.left);
			}
			if(current_node.right != null){
				queue.add(current_node.right);
			}
		}

	}





}