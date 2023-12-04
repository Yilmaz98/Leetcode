class Solution {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        int start;
        int end;
        
        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.count = 0;
        }
    }
    
    public SegmentTreeNode buildTree(int start, int end) {
        if(start > end) {
            return null;
        } else {
             SegmentTreeNode root = new SegmentTreeNode(start, end);
            if(start == end) {
                root.count = 0;
            } else {
            int mid = start + (end - start)/2;
            root.left = buildTree(start, mid);
            root.right = buildTree(mid + 1, end);
            root.count = root.left.count + root.right.count;
            }
            return root;
        }
    }
    
    public void update(SegmentTreeNode root, int index) {
        if(root == null)
            return;
        
        if(root.start == index && root.end == index) {
            root.count++;
            return;
        }
        
        int mid = root.start + (root.end - root.start)/2;
        if(index <= mid) {
            update(root.left, index);
        } else {
            update(root.right, index);
        }
        root.count = root.left.count + root.right.count;
    }
    
    public int returnSum(SegmentTreeNode root, int start, int end) {
        if(root == null || start > end)
            return 0;
        
        if(root.start == start && root.end == end) {
            return root.count;
        }
        
        int mid = root.start + (root.end - root.start)/2;
        if(end <= mid) {
            return returnSum(root.left, start, end);
        } else if(start >= mid+1) {
            return returnSum(root.right, start, end);
        }
        
        return returnSum(root.left, start, mid) + returnSum(root.right, mid + 1, end);
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        
        SegmentTreeNode root = buildTree(mini, maxi);
        List<Integer> count = new ArrayList<>();
        
        for(int i = nums.length - 1;i>=0;i--) {
            update(root, nums[i]);
            count.add(0, returnSum(root, mini, nums[i] - 1));
        }
        
        return count;
    }
}