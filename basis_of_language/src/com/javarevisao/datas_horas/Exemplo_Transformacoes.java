package com.javarevisao.datas_horas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Exemplo_Transformacoes {

    public static void exemploTransformacoes() {

        LocalDateTime dataHora = LocalDateTime.of(2021, 12, 31, 23, 59);
        LocalDate data = LocalDate.of(2021, 12, 31);

        // Para passar para do formato LocalDateTime para o LocalDate:
        recebeApenasLocalDate(dataHora.toLocalDate());

        // Para passar para do formato LocalDate para o LocalDateTime:
        recebeApenasLocalDateTime(data.atTime(23, 59));
        // Se você quisesse por a hora do momento:
        recebeApenasLocalDateTime(data.atTime(LocalTime.now()));

    }

    public static void recebeApenasLocalDate(LocalDate data) {
        System.out.println("\nLocalDate recebida pela função: " + data);
    }

    public static void recebeApenasLocalDateTime(LocalDateTime dataHora) {
        System.out.println("\nLocalDateTime recebida pela função: " + dataHora);
    }


}
