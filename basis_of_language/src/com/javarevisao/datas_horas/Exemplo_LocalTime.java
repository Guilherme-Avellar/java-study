package com.javarevisao.datas_horas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exemplo_LocalTime {

    public static void Exemplo_LocalTime() {

        LocalTime horaAtual = LocalTime.now();
        //System.out.println(horaAtual);
        LocalTime horaMinutoSegundoEspecifico = LocalTime.of(10, 15, 40); // 10:15:40
        //System.out.println(horaMinutoSegundoEspecifico);
        LocalTime horaMinutoEspecifico = LocalTime.of(13, 21);
        //System.out.println(horaMinutoEspecifico);
        LocalTime horaDeUmaString = LocalTime.parse("10:15:40");
        //System.out.println(horaDeUmaString);

        // para formatar
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime horaDeUmaStringDespadronizada = LocalTime.parse("101540", formatter);
        //System.out.println(horaDeUmaStringDespadronizada); // 10:15:40
        formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
        String horaEmString = horaMinutoSegundoEspecifico.format(formatter);
        //System.out.println(horaEmString); // 10-15-40

        // Operações
        LocalTime horaAtualMais30min = horaAtual.plusMinutes(30);
        LocalTime horaAtualMenos2horas = horaAtual.minusHours(2);
        /*System.out.println(horaAtual);
        System.out.println(horaAtualMais30min);
        System.out.println(horaAtualMenos2horas);
        */

        // Comparações
        boolean antesOuDepois = horaAtual.isBefore(horaAtualMenos2horas); // false
        //System.out.println(antesOuDepois);
        antesOuDepois = horaAtual.isAfter(horaAtualMenos2horas);
        //System.out.println(antesOuDepois); // true

        // Para pegar separado: h, m, s etc
        //System.out.println("\nhora: " + horaMinutoSegundoEspecifico.getHour());



    }

}
