package com.javarevisao.datas_horas;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exemplo_LocalDateTime {
    public static void Exemplo_LocalDateTime() {

        // a ordem é: ano, mes, dia, hora, minuto e segundo (segundo é opcional)
        LocalDateTime dataHoraEspecifica = LocalDateTime.of(2025, 2, 15, 18, 30, 50);
        //System.out.println(dataHoraEspecifica);

        // Operações
        //System.out.println(dataHoraEspecifica.minusHours(12));
        //System.out.println(dataHoraEspecifica.minusYears(7));

        // Data e hora atual
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        //System.out.println(dataHoraAtual);

        // Comparações
        LocalDateTime dataHoraEspecificaMenos2horas = dataHoraEspecifica.minusHours(2);
        //System.out.println(dataHoraEspecifica.equals(dataHoraEspecificaMenos2horas));
        //System.out.println(dataHoraEspecifica.getDayOfMonth() == dataHoraEspecificaMenos2horas.getDayOfMonth());

        // Formatação
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataHoraFormatada = dataHoraEspecifica.format(formatter);
        //System.out.println(dataHoraFormatada);


    }
}
