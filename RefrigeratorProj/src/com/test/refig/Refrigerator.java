package com.test.refig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Refrigerator {

	List<Item> items;
	Map<RACKTYPE, Integer> capacityMap;

	public Refrigerator(Map<RACKTYPE, Integer> capacity) throws Exception {
		if (capacity == null || capacity.size() < 3) {
			throw new Exception("Please specify capacity for all types of racks");
		}
		items = new ArrayList<Refrigerator.Item>();
		capacityMap = capacity;
	}

	/********************************************************************
	 *  Class: Item														*
	 *  Description: It has properties like itemId, itemSize(Shelve)	*
	 *  			name (item name), itemCount(how many items)			*
	 * ******************************************************************/
	public class Item {
		int itemId;
		RACKTYPE itemSize;
		String name;
		int itemCount;

		public Item(int itemId, int itemCount, RACKTYPE size, String name) {
			this.itemId = itemId;
			this.itemSize = size;
			this.name = name;
			this.itemCount = itemCount;
		}

		public Item(int itemId) {
			this.itemId = itemId;
		}

		public int getItemId() {
			return itemId;
		}

		public String getName() {
			return name;
		}

		public RACKTYPE getItemSize() {
			return itemSize;
		}

	}
	/**************************************************
	 *  Custom Exception for handling error scenario  *
	 * ************************************************/
	public class NotEnoughSpaceException extends Exception {
		public NotEnoughSpaceException(String msg) {
			super(msg);
		}
	}
	/******************************************
	 *  Define the racks in the refrigerator  *
	 * ****************************************/
	public enum RACKTYPE {
		SMALL, MEDIUM, LARGE
	}

	
	/************************************************************
	 *  Method: putItem											*
	 *  Description: used for adding items to the refrigerator  *
	 *  			 in respective shelves  					*
	 * **********************************************************/
	public boolean putItem(Item item) throws NotEnoughSpaceException {
		if (item == null) {
			return false;
		}
		if (capacityMap.get(item.getItemSize()) < item.itemCount) {		// If rackSize < itemCount then through error
			throw new NotEnoughSpaceException("Not Enough Space. Please place item in different rack or remove some items");
		}
		items.add(item);
		capacityMap.put(item.getItemSize(), Integer.valueOf(capacityMap.get(item.getItemSize()).intValue() - item.itemCount));
		return true;
	}

	/****************************************************************
	 *  Method: getItem								 				*
	 *  Description: used for removing items from the refrigerator  *
	 *  			 from respective shelves  						*
	 * **************************************************************/
	public boolean getItem(Item item) throws Exception {
		int index = items.indexOf(item);
		if (index >= 0) {
			Item itemRem = items.get(index); // item to be removed
			items.remove(itemRem);
			capacityMap.put(item.getItemSize(), Integer.valueOf(capacityMap.get(item.getItemSize()).intValue() + item.itemCount));
			return true;
		} else {
			throw new Exception("No Item found");
		}

	}
}

