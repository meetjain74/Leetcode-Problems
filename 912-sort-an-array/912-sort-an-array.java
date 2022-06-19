class Solution {
    public int[] sortArray(int[] nums) {
        quickSort_3way(nums);
        return nums;
    }
    
    /******************************BUBBLE SORT**********************************/
    
    public void bubbleSort(int array[]) {
        int temp,flag;
        for (int i=0;i<array.length-1;i++) {
            flag=0;
            for (int j=0;j<array.length-i-1;j++) {
                if (array[j]>array[j+1]) {
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
    
    public void selectionSort(int array[]) {
        int small,temp;
        for (int i=0;i<array.length-1;i++) {
            small=array[i];
            for (int j=i;j<array.length;j++) {
                if (array[j]<small) {
                    temp=array[j];
                    array[j]=small;
                    small=temp;
                }
            }
            array[i]=small;
        }
    }
    
    /******************************INSERTION SORT**********************************/
    
    public void insertionSort(int array[]) {
        int temp,j;
        for (int i=1;i<array.length;i++) {
            temp=array[i];
            j=i-1;
            while (j>=0 && array[j]>temp) {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }
    
    /******************************QUICK SORT**********************************/
    
    public void quickSort(int array[]) {
        quickSort(array,0,array.length-1);
    }

    public void quickSort(int array[],int p,int r) {
        if (p<r) {
            int q=partition(array,p,r);
            quickSort(array,p,q-1);
            quickSort(array,q+1,r);	
        }
    }

    public void swapAtIndex(int array[],int x,int y) {
        int temp=array[x];
        array[x]=array[y];
        array[y]=temp;
    }

    public int partition(int array[],int p,int r) {
        int pivot=array[r];
        int i=p-1;
        for (int j=p;j<=r-1;j++) {
            if (array[j]<=pivot)
                swapAtIndex(array,++i,j);
        }
        swapAtIndex(array,++i,r);
        return i;
    }
    
    /******************************QUICK SORT 3 WAY**********************************/
    
    public void quickSort_3way(int array[]) {
        quickSort_3way(array,0,array.length-1);
    }

    public void quickSort_3way(int array[],int p,int r) {
        if (p<r) {
            int q[]=partition_3way(array,p,r);
            quickSort_3way(array,p,q[0]-1);
            quickSort_3way(array,q[1]+1,r);	
        }
    }

    public int[] partition_3way(int array[],int p,int r) {
        int pivot=array[r];
        int i=p;
        int k=r;
        for (int j=p;j<k;j++) {
            if (array[j]<pivot) {
                swapAtIndex(array,i++,j);
            }
            else if (array[j]>pivot) {
                swapAtIndex(array,--k,j);
                j--;
            }
        }
        swapAtIndex(array,k,r);
        int indexes[]=new int[] {i,k};
        return indexes;
    }
}