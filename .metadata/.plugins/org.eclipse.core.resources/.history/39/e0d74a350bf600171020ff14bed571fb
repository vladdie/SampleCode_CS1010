package optimizationProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
            new City(116.41667, 39.91667, "北京"),
            new City(121.43333, 34.50000, "上海"),
            new City(113.00000, 28.21667, "长沙"),
            new City(106.26667, 38.46667, "银川"),
            new City(109.50000, 18.20000, "三亚"),
            new City(112.53333, 37.86667, "太原"),
            new City(91.00000, 29.60000, "拉萨"),
            new City(102.73333,  25.05000, "昆明"),
            new City(126.63333, 45.75000, "哈尔滨"),
            new City(113.65000, 34.76667, "郑州"),
            new City(113.50000, 22.20000, "澳门")));
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
        Route route = new Route(solution.initialCities);
        System.out.println("Please choose the optimization algorithm by entering the index number:");
        System.out.println("1: Hill Climbing");
        System.out.println("2: Simulated Annealing");
        Scanner reader = new Scanner(System.in); 
        System.out.println("Please enter the index: ");
        int index = reader.nextInt(); 
        reader.close(); 
        switch(index){
        	case 1: 
        		new HillClimbing().findShortestRoute(route);
        		break;
        	case 2:
        		 new SimulatedAnnealing().findShortestRoute(route);
        		 break;
        	default:
        		System.out.println("Invalid input");
        }
       
    }


}
