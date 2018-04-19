
//NOTE: For some reason, BinarySearchTree<T> was not allowed on EECS machines, LOL
// I just want to template this :(
public class BinarySearchTree {
	
	public class Node{
	
		Node m_left;
		Node m_right;
		int m_value;
		
		Node(int val){
			m_left = m_right = null;
			m_value = val;
		}
	}
/*
 * Member Variables
 */
	Node m_root;
	int m_entries;
	
	
/*
 * Public Functions
 */
	BinarySearchTree()
	{
		m_root = null;
		m_entries = 0;
	}
	
	
	public void insert(int num)
	{
		if(m_root == null)
		{
			m_root = new Node(num);
			m_entries++;
			return;	
		}
		insert(num, m_root);
	}
	
	public Node search(int val)
	{
		if (m_root == null)
			return null;
		
		return search(val, m_root);
	}
	
	public void deleteMin()
	{
		
	}
	
	public void deleteMax()
	{
		
	}
	
	public void deleteValue() //generic delete
	{
		
	}
	


	public void inOrder()
	{
		inOrder(m_root);
		System.out.println();
	}
	
	public void preOrder()
	{
		preOrder(m_root);
		System.out.println();
	}
	
	public void postOrder()
	{
		postOrder(m_root);
		System.out.println();
	}
	
/*
 * Private Helper Functions
 */
	
	
	private void insert(int num, Node subtree)
	{
		if (num >= subtree.m_value)
		{
			if (subtree.m_right != null)
				insert(num, subtree.m_right);
			else
			{
				subtree.m_right = new Node(num);
				m_entries++;
			}
		}
		else
		{
			if (subtree.m_left != null)
				insert(num, subtree.m_left);
			else
			{
				subtree.m_left = new Node(num);
			}
		}
	}
	
	private Node search(int num, Node subtree)
	{
		if(subtree != null)
		{
			if (num == subtree.m_value)
				return subtree;
			else if (num < subtree.m_value)
				return search(num, subtree.m_left);
			else if (num >= subtree.m_value)
				return search(num, subtree.m_right);
		}
		return null;
	}
	
	private void inOrder(Node subtree)
	{
		if (subtree == null) {return;}
		
		inOrder(subtree.m_left);
		System.out.print(subtree.m_value + " ");
		inOrder(subtree.m_right);
	}
	
	private void preOrder(Node subtree)
	{
		if (subtree == null) {return;}
		
		inOrder(subtree.m_left);
		inOrder(subtree.m_right);
		System.out.print(subtree.m_value + " ");	
	}
	
	private void postOrder(Node subtree)
	{
		if (subtree == null) {return;}
		
		System.out.print(subtree.m_value + " ");
		inOrder(subtree.m_left);
		inOrder(subtree.m_right);
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree t = new BinarySearchTree();
		for(int i=0; i<20; i++)
		{
			t.insert(2 * i);
		}
		t.inOrder();
		t.preOrder();
		t.postOrder();
		Node temp = t.search(2);
		System.out.println("\nResult of search(2) : " + !(temp == null));
		
		
	}

}
