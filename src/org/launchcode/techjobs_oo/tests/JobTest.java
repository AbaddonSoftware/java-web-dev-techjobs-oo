package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job jobWithFieldsSet;
    Job secondJobWithFieldsSet;

    @Before public void initializeTestData() {
        job1 = new Job();
        job2 = new Job();
        jobWithFieldsSet = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        secondJobWithFieldsSet = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        String msg = "job1 id: " + job1.getId() + " job2 id:" + job2.getId();
        assertTrue(msg, Math.abs(job2.getId() - job1.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        boolean isNameString = jobWithFieldsSet.getName() instanceof String;
        boolean isEmployer = jobWithFieldsSet.getEmployer() instanceof Employer;
        boolean isLocation = jobWithFieldsSet.getLocation() instanceof Location;
        boolean isPositionType = jobWithFieldsSet.getPositionType() instanceof PositionType;
        boolean isCoreCompetency = jobWithFieldsSet.getCoreCompetency() instanceof CoreCompetency;
        boolean allFieldsOfProperClass = isNameString
                                     && isEmployer
                                     && isLocation
                                     && isPositionType
                                     && isCoreCompetency;
        boolean nameSetAsGiven = jobWithFieldsSet.getName().equals("Product Tester");
        boolean employerSetAsGiven = jobWithFieldsSet.getEmployer().toString().equals("ACME");
        boolean locationSetAsGiven = jobWithFieldsSet.getLocation().toString().equals("Desert");
        boolean positionTypeSetAsGiven = jobWithFieldsSet.getPositionType().toString().equals("Quality Control");
        boolean coreCompetencySetAsGiven = jobWithFieldsSet.getCoreCompetency().toString().equals("Persistence");
        boolean allFieldsSetAsGiven = nameSetAsGiven
                                    && employerSetAsGiven
                                    && locationSetAsGiven
                                    && positionTypeSetAsGiven
                                    && coreCompetencySetAsGiven;
        String msg = String.format("Fields match proper class?\nisName: %b, isEmployer: %b, isLocation: %b, isPositionType: %b, isCoreCompetency: %b,\n", isNameString, isEmployer, isLocation, isPositionType, isCoreCompetency);
        msg += String.format("Fields set as input?\nnameSetAsGiven: %b, employerSetAsGiven: %b, locationSetAsGiven: %b, positionTypeSetAsGiven: %b, coreCompetencySetAsGiven: %b\n", nameSetAsGiven, employerSetAsGiven, locationSetAsGiven, positionTypeSetAsGiven, coreCompetencySetAsGiven);
        assertTrue(msg, allFieldsOfProperClass && allFieldsSetAsGiven);
    }

    @Test
    public void testJobsForInequality() {
        assertNotEquals(jobWithFieldsSet, secondJobWithFieldsSet);
    }

    @Test
    public void testToStringHasNewLineBeforeAndAfter() {
        assertTrue(job1.toString().startsWith("\n") && job1.toString().endsWith("\n"));
    }

    @Test
    public void testToStringPrintsFieldsAndData() {
        String expected = "\n" +
                          "ID: " + jobWithFieldsSet.getId()+"\n"+
                          "Name: " + "Product Tester"+"\n"+
                          "Employer: " +"ACME"+"\n"+
                          "Location: " +"Desert"+"\n"+
                          "Position Type: " +"Quality Control"+"\n"+
                          "Core Competency: " +"Persistence"+"\n";
        assertEquals(expected, jobWithFieldsSet.toString());
    }

    @Test
    public void testToStringEmptyFieldsPrintsDefaultString() {
        job1.setEmployer(new Employer("Abaddon Software"));
        job1.setLocation(null);
        job1.setCoreCompetency(new CoreCompetency("     "));
        job1.setPositionType(new PositionType("         "));
        String expected = "\n" + "ID: " + job1.getId()+"\n"+
                "Name: Data not available\n"+
                "Employer: Abaddon Software\n"+
                "Location: Data not available\n"+
                "Position Type: Data not available\n"+
                "Core Competency: Data not available\n";
        assertEquals(job1.toString(), expected, job1.toString());
    }

    @Test
    public void testToStringOnlyIdSetReturnOopsMsg() {
        assertEquals("\nOOPS! This job does not seem to exist.\n", job1.toString());
    }
}
