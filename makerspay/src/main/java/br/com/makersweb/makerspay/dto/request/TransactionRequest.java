package br.com.makersweb.makerspay.dto.request;

import br.com.makersweb.makerspay.dto.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author anderson
 * @param value
 * @param type
 * @param description
 */
public record TransactionRequest(
        @JsonProperty(value = "valor") Integer value,
        @JsonProperty(value = "tipo") TransactionType type,
        @JsonProperty(value = "descricao") String description
) {
}
