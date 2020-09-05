package com.wellsfargo.stockmarket.stockpricedetails.response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResponseMessage {

	private String message;
	private int sz;
	private long code;
	private Date d1;
	private Date d2;
	List<String> Ls;

	  public ResponseMessage(String message, int sz, long code, Date d1, Date d2) {

	    this.sz = sz;
	    this.code = code;
	    this.d1 = d1;
	    this.d2 = d2;
	    this.message = message ;
	    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	    Ls = new ArrayList<String>();
	    Ls.add("Upload successful for file: " + this.message);
	    Ls.add("Number Of Records         : " + Integer.toString(sz));
	    Ls.add("Company code is           : " + Long.toString(code));
	    Ls.add("Start Date                : " + dateFormat.format(d1));
	    Ls.add("End Date                  : " + dateFormat.format(d2));
	    
	  }
	  public ResponseMessage(String message) {
		  this.message = message;
		  Ls = new ArrayList<String>();
		  this.Ls.add(this.message);
	  }

	  public List<String> getMessage() {
	    return this.Ls;
	  }
	  
}
