import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            if(m.containsKey(words[i])) m.put(words[i], m.get(words[i])+1);
            else m.put(words[i], 1);
        }  
        for(int i=0; i<words[0].length() - 1; i++){
            int count=0,l=i;
            Map<String,Integer> curm = new HashMap<String, Integer>();
            for(int j=i; j< s.length()-words[0].length()+1; j+=words[0].length()){
                String str = s.substring(j, j+words[0].length());
                if(m.containsKey(str)) {
                    if(curm.containsKey(str)) curm.put(str, m.get(str)+1);
                    else curm.put(str, 1);
                    count++;
         
                    while(curm.get(str) > m.get(str)){
                        String tmp = s.substring(l, l+words[0].length());
                        if(curm.containsKey(tmp)){
                            curm.put(tmp, curm.get(tmp)-1);
                            count--;
                        }
                        l = l+words[0].length();
                    }
                    if(count == words.length){
                        res.add(l);
                        String tmp = s.substring(l, l+words[0].length());
                        if(curm.containsKey(tmp)){
                            curm.put(tmp, curm.get(tmp)-1);
                            count--;
                        }
                        l = l+words[0].length();
                    }
                } else{
                    curm.clear();
                    count=0;
                    l=j+words[0].length();
                }
            }
        }
        return res;
    }
}