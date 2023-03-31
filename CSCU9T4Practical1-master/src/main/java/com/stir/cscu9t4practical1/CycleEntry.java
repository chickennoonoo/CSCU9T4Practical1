package com.stir.cscu9t4practical1;

class CycleEntry extends Entry {
    private String where;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, int dist, String w, String moderate) {
        super(n, d, m, y, h, min, s, dist);
        where = w;
    }

    public String getWhere() {
        return where;
    }

    public String getEntry() {
        String result = getName() + " cycled " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec()
                + " on " + getDay() + "/" + getMonth() + "/" + getYear() + " at " + getWhere() + "\n";
        return result;
    }
}
