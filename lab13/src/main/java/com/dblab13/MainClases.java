package com.dblab13;

public class MainClases {


    public static void main(String[] args) {
        int id1 = 23123;

        Company company = new Company(id1,"Company Test Ltd", "07965369258", "Norwich", "NR1 7DD");

        if(company.insert()){
            System.out.println(company.getCompanyName() + " inserted into DB");
        } else {
            System.out.println(company.getCompanyName() + " failed to insert into DB");
        }

        

        int id2 = 11234;
        Company selectCompany2 = Company.findByCompanyNo(11234);

        if(selectCompany2 != null){
            System.out.println(selectCompany2.getCompanyName() + " found in DB");
        } else {
            System.out.println("No company with ID: " + id2);
        }

        Company selectCompany = Company.findByCompanyNo(id1);

        if(selectCompany != null){
            System.out.println(selectCompany.getCompanyName() + " found in DB");

            selectCompany.setCompanyName("Stan Lee Ltd");
            selectCompany.setPostCode("UNKNOWN");

            selectCompany.update();

            selectCompany = Company.findByCompanyNo(id1);

            System.out.println(selectCompany.getCompanyName() + " updated in DB, new postcode: " + selectCompany.getPostCode());

        } else {
            System.out.println("No company with that ID");
        }
    
    }

    
}
