package org.launchcode.techjobs_oo;


public class PositionType extends JobField{
    private static int nextId = 0;

    public PositionType(String value) {
        super(nextId++, value);
    }

}
