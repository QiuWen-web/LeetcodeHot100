package DFS;
import java.util.ArrayList;
//Կ�׺ͷ���
import java.util.List;
//�� N �����䣬��ʼʱ��λ�� 0 �ŷ��䡣ÿ��
//�����в�ͬ�ĺ��룺0��1��2��...��N-1������
//�����������һЩԿ����ʹ�������һ�����䡣
public class Solution841 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(new ArrayList<>(1));
		rooms.add(new ArrayList<>(2));
		rooms.add(new ArrayList<>(3));
		rooms.add(new ArrayList<>());
		dfsSolution841 res = new dfsSolution841();
		boolean r = res.canVisitAllRooms(rooms);
		System.out.println(r);
	}

}
class dfsSolution841 {
	//���������б�
	boolean[] visited;
	//��¼������
	int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	n = rooms.size();
    	visited = new boolean[n];
    	dfs(rooms,0);
    	for(int i = 0;i<n;i++) {
    		if(!visited[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    public void dfs(List<List<Integer>> rooms,int index) {
    	//�������Ѿ���ȥ�������ٽ�ȥ
    	if(visited[index]) {
    		return;
    	}
    	//index�ŵķ����ѷ���
    	visited[index] = true;
    	//�õ������ڵ�����Կ��
    	List<Integer> keys = rooms.get(index);
    	for(Integer key:keys) {
    		dfs(rooms,key);
    	}
    }
}