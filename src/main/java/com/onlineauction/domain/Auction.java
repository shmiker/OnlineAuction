package com.onlineauction.domain;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Auction implements AuctionInteface {

    private Bidder currentWinningBid;

    private List<Bidder> bidders = new ArrayList<>();

    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    /**
     * Start of the auction.
     * Winner is determined when his current bid equals the latest maximum.
     * Algorithm is kind of observer pattern: we have one main source (currentWinnigBid)
     * which relates to Bidders as one-to-many and notifying them to update their states.
     */
    @Override
    public void startAuction() {
        // first round start
        firstRound();

        // start of the main process
        while (true) {
            currentWinningBid = bidders.stream().max(Comparator.comparing(Bidder::getCurrentBid)).get();
            for (Bidder bidder : bidders) {
                bidder.updateBid(currentWinningBid.getCurrentBid());
            }
            // currentMaxBid equals to maximum from list of Bidders means that latest maximum has been found
            if (currentWinningBid.getCurrentBid() == bidders.stream().max(Comparator.comparing(Bidder::getCurrentBid)).get().getCurrentBid()) {
                System.out.println("The winner is " + currentWinningBid.getName() + " with amount: " + currentWinningBid.getCurrentBid());
                return;
            }
        }

    }

    /**
     * First round of auction where the maximum of starting bids is determined
     * and current bids of the bidders are updated.
     */
    public void firstRound() {
        // finding maximum from starting bids
        currentWinningBid = bidders.stream().max(Comparator.comparing(Bidder::getStartingBid)).get();
        // updating current bids of the bidders
        for (Bidder bidder : bidders) {
            bidder.updateBid(currentWinningBid.getStartingBid());
        }
    }

}
