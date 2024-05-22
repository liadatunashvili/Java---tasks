import java.util.HashMap;
import java.util.Map;

public class Dictionary<T> {
    private T value;
    private Map<Character, Dictionary<T>> h;

    public Dictionary() {
        this.h = new HashMap<>();
    }

    public void record(String s, T value){
        if(s == "" || s == null){
            this.value = value;
            return;
        }else if(this.h.get(s.charAt(0))==null){

            this.h.put(s.charAt(0), new Dictionary<>());

        }
        record(s.substring(1),value);


    }

    public T lookUp(String s){
        if(s == "" || s == null)
            return this.value;
        else if(h.get(s.charAt(0))==null){
            return null;
        }
        String left = s.substring(1);
        Dictionary<T> childern = this.h.get(s.charAt(0));

        return  childern.lookUp(left);
    }


    public T remove(String s) {
        return auxRem(s, this);
    }

    private T auxRem(String s, Dictionary<T> parent) {
        if (s == "" || s == null) {
            T removedValue = parent.value;
            parent.value = null;
            return removedValue;
        } else {

            Dictionary<T> children = parent.h.get( s.charAt(0));

            if (children == null) {
                return null;
            }

            String remainingString = s.substring(1);
            T removedValue = children.auxRem(remainingString, parent.h.get(s.charAt(0)));

            if (children.isEmpty()) {
                parent.h.remove(s.charAt(0));
            }

            return removedValue;
        }
    }
    public boolean isEmpty(){
        return this.value == "" || this.value == null;

    }




}
