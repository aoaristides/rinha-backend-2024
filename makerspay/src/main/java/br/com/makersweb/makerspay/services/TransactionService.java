package br.com.makersweb.makerspay.services;

import br.com.makersweb.makerspay.dto.request.TransactionRequest;
import br.com.makersweb.makerspay.dto.response.transaction.TransactionResponse;

/**
 * @author anderson
 */
public interface TransactionService {

    TransactionResponse transaction(final Long id, final TransactionRequest request);

}
