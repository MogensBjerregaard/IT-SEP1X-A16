package autoBus;

import java.io.Serializable;

/**
 * Created by lenovo on 11/29/2016.
 */
public class Passenger extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public Passenger(String name, String email, String address, Date birthday) {
        super(name, email, address, birthday);
    }
}
