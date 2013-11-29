package me.agilani.www;

public class NodeTest
{
	public NodeTest()
	{
	}
	
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
		rasheed.setRoot(new Node<Person>(grandfather)); // setting the grandfather as the root of the tree
		
		Node<Person> shafiq = new Node<Person>(father); // setting the father as the parent of the branches
		Node<Person> rafiq = new Node<Person>(uncle1); // setting the uncle1 as the parent of the branches
		Node<Person> shabir = new Node<Person>(uncle2); // setting the uncle2 as the parent of the branches
		Node<Person> mushtaq = new Node<Person>(uncle3); // setting the uncle3 as the parent of the branches
		Node<Person> attiq = new Node<Person>(uncle4); // setting the uncle4 as the parent of the branches
		
		
		Node<Person> adeel = new Node<Person>(me); // setting me as the parent of the branches
		Node<Person> kamil = new Node<Person>(mySon); // setting kamil as the parent of the branches
		Node<Person> nabeel = new Node<Person>(myBrother); // setting my brother as the parent of the branches
		Node<Person> zoya = new Node<Person>(myNiece1); // setting my brother as the parent of the branches
		Node<Person> kiran = new Node<Person>(mySister); // setting my brother as the parent of the branches
		Node<Person> zoa = new Node<Person>(myNiece2); // setting my brother as the parent of the branches
		Node<Person> taha = new Node<Person>(myNephew1); // setting my brother as the parent of the branches
		
		Node<Person> faisal = new Node<Person>(myCuzSonOfShabir); // setting my brother as the parent of the branches
		Node<Person> sania = new Node<Person>(myCuzDaughterOfShabir); // setting my brother as the parent of the branches
		
		rasheed.addChild(shafiq);
		rasheed.addChild(rafiq);
		rasheed.addChild(shabir);
		rasheed.addChild(mushtaq);
		rasheed.addChild(attiq);
		
		shafiq.addChild(adeel);
		shafiq.addChild(nabeel);
		shafiq.addChild(kiran);
		
		shabir.addChild(faisal);
		shabir.addChild(sania);
		
		adeel.addChild(kamil);
		nabeel.addChild(zoya);
		kiran.addChild(zoa);
		kiran.addChild(taha);
		
		
		
		System.out.println( "\n" + "Root of the Tree" );
		System.out.println(rasheed.getItem().toString());
		
		System.out.println( "\n" + "Rasheed is root? " );
		System.out.println(rasheed.isRoot());
		
		System.out.println( "\n" + "Shafiq is root? " );
		System.out.println(shafiq.isRoot());
		
		System.out.println( "\n" + "Shafiq has children? " );
		System.out.println(shafiq.hasChildren());
		
		System.out.println( "\n" + "Nabeel has children? " );
		System.out.println(nabeel.hasChildren());
		
		System.out.println( "\n" + "Rasheed's children? " );
		Node<Person>[] children = rasheed.children();
		for(int i=0; i<children.length; i++)
		{
			System.out.println(children[i].getItem().toString());
		}
		
		System.out.println( "\n" + "Shafiq's children? " );
		children = shafiq.children();
		for(int i=0; i<children.length; i++)
		{
			System.out.println(children[i].getItem().toString());
		}


		System.out.println( "\n" + "Adeel's children? " );
		children = adeel.children();
	
		for(int i=0; i<children.length; i++)
		{
			System.out.println(children[i].getItem().toString());
		}

		System.out.println( "\n" + "Nabeel's children? " );
		children = nabeel.children();
		for(int i=0; i<children.length; i++)
		{
			System.out.println(children[i].getItem().toString());
		}

		
		
		System.out.println( "\n" + "Rasheed's siblings? " );
		Node<Person>[] siblings = rasheed.getSiblings();
		if(siblings!=null)
		{
			for(int i=0; i<siblings.length; i++)
			{
				System.out.println(siblings[i].getItem().toString());
			}
		}
		
		System.out.println( "\n" + "Shafiq's siblings? " );
		siblings = shafiq.getSiblings();
		if(siblings!=null)
		{
			for(int i=0; i<siblings.length; i++)
			{
				System.out.println(siblings[i].getItem().toString());
			}
		}

		System.out.println( "\n" + "Kamil's siblings? " );
		siblings = kamil.getSiblings();
		if(siblings!=null)
		{
			for(int i=0; i<siblings.length; i++)
			{
				System.out.println(siblings[i].getItem().toString());
			}
		}

		
		rasheed.removeChild(shabir);
		System.out.println( "\n" + "Rasheed's son Shabir is removed. OK!");
		
		System.out.println( "\n" + "Shafiq's siblings? " );
		siblings = shafiq.getSiblings();
		if(siblings!=null)
		{
			for(int i=0; i<siblings.length; i++)
			{
				System.out.println(siblings[i].getItem().toString());
			}
		}

		System.out.println( "\n" + "Adeel's Father is " + adeel.getParent().getItem().toString() );
		
	}
}
