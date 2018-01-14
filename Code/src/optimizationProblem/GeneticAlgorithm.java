package optimizationProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class GeneticAlgorithm {
	
	public static double[][] distance; // �������  
    public final static int P_SIZE=200; //��Ⱥ��С
    //private int cityNum; // ����������Ⱦɫ�峤��  
    private int MAX_GEN = 1000; // ��������  
    public static final int beginIndex = 0;
    //private int[] gene;
    private ArrayList<Chromosome> population;//��Ⱥ
    private final double eps = 1e-10; //�������
    private final double Mutation_Probability = 0.6;   //����ĸ���
    private City[] initialCities;
     /*private int bestT;// ��ѳ��ִ���  
    private int bestLength; // ��ѳ���  
    private int[] Route; // ���·��  
    
    // ��ʼ��Ⱥ��������Ⱥ��������ʾ��Ⱥ��ģ��һ�д���һ�����壬��Ⱦɫ�壬�б�ʾȾɫ�����Ƭ��  
    private int[][] oldPopulation;  
    private int[][] newPopulation;// �µ���Ⱥ���Ӵ���Ⱥ  
    private int[] fitness;// ��Ⱥ��Ӧ�ȣ���ʾ��Ⱥ�и����������Ӧ��  
  
    private float[] Pi;// ��Ⱥ�и���������ۼƸ���  
    private float Pc;// �������  
    private float Pm;// �������  
    private int iteration;// ��ǰ����  
    
    public GeneticAlgorithm(int scale, int cityNum, float pc, float pm, Route currentRoute) {  
        this.scale = scale;  
        this.cityNum = cityNum;  
        this.Pc = pc;  
        this.Pm = pm;  
        this.init(currentRoute);
    }  */
    
    
    private void init(City[] cities){
    	initialCities = cities;
    	computeDistanceMap(cities);
    	//���ɳ�ʼ��Ⱥ(��������)
    	population = new ArrayList<Chromosome>();
    	int[] gene = new int[cities.length];
    	for(int i = 0; i< cities.length; i++){
    		gene[i] = i;
    	}
    	//swap(gene[beginIndex],gene[0]);
    	swapInGene(gene,beginIndex,0);
    	population.add(new Chromosome(gene));
    	for(int i = 0; i< cities.length; i++){
    		gene[i] = cities.length-i-1;
    	}
    	//swap(gene[cities.length-beginIndex-1],gene[0]);
    	swapInGene(gene,cities.length-beginIndex-1,0);
    	population.add(new Chromosome(gene));
    	
    	Collections.sort(population);
    }
    
    private void swapInGene( int[] gene, int index1, int index2){
    	int temp = gene[index1];
    	gene[index1] = gene[index2];
    	gene[index2] = temp;
    }
    
    private void swapBetweenGene( int[] gene1, int[] gene2, int index1, int index2){
    	int temp = gene1[index1];
    	gene1[index1] = gene2[index2];
    	gene2[index2] = temp;
    }
    
    //��ʼ�Ŵ�
  	public Chromosome run(City[] cities)
  	{
  		//������ʼ��Ⱥ
  		init(cities);
  		
  		for(int i=0;i<=MAX_GEN;i++)
  		{
  			System.out.println("�� "+i+" ��");
  			int size = population.size();
  			for(int j = 0; j < size; j++)
  				population.get(j).print();
  			System.out.println("*********************************************");
  			
  			if(i!= MAX_GEN){
  				System.out.println("�������彻��");
  				for(int x = 0; x < size; x++){
  	  				for(int y = x + 1; y < size; y++) {
  	                    Chromosome[] children = crossover(population.get(x),population.get(y));
  	                    if(children[0].Alive())
  	                    	population.add(children[0]);
  	                    if(children[1].Alive())
  	                    	population.add(children[1]);
  	                }
  	  			 }
  				System.out.println("�������彻�����");
  				
  				System.out.println("\n �����������");
  				for(int x = 0; x < size; x++) {
  	                if(Math.random() <= eps + Mutation_Probability) {
  	                    Chromosome temp;
  	                    temp = population.get(x).Mutation();
  	                    if(temp.Alive() )
  	                    	population.add(temp);
  	                }
  	            }
  				
  				//��������
  				Collections.sort(population);
  				eraseDuplicate(population);
  				
  				if(population.size() > P_SIZE)
  					System.out.println("\n ɱ�����ȷ�ֳ���壺"+(population.size()-P_SIZE));
  	            while(population.size() > P_SIZE)
  	            	population.remove(population.size()-1);
  	            System.out.println("��Ⱥ��Ӧ�ȣ�"+ population.get(population.size()-1).getFitness());
  			}
  			
  			 
  		}
		return population.get(0);	
  		
  	}
    
  	private void eraseDuplicate(ArrayList<Chromosome> array){
  		Set<Chromosome> primesWithoutDuplicates = new LinkedHashSet<Chromosome>(array);
  		array.clear();
  		array.addAll(primesWithoutDuplicates);	
	}
	
  	public void printResult(Chromosome chrom){
  		System.out.println("\n ��Ѹ��壺");
  		for(int i = 0; i < chrom.getGene().length; i++) {
  			System.out.print(chrom.getGene()[i]+", ");
  	    }
  		System.out.println("\n ����·����");
  		for(int i = 0; i < chrom.getGene().length; i++) {
  			System.out.print(initialCities[chrom.getGene()[i]].getName()+", ");
  	    }
  	    double dis = distance[chrom.getGene()[chrom.getGene().length - 1]][chrom.getGene()[0]];
  	    for(int i = 0; i < chrom.getGene().length-1; i++){
  	        dis += distance[chrom.getGene()[i]][chrom.getGene()[i + 1]];
  	    }
  	    System.out.println("\n ��·�̣�"+dis);
  	}
		
	//�������
	private Chromosome[] crossover(Chromosome parent1,Chromosome parent2)
	{
		 // ѡȡ�������� 0 [1-x) [x,y] (y,N-1]
       // int y = (int) (Math.random()*(parent1.getGene().length - 1)) + 1;
       // int x = (int) (Math.random()*(y - 1)) + 1;
		int y = 6;
		int x=2;
        int[] gene1 = parent1.getGene().clone();
        int[] gene2 = parent2.getGene().clone();
        HashMap<Integer,Integer> m1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> m2 = new HashMap<Integer,Integer>();
        
        for(int i = x; i <= y; i++) {
        	m1.put(gene1[i], gene2[i]);
            m2.put(gene2[i],gene1[i]);
           // swap(gene1[i], gene2[i]);
            swapBetweenGene(gene1,gene2,i,i);
            
        }
        
        for(int i = 0; i <= parent1.getGene().length - 1; i++) {
            if(i < x || i > y) {
                if(m2.containsKey(gene1[i]))
                    gene1[i] = m2.get(gene1[i]);
                if(m1.containsKey(gene2[i]))
                    gene2[i] =m1.get(gene2[i]);
            }
        }
        Chromosome[] children = new Chromosome[2];
        children[0] = new Chromosome(gene1);
        children[1] = new Chromosome(gene2);
        return children;
	}
	
	

		
	public void computeDistanceMap(City[] cities){
		distance = new double[cities.length][cities.length];
    	for(int i=0;i<cities.length;i++)
		{
			for(int j=i;j<cities.length;j++)
			{
				double dist = cities[i].measureDistance(cities[j]);
				distance[i][j]=dist;
				distance[j][i]=distance[i][j];
				//System.out.println(cities[i].getName() + " to " +cities[j].getName()+" distance: "+dist);
			}
		}	
    }	

}