package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Kakikomi implements Serializable {
    private int id;
    private String name;
    private String comment;
    private Date date;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTime(Timestamp timestamp) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
 

}
