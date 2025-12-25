package index;


    public class BinaryTree<T>{
        protected T root;
        public BinaryTree(){
            root = null;
        }
        public boolean isEmpty(){
            return root == null;
        }

        public T getRoot() {
                return root;
        }
    }


