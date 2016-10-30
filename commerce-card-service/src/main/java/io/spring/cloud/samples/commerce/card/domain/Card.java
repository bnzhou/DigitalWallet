package io.spring.cloud.samples.commerce.card.domain;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    private String cardNumber;

    @Column(nullable = false)
    private String username;

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

    public Card() {}

    public Card (String cardNumber, String username, String cardHolder,
                 String cardType, String expireDate, String secureNum,
                 String description) {
        this.cardNumber = cardNumber;
        this.username = username;
        this.cardHolder = cardHolder;
        this.cardType = cardType;
        this.expireDate = expireDate;
        this.secureNum = secureNum;
        this.description = description;
    }

    public String getId() { return cardNumber; }

    public String getUserName() { return username; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("cardNumber='").append(cardNumber).append('\'');
        sb.append(", cardHolder='").append(cardHolder).append('\'');
        sb.append(", cardType='").append(cardType).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
