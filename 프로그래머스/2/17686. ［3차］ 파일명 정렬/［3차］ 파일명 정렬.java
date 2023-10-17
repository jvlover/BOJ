import java.util.*;

class Solution {
    
    class File implements Comparable<File> {
        String head, number, tail;
        
        File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public int compareTo(File o) {
            if (!this.head.toLowerCase().equals(o.head.toLowerCase()))
                return this.head.toLowerCase().compareTo(o.head.toLowerCase());
            else if (!this.number.equals(o.number))
                return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
            else return 0;
        }
    }
    
    public String[] solution(String[] files) {
        
        List<File> fileList = new ArrayList<>();
        
        for (String s : files) {
            
            boolean flag = true;
            int startIdx = 0, endIdx = s.length();
            
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if (flag) {
                        startIdx = i;
                        flag = false;
                    }
                } else if (!flag) {
                    endIdx = i;
                    break;
                }
            }

            fileList.add(new File(s.substring(0, startIdx), s.substring(startIdx, endIdx), s.substring(endIdx)));
        }
        
        Collections.sort(fileList);
        
        return fileList.stream().map(file -> file.head + file.number + file.tail).toArray(String[]::new);
    }
}