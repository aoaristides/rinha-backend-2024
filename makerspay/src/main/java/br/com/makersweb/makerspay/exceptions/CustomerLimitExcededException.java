package br.com.makersweb.makerspay.exceptions;

/**
 * @author anderson
 */
public class CustomerLimitExcededException extends RuntimeException {

    public CustomerLimitExcededException() {
        super("Customer limit exceeded");
    }
}
