package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tarena.dao.BookDAO;
import com.tarena.entity.Book;
import com.tarena.util.DBUtil;

public class BookDAOImpl implements BookDAO{

	public ArrayList getBooks() {
		ArrayList books=null;
		try {
			Connection con=DBUtil.getConnection();
			
			String sql="select * from d_book";
			PreparedStatement prep=con.prepareStatement(sql);
			ResultSet rs=prep.executeQuery();
			
//			String sql="select * from d_book";
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery(sql);
			
			books=new ArrayList();
			while(rs.next()){
				Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setProductName(rs.getString("product_name"));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setProductPic(rs.getString("product_pic"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(rs.getDate("publish_time"));
				book.setAuthorSummary(rs.getString("author_summary"));
				book.setDescription(rs.getString("description"));
				//book.setScore(rs.getInt("score"));
				books.add(book);
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			Connection con=DBUtil.getConnection();
			String sql="select * from d_book where id=?";
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs=prep.executeQuery();
			
			while(rs.next()){
			    book=new Book();
				book.setId(rs.getInt("id"));
				book.setProductName(rs.getString("product_name"));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setProductPic(rs.getString("product_pic"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(rs.getDate("publish_time"));
				book.setAuthorSummary(rs.getString("author_summary"));
				book.setDescription(rs.getString("description"));
				book.setScore(rs.getInt("score"));
				
			}
			DBUtil.close(rs, prep, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
		
	}

}
