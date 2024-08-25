package br.com.makersweb.makerspay.services;

import br.com.makersweb.makerspay.dto.response.extract.ExtractResponse;

/**
 * @author anderson
 */
public interface CustomerService {

    ExtractResponse extract(final Long id);

}
