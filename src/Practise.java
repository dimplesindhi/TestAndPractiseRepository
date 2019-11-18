static int d1 = -1; 
    static int d2 = -1; 
    static int dist = 0; 

// Returns level of key k if it is present in tree, 
     // otherwise returns -1 
    static int findLevel(Node root, int k, int level) 
    { 
        // Base Case 
        if (root == null) 
            return -1; 
          
        // If key is present at root, or in left subtree or right subtree, 
        // return true; 
        if (root.key == k) 
            return level; 
              
        int l = findLevel(root.left, k, level + 1); 
        return (l != -1)? l : findLevel(root.right, k, level + 1); 
    } 
      
    // This function returns pointer to LCA of two given values n1 and n2.  
    // It also sets d1, d2 and dist if one key is not ancestor of other 
    // d1 --> To store distance of n1 from root 
    // d2 --> To store distance of n2 from root 
    // lvl --> Level (or distance from root) of current node 
    // dist --> To store distance between n1 and n2 
    static Node findDistUtil(Node root, int n1, int n2, int lvl){ 
          
        // Base case 
        if (root == null) 
            return null; 
          
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (root.key == n1){ 
            d1 = lvl; 
            return root; 
        } 
        if (root.key == n2) 
        { 
            d2 = lvl; 
            return root; 
        } 
          
        // Look for n1 and n2 in left and right subtrees 
        Node left_lca = findDistUtil(root.left, n1, n2,  lvl + 1); 
        Node right_lca = findDistUtil(root.right, n1, n2,  lvl + 1); 
          
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca != null && right_lca != null) 
        { 
            dist = (d1 + d2) - 2*lvl; 
            return root; 
        } 
          
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null)? left_lca : right_lca;     
    } 
      
    // The main function that returns distance between n1 and n2 
    // This function returns -1 if either n1 or n2 is not present in 
    // Binary Tree. 
    static int findDistance(Node root, int n1, int n2){ 
         d1 = -1; 
         d2 = -1; 
         dist = 0; 
        Node lca = findDistUtil(root, n1, n2, 1); 
          
        // If both n1 and n2 were present in Binary Tree, return dist 
        if (d1 != -1 && d2 != -1) 
            return dist; 
          
        // If n1 is ancestor of n2, consider n1 as root and find level  
        // of n2 in subtree rooted with n1 
        if (d1 != -1) 
        { 
            dist = findLevel(lca, n2, 0); 
            return dist; 
        } 
          
        // If n2 is ancestor of n1, consider n2 as root and find level  
        // of n1 in subtree rooted with n2 
        if (d2 != -1) 
        { 
            dist = findLevel(lca, n1, 0); 
            return dist; 
        } 
          
        return -1; 
    } 


int findMaxUtil(Node node, Res res) 
    { 
  
        // Base Case 
        if (node == null) 
            return 0; 
  
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int l = findMaxUtil(node.left, res); 
        int r = findMaxUtil(node.right, res); 
  
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(l, r) + node.data, 
                                  node.data); 
  
  
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, l + r + node.data); 
  
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    } 
    
    
    
public int bstDistance(TreeNode root, int node1, int node2) {
    if (root == null) return -1;
    TreeNode lca = lca(root, node1, node2);
    return getDistance(lca, node1) + getDistance(lca, node2);
}

private int getDistance(TreeNode src, int dest) {
    if (src.val == dest) return 0;
    TreeNode node = src.left;
    if (src.val < dest) {
        node = src.right;
    }
    return 1 + getDistance(node, dest);
}

private TreeNode lca(TreeNode root, int node1, int node2) {
    while (true) {
        if (root.val > node1 && root.val > node2) {
            root = root.left;
        } else if (root.val < node1 && root.val < node2) {
            root = root.right;
        } else {
            return root;
        }
    }
}


if (root == null){
            return null;
        }if (nodeA == root || nodeB == root){
            return root;
        }
        TreeNode left = LCA(root.left,node1,node2);
        TreeNode right = LCA(root.right,node1,node2);
        if (left != null && right != null){
            return root;
        }
        if (left == null){
            return right;
        }else return left;
 
