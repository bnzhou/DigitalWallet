package io.spring.cloud.samples.commerce.address.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String address;

    public Address(){}

    public Address(String id, String username, String address){
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public String getid() { return id;}

    public void setid(String id) { this.id = id; }

    public String getusername() { return username;}

    public void setusername(String username) { this.username = username; }

    public String getAddr() { return address;}

    public void setAddr(String address) { this.address = address; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address {");
        sb.append("username='").append(username).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
