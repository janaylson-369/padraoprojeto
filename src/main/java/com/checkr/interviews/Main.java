package com.checkr.interviews;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Map<String, String> result = FundingRaised.findBy(Map.of("company_name", "Facebook", "round", "a"));
        System.out.println("--------------------------------UMA LINHA--------------------------------");
        System.out.printf("Linha: %s%n", result);
        System.err.println("----------------------------------------------------------------");
        System.out.printf("Tamanho: %s%n", result.size());
        
        System.out.println("-----------------------------LISTA-----------------------------------");

        List<Map<String, String>> results = FundingRaised.where(Map.of("company_name", "Facebook"));
        System.out.printf("Lista de valores: %s%n", results);
        System.err.println("----------------------------------------------------------------");
        System.out.printf("Lista, qt linhas: %s%n", results.size());
        
    }
}
