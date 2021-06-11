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
        //����employees���ҵ����ϵ�id�����������id�µ�����Ա��
    	//�õ����ǵ���Ҫ��ȫ��������
    	for(Employee people:employees) {
    		if(people.id == id) {
    			dfs(people,employees);
    		}
    	}
    }
    public void dfs(Employee people,List<Employee> employees) {
    	//�����Ȱ���Ҫ�ȼ���ȥ
    	sum += people.importance;
    	//Ѱ�Ҵ����µ�Ա��id
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