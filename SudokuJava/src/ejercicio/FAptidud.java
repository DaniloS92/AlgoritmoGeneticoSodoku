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
    public double evaluate(IChromosome cromosoma){
        apto = 0;
        
        for (int i = 0; i < cromosoma.size(); i++) {
            evaluarHorizontal(cromosoma);
        }
        
        for (int i = 0; i < cromosoma.size(); i++) {
            evaluarVertical(cromosoma);
        }
        
        return apto;
    }

    private void evaluarHorizontal(IChromosome cromosoma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void evaluarVertical(IChromosome cromosoma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
