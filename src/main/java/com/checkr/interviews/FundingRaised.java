package com.checkr.interviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundingRaised {

    private final String permalink;
    private final String companyName;
    private final String numberEmployees;
    private final String category;
    private final String city;
    private final String state;
    private final String fundedDate;
    private final String raisedAmount;
    private final String raisedCurrency;
    private final String round;
    private static InterfaceRepository repository;

    public FundingRaised(String permalink, String companyName, String numberEmployees, String category, 
        String city, String state, String fundedDate, String raisedAmount, String raisedCurrency, String round) {

        this.permalink = permalink;
        this.companyName = companyName;
        this.numberEmployees = numberEmployees;
        this.category = category;
        this.city = city;
        this.state = state;
        this.fundedDate = fundedDate;
        this.raisedAmount = raisedAmount;
        this.raisedCurrency = raisedCurrency;
        this.round = round;
    }

    

    public static InterfaceRepository getRepository() throws IOException {
        if (repository == null) {
            LeitorCsv leitor = new LeitorCsv("startup_funding.csv");
            try {
                repository = new FundingRepositoryCsv(leitor.lerCsv());
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        return repository;
    }

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException{
        return getRepository().where(options);
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        return getRepository().findBy(options);
    }

    // map
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("permalink", this.permalink);
        map.put("company_name", this.companyName);
        map.put("number_employees", this.numberEmployees);
        map.put("category", this.category);
        map.put("city", this.city);
        map.put("state", this.state);
        map.put("funded_date", this.fundedDate);
        map.put("raised_amount", this.raisedAmount);
        map.put("raised_currency", this.raisedCurrency);
        map.put("round", this.round);
        return map;
    }

    public String getPermalink() {
        return permalink;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public String getNumberEmployees() {
        return numberEmployees;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }

    public String getFundedDate() {
        return fundedDate;
    }

    public String getRaisedAmount() {
        return raisedAmount;
    }

    public String getRaisedCurrency() {
        return raisedCurrency;
    }

    public String getRound() {
        return round;
    }   
    
}

class NoSuchEntryException extends Exception {}
