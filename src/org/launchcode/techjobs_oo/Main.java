package org.launchcode.techjobs_oo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void testIds() {
        Location firstLocation = new Location("First Location");
        Location secondLocation = new Location("Second Location");
        Employer firstEmployer = new Employer("First Employer");
        Employer secondEmployer = new Employer("Second Employer");
        Location thirdLocation = new Location("Third Location");
        Employer thirdEmployer = new Employer("Third Employer");
        Location fourthLocation = new Location("Fourth Location");
        List<JobField> jobFields = Arrays.asList(firstLocation, secondLocation, firstEmployer, secondEmployer, thirdLocation, thirdEmployer, fourthLocation);
        for(JobField jobField : jobFields) {
            System.out.println(jobField.getValue() + ": " + jobField.getId());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Run ID example code? Y/N");
        String runTests = input.nextLine();
        if(runTests.toLowerCase().trim().matches("^y|yes$")) testIds();

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
