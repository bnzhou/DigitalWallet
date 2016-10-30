package io.spring.cloud.samples.commerce.transaction.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Transaction {
    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String cardnum;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String timestamp;

    public Transaction(){}

    public Transaction(String id, String username, String cardnum,
                       String address, String timestamp){
        this.id = id;
        this.username = username;
        this.cardnum = cardnum;
        this.address = address;
        this.timestamp = timestamp;
    }

    public String getid() { return id;}

    public void setid(String id) { this.id = id; }

    public String getusername() { return username;}

    public void setusername(String username) { this.username = username; }

    public String getcardnum() { return cardnum;}

    public void setcardnum(String cardnum) { this.cardnum = cardnum; }

    public String getAddr() { return address;}

    public void setAddr(String address) { this.address = address; }

    public String gettimestamp() { return timestamp;}

    public void settimestamp(String timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction {");
        sb.append("username='").append(username).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", cardnum='").append(cardnum).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", timestamp='").append(timestamp).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
