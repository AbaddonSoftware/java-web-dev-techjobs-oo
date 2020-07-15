package org.launchcode.techjobs_oo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        Job job4 = new Job(null, null, null, null, null);
        Job job5 = new Job("    ", null, new Location("     \n"), new PositionType("who cares"), new CoreCompetency("stuff"));

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);

//        String line;
//        StringBuilder stringFromFile = new StringBuilder();
//        BufferedReader fileRead = new BufferedReader(new FileReader( "./resources/file.txt" ));
//        while((line = fileRead.readLine()) != null) {
//            String asLine = line + "\n";
//            stringFromFile.append(asLine);
//        }

        for (Job job : jobs){
            System.out.println(job);
        }
    }

}
