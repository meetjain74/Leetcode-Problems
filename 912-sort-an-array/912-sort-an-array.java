class Solution {
    public int[] sortArray(int[] nums) {
        insertionSort(nums);
        return nums;
    }
    
    /******************************BUBBLE SORT**********************************/
    
    public void bubbleSort(int array[]) {
        int temp,flag;
        for (int i=0;i<array.length-1;i++)
        {
            flag=0;
            for (int j=0;j<array.length-i-1;j++)
            {
                if (array[j]>array[j+1])
                {
                    flag=1;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if (flag==0)
                break;
        }
    }
    
    /******************************SELECTION SORT**********************************/
    
    public void selectionSort(int array[])
    {
        int small,temp;
        for (int i=0;i<array.length-1;i++)
        {
            small=array[i];
            for (int j=i;j<array.length;j++)
            {
                if (array[j]<small)
                {
                    temp=array[j];
                    array[j]=small;
                    small=temp;
                }
            }
            array[i]=small;
        }
    }
    
    /******************************INSERTION SORT**********************************/
    
    public void insertionSort(int array[])
    {
        int temp,j;
        for (int i=1;i<array.length;i++)
        {
            temp=array[i];
            j=i-1;
            while (j>=0 && array[j]>temp)
            {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }
}