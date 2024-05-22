package fop.w5phone;

public class Entry {

    private String lastName;
    private String firstName;
    private String phoneNumber;

    public Entry(String lasN, String firstN, String phoneN){
        this.firstName = firstN;
        this.lastName = lasN;
        this.phoneNumber =  phoneN;


    }
    public String getLastName(){

        return lastName;
    }
    public String getFirstName(){

        return firstName;
    }
    public String getPhoneNumber(){

        return phoneNumber;
    }




}