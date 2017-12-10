package LeetCode.Str;

/**
 * Created by SN2OV on 2017/8/26.
 */
public class StrAlgo {

    public Boolean BruteForceStringMatch(int T[],int n,int P[],int m){
        for(int i=0;i<=n-m;i++){
            int j= 0;
            while (j < m && P[j]==T[i+j])
                j = j+1;
            if(j==m)
                return true;
        }
        return false;
    }

}

