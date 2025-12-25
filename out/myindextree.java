package index;
import java.util.List;
public class myindextree extends BinaryTree<myindextree>{
    myindexnode root;
    public  myindextree(){
        root=null;
        }
    public void add(String word, int linenumber){
         root = add(root,word,linenumber);
    }
    private myindexnode add(myindexnode current, String word,int linenumber){
        if(current==null){
            return new myindexnode(word,linenumber);

        }
        int cmp=word.compareTo(current.word);

        if (cmp==0) {
            current.addLine(linenumber);

        }else if(cmp<0){
            current.left=add(current.left,word,linenumber);
        }else if(cmp>0){
            current.right=add(current.right,word,linenumber);
        }

        return current;
    }
    public void find(String word){
         find(root,word);
    }
    public myindexnode find(myindexnode current, String word){
        if(current==null){
            return null;

        }
        int cmp=word.compareTo(current.word);
        if(cmp==0){
            return current;
        }else if(cmp<0){
            return find(current.left,word);
        }else if(cmp>0){
            return find(current.right,word);
        }
        return current;
    }
}
