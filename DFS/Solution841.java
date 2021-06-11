package DFS;
import java.util.ArrayList;
//钥匙和房间
import java.util.List;
//有 N 个房间，开始时你位于 0 号房间。每个
//房间有不同的号码：0，1，2，...，N-1，并且
//房间里可能有一些钥匙能使你进入下一个房间。
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
	//建立访问列表
	boolean[] visited;
	//记录房间数
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
    	//若房间已经进去过则不用再进去
    	if(visited[index]) {
    		return;
    	}
    	//index号的房间已访问
    	visited[index] = true;
    	//拿到房间内的所有钥匙
    	List<Integer> keys = rooms.get(index);
    	for(Integer key:keys) {
    		dfs(rooms,key);
    	}
    }
}