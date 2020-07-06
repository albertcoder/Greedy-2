//time complexity O(n) since we are iterating over the array once
//space complexity O(1) although we use HashMap still its space is constant A-Z

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int maxFreq = 0;//max times a character appears
       	int countMaxFreq = 0;//how many ele have the maxFreq
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){//calc maxFreq
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            int count = map.get(c);
            maxFreq = Math.max(count, maxFreq);
        }
        for(char c: map.keySet()){//calc countMaxFreq
            if(map.get(c) == maxFreq) countMaxFreq++;
        }
        int partitions = maxFreq - 1;
        int empty = (n - countMaxFreq + 1) * partitions;
        int pending = tasks.length - (maxFreq * countMaxFreq);
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}
