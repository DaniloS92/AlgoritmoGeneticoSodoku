/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.Chromosome;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;

/**
 *
 * @author Danilo
 */
public class main  {
    
    public static void main(String[] args) throws Exception{
        DefaultConfiguration AGConfig = new DefaultConfiguration();
        
        AGConfig.setPreservFittestIndividual(true);
        FAptidud funcionAPtitud = new FAptidud();
        
        AGConfig.setFitnessFunction(null);//Aqui va la FAptitud
        
        Gene [] AGgen = new Gene[81];
        
        for (int i = 0; i < AGgen.length; i++) {//fila 
            AGgen[i] = new IntegerGene(AGConfig, 1, 9);
        }
        
        IChromosome AgChromosoma = new Chromosome(AGConfig, AGgen);   
        AGConfig.setSampleChromosome(AgChromosoma);
        
        AGConfig.setPopulationSize(1000);
        
        Genotype poblacion = Genotype.randomInitialGenotype(AGConfig);
        
        for (int i = 0; i < 100; i++) {
            poblacion.evolve();
        }
    }
}
