import java.util.*;

public class c269 {
    Queue<Character> queue = new ArrayDeque<>();
    HashMap<Character, List<Character>> edges = new HashMap<>();
    HashMap<Character, Integer> indegrees = new HashMap<>();

    boolean valid = true;
    public String alienOrder(String[] words) {
        for (String word: words){
            int length = word.length();
            for (int i = 0; i < length; i++){
                char c = word.charAt(i);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++){
            addEdge(words[i-1], words[i]);
        }
        if (!valid){
            return "";
        }

        StringBuilder ans = new StringBuilder();
        for (Character c: indegrees.keySet()){
            if (indegrees.get(c) == 0){
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()){
            char c = queue.poll();
            ans.append(c);
            if (edges.get(c) != null){
                for (Character temp: edges.get(c)){
                    indegrees.put(temp, indegrees.get(temp) - 1);
                    if (indegrees.get(temp) == 0){
                        queue.offer(temp);
                    }
                }
            }
        }
        return ans.length() == edges.size()? ans.toString(): "";
    }

    public void addEdge(String before, String after){
        int length1 = before.length();
        int length2 = after.length();
        int length = Math.min(length2, length1);

        int index = 0;
        while (index < length){
            if (before.charAt(index) != after.charAt(index)){
                edges.get(before.charAt(index)).add(after.charAt(index));
                indegrees.put(after.charAt(index),indegrees.getOrDefault(after.charAt(index), 0) + 1);
            }
            index++;
        }

        if(index == length && length1 > length2){
            valid = false;
        }
    }
}
