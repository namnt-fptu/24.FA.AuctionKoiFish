package com.group10.koiauction.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group10.koiauction.entity.enums.TransactionEnum;
import com.group10.koiauction.entity.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createAt;

    @Enumerated(EnumType.STRING)
    private TransactionEnum type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private double amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "from_id")
    Account from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    Account to;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnore
    Payment payment;

    @OneToOne
    @JoinColumn(name = "payment_request_id")
    PaymentRequest paymentRequest;

    @OneToOne
    @JoinColumn(name = "bid_id")
    Bid bid;

    @OneToOne(mappedBy = "transaction",cascade = CascadeType.ALL)// each time save transaction -> save system profit
    SystemProfit systemProfit;


    @ManyToOne
    @JoinColumn(name = "auction_session_id")
    AuctionSession auctionSession;

    @OneToOne
    @JoinColumn(name = "withdraw_request_id")
    WithDrawRequest withdrawRequest;

}
