package javatests.equals;

import java.util.Objects;

public class EqualseClass {
    private  Long id;
    private String name;

    public EqualseClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        EqualseClass other = (EqualseClass) o;
        return id.equals(other.id) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        byte[] hashNameNByte = name.getBytes();
        int hashName = 0;
                for(byte hashByte:hashNameNByte){
                    hashName+=(int) hashByte;
                }
        System.out.println("hashName: "+hashName);
        return hashName;
    }
}
