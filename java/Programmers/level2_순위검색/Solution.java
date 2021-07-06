import java.util.*;

// hash, 부분집합(dfs),이분탐색 
class Solution {
    static HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {   
        
        int lenQuery = query.length;
        int lenInfo = info.length;
        int[] answer = new int[lenQuery];
        
        String newQuery="";
        for(int i=0;i < lenInfo; i++){
            String[] infos = info[i].split(" ");
            newQuery="";
            int score=Integer.parseInt(infos[4]);
            dfs(0,"",infos,score);   
        }
        
        // 이분탐색을 위한 값 정렬
        for(String key: map.keySet()){
            ArrayList<Integer> arr = map.get(key);
            Collections.sort(arr);
        }
        
        for(int i=0; i<lenQuery;i++){
            
            String[] querys = query[i].split(" ");
            String queryStr = querys[0]+querys[2]+querys[4]+querys[6];
            
            int score = Integer.parseInt(querys[7]);
            if(map.containsKey(queryStr)){
                ArrayList<Integer> arr = map.get(queryStr);
                answer[i] = binarySearch(arr,score);
            }
        }
        
        return answer;
    }
    public static int binarySearch(ArrayList<Integer> arr, int score){
        
	int mid=0;
    int end = arr.size();
	int start = 0;
        
    while (start < end) // end가 start보다 같거나 작아지면, 그 값이 Lower Bound이므로 반복을 종료한다.
	{
		mid = (start + end) / 2; 
       	if (arr.get(mid) >= score) {
            // 중간값이 원하는 값보다 크거나 같을 경우, 끝값을 중간값으로 설정하여 다시 탐색한다.
			end = mid;
        }
		else{ 
            start = mid + 1; // 중간값이 원하는 값보다 작을 경우, 시작값을 중간값+1로 설정하여 다시 탐색한다.
	
        }
    }
	return arr.size()-start;
        
    }

    public static void dfs(int idx,String q, String[] info, int score) {
        if(idx ==4){
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(q)){
                list = map.get(q);
            }
            list.add(score);
            map.put(q,list);
            return;
        }
        dfs(idx+1,q+info[idx],info,score);
        dfs(idx+1,q+"-",info,score);
    }
}
