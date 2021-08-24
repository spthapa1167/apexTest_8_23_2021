package com.apex.satya.satyaApiWork.controller;

import com.apex.satya.satyaApiWork.model.RewardSummary;
import com.apex.satya.satyaApiWork.service.RewardSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RewardsPointController {

    @Autowired
    RewardSummaryService rewardSummaryService;

    /**
     * Reward point API
     * results reward points earned for each customer per month and total.
     * @param customerId
     * @return
     */
    @GetMapping("/rewards/{customerId}")
    public ResponseEntity<RewardSummary> findTotalRewardForCustomers(@PathVariable Integer customerId){
        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RewardSummary rewardSummary = rewardSummaryService.getSummary(customerId);
        if(rewardSummary == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rewardSummary, HttpStatus.OK);
    }
}
