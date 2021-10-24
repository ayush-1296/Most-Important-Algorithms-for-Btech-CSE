package com.firsts;

import java.util.Arrays;

public class FirstLast {
    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,3,5,6,9,9,9,9,9,13};
        int target = 3;
        System.out.println(Arrays.toString(firstLastOccurence(arr,target)));
    }
    static int[] firstLastOccurence(int[] arr,int target){
        int[] ansArr={-1,-1};
        ansArr[0] = binarysearch(arr,target,true);//isFirst==true means searching for the first occurence
        if(ansArr[0]!=-1)//searching for last occurence is not required if target is not present at all(-1)
            ansArr[1] = binarysearch(arr,target,false);//isFirst==false means searching for the last occurence
        return ansArr;
    }
    static int binarysearch(int[] arr,int target,boolean isFirst){
        int start=0;
        int end=arr.length-1;
        int ans=-1;//Initially,we consider that the element is not at all present
        while(start <= end){
            int mid=start+(end-start)/2;

            if(target > arr[mid])
                start=mid+1;
            else if(target < arr[mid])
                end=mid-1;
            else{ //If we find the target,we store the index of it in ans and check in it's left part(for isfirst==true)
                ans=mid;
                if(isFirst)
                    end=mid-1;
                else
                    start=mid+1;
            }
        }//after the loop,the value in ans is the first index(for isFirst==true)
        return ans;//if we never found the target,ans will be -1 after the loop.
    }
}

