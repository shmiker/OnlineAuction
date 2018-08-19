package com.onlineauction.domain;


public interface AuctionInteface {

    void addBidder(Bidder bidder);

    void startAuction();

    void firstRound();
}
