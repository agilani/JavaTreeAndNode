package me.agilani.www;

import java.util.*;

/**
 * The Node class can be used to create nodes of a tree.<br>
 * Node can take any kind of object and can be initialized like<br><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Node&lt;String&gt; node = new Node&lt;String&gt;(new String("example"))<br><br> 
 * This class also behaves like a Tree in it self and exposes many useful functions. For Example:<br>
 * <table border=0 width=100%>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void addChild(Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Adds a new child node to the current node</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void removeChild(Node&lt;T&gt; child)</strong></td>
 * <td valign=center align=left>Removes a child node from a parent</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>Node&lt;T&gt; getParent()</strong></td>
 * <td valign=center align=left>Returns the parent node of the current node</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void setParent(Node&lt;T&gt; parent)</strong></td>
 * <td valign=center align=left>Set the parent node of the current node</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>boolean isRoot()</strong></td>
 * <td valign=center align=left>Returns true if the current node is the root of the tree</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>void setRoot(Node&lt;T&gt; root)</strong></td>
 * <td valign=center align=left>Sets the current node as the root of the tree</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>Node&lt;T&gt;[] children()</strong></td>
 * <td valign=center align=left>Returns the children of the current node as an array of Node&lt;T&gt; types</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>boolean hasChildren()</strong></td>
 * <td valign=center align=left>Returns true if the current node has children</td>
 * </tr>
 * <tr>
 * <td valign=center align=right><li> </li></td>
 * <td valign=center align=left><strong>Node&lt;T&gt;[] getSiblings()</strong></td>
 * <td valign=center align=left>Returns the sibling nodes of the current node as an array of Node&lt;T&gt; types</td>
 * </tr>
 * </table>
 * <P>
 * @param  T  Object Type
 * @author Adi Gilani - G00279198 - Data Structure of 2nd Year Software Development 2012
 * @version 1.0
 * @since 25 April 2012
 * */

public final class Node<T>
{
	private Node<T> root; // a T type variable to store the root of the list
	private Node<T> parent; // a T type variable to store the parent of the list
	private T child;
	private List<Node<T>> children = new ArrayList<Node<T>>(); // a T type list to store the children of the list
	
	// default constructor
	public Node(){}
	
	// constructor overloading to set the child
	public Node(T child)
	{
		setParent(null);
		setRoot(null);
		setItem(child);
	}
	
	// constructor overloading to set the parent
	public Node(Node<T> parent)
	{
		this.setParent(parent);
		//this.addChild(parent);
	}
	
	// constructor overloading to set the parent of the list  
	public Node(Node<T> parent, Node<T> child)
	{
		this(parent);
		this.children.add(child);
	}
	
	/**
	 * This method doesn't return anything and takes a parameter of the Node&lt;T&gt; object to add to the parent node
	 * <p>
	 * @param child &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; an object of Node&lt;T&gt;
	 **/
	public void addChild(Node<T> child)
	{
		child.root = null;
		child.setParent((Node<T>)this);
		this.children.add(child); // add this child to the list
	}

	/**
	 * This method doesn't return anything and takes a parameter of the Node&lt;T&gt; object to remove from the parent node 
	 * <p>
	 * @param child &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; an object of Node&lt;T&gt;
	 **/
	public void removeChild(Node<T> child)
	{
		this.children.remove(child); // remove this child from the list
	}
	
	/**
	 * This method returns a Node&lt;T&gt; object stored as the root of the Node's tree 
	 * <p>
	 * @return child &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; an object of Node&lt;T&gt;
	 **/
	public Node<T> getRoot()
	{
		return root;
	}

	/**
	 * This method returns a true or false to determine if the current Node is the root of the tree 
	 * <p>
	 * @return True or False
	 **/
	public boolean isRoot()
	{
		return this.root != null; // check to see if the root is null if yes then return true else return false
	}

	 /** This method doesn't return anything and takes a parameter of the Node&lt;T&gt; object to set as the root of the node tree
	  * 
	  * @param root
	  */
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/**
	 * This method returns a Node&lt;T&gt; object stored as the parent of the current node
	 * @return Node&lt;T&gt;
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * This method doesn't return anything and takes a Node&lt;T&gt; object to be stored as the parent of the current node
	 * @param parent Node&lt;T&gt;
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * This method return the data from the Node&lt;T&gt; object
	 * @return child from the Node&lt;T&gt;
	 */
	public T getItem() {
		return child;
	}

	/**
	 * This method set the data of the Node&lt;T&gt; object
	 * @param child
	 */
	public void setItem(T child) {
		this.child = child;
	}

	/**
	 * This method return true or false to determine if current node has children
	 * @return true or false
	 */
	public boolean hasChildren()
	{
		return this.children.size()>0;
	}
	
	/**
	 * This method returns a collection of Node&lt;T&gt; objects as an array which are the children of the current node 
	 * @return Node&lt;T&gt;[]
	 */
	@SuppressWarnings("unchecked")
	public Node<T>[] children()
	{
		return (Node<T>[]) children.toArray(new Node[children.size()]);
	}
	
	/**
	 * This method returns a collection of Node&lt;T&gt; objects as an array which are the sibling nodes of the current node 
	 * @return Node&lt;T&gt;[]
	 */
	@SuppressWarnings("unchecked")
	public Node<T>[] getSiblings()
	{
		if(this.isRoot()!=false && parent==null)
		{
			System.out.println("this is root or there are no siblings");
			return null;
		}
		else{
			List<Node<T>> siblings = new ArrayList<Node<T>>();
			Node<T>[] tempSiblings = this.parent.children();
			for(int i=0; i<tempSiblings.length; i++)
			{
				siblings.add(tempSiblings[i]);
			}
			siblings.remove(this);
			return siblings.toArray(new Node[siblings.size()]);
		}
	}
}