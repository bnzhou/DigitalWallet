package io.spring.cloud.samples.commerce.addressservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String description;

    public String getUsername() {return username;}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Login {");
        sb.append("username='").append(username).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
