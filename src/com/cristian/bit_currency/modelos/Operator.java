package com.cristian.bit_currency.modelos;

public record Operator(String base_code,
                       String target_code,
                       String conversion_rate,
                       String conversion_result) {
}
