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

  }
