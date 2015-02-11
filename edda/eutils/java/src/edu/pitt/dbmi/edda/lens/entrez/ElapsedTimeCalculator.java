package edu.pitt.dbmi.edda.lens.entrez;

import java.util.Date;

public class ElapsedTimeCalculator {

	private long secondInMillis = 1000;
	private long minuteInMillis = secondInMillis * 60;
	private long hourInMillis = minuteInMillis * 60;
	private long dayInMillis = hourInMillis * 24;

	private Date startDate;
	private Date stopDate;
	private long elapsedDays = 0L;
	private long elapsedHours = 0L;
	private long elapsedMinutes = 0L;
	private long elapsedSeconds = 0L;

	public void execute() {
		long l1 = startDate.getTime();
		long l2 = stopDate.getTime();
		long diff = l2 - l1;
		elapsedDays = diff / dayInMillis;
		diff = diff % dayInMillis;
		elapsedHours = diff / hourInMillis;
		diff = diff % hourInMillis;
		elapsedMinutes = diff / minuteInMillis;
		diff = diff % minuteInMillis;
		elapsedSeconds = diff / secondInMillis;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}


	public String toString() {
		return String.format("%d days, %d hours, %d minutes, %d seconds",
				elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
	}

}
