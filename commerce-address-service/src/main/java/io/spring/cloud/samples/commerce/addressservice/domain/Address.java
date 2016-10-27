package io.spring.cloud.samples.commerce.addressservice.domain;

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

    public String getAddr() { return address;}

    public void setAddr(String address) { this.address = address; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address {");
        sb.append("username='").append(username).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
