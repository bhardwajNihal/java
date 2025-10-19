package Graph.Questions;

import java.util.*;

public class AlienDictionary {
    

    // complexity
    // sc = O(4K + V)         // 1st one for char set, indegree, ans list, and queue
                                    // 2nd one for the graph
                                    
    // tc = ~ O(V+E)        // for the topo sort and other constant operations can be ignored

     public String findOrder(String[] words) {
        
        
        // counting no. of unique alphabets used
        Set<Character> set = new HashSet<>();
        for(String word : words){
            for(int i = 0; i<word.length(); i++){
                set.add(word.charAt(i));
            }
        }
        
        int m = set.size();
        // initializing a graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        
         // indegeree map
        // maintaining a map, because nodes are non linear
        // it can be anywhere around 0 to 25, corresponding to alphabets
        Map<Integer, Integer> indegree = new HashMap<>();
        for (char ch : set) {           // adding each char
            indegree.put(ch - 'a', 0);
        }
        
        
        // now iterate over the words array
        // extract pair wise
        // compare each letter 
        // add edge to 1st unmatched letter found
        // repeat process till the last word
        
        for(int i = 0; i<words.length-1; i++){
            
            String s1 = words[i];
            String s2 = words[i+1];
            
        
        // early return
        // incase of larger str is before shorter string, and initial chars are same, depicting invalid order
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            
            
            // now iterate over each letter of the two words
            for(int j = 0 ;j< Integer.min(s1.length(), s2.length()); j++){
                
                char l1 = s1.charAt(j);
                char l2 = s2.charAt(j);
                
                if(l1 !=l2){
                    
                    // using typecasting to get corresponding integer values of char
                    int u = l1 - 'a';
                    int v = l2 - 'a';
                    if (!graph.get(u).contains(v)) { //avoiding adding again
                        graph.get(u).add(v);
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    break;          // if 1st msmatch found no need to furthur iterate
                    
                }
            }
        }
        
        // now we have the graph
        // just need to topologically sort
        // once we get the list
        // finally again convert the nums from the list to corresponding letters
        // and adding to a string, and returning it
        // will return empty string, if topo sort is not possible
        
        
        // applying kahn's algorithm, for topo sort
        
        // now we have indegree map
        // with node value and corresponding indegree count
        
        
        // initialize queue
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        // add to que, the nodes with indegree 0;
        for(int key : indegree.keySet()){
            if(indegree.get(key) == 0) que.add(key);
        }
        
        while(!que.isEmpty()){
            
            int node = que.peek();
            ans.add(node);
            que.remove();
            
            // explore neighbours, decrement indegree, if 0 add to que
            for(int neighbour : graph.get(node)){
                indegree.put(neighbour, indegree.get(neighbour)-1);
                
                if(indegree.get(neighbour) == 0) que.add(neighbour);
            }
            
        }
        
        
        // now we have the nodes topologically sorted in the list
        
        // if the ans array has exact no. of unique letters provided, then the sequeuence is achievable, and there is no cycle
        // then initialize a string, and add chars corresponding the int node to it and return
        // or else return an empty string
        
        String str = "";
        if(ans.size() != m) return str;
            
        for(int i =0; i<m; i++){
            str += (char)(ans.get(i) + 'a');
        }
        return str;
        
        
        // fucking great solution
        // byfar the one of the complex ones
        // but somehow managed through it
        // ha ha
        
    }
}
