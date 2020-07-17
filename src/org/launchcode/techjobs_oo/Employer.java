package org.launchcode.techjobs_oo;



public class Employer extends JobField {
    private static int nextId = 0;

    public Employer(String value) {
        super(nextId++, value);
    }

}
