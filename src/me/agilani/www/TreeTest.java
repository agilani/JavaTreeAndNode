package me.agilani.www;

public class TreeTest {
	
	public static void main(String[] args)
	{

		Person grandfather = new Person("Syed Rasheed Ahmed Gilani", 75, "Dead");
		Person father = new Person("Shafiq", 63, "Alive");
		Person uncle1 = new Person("Rafiq", 33, "Dead");
		Person uncle2 = new Person("Shabir", 60, "Alive");
		Person uncle3 = new Person("Mushtaq", 57, "Alive");
		Person uncle4 = new Person("Attiq", 50, "Alive");
		Person me = new Person("Adeel", 30, "Alive");
		Person mySon = new Person("Kamil", 1, "Alive");
		Person myBrother = new Person("Nabeel", 28, "Alive");
		Person mySister = new Person("Kiran", 32, "Alive");
		Person myNiece1 = new Person("Zoya", 4, "Alive");
		Person myNiece2 = new Person("Zoha", 1, "Alive");
		Person myNephew1 = new Person("Taha", 4, "Alive");
		Person myCuzSonOfShabir = new Person("Faisal", 29, "Alive");
		Person myCuzDaughterOfShabir = new Person("Sania", 27, "Alive");
		
		
		
		Node<Person> rasheed = new Node<Person>(grandfather); // setting the grandfather as the parent of the branches
		Node<Person> shafiq = new Node<Person>(father); // setting the father as the parent of the branches
		Node<Person> rafiq = new Node<Person>(uncle1); // setting the uncle1 as the parent of the branches
		Node<Person> shabir = new Node<Person>(uncle2); // setting the uncle2 as the parent of the branches
		Node<Person> mushtaq = new Node<Person>(uncle3); // setting the uncle3 as the parent of the branches
		Node<Person> attiq = new Node<Person>(uncle4); // setting the uncle4 as the parent of the branches
		Node<Person> adeel = new Node<Person>(me); // setting me as the parent of the branches
		Node<Person> kamil = new Node<Person>(mySon); // setting kamil as the parent of the branches
		Node<Person> nabeel = new Node<Person>(myBrother); // setting my brother as the parent of the branches
		Node<Person> zoa = new Node<Person>(myNiece1); // setting my brother as the parent of the branches
		Node<Person> kiran = new Node<Person>(mySister); // setting my brother as the parent of the branches
		Node<Person> zoha = new Node<Person>(myNiece2); // setting my brother as the parent of the branches
		Node<Person> taha = new Node<Person>(myNephew1); // setting my brother as the parent of the branches
		Node<Person> faisal = new Node<Person>(myCuzSonOfShabir); // setting my brother as the parent of the branches
		Node<Person> sania = new Node<Person>(myCuzDaughterOfShabir); // setting my brother as the parent of the branches

		Tree<Person> familyTree = new Tree<Person>();
		familyTree.add(rasheed, shafiq);
		familyTree.add(rasheed, rafiq);
		familyTree.add(rasheed, shabir);
		familyTree.add(rasheed, mushtaq);
		familyTree.add(rasheed, attiq);
		
		familyTree.add(shabir, faisal);
		familyTree.add(shabir, sania);
		
		familyTree.add(shafiq, adeel);
		familyTree.add(shafiq, nabeel);
		familyTree.add(shafiq, kiran);

		familyTree.add(adeel, kamil);
		
		familyTree.add(nabeel, zoa);
		
		familyTree.add(kiran, taha);
		//familyTree.add(kiran, zoha);

		System.out.println("familyTree\n");
		System.out.println("\nDepth First Search for Rasheed -- will return rasheed and all the decendents of rasheed");
		familyTree.dfs(rasheed);

		System.out.println("\n\nDepth First Search for Shafiq -- will return shafiq and all the decendents of shafiq");
		familyTree.dfs(shafiq);

		System.out.println("\n\nDepth First Search for zoha -- will return not found as it was not added in the tree");
		familyTree.dfs(zoha);

		
		System.out.println("\n\nBreadth First Search for Rasheed -- will return rasheed and all the decendents of rasheed");
		familyTree.bfs(rasheed);
		
		System.out.println("\n\nDepth First Search for Shafiq -- will return shafiq and all the decendents of shafiq");
		familyTree.bfs(shafiq);

		System.out.println("\n\nDepth First Search for zoha -- will return not found as it was not added in the tree");
		familyTree.bfs(zoha);
	
		

		Tree<String> myTree = new Tree<String>();
		Node<String> a = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> b1 = new Node<String>("B1");
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		myTree.add(a, b);
		myTree.add(b, b1);
		myTree.add(a, c);
		myTree.add(a, d);
	
		System.out.println("\n\nAlphabet Tree myTree\n");
		System.out.println("\nmyTree contains 'b': " + myTree.contains(b) + " who is child of " + b.getParent().getItem());
		System.out.println("myTree contains 'b1': " + myTree.contains(b) + " who is child of " + b1.getParent().getItem());
		myTree.removeChild(a, b);
		System.out.println("After removing b from 'a' does myTree contains b: " + myTree.contains(b));
		System.out.println("After removing 'b' from myTree, tree contains 'b1' who is child of 'b': " + myTree.contains(b1));
		System.out.println("myTree contains 'a': " + myTree.contains(a));
		System.out.println("myTree root is " + myTree.getRootNode().getItem().toString());
		System.out.println("myTree contains 'c' the child of a: " + myTree.contains(c));
		System.out.println("myTree contains 'd' the child of a: " + myTree.contains(d));
	}
}
