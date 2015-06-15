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
        
        AGConfig.setFitnessFunction(funcionAPtitud);//Aqui va la FAptitud
        
        Gene [] AGgen = new Gene[81];
        
        for (int i = 0; i < AGgen.length; i++) {//fila 
            AGgen[i] = new IntegerGene(AGConfig, 1, 9);
        }
        
        IChromosome AgChromosoma = new Chromosome(AGConfig, AGgen);   
        AGConfig.setSampleChromosome(AgChromosoma);
        
        AGConfig.setPopulationSize(1000);
        
        Genotype poblacion = Genotype.randomInitialGenotype(AGConfig);
        
        for (int i = 0; i < 300; i++) {
            poblacion.evolve();
        }
        
        IChromosome mejor = poblacion.getFittestChromosome();
        int ja = 0;
        for (int i = 0; i < 81; i++) {
                System.out.print((Integer)mejor.getGene(i).getAllele()+"\t");
                if(i==8 || i==17 || i==26 || i==35 || i==44 || i==53 || i==62 || i==71 || i==80)System.out.println("");
        }   
    }
}
