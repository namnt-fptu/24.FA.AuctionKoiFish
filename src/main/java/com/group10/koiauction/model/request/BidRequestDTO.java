package com.group10.koiauction.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidRequestDTO {
    private double bidAmount;
    private Long auctionSessionId;
}
