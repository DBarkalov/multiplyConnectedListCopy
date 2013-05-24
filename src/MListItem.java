/***
 *  copy of multiply linked list exapmle  
 * @author Dmitry Barkalov
 */
public class MListItem {

	// todo make private  members
	public String val;	
	public MListItem next;
	public MListItem rand;

	MListItem(MListItem next, MListItem rand, String val){
		this.next = next;
		this.rand = rand;
		this.val = val;		
	}

	private static void insertAfter(MListItem insertAfter){
		insertAfter.next = new MListItem(insertAfter.next, null, insertAfter.val);		
	}
	
	public static void print (MListItem first){
		MListItem item = first;
		while(item != null){
			System.out.println("item val = " + item.val + "  item.rand.val = " + item.rand.val);
			item = item.next;
		}
	}
	
 	public static boolean equals(final MListItem list1 ,  final  MListItem list2){		
 		MListItem i1 = list1;
 		MListItem i2 = list2; 		
 		while(i1 != null  && i2 != null){ 			
 			if(!(i1.val.equals(i2.val)) || !(i1.rand.val.equals(i2.rand.val))){
 				return false;
 			} 			
 			i1 = i1.next; 
 			i2 = i2.next;
		} 		 		
 		return true;
 	} 
	
	public static  MListItem getCopy (MListItem origFirst){		
		// 1 add copy items after orinals
		MListItem item = origFirst;		
		while(item != null ){
			insertAfter(item);
			item = item.next.next; 
		}
				
		// 2 set rand reference		
		item = origFirst;		
		while(item != null ){
			item.next.rand = item.rand.next;  
		    item = item.next.next;
		}
				
		// 3 separate new list
		MListItem result = origFirst.next;		
		item = origFirst;		
		while(item != null && item.next != null ){
			MListItem orig = item;
			MListItem copy = item.next;
			item = copy.next;
			orig.next = copy.next;
			if(copy.next != null){
				copy.next = copy.next.next;
			} 
		}
				
		return result;								
	}
	
}
