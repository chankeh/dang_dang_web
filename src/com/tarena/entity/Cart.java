package com.tarena.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
    private ArrayList<BookItem> itemList  = new ArrayList<BookItem>();
    public ArrayList<BookItem> getItemList() {
		return itemList;
	}
    
	public void setItemList(ArrayList<BookItem> itemList) {
		this.itemList = itemList;
	}
	public double getSave(){
		double all=0;
		for (BookItem item :itemList ) {
			all+=item.getSave();
		}
		return all;
	}
	public double getTotleA(){
		double all=0;
		for (BookItem item :itemList ) {
			all+=item.getTotleA();
		}
		return all;
	}
	public void update(int id,int num){
		for (BookItem item :itemList) {
			if(item.getBook().getId()==id){
				item.setCount(num);
			}
		}
	}
	public void delete(int id){
		Iterator<BookItem>list = itemList.iterator();
		while(list.hasNext()){
			if(list.next().getBook().getId()==id){
				list.remove();
			}
		}
	}

	
}
