package be.electrodoctor.electroman.model;

/**
 * Created by janjoris on 27/01/15.
 */
public class Client {

    private long id;
    private Address address;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
