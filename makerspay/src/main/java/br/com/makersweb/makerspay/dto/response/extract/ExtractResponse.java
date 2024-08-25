package br.com.makersweb.makerspay.dto.response.extract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author anderson
 * @param balance
 * @param lastTransactions
 */
public record ExtractResponse(
        @JsonProperty("saldo") BalanceResponse balance,
        @JsonProperty("ultimas_transacoes") List<TransactionResponse> lastTransactions
) {

        public static ExtractResponse with(final BalanceResponse balance, final List<TransactionResponse> transactions) {
                return new ExtractResponse(balance, transactions);
        }
}
