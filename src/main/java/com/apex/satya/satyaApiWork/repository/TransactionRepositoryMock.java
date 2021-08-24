package com.apex.satya.satyaApiWork.repository;

import com.apex.satya.satyaApiWork.entity.Customer;
import com.apex.satya.satyaApiWork.entity.Transactions;

import java.util.*;

public class TransactionRepositoryMock {

    public static final HashMap<Integer, List<Transactions>> transactions = new HashMap<>();;
    static {

        ArrayList<Transactions> list1= new ArrayList<>();
        list1.add(new Transactions(1001, "Transaction 1", 120.00, getDateOfPastNDays(77), 100));
        list1.add(new Transactions(1002, "Transaction 2", 200.00, getDateOfPastNDays(56), 100));
        list1.add(new Transactions(1003, "Transaction 3", 300.00, getDateOfPastNDays(46), 100));
        list1.add(new Transactions(1004, "Transaction 4", 400.00, getDateOfPastNDays(36), 100));
        list1.add(new Transactions(1005, "Transaction 5", 70.00, getDateOfPastNDays(16), 100));
        list1.add(new Transactions(1006, "Transaction 6", 50.00, getDateOfPastNDays(06), 100));

        ArrayList<Transactions> list2 = new ArrayList<>();
        list2.add(new Transactions(1007, "Transaction 1", 70.00, getDateOfPastNDays(76), 101));
        list2.add(new Transactions(1008, "Transaction 2", 200.00, getDateOfPastNDays(55), 101));
        list2.add(new Transactions(1009, "Transaction 3", 300.00, getDateOfPastNDays(46), 101));
        list2.add(new Transactions(1010, "Transaction 4", 800.00, getDateOfPastNDays(32), 101));
        list2.add(new Transactions(1011, "Transaction 5", 100.00, getDateOfPastNDays(15), 101));
        list2.add(new Transactions(1012, "Transaction 6", 40.00, getDateOfPastNDays(05), 101));

        transactions.put(100, list1);
        transactions.put(101, list2);

    }

    public static List<Transactions> getTransactionsById(Integer customerId){
        return transactions.get(customerId);
    }

    private static Date getDateOfPastNDays(Integer n){
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        Date date = cal.getTime();
        return date;
    }
}
