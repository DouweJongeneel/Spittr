package com.douwe;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;

/**
 * Created by Milan_Verheij on 03-08-16.
 *
 * Spitter model
 */

public class Spitter {

    private Long id;

    /*
     * Doordat username.size binnen { } staat wordt aangegeven dat het om een property uit 
     * een properties bestand gaat. Wanneer de accolades weggelaten worden wordt de error message
     * als message doorgegeven.
     */
    @NotNull // Javax Validation
    @Size(min=5, max=16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message = "{password.size}")
    private String password;

    @NotNull
    @Size(min=2, max=30, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min=2, max=30, message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Email(message = "{email.valid}") // Hibernate validation
    private String email;

    public Spitter() {}

    public Spitter(String username, String password, String firstName,
                   String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }

    public Spitter(Long id, String username, String password,
                   String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Apache commons overrides
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password", "email");

    }
}
