package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
    }
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        @Override
        public String getCountryCode() {
            String key = null;
            for(Map.Entry<String,String> pair : countries.entrySet()){
                if(pair.getValue().equals(this.customer.getCountryName())){
                    key = pair.getKey();
                }
            }
            return key;
        }
        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }
        @Override
        public String getContactFirstName() {
            String[] person = this.contact.getName().split(",");
            return person[1].trim();
        }
        @Override
        public String getContactLastName() {
            String[] person = this.contact.getName().split(",");
            return person[0].trim();
        }
        @Override
        public String getDialString() {
            return "callto://+"+this.contact.getPhoneNumber().replaceAll("[\\D]", "");
        }
        public DataAdapter(Customer customer, Contact contact) {
            this.contact=contact;
            this.customer=customer;
        }
    }
    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }
    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }
    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}