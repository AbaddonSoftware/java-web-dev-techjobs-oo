package org.launchcode.techjobs_oo;



public class Location extends JobField{
    private static int nextId = 0;

    public Location(String value) {
        super(nextId++, value);
    }

}
