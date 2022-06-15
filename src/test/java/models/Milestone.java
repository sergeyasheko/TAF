package models;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Milestone {

    /**
     * Name of the Milestone
     *
     * @param name New value for this Milestone's name.
     * @return The current value of this Milestone's name.
     */
    private String name = "first";

    /**
     * Age of the person
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    private String references;

    /**
     * Age of the person
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    private String description;

  }
