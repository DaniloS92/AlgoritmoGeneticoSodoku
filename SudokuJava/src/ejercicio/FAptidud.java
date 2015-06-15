/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author Danilo
 */
public class FAptidud extends FitnessFunction {

    double apto = 0;
    int a = 0;
    int b = 0;
    int c = 0;
    int j = 0;

    public double evaluate(IChromosome cromosoma) {
        apto = 0;

        for (int i = 0; i < 9; i++) {
            evaluarHorizontal(cromosoma, a);
            a += 9;
        }
        j = 0;
        for (int i = 0; i < 9; i++) {
            evaluarVertical(cromosoma, i);
        }

        j = 0;
        c = 0;
        for (int i = 0; i < 9; i++) {
            repetidosHorizontales(cromosoma, c);
            c += 9;
        }

        for (int i = 0; i < 9; i++) {
            repetidosVerticales(cromosoma, i);
        }

        j = 0;

        return apto;
    }

    // variable q me servira para validar hasta q filas tiene que llegar el bucle
    public void evaluarHorizontal(IChromosome cromosoma, int fila) {
        int acumulador = 0; // tomando en cuenta q la suma de los numero deeb ser = a 45 esta variable jnos permitira saber
        j += 9; // aqui le estamos dado el limite del blucle para q obtenga los numeros,cada vez q se inicie este metodo J se va a aumentar 9

        while (fila < j) {
            acumulador += (Integer) cromosoma.getGene(fila).getAllele();
            fila++;
        }

        if (acumulador == 45) {
            apto += 20;
        }
    }

    public void evaluarVertical(IChromosome cromosoma, int fila) {
        int acumulador = 0;

        for (int i = fila; i < (fila + 72); i = i + 9) {
            acumulador += (Integer) cromosoma.getGene(i).getAllele();
        }

        if (acumulador == 45) {
            apto += 20;
        }
    }
//
//    String cadena = "";
//    String[] vectorConsulta;

    public void repetidosHorizontales(IChromosome cromosoma, int fila) {

        String cadena = "";
        String[] vectorConsulta;
        j += 9; // aqui le estamos dado el limite del blucle para q obtenga los numeros,cada vez q se inicie este metodo J se va a aumentar 9

        while (fila < j) {
            cadena += "," + (Integer) cromosoma.getGene(fila).getAllele();
            fila++;
        }

        cadena = cadena.trim();
        cadena = cadena.substring(1);
        //System.out.println("Cadena de la Horizontal; "+cadena);
        vectorConsulta = cadena.split(",");

        calcularRepetidos(vectorConsulta);

    }

    public void repetidosVerticales(IChromosome cromosoma, int fila) {
        String cadena = "";
        String[] vectorConsulta;
        for (int i = fila; i < (fila + 72); i = i + 9) {
            cadena += "," + (Integer) cromosoma.getGene(fila).getAllele();
        }

        cadena = cadena.trim();
        vectorConsulta = cadena.split(",");

        calcularRepetidos(vectorConsulta);
    }

    public void calcularRepetidos(String[] vector) {

        String gen0 = vector[0];
        String gen1 = vector[1];
        String gen2 = vector[2];
        String gen3 = vector[3];
        String gen4 = vector[4];
        String gen5 = vector[5];
        String gen6 = vector[6];
        String gen7 = vector[7];
        String gen8 = vector[8];

        if ((gen0.compareTo(gen1) != 0) && (gen0.compareTo(gen2) != 0) && (gen0.compareTo(gen3) != 0)
                && (gen0.compareTo(gen4) != 0) && (gen0.compareTo(gen5) != 0) && (gen0.compareTo(gen6) != 0)
                && (gen0.compareTo(gen7) != 0) && (gen0.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen1.compareTo(gen0) != 0) && (gen1.compareTo(gen2) != 0) && (gen1.compareTo(gen3) != 0)
                && (gen1.compareTo(gen4) != 0) && (gen1.compareTo(gen5) != 0) && (gen1.compareTo(gen6) != 0)
                && (gen1.compareTo(gen7) != 0) && (gen1.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen2.compareTo(gen0) != 0) && (gen2.compareTo(gen1) != 0) && (gen2.compareTo(gen3) != 0)
                && (gen2.compareTo(gen4) != 0) && (gen2.compareTo(gen5) != 0) && (gen2.compareTo(gen6) != 0)
                && (gen2.compareTo(gen7) != 0) && (gen2.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen3.compareTo(gen0) != 0) && (gen3.compareTo(gen1) != 0) && (gen3.compareTo(gen2) != 0)
                && (gen3.compareTo(gen4) != 0) && (gen3.compareTo(gen5) != 0) && (gen3.compareTo(gen6) != 0)
                && (gen3.compareTo(gen7) != 0) && (gen3.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen4.compareTo(gen0) != 0) && (gen4.compareTo(gen1) != 0) && (gen4.compareTo(gen2) != 0)
                && (gen4.compareTo(gen3) != 0) && (gen4.compareTo(gen5) != 0) && (gen4.compareTo(gen6) != 0)
                && (gen4.compareTo(gen7) != 0) && (gen4.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen5.compareTo(gen0) != 0) && (gen5.compareTo(gen1) != 0) && (gen5.compareTo(gen2) != 0)
                && (gen5.compareTo(gen3) != 0) && (gen5.compareTo(gen4) != 0) && (gen5.compareTo(gen6) != 0)
                && (gen5.compareTo(gen7) != 0) && (gen5.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen6.compareTo(gen1) != 0) && (gen6.compareTo(gen2) != 0) && (gen6.compareTo(gen3) != 0)
                && (gen6.compareTo(gen4) != 0) && (gen6.compareTo(gen5) != 0) && (gen6.compareTo(gen0) != 0)
                && (gen6.compareTo(gen7) != 0) && (gen6.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen7.compareTo(gen1) != 0) && (gen7.compareTo(gen2) != 0) && (gen7.compareTo(gen3) != 0)
                && (gen7.compareTo(gen4) != 0) && (gen7.compareTo(gen5) != 0) && (gen7.compareTo(gen6) != 0)
                && (gen7.compareTo(gen0) != 0) && (gen7.compareTo(gen8) != 0)) {
            apto += 10;
        }

        if ((gen8.compareTo(gen1) != 0) && (gen8.compareTo(gen2) != 0) && (gen8.compareTo(gen3) != 0)
                && (gen8.compareTo(gen4) != 0) && (gen8.compareTo(gen5) != 0) && (gen8.compareTo(gen6) != 0)
                && (gen8.compareTo(gen7) != 0) && (gen8.compareTo(gen0) != 0)) {
            apto += 10;
        }
    }

}
