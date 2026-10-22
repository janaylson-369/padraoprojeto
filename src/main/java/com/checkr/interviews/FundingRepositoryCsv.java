package com.checkr.interviews;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FundingRepositoryCsv implements InterfaceRepository {

    private final List<FundingRaised> aporte;

    public FundingRepositoryCsv(List<FundingRaised> aporte) {
        this.aporte = aporte;
    }

    public boolean opcoesFiltro(FundingRaised item, Map<String, String> options) {
        if (options.containsKey("company_name") && !item.getCompanyName().equals(options.get("company_name"))) {
            return false;
        }
        if (options.containsKey("city") && !item.getCity().equals(options.get("city"))) {
            return false;
        }
        if (options.containsKey("state") && !item.getState().equals(options.get("state"))) {
            return false;
        }
        return !(options.containsKey("round") && !item.getRound().equals(options.get("round")));
    }


    @Override      
    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
    
        return aporte.stream()
                        .filter(item -> opcoesFiltro(item, options))
                            .map(FundingRaised::toMap)
                                .collect(Collectors.toList());
    }


    @Override 
    public Map<String, String> findBy(Map<String, String> options) throws NoSuchEntryException {
        return aporte.stream()
                    .filter(item -> opcoesFiltro(item, options))
                        .findFirst().map(FundingRaised::toMap)
                            .orElseThrow(() -> new NoSuchEntryException());
                    
    }


}
