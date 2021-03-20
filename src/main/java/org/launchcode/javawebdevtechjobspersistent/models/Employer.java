package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message="Location is required")
    @Size(min=2, message="Location must be at least 2 characters long")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer(@NotBlank(message = "Location is required")
                    @Size(min = 2, message = "Location must be at least 2 characters long") String location) {
        this.location = location;
    }

    public Employer() {
    }
}
