package models;

import lombok.Builder;

@Builder
public class UserBuilder {

    /**
     * Email of the user
     *
     * @param email New value for this User's email.
     * @return The current value of this User's email.
     */
    private String email = "atrostyanko@gmail.com";

    /**
     * Psw of the User
     *
     * @param psw New value for this User's psw.
     * @return The current value of this User's psw.
     */
    private String psw = "Americana#1";

}