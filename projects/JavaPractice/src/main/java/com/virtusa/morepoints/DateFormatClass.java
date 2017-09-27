package com.virtusa.morepoints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateFormatClass {
	public static void main(String[] args) throws ParseException {
		//Instant timestamp = Instant.now();
	//	System.out.println("instance time"+timestamp);
		String date2 = null;
		    String dateStart = "2017-05-10T10:45:22Z";
		   // SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD\'T\'HH:mm:ssZ");
		   // Instant timestamp1=Instant.parse(dateStart);
		    /*long secondsFromEpoch = Instant.ofEpochSecond(timestamp).until(Instant.now(),
                    ChronoUnit.SECONDS);*/
		  //  boolean result=
		  //  System.out.println(timestamp1);
		   /* if((timestamp-timestamp1)>15)
		    {
		    	
		    }*/
		    Date dateStop=new Date();
		   // System.out.println(dateStop.toString()+"GMT"+dateStop.toGMTString());
		 //   Custom date format
		    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ");
		    date2 = format.format(dateStop);
		    System.out.println(date2);
		   Date d1 = null;
		   Date d2 = null;
		  //  try {
		        d1 = format.parse(dateStart);
		        d2 = format.parse(date2);
		   // } catch (ParseException e) {
		    //    e.printStackTrace();
		   // }
		    System.out.println(dateStart);
		    System.out.println("d2 date"+d2);

		  //   Get msec from each, and subtract.
		    long diff = d2.getTime() - d1.getTime();
		    long diffSeconds = diff / 1000 % 60;
		    long diffMinutes = diff / (60 * 1000) % 60;
		    long diffHours = diff / (60 * 60 * 1000);
		    System.out.println("Time in seconds: " + diffSeconds + " seconds.");
		    System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		    System.out.println("Time in hours: " + diffHours + " hours.");
	}

}
