package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> tickets = new ArrayList<>();
		List<String> ticket1 = new ArrayList<>();
		List<String> ticket2 = new ArrayList<>();
		List<String> ticket3 = new ArrayList<>();
		List<String> ticket4 = new ArrayList<>();
		List<String> ticket5 = new ArrayList<>();
		ticket1.add("JFK");ticket1.add("KUL");tickets.add(ticket1);
		ticket2.add("JFK");ticket2.add("NRT");tickets.add(ticket2);
		ticket3.add("NRT");ticket3.add("JFK");tickets.add(ticket3);
	//	ticket4.add("ATL");ticket4.add("JFK");tickets.add(ticket4);
	//	ticket5.add("ATL");ticket5.add("SFO");tickets.add(ticket5);
		dfsSolution332 s = new dfsSolution332();
		List<String> res = s.findItinerary(tickets);
		System.out.println(res.toString());
	}

}
class dfsSolution332 {
	//��������
	List<String> res = new ArrayList<>();
	//Ѱ�ҵ�һ����Ȼ����������б�
    public List<String> findItinerary(List<List<String>> tickets) {
    	if(tickets.size() == 0) {
    		return res;
    	}
    	//�ܹ��м�������,�����б�
    	
    	List<String> airportname = new ArrayList<>();
    	for(List<String> i : tickets) {
    		for(String j:i) {
    			if(!airportname.contains(j)) {
    				airportname.add(j);
    			}
    		}
    	}
    	int airports = airportname.size();
    	//�Ի�������
    	airportname.sort(null);
    	//��ͼ
    	int[][] dp = new int[airports][airports];
    	//����г�
    	for(List<String> i : tickets) {
    		String dep = i.get(0);
    		int index_dep = airportname.indexOf(dep);
    		String des = i.get(1);
    		int index_des = airportname.indexOf(des);
    		dp[index_dep][index_des] = 1;
    	}
    	//��������
    	res.add("JFK");
    	dfs(dp,res,"JFK",airportname);
    	
    	return res;
    }
    public void dfs(int[][] dp,List<String> res,String dep,List<String> airportname){
    	//���dpȫΪ0�����������
    	boolean flag = true;
    	for(int[] i:dp) {
    		for(int j:i) {
    			if(j == 1) {
    				flag = false;
    				break;
    			}
    		}
    		if(!flag) {
    			break;
    		}
    	}
    	if(flag) {
    		return;
    	}
    	//�õ����������ڵ���
    	int index_dep = airportname.indexOf(dep);
    	//��dp��һ����Ѱ�ҿ��ܵ����Ŀ�ĵ�
    	int n = dp.length;
    	for(int i = 0;i<n;i++) {
    		if(dp[index_dep][i] == 1) {
    			//˵��i�����ɵ���
    			String des = airportname.get(i);
    			res.add(des);
    			dp[index_dep][i] = 0;
    			dfs(dp,res,des,airportname);
    			dp[index_dep][i] = 1;
    			
    		}
    	}
    	return;
    }
}