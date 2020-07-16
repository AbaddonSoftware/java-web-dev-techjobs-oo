package org.launchcode.techjobs_oo;

import java.util.Arrays;
import java.util.List;

public class Main {
    public String test = "test 123";

    public static void main(String[] args) {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        Job job4 = new Job(null, null, null, null, new CoreCompetency(""));
        Job job5 = new Job("    ", null, new Location("     \n"), new PositionType("who cares"), new CoreCompetency("stuff"));
        Job job6 = new Job();

        List<Job> jobs = Arrays.asList(job1, job2, job3, job4, job5, job6);


        for (Job job : jobs){
            System.out.println("Job ID:" +job.getId());
            System.out.println(job);
        }
    }

}
