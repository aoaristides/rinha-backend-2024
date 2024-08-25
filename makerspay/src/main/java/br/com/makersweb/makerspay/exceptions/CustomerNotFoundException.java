package br.com.makersweb.makerspay.exceptions;

/**
 * @author anderson
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Customer not found");
    }

}
