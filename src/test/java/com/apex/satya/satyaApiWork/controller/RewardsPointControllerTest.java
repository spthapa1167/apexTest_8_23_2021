package com.apex.satya.satyaApiWork.controller;

import com.apex.satya.satyaApiWork.model.RewardSummary;
import com.apex.satya.satyaApiWork.model.TotalRewardPerMonth;
import com.apex.satya.satyaApiWork.service.RewardSummaryService;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RewardsPointController.class)
public class RewardsPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RewardSummaryService rewardSummaryService;


    @Test
    public void testGetSummaryForCustomer() throws Exception{
        given(rewardSummaryService.getSummary(100)).willReturn(prepareTestData());
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/rewards/{customerId}",100))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customerName").value("Tango"))
                .andExpect(jsonPath("$.summary.length()").value(3));
    }

    @Test
    public void testRewardApiNotFound() throws Exception{
        given(rewardSummaryService.getSummary(102)).willReturn(null);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/rewards/{customerId}",102))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testRewardApiBadRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/rewards/{customerId}","abc"))
                .andExpect(status().isBadRequest());
    }

    private RewardSummary prepareTestData(){
        TotalRewardPerMonth month1 = new TotalRewardPerMonth("8/2021", 50.00);
        TotalRewardPerMonth month2 = new TotalRewardPerMonth("7/2021", 120.00);
        TotalRewardPerMonth month3 = new TotalRewardPerMonth("6/2021", 200.00);
        ArrayList<TotalRewardPerMonth> list = new ArrayList<>();
        list.add(month1);
        list.add(month2);
        list.add(month3);
        RewardSummary rewardSummary = new RewardSummary(100, "Tango", list);
        return rewardSummary;
    }
}
