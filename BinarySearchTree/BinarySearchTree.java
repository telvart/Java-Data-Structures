
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
		if(m_root == null)
			return;
		
		deleteMin(m_root);
	}
	
	public void deleteMax()
	{
		if(m_root == null)
			return;
		
		deleteMax(m_root);
	}
	
	public void deleteValue() //generic delete
	{
		
	}
	
	public Node findMin(Node subtree)
	{
		Node cur = subtree;
		while(cur.m_left != null)
			cur = cur.m_left;
		
		return cur;
	}
	
	public Node findMax(Node subtree)
	{
		Node cur = subtree;
		while(cur.m_right != null)
			cur = cur.m_right;
		
		return cur;
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
	
	public void levelOrder()
	{
//		 if(m_root == nullptr) {return;}
//
//		  Queue<BSTNode<T>*> queue = Queue<BSTNode<T>*>();
//		  queue.enqueue(m_root);
//
//		  while(!queue.isEmpty())
//		  {
//		    BSTNode<T>* currentNode = queue.dequeue();
//		    std::cout<<currentNode->getValue()<<" ";
//
//		    if(currentNode->getLeft() != nullptr)
//		    {
//		      queue.enqueue(currentNode->getLeft());
//		    }
//		    if(currentNode->getRight() != nullptr)
//		    {
//		      queue.enqueue(currentNode->getRight());
//		    }
//		  }
//		  std::cout<<std::endl;
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
	
	private void deleteMin(Node subtree)
	{
		if((subtree == m_root) && m_root.m_left == null)
		{
			m_root = m_root.m_right;
			m_entries--;
			return;
		}
		if(subtree.m_left != null)
		{
			if (subtree.m_left.m_left != null)
			{
				deleteMin(subtree.m_left);
			}
			else
			{
				if(subtree.m_left.m_right != null)
				{
					subtree.m_left = subtree.m_left.m_right;
					m_entries--;
				}
				else
				{
					subtree.m_left = null;
					m_entries--;
				}
			}
		}
	}
	
	private void deleteMax(Node subtree)
	{
//		if(subtree == m_root && subtree->getRight() == nullptr)
//		  {
//		    BSTNode<T>* temp = subtree;
//		    m_root = subtree->getLeft();
//		    m_entries--;
//		    delete temp;
//		    return;
//		  }
//		  if(subtree->getRight() != nullptr)
//		  {
//		    if(subtree->getRight()->getRight() != nullptr)
//		    {
//		      deleteMax(subtree->getRight());
//		    }
//		    else
//		    {
//		      if(subtree->getRight()->getLeft() != nullptr)
//		      {
//		        BSTNode<T>* temp = subtree->getRight();
//		        subtree->setRight(subtree->getRight()->getLeft());
//		        m_entries--;
//		        delete temp;
//		      }
//		      else
//		      {
//		        m_entries--;
//		        delete subtree->getRight();
//		        subtree->setRight(nullptr);
//		      }
//		    }
//		  }

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
		
		t.deleteMin();
		t.deleteMin();
		t.deleteMin();
		
		System.out.println();
		
		t.inOrder();
		t.preOrder();
		t.postOrder();
		Node temp = t.search(2);
		System.out.println("\nResult of search(2) : " + !(temp == null));
		
		
	}

}
