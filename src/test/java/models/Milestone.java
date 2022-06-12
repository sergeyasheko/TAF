package models;

public class Milestone {

    private String name;
    private String references;
    private String description;

    public static class Builder {
        private Milestone newMilestone;

        public Builder() {
            newMilestone = new Milestone();
        }

        public Builder withName(String name) {
            newMilestone.name = name;
            return this;
        }

        public Builder withReferences(String references) {
            newMilestone.references = references;
            return this;
        }

        public Builder withDescription(String description) {
            newMilestone.description = description;
            return this;
        }

        public Milestone build() {
            return newMilestone;
        }
    }

    public String getName() {
        return name;
    }

    public String getReferences() {
        return references;
    }

    public String getDescription() {
        return description;
    }
}
