class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word: words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        var count = 0;
        for(var e : wordCount.entrySet())
            if(isSubsequence(s, e.getKey())) count += e.getValue();

        return count;
    }

    private boolean isSubsequence(String s, String w) {
        int wIndex = 0;
        for(int i = 0; i < s.length() && wIndex < w.length(); ++i) {
            if(w.charAt(wIndex) == s.charAt(i)) ++wIndex;
        }
        return wIndex == w.length();
    }
}