package com.checkr.interviews;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class LeitorCsv {

    private final String caminhoArquivo;

    public LeitorCsv(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<FundingRaised> lerCsv() throws Exception {

        List<FundingRaised> aportes = new ArrayList<>();

        CSVReader reader = new CSVReader(new FileReader(this.caminhoArquivo));
        String[] row;
        reader.readNext(); 

        while ((row = reader.readNext()) != null) {
            FundingRaised aporte = new FundingRaised(
                row[0], 
                row[1], 
                row[2], 
                row[3], 
                row[4], 
                row[5], 
                row[6], 
                row[7],
                row[8], 
                row[9]  
            );
            aportes.add(aporte);
        }
        reader.close();
        
        return aportes;
    }

    
}
