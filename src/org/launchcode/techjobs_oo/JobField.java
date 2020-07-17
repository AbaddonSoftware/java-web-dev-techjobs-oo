package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    private final int ID;
    private String value;

    public JobField(int nextId) {
          ID = nextId;
    }

    public JobField(int nextId ,String value) {
        this(nextId);
        this.value = value;
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return ID == jobField.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public int getId() {
        return ID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

