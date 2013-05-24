
public class Test {

	
	public static void main(String[] args) {

		// new items
		MListItem l1 = new MListItem(null, null, "l1");
		MListItem l2 = new MListItem(null, null, "l2");
		MListItem l3 = new MListItem(null, null, "l3");
		// set random references
		l1.next = l2;
		l1.rand = l3;		
		l2.next = l3;
		l2.rand = l1;		
		l3.next = null;
		l3.rand = l2;				
		
		System.out.println(" original list");
		MListItem.print(l1);
		
		System.out.println("list copy");		
		MListItem l2copy = MListItem.getCopy(l1);
		MListItem.print(l2copy);
				
		System.out.println("equals ?  --------------------------------");
		System.out.println(MListItem.equals(l1, l2copy));
	}

}
