package fop.w5phone;

class PhoneBook{
    private Entry[] entries;

    public PhoneBook(Entry[] entri){
        this.entries = entri;

    }


    public String find(String firstName, String lastName){
        int left = 0;
        int right = entries.length -1;


        while (left <= right){
            int mid = (left+right)/2;
            int result = entries[mid].getLastName().compareTo(lastName);
            if(result == 0){
                result = entries[mid].getFirstName().compareTo(firstName);
                if (result == 0){
                    return entries[mid].toString();

                } else if (result < 0 ) {


                }
                if (result > 0){

                    left = mid;
                    continue;

                }
                if (result < 0){
                    right = mid;
                    continue;
                }
            }

            return entries[mid].getPhoneNumber();
        }



    }


}