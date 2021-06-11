package DFS;

import java.util.List;

public class Solution690 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
class dfsSolution690 {
	int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        //遍历employees，找到符合的id，深度搜索此id下的所有员工
    	//得到他们的重要度全都加起来
    	for(Employee people:employees) {
    		if(people.id == id) {
    			dfs(people,employees);
    		}
    	}
    }
    public void dfs(Employee people,List<Employee> employees) {
    	//首先先把重要度加上去
    	sum += people.importance;
    	//寻找此人下的员工id
    	List<Integer> ids = people.subordinates;
    	if(ids.isEmpty()) {
    		return;
    	}
    	for(Employee zipeople:employees) {
    		for(Integer id:ids) {
    			if(zipeople.id == id) {
    				dfs(zipeople,employees);
    			}
    		}
    	}
    }
}