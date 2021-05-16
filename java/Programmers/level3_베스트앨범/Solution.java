import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len=genres.length; 
        Music[] music=new Music[len];
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        
        for(int i=0;i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            music[i]=new Music(genres[i],plays[i],i);
        }
        Arrays.sort(music);
        List<String> keyList=new ArrayList<>(map.keySet());
        Collections.sort(keyList,(o1,o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        List<Integer> list=new ArrayList<Integer>();
        for(String key: keyList){
            int cnt=0;
            for(int i=0;i<genres.length;i++){
                if(music[i].gerne.equals(key)){
                    list.add(music[i].id);
                    cnt++;
                    if(cnt==2)
                        break;
                }
            }
        }
        
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        
        return answer;
    }
    static class Music implements Comparable<Music>{
        String gerne;
        int cnt,id;
        
        public Music(String gerne,int cnt,int id){
            this.gerne=gerne;
            this.cnt=cnt;
            this.id=id;
        }
        
        public int compareTo(Music o){
            int diff=o.cnt-this.cnt;
            if(diff==0)
                diff=this.id-o.id;
            return diff;
        }
    }
}
