package br.com.makersweb.makerspay.dto.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author anderson
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionType {
    CREDITO("c"),
    DEBITO("d");

    private String value;

    TransactionType(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static TransactionType get(final String type) {
        return Arrays.stream(TransactionType.values()).filter(x -> x.value.equals(type)).findFirst().orElse(null);
    }
}
