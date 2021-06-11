package DFS;


import java.util.ArrayList;
import java.util.List;

public class Solution721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> accounts = new ArrayList<>();
		List<String> item1 = new ArrayList<>();
		List<String> item2 = new ArrayList<>();
		List<String> item3 = new ArrayList<>();
		List<String> item4 = new ArrayList<>();
		item1.add("John");item1.add("johnsmith@mail.com");item1.add("john_newyork@mail.com");
		item2.add("John");item2.add("johnnybravo@mail.com");
		item3.add("John");item3.add("johnsmith@mail.com");item3.add("john00@mail.com");
		item4.add("Mary");item4.add("mary@mail.com");
		accounts.add(item1);accounts.add(item2);accounts.add(item3);accounts.add(item4);
		dfsSolution721 s = new dfsSolution721();
		List<List<String>> res = s.accountsMerge(accounts);
		for(List<String> item:res) {
			for(String si : item) {
				System.out.print(si+" ");
			}
			System.out.println();
		}
	}

	

}
class dfsSolution721 {
	int account_len;
	boolean[] visited;
	List<List<String>> res = new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	account_len = accounts.size();
    	visited = new boolean[account_len];
    	for(int i = 0;i<account_len;i++) {
    		//���û�б����ʣ��ȼ���
    		if(!visited[i]) {
    			res.add(accounts.get(i));
    		}
    		for(int j = i+1;j<account_len;j++) {
    			//�Ա�����name�Ƿ�һ��
    			if(res.get(res.size()-1).get(0) == accounts.get(j).get(0) && !visited[j]) {
    				//���һ��,������ȱ���,�����Ƿ�Ϊͬһ��
    				dfs(accounts,j);
    			}
    		}
    		visited[i] = true;
    	}
    	//��ʱ��res�����������������Ҫ����
    	for(List<String> items:res) {
    		//��items��1-size-1�Ĳ�������
    		items.subList(1,items.size()).sort(null);
    	}
    	return res;
    }
    public void dfs(List<List<String>> accounts,int j) {
    	//�ж��Ƿ�Ϊͬһ��
    	boolean flag = false;
    	int m = res.get(res.size()-1).size();
    	int n = accounts.get(j).size();
    	for(int p = 1;p<m;p++) {
    		for(int q = 1;q<n;q++) {
    			if(res.get(res.size()-1).get(p).equals(accounts.get(j).get(q))) {
    				flag = true;
    				break;
    			}
    		}
    	}
    	//���Ϊͬһ��
    	if(flag) {
    		//�����������
    		for(int q= 1;q<n;q++) {
    			List<String> item = res.get(res.size()-1);
    			if(!item.contains(accounts.get(j).get(q))) {
    				item.add(accounts.get(j).get(q));
    			}
    		}
    		visited[j] = true;
    	}
    }
}