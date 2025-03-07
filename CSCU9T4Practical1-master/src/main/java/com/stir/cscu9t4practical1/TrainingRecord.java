// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TrainingRecord {
	private List<Entry> tr;

	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} // constructor

	// add a record to the list
	public void addEntry(Entry e) {
		tr.add(e);
	} // addClass

	// look up the entry of a given day and month
	public String lookupEntry(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result = current.getEntry();
		}
		return result;
	} // lookupEntry

	// Count the number of entries
	public int getNumberOfEntries() {
		return tr.size();
	}

	// Clear all entries
	public void clearAllEntries() {
		tr.clear();
	}

	// find all entries of a given day and month
	public List<Entry> findAllEntries(int d, int m, int y) {
		List<Entry> entries = new ArrayList<Entry>();
		for (Entry entry : tr) {
			if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
				entries.add(entry);
			}
		}
		return entries;
	}
} // TrainingRecord