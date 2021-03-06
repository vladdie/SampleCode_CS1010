package optimizationProblem;

/**
 * TSP: Travelling Salesman Problem
 * 
 * 场景：一个旅行商人需要拜访n个城市
 * 条件：要选择一个路径能够拜访到所有的城市，且每个城市只能被拜访一次，最终回到起点
 * 目标：求得的路径路程为所有路径可能之中的最小值
 * 算法描述： 从当前的节点开始，和周围的邻居节点的值进行比较，以一定的概率来接受一个比当前解要差的解：
 * 		     如果当前节点大于邻居节点，以一定概率替换当前节点，以邻居节点作为最大值(既山峰最高点)；
 * 		    反之就用最高的邻居节点来，替换当前节点；
 * 		    如此循环直到达到最高点
 * @author Fan
 *
 */
public class SimulatedAnnealing {
	// 最大迭代次数
    private double temperature = 10000;
    private double coolingRate = 0.99;
    private double absoluteTemperature = 0.00001;
    
    /**
     * 寻找最短路径
     * @param currentRoute
     * @return
     */
    public Route findShortestRoute(Route currentRoute) {
        Route adjacentRoute;
        int iterToMaximumCounter = 0;
        String compareRoutes = null;
        while(temperature > absoluteTemperature) {
            adjacentRoute = obtainAdjacentRoute(new Route(currentRoute));
            double deltaDistance = adjacentRoute.getTotalDistance()-currentRoute.getTotalDistance();
            if(deltaDistance <= 0) {
                compareRoutes = "<= (更新) - 迭代次数 # "+ iterToMaximumCounter;
                currentRoute = new Route(adjacentRoute);
            } else {
            	if(Math.exp(-deltaDistance/temperature)>Math.random()){
            		compareRoutes = "> (更新退火) - 迭代次数 # "+ iterToMaximumCounter;
                    currentRoute = new Route(adjacentRoute);
            	}else{
            		compareRoutes = "> (保持) - 迭代次数 # " + iterToMaximumCounter;
            	}
            }
            temperature *= coolingRate;
            iterToMaximumCounter++;
            System.out.println("       | " + compareRoutes);
            System.out.print(currentRoute + " |      " + currentRoute.getTotalStringDistance());
        }
        
        System.out.println("       | 可能的最优解");
        
        return currentRoute;
    }
    
    /**
     * 随机交换两个城市位置
     * @param route
     * @return
     */
    public Route obtainAdjacentRoute(Route route) {
        int x1 = 0, x2 = 0;
        while(x1 == x2) {
            x1 = (int) (route.getCities().size() * Math.random());
            x2 = (int) (route.getCities().size() * Math.random());
        }
        
        City city1 = route.getCities().get(x1);
        City city2 = route.getCities().get(x2);
        
        // swap two stochastic cities
        route.getCities().set(x2, city1);
        route.getCities().set(x1, city2);
        return route;
    }
}
