import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> chart = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if(chart.containsKey(genres[i])) {
                music.get(genres[i]).put(i, plays[i]);
                chart.put(genres[i], chart.get(genres[i]) + plays[i]);
            } else {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                
                tmp.put(i, plays[i]);
                music.put(genres[i], tmp);
                chart.put(genres[i], plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList(chart.keySet());
        Collections.sort(keySet, (s1, s2) -> chart.get(s2) - chart.get(s1));
 
        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genreKey = new ArrayList(map.keySet());
 
            Collections.sort(genreKey, (s1, s2) -> map.get(s2) - (map.get(s1)));
 
            answer.add(genreKey.get(0));
            
            if (genreKey.size() > 1) {
                answer.add(genreKey.get(1));
            }
        }
 
        return answer.stream().mapToInt(i -> i).toArray();
    }
}