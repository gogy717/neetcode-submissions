class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            mapS.put(sc, mapS.getOrDefault(sc, 0) + 1);
            mapT.put(tc, mapT.getOrDefault(tc, 0) + 1);
        }
        return mapS.equals(mapT);
    }
}
