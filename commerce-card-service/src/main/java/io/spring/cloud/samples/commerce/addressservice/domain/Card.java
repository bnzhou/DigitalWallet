package io.spring.cloud.samples.commerce.addressservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String lastDigits;

    @Column(nullable = false)
    private String cardHolder;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private String expireDate;

    @Column(nullable = false)
    private String secureNum;

    @Column(nullable = true)
    private String description;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(cardHolder).append('\'');
        sb.append(", last-four-digit='").append(lastDigits).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
