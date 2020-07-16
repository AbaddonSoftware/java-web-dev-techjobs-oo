package org.launchcode.techjobs_oo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Job {

    private final int ID;
    private static int nextId = 1;

    private final String NO_DATA = "Data not available";
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        ID = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    private String dataAvailable(String aString) {
        return Objects.nonNull(aString) && !aString.matches("[\\s]*") ? aString : NO_DATA;
    }
    private String dataAvailable(JobField aJobField) {
        return Objects.nonNull(aJobField) && !aJobField.getValue().matches("[\\s]*") ? aJobField.getValue() : NO_DATA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return ID == job.ID;
    }

    @Override
    public String toString() {
        String id = Integer.toString(getId());
        String name =  dataAvailable(this.name);
        String employer =  dataAvailable(getEmployer());
        String location =  dataAvailable(getLocation());
        String positionType = dataAvailable(getPositionType());
        String coreCompetency = dataAvailable(getCoreCompetency());
        List<String> allStrings = Arrays.asList(name, employer, location, positionType, coreCompetency);
        boolean dataAvailable = !allStrings.stream().allMatch(aString -> aString.equals(NO_DATA));
        return  dataAvailable ?
                String.format("\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency)
                        : "\nOOPS! This job does not seem to exist.\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, employer, location, positionType, coreCompetency);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return ID;
    }

}
