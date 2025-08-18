public class CelebrityProb {
    
public int celebrity(int mat[][]) {
        // code here
        
        // stack to maintain the potential candidates
        Stack<Integer> st = new Stack<>();
        
        for(int i =0; i< mat.length; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            // now check of potential celebrities
            int p1 = st.pop();
            int p2 = st.pop();
            
            if(mat[p1][p2] == 0){   // p1, doesn't know p2, then p2 is surely not a celebrity
                //but p1 is potential, push is back
                st.push(p1);
            }
            else{   // else if, p1 knows p2, then p1 is not for sure, p2 is potential
                st.push(p2);
            }
        }
        
        if(st.size() = 0) return -1;        // if stack becomes empty, no potential
        // at this point we have only one index in the stack, which is the potential one
        
        for(int i =0; i<mat[st.peek()].length; i++){
            // if it knows anyone, or any of one doen't know it
            if(st.peek()!=i && (mat[st.peek()][i] == 1 || mat[i][st.peek()]==0)) return -1;
        }
        
        // if at this point ele in the stack know nobody return it
        return st.pop();
        
    }

}
