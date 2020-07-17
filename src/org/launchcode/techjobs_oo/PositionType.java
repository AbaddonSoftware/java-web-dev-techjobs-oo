package org.launchcode.techjobs_oo;


public class PositionType extends JobField{
    private static int nextId = 1;

    public PositionType(String value) {
        super(nextId, value);
        nextId++;
    }

}
