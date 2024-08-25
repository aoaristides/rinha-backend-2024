package br.com.makersweb.makerspay.dto.response.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author anderson
 * @param limit
 * @param balance
 */
public record TransactionResponse(
    @JsonProperty(value = "limite") Integer limit,
    @JsonProperty(value = "saldo") Integer balance
) {

    public static TransactionResponse with(final Integer limit, final Integer balance) {
        return new TransactionResponse(limit, balance);
    }

}
