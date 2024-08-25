package br.com.makersweb.makerspay.dto.response.extract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * @author anderson
 * @param total
 * @param dataExtrato
 * @param limit
 */
public record BalanceResponse(
        Integer total,
        @JsonProperty("data_extrato")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
        Instant dataExtrato,
        @JsonProperty("limite")
        Integer limit
) {
        public static BalanceResponse with(final Integer total, final Integer limit) {
                return new BalanceResponse(total, Instant.now(), limit);
        }
}
