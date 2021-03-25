package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message="Location is required")
    @Size(min=2, message="Location must be at least 2 characters long")
    private String location;


    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer(@NotBlank(message = "Location is required")
                    @Size(min = 2, message = "Location must be at least 2 characters long")
                            String location) {
        this.location = location;
    }

    public Employer() {
    }
}
