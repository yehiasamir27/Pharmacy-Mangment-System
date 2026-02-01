package com.example.pharmacy_mangment_system_project;

import java.time.LocalDate;
import java.util.Date;

public class OTCMedication extends Medication {
    //private String dosageForm;
    //private final Date expiarydate;


    public OTCMedication(int id, String name, double price, LocalDate expiarydate, String dosageInstructions, String type,String status) {
        super(id,name, price,expiarydate,dosageInstructions,type,status);
        //this.dosageForm = dosageForm;
    }

//    public String getDosageForm() {
//        return dosageForm;
//    }
//
//    public void setDosageForm(String dosageForm) {
//        this.dosageForm = dosageForm;
//    }


//@Override
//    public String getExpirationDate(){
//        return expiarydate.getYear()+"/"+expiarydate.getMonth()+"/"+expiarydate.getDay();
//    }
}
