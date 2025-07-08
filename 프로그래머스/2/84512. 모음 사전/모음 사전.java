public class Solution {
    static String[] vowel = {"A", "E","I","O", "U"};
    static int count;
    static int result;
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(5,0,sb,word);
        return result;
    }
    public void dfs(int goal, int depth, StringBuilder sb, String word){
        if(sb.toString().equals(word)){
            result = count;
            return;
        }
        if(goal==depth){
            return;
        }
        for(int i=0; i< vowel.length; i++){
            sb.append(vowel[i]);
            count++;
            dfs(goal, depth+1, sb, word);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
