package br.com.makersweb.makerspay.dto.response.extract;

import br.com.makersweb.makerspay.domain.entity.Transaction;
import br.com.makersweb.makerspay.dto.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * @author anderson
 * @param value
 * @param type
 * @param description
 * @param realizadaEm
 */
public record TransactionResponse(
    @JsonProperty("valor")
    Long value,
    @JsonProperty("tipo")
    TransactionType type,
    @JsonProperty("descricao")
    String description,
    @JsonProperty("realizada_em")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
    Instant realizadaEm
) {

    public static TransactionResponse from(final Transaction transaction) {
        return new TransactionResponse(transaction.getAmount().longValue(), TransactionType.get(transaction.getType()), transaction.getDescription(), transaction.getCreatedAt());
    }

}
