class ProductOfNumbers {
  static List<Integer> prod;
    static int p;
    public ProductOfNumbers() {
        prod = new ArrayList<>();
        p = 1;
    }
    public void add(int num) {
        if(num == 0) {
            prod = new ArrayList<>();
            p = 1;
            return;
        }
        p *= num;
        prod.add(p);
    }
    public int getProduct(int k) {
        if(prod.size() < k) return 0;
        int ans = prod.get(prod.size() - 1);
        if(prod.size() == k) return ans;
        return (ans / prod.get(prod.size() - 1 - k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */