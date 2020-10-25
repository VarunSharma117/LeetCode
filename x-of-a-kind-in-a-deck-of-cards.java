class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int prevgcd=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int e:deck) map.put(e,map.getOrDefault(e,0)+1);
        for(int e:map.values()) prevgcd = gcd(prevgcd,e);
        return prevgcd>=2;
    }
    int gcd(int a,int b){ return b==0?a:gcd(b,a%b);}
}
