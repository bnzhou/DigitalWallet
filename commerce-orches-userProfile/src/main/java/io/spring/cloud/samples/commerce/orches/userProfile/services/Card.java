package io.spring.cloud.samples.commerce.orches.userProfile.services;

public class Card {

    private String cardNumber;

    private String username;

    private String cardHolder;

    private String cardType;

    private String expireDate;

    private String secureNum;

    private String description;

    public Card() {}

    public Card(String cardNumber, String username, String cardHolder,
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

    public String getNum() {
        return cardNumber;
    }

    public String getUserName() { return username; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
