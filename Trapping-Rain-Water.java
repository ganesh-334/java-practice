class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int[] l=new int[len];
        int[] r=new int[len];
        int ml=height[0];
        for(int i=0;i<len;i++){
            if(height[i]>ml){
                ml=height[i];
            }
            l[i]=ml;
        }
        int mr=height[len-1];
        for(int j=len-1;j>=0;j--){
            if(height[j]>mr){
                mr=height[j];
            }
            r[j]=mr;
        }
        int water=0;
        for(int i=0;i<len;i++){
            int minval=Math.min(l[i],r[i]);
            int s=Math.abs(minval-height[i]);
            water+=s;
        }
        return water;
    }
}
