package org.launchcode.techjobs_oo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
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

    private String isEmptyOrNull(Object anObject) {
        if(anObject != null) {
            return !anObject.toString().matches("[\\s]*") ? anObject.toString() : "Data not available";
        }
        return "Data not available";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public String toString() {
        String id = Integer.toString(getId());
        String name = isEmptyOrNull(getName());
        String employer =  isEmptyOrNull(getEmployer());
        String location =  isEmptyOrNull(getLocation());
        String positionType = isEmptyOrNull(getPositionType());
        String coreCompetency = isEmptyOrNull(getCoreCompetency());
        List<String> allString = Arrays.asList(name, employer, location, positionType, coreCompetency);
        boolean dataAvailable = !allString.stream().allMatch(aString -> aString.equals("Data not available"));
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
        return Objects.hash(id);
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
        return id;
    }

}
