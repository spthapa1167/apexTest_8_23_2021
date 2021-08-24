package com.apex.satya.satyaApiWork.service;

import com.apex.satya.satyaApiWork.entity.Customer;
import com.apex.satya.satyaApiWork.entity.Transactions;
import com.apex.satya.satyaApiWork.model.RewardSummary;
import com.apex.satya.satyaApiWork.model.TotalRewardPerMonth;
import com.apex.satya.satyaApiWork.repository.CustomerRepositoryMock;
import com.apex.satya.satyaApiWork.repository.TransactionRepositoryMock;
import com.apex.satya.satyaApiWork.util.RewardUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RewardSummaryServiceImpl implements RewardSummaryService{

    @Override
    public RewardSummary getSummary(Integer customerId) {
        Customer customer= CustomerRepositoryMock.getCustomerById(customerId);

        if(customer != null) {
            List<Transactions> transactions = TransactionRepositoryMock.getTransactionsById(customerId);
            if(transactions != null) {
                return prepareSummary(customer, transactions);
            }
        }
         return null;
    }

    private  RewardSummary prepareSummary(Customer customer, List<Transactions> transactions){
        HashMap<String, Integer> map = new HashMap<>();
        Integer point = 0;
        for(Transactions var: transactions){
            point = RewardUtil.calculatePoints(var.getAmount());
            String key = getMonthYearValue(var.getTxnDate());
            if(map.containsKey(key)){
                RewardUtil.calculatePoints(var.getAmount());
                 map.put(key, point + map.get(key));
            }else{
                map.put(key, point);
            }
        }

        ArrayList<TotalRewardPerMonth> listTotalBreakDownByMonth = new ArrayList<>();
        for(String var: map.keySet()){
            listTotalBreakDownByMonth.add(new TotalRewardPerMonth(var, map.get(var)));
        }

        return new RewardSummary(customer.getId(), customer.getName(),listTotalBreakDownByMonth);
    }

    private String getMonthYearValue(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        return month+"/"+year;
    }
}
