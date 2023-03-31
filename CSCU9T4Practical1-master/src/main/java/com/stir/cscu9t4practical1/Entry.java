// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class Entry {
	private String name;
	private Calendar dateAndTime;
	private float distance;
    private int hours;
    private int minutes;
    private int seconds;
    private Object location;

	public Entry(String n, int d, int m, int y, int h, int min, int s, float dist) {
		name = n;
		Calendar inst = Calendar.getInstance();
		inst.set(y, m - 1, d, h, min, s);
		dateAndTime = inst;
		distance = dist;
	} // constructor

	public String getName() {
		return name;
	} // getName

	public int getDay() {
		return dateAndTime.get(Calendar.DATE);
	} // getDay

	public int getMonth() {
		int month = dateAndTime.get(Calendar.MONTH) + 1;
		return month;
	} // getMonth

	public int getYear() {
		return dateAndTime.get(Calendar.YEAR);
	} // getYear

	public int getHour() {
		return dateAndTime.get(Calendar.HOUR);
	} // getHour

	public int getMin() {
		return dateAndTime.get(Calendar.MINUTE);
	} // getMin

	public int getSec() {
		return dateAndTime.get(Calendar.SECOND);
	} // getSec

	public float getDistance() {
		return distance;
	} // getYear

	public String getEntry() {
		String result = getName() + " ran " + getDistance() + " km at " + getTime() + " on " + getDay() + "/"
				+ getMonth() + "/" + getYear() + "\n";
		return result;
	}

	public String getTime() {
		int hour = dateAndTime.get(Calendar.HOUR_OF_DAY);
		int minute = dateAndTime.get(Calendar.MINUTE);
		int second = dateAndTime.get(Calendar.SECOND);
		String time = String.format("%02d:%02d:%02d", hour, minute, second);
		return time;
	}
        public double getTempo() {
    double totalTimeInMinutes = (getHour() * 60) + getMin() + (getSec() / 60.0);
    double tempo = totalTimeInMinutes / getDistance();
    return tempo;
}
public String getTerrain() {
    if (getDistance() < 3) {
        return "Flat Terrain";
    } else if (getDistance() >= 3 && getDistance() <= 7) {
        return "Mixed Terrain";
    } else {
        return "Hilly Terrain";
    }
}
public int getRepetitions() {
    if (this instanceof SprintEntry) {
        SprintEntry sprint = (SprintEntry) this;
        return sprint.getSets() * sprint.getReps();
    } else {
        return -1; 
    }
    
}
public int getSets() {
            int sets = 0;
    return sets;
}

public int getReps() {
            int reps = 0;
    return reps;
}

public int getRecovery() {
    int repetitions = getRepetitions();
    double intensity = (double) getSpeed() / (double) getDistance();
    int recovery = (int) (repetitions * intensity * 2);
    return recovery;
}
public double getSpeed() {
    // Calculate the total distance covered in meters
    double distance = this.distance * 1000; // convert from kilometers to meters
    // Calculate the time taken in seconds
    double time = (this.hours * 3600) + (this.minutes * 60) + this.seconds;
    // Calculate the speed in meters per second
    double speed = distance / time;
    return speed;
}
public String getWhere() {
    if (location.equals("outdoors")) {
        return "outdoors";
    } else {
        return "in a pool";
    }
}



} // Entry