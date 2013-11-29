package me.agilani.www;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * The Tree class can be used to create tree which contains nodes&lt;T&gt;<br>
 * Tree can take any kind of object and can be initialized like<br><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tree&lt;String&gt; tree = new Tree&lt;String&gt;(new String("example"))<br><br> 
 * This class exposes many useful functions. For Example:<br>
 * <table border=0 width=100%>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void add(Node&lt;T&gt; parent, Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Adds a new child node to the parent node</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void removeChild(Node&lt;T&gt; parent, Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Removes a child node from a parent</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>Node&lt;T&gt; getRootNode()</strong></td>
 * <td valign=center align=left>Returns the root node of the tree</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void setRoot(Node&lt;T&gt; root)</strong></td>
 * <td valign=center align=left>Set the root node of the tree</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>boolean contains(Node&lt;T&gt; data)</strong></td>
 * <td valign=center align=left>Returns true if the tree contains data</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void dfs(Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Performs a depth first search of the tree and outputs to the screen</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void bfs(Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Performs a breadth first search of the tree and outputs to the screen</td>
 * </tr>
 * </table>
 * <P>
 * @param  T  Object Type
 * @author Adi Gilani - G00279198 - Data Structure of 2nd Year Software Development 2012
 * @version 1.0
 * @since 25 April 2012
 * */
public class Tree<T> {
	private Node<T> root;
	private Map<Node<T>, List<Node<T>>> myTree = new HashMap<Node<T>, List<Node<T>>>();
	
	//default constructor
	public Tree()
	{ }

	/**
	 * This method returns the Root of the tree as a Node&lt;T&gt; object
	 * <p>
	 * @return Node&lt;T&gt; root 
	 **/
	public Node<T> getRootNode()
	{
		// returns the root element of the tree 
		return root;
	}

	 /** This method doesn't return anything and takes a parameter of the Node&lt;T&gt; object to set as the root of the tree
	  * 
	  * @param root
	  */
	public void setRoot(Node<T> root)
	{
		// sets the root element of the tree
		this.root = root;
	}

	 /** This method doesn't return anything and takes two parameter. Node&lt;T&gt; parent, Node&lt;T&gt; child and adds child to the parent
	  * 
	  * @param parent
	  * @param child
	  */
	public void add(Node<T> parent, Node<T> child)
	{
		// make the parent node the parent of this tree
		if(parent.isRoot() || this.root==null)
		{
			//if there is no root then set the first element as the root
			this.setRoot(parent);
		}
		
		// add a new child node to the parent node
		parent.addChild(child);
		
		//add parent and the children of the parent to the myTree Map
		//get the children of the parent node in an array list
		//in the map add the parent as the key and children collection as the value
		
		List<Node<T>> childrenList = new ArrayList<Node<T>>();
		for(int i=0; i<child.getParent().children().length; i++)
		{
			childrenList.add(child.getParent().children()[i]);
		}
		myTree.put(parent, childrenList);
		
		//add the child as the key too and the children as null
		myTree.put(child, null);
	}
	
	/** This method doesn't return anything and takes two parameter. Node&lt;T&gt; parent, Node&lt;T&gt; child and adds delete child from the parent
	  * 
	  * @param parent
	  * @param child
	  */
	public void removeChild(Node<T> parent, Node<T> child)
	{
		// should remove child node from a parent
		// should remove any children this child has
		
		if(myTree.containsKey(parent))
		{
			//remove child from the parent
			parent.removeChild(child);
		}

		//delete it from the myTree map too and any children this child had
		if(myTree.containsKey(child))
		{
			myTree.remove(child); // remove from tree
			for(int i=0; i<child.children().length; i++)
			{
				//remove children of child from the tree
				if(myTree.containsKey(child.children()[i]))
					myTree.remove(child.children()[i]);
			}
		}
	}
	
	/** This method return a true or false to determine if the item exist in the tree. IT takes a parameter of. Node&lt;T&gt; data
	  * @param data
	  */
	public boolean contains(Node<T> data)
	{
		// searches the tree for a given type
		return myTree.containsKey(data);
	}
	
	/**
	 * Performs a depth first search on the tree and outputs each node
	 * @param child is a Node&lt;T&gt;
	 */
	@SuppressWarnings("unchecked")
	public void dfs(Node<T> child){
		if(myTree.containsKey(child))
	    {
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
	        list.add(child);
	        while(!list.isEmpty())
	        {
	        	Node<T> node = list.get(list.size() - 1);
	        	if(child.equals(node))
	        		System.out.println("The DFS search for " + node.getItem().toString() + ". FOUND!!!");
	        	else
	        		System.out.println(node.getItem().toString());
	            list.remove(list.size() - 1);
                if(myTree.get(node)!=null)
                {
                	//System.out.println(myTree.get(node).toArray().length);
					Object[] children = myTree.get(node).toArray();
                    for(int i=0; i<children.length; i++)
                    {
                        list.addLast((Node<T>)children[i]);
                    }
                }
            }
        }
        else
            System.out.println("Not found");
	}


	/**
	 * Performs a Breadth First Search of the Tree and outputs each node
	 * @param child is a Node&lt;T&gt;
	 */
	@SuppressWarnings("unchecked")
	public void bfs(Node<T> child)
	{
		if(myTree.containsKey(child))
	    {
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
	        list.add(child);
	        while(!list.isEmpty())
	        {
	        	Node<T> node = list.get(list.size() - 1);
	        	if(child.equals(node))
	        		System.out.println("The BFS search for " + node.getItem().toString() + ". FOUND!!!");
	        	else
	        		System.out.println(node.getItem().toString());
	            list.remove(list.size() - 1);
                if(myTree.get(node)!=null)
                {
                	//System.out.println(myTree.get(node).toArray().length);
					Object[] children = myTree.get(node).toArray();
                    for(int i=0; i<children.length; i++)
                    {
                        list.addFirst((Node<T>)children[i]);
                    }
                }
            }
        }
        else
            System.out.println("Not found");
    }

}
