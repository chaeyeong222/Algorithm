import java.util.*; 
class Solution {
    public String solution(String s, String[] musicinfos) {
        String answer = "";
        String m = replace(s);
        PriorityQueue<Music> pq = new PriorityQueue<>(new Comparator<Music>(){
           @Override
            public int compare(Music m1, Music m2){
                if(m1.time==m2.time) return m1.idx-m2.idx;
                return m2.time-m1.time;
            }
        });
        int index = 0;
        for(String mu : musicinfos){ 
            
            String[] info = mu.split(",");
            int start = Integer.parseInt(info[0].split(":")[0]) * 60 + Integer.parseInt(info[0].split(":")[1]);
            int end = Integer.parseInt(info[1].split(":")[0]) * 60 + Integer.parseInt(info[1].split(":")[1]);
            int timeDiff = end-start;  //재생시간
            String title = info[2]; //제목
            String song = replace(info[3]);
            
            StringBuilder sb = new StringBuilder(); //실제 재생된 노래
            int n = song.length();
            int times = timeDiff/n;
            int lefts = timeDiff%n;
            for(int i=0; i<times; i++){
                sb.append(song);
            }
            sb.append(song.substring(0,lefts)); 
             
            // //노래재생 일치하는지 체크 
            
            if(sb.toString().contains(m)){
                pq.offer(new Music(index, timeDiff, title));
            }
            index++;
        }
        if(pq.isEmpty()) return "(None)";
        Music music = pq.poll();
        return music.title;
    } 
    public String replace(String mm){
        return mm.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a")
                .replace("B#","b");
    }
}

class Music{
    int idx;
    int time;
    String title;
    Music(int idx, int time, String title){
        this.idx = idx;
        this.time = time;
        this.title = title;
    }
} 