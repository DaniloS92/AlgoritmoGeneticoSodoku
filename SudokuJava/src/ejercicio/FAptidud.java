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
    public double evaluate(IChromosome cromosoma){
        apto = 0;
        
        for (int i = 0; i < 9; i++) {
            evaluarHorizontal(cromosoma,a);
            a+=9;
        }
        
        for (int i = 0; i < 9; i++) {
            evaluarVertical(cromosoma);
        }
        
        return apto;
    }

    int j = 0; // variable q me servira para validar hasta q filas tiene que llegar el bucle
    private void evaluarHorizontal(IChromosome cromosoma, int fila) {
        int acumulador = 0; // tomando en cuenta q la suma de los numero deeb ser = a 45 esta variable jnos permitira saber
        j+=9; // aqui le estamos dado el limite del blucle para q obtenga los numeros,cada vez q se inicie este metodo J se va a aumentar 9
        
        while(fila < j){
            acumulador+= (Integer)cromosoma.getGene(fila).getAllele();
            fila++;
        }
        
        if (acumulador == 45) apto+=20;
    }

    private void evaluarVertical(IChromosome cromosoma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
