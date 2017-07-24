package com.tarena.entity;

public class BookItem {
	private int count;// ͼ������
	private Book book;// ͼ����
	private double s;// ��ʡ���

	public BookItem() {// �޲ι�����

	}

	public BookItem(int count, Book book) {

		this.count = count;
		this.book = book;
		this.s = book.getFixedPrice() - book.getDangPrice();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

	public double getSave() {
		return s * count;
	}

	public double getTotleA() {
		return book.getDangPrice() * count;

	}
}
