package com.group10.koiauction.repository;

import com.group10.koiauction.entity.AuctionRequest;
import com.group10.koiauction.entity.enums.AuctionRequestStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionRequestRepository extends JpaRepository<AuctionRequest, Long> {
    @Query("SELECT U FROM AuctionRequest U WHERE U.auction_request_id = ?1")
    AuctionRequest findByAuctionRequestId(@Param("auction_request_id") Long id);

    @Query("SELECT U FROM AuctionRequest U WHERE U.status = ?1")
    List<AuctionRequest> findByStatus(@Param("status") AuctionRequestStatusEnum status);

    @Query("SELECT U FROM AuctionRequest U WHERE U.account.user_id = :koiBreederId")
    List<AuctionRequest> findByBreederId(@Param("koiBreederId") Long koiBreederId);

    AuctionRequest findAuctionRequestByTitle(String title);
}
