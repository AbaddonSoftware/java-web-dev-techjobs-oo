package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
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
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


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



    @Override
    public String toString() {
        boolean isNameEmpty = getName() == null || getName().equals("");
        boolean isEmployerEmpty = getEmployer() == null || getEmployer().toString().equals("");
        boolean isLocationEmpty = getLocation() == null || getLocation().toString().equals("");
        boolean isPositionTypeEmpty = getPositionType() == null || getPositionType().toString().equals("");
        boolean isCoreCompetencyEmpty = getCoreCompetency() == null || getCoreCompetency().toString().equals("");
        boolean allNonIdFieldsEmpty = (isNameEmpty && isEmployerEmpty && isLocationEmpty && isPositionTypeEmpty && isCoreCompetencyEmpty);
        String id = Integer.toString(getId());
        String name = isNameEmpty ? "Data not available" : getName();
        String employer =  isEmployerEmpty ? "Data not available" : getEmployer().toString();
        String location =  isLocationEmpty ? "Data not available" : getLocation().toString();
        String positionType = isPositionTypeEmpty  ? "Data not available" : getPositionType().toString();
        String coreCompetency = isCoreCompetencyEmpty ? "Data not available" : getCoreCompetency().toString();
        return !allNonIdFieldsEmpty ? String.format("\nID: %s\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n", id, name, employer, location, positionType, coreCompetency) : "\nOOPS! This job does not seem to exist.\n";
    }
}
