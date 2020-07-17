package org.launchcode.techjobs_oo;



public class CoreCompetency extends JobField{

    private static int nextId = 0;

    public CoreCompetency(String value) {
        super(nextId++, value);
    }

}
