package com.test.refig;

import java.util.HashMap;
import java.util.Map;
import com.test.refig.Refrigerator.RACKTYPE;

public class TestRefrigerator {
	public static void main(String[] args) {
		Map<RACKTYPE, Integer> capacityMap = new HashMap<Refrigerator.RACKTYPE, Integer>();
		//Define the initial capacity for the shelves
		capacityMap.put(RACKTYPE.SMALL, 10);   //It means SMALL shelve/rack has capacity of 10
		capacityMap.put(RACKTYPE.MEDIUM, 20);
		capacityMap.put(RACKTYPE.LARGE, 30);
		try {
			Refrigerator refrigerator = new Refrigerator(capacityMap);
			Refrigerator.Item item1 = new Refrigerator(capacityMap).new Item(1, 5, RACKTYPE.SMALL, "Apples"); //Item(itemId, itemCount, RACKTYPE, itemName)
			Refrigerator.Item item2 = new Refrigerator(capacityMap).new Item(1, 5, RACKTYPE.SMALL, "Apples");
			
			/*******************************************************************************
			 *  NOTE: FOR TESTING BELOW CASES COMMENT OR UN-COMMENT WHEREVER ITS REQUIRED. *
			 * *****************************************************************************/
			
			/**********************************************************************
			 *  CASE 1: NO ITEM FOUND. BECAUSE item1 is not present in REFRIGERATOR
			 **********************************************************************/
			refrigerator.getItem(item1);  //O/P: No Item found
			
			
			/*********************************
			 *  CASE 2: PUT AN ITEM IN REFRIGERATOR. 
			 * *******************************/
			//if (refrigerator.putItem(item1)) {
			//	System.out.println("Please close the door.");	//O/P: Please close the door.
			//}
			
			
			/****************************************
			 *  CASE 3: PUT item1 and item2 IN REFRIGERATOR
			 * **************************************/
			//if (refrigerator.putItem(item1) && refrigerator.putItem(item2)) {
			//	System.out.println("Please close the door.");		//O/P: Please close the door.
			//}
			
			/****************************************
			 *  CASE 4: PUT item1 and item2 IN REFRIGERATOR AND GET item1 FROM REFRIGERATOR
			 * **************************************/
			//if (refrigerator.putItem(item1) && refrigerator.putItem(item2) && refrigerator.getItem(item1)) {
			//	System.out.println("Please close the door.");	//O/P: Please close the door.
			//}
			
			
			/*****************************************************************************
			 *  CASE 5: IF COUNT OF items MORE THAN CAPACITY OF SHELVE/RACK, THROUGH ERROR.
			 * ***************************************************************************/
			//refrigerator.putItem(item1);	//AFTER PUTTING item1, SHELVE CAPACITY= 5
			//refrigerator.putItem(item2);	//AFTER PUTTING item1, SHELVE CAPACITY= 0, IF WE PUT item AGAIN THEN BELOW O/P WE WILL GET
			//refrigerator.putItem(item2);	//O/P: Not Enough Space. Please place item in different rack or remove some items
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
