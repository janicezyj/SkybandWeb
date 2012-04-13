/*  
This file: BookmarkBean.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The bean represents an entry in the 
bookmark database - hsuehhac_bookmark
Last Modified: 2/26/2011
Compiler: JavaSE 1.6
*/

package databeans;

public class BookmarkBean implements Comparable<BookmarkBean>{
	private int 	bookmarkId	= -1;
	private int 	userId		= -1;
	private String 	url			= null;
	private String 	comment		= null;
	private int 	clickCount	= 0;
	
	public int compareTo(BookmarkBean other) {
		// Order first by userId, then by bookmarkId
		if (userId == -1 && other.userId != -1) return -1; 
		if (userId != -1 && other.userId == -1) return 1;
		int c = userId - other.userId;
		if (c != 0) return c;
		
		return bookmarkId - other.bookmarkId;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof BookmarkBean) {
			BookmarkBean other = (BookmarkBean)obj;
			return compareTo(other) == 0;
		}
		return false;
	}
	
	public int getBookmarkId() { return bookmarkId;	}
	public int getUserId() { return userId;	}
	public String getUrl() { return url; }	
	public String getComment() { return comment; }
	public int getClickCount() { return clickCount;	}
	
	public void setUserId(int userId) { this.userId = userId; }
	public void setUrl(String URL) { this.url = URL; }
	public void setComment(String comment) { this.comment = comment; }
	public void setClickCount(int clickCount) {	this.clickCount = clickCount; }
	public void setBookmarkId(int id) { bookmarkId = id; }
	
    public String toString() {
    	return "User("+userId+"), Bookmark("+bookmarkId+")";
    }
}
