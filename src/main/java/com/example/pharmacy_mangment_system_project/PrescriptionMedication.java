package com.example.pharmacy_mangment_system_project;
import java.time.LocalDate;
import java.util.Date;

public class PrescriptionMedication extends Medication {
    //private String dosageForm;
    //private String dosageInstructions;





    public PrescriptionMedication(int id, String name, double price, LocalDate expiarydate, String dosageInstructions, String type,String status) {
        super(id,name, price,expiarydate,dosageInstructions,type,status);
        //this.dosageForm=dosageForm;
        //this.dosageInstructions = dosageInstructions;

    }
//    public String getDosageForm() {
//        return dosageForm;
//    }
//
//    public void setDosageForm(String dosageForm) {
//        this.dosageForm = dosageForm;
//    }

//    public String getDosageInstructions() {
//        return dosageInstructions;
//    }
//
//    public void setDosageInstructions(String dosageInstructions) {
//        this.dosageInstructions = dosageInstructions;
//    }
    // @Override
//    public String getExpirationDate(){
//        return expiarydate.getYear()+"/"+expiarydate.getMonth()+"/"+expiarydate.getDay();
//    }
}
