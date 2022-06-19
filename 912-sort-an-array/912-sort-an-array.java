class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
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
    
    /******************************RANDOMISED QUICK SORT***************************/
    
    public void randomised_QuickSort(int array[]) {
        randomised_QuickSort(array,0,array.length-1);
    }

    public void randomised_QuickSort(int array[],int p,int r) {
        if (p<r) {
            int q[]=randomised_partition(array,p,r);
            randomised_QuickSort(array,p,q[0]-1);
            randomised_QuickSort(array,q[1]+1,r);	
        }
    }

    public int[] randomised_partition(int array[],int p,int r) {
        Random rand=new Random();
        int swap_index=p+rand.nextInt(r-p);
        swapAtIndex(array,swap_index,r);
        return partition_3way(array,p,r);
    }
    
    /******************************MERGE SORT******************************/
    
    public void merge(int arr[],int left,int right,int mid) {
        int n1=mid-left+1;
        int n2=right-mid;
        int leftArray[]=new int[n1];
        int rightArray[]=new int[n2];

        for (int i=0;i<n1;i++)
            leftArray[i]=arr[left+i];
        for (int i=0;i<n2;i++)
            rightArray[i]=arr[mid+1+i];

        
        int i=0,j=0; /*Initial index of both subarrays is zero*/
        int k=left; /*Initial index of merged subarray*/

        while (i<n1 && j<n2) {
            if (leftArray[i]<rightArray[j]) {
                arr[k]=leftArray[i];
                i++;
            }
            else {
                arr[k]=rightArray[j];
                j++;
            }
            k++;
        }

        while (i<n1)
            arr[k++]=leftArray[i++];
        while (j<n2)
            arr[k++]=rightArray[j++];
    }

    public void mergeSort(int arr[]) {
        mergeSort(arr,0,arr.length-1);
    }

    
    public void mergeSort(int arr[],int left,int right) {
        if (left>=right)
            return;

        int mid=(left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,right,mid);
    }
    
    /******************************HEAP SORT******************************/
    
    public void heapSort(int arr[]) {
        int n=arr.length; 
        buildMaxHeap(arr);
        
        // One by one extract an element from heap 
        for (int i=n-1;i>=1;i--) { 
            // Move current root to end 
            int temp=arr[0]; 
            arr[0]=arr[i]; 
            arr[i]=temp; 
            // call max heapify on the reduced heap 
            heapify(arr,i,0); 
        } 
    }

    /*Time Complexity-O(n)*/
    public void buildMaxHeap(int arr[]) {
        int n=arr.length; 
        for (int i=n/2-1;i>=0; i--) 
            heapify(arr,n,i);
    }

    /*Time Complexity-O(nlogn)*/
    public void heapify(int arr[],int n,int i) { 
        int largest=i;  // Initialize largest as root 
        int l=2*i+1;
        int r=2*i+2;

        if (l<n && arr[l]>arr[largest]) 
            largest=l; 
        if (r<n && arr[r]>arr[largest]) 
            largest=r; 

        if (largest!=i) { 
            int swap=arr[i]; 
            arr[i]=arr[largest]; 
            arr[largest]=swap; 
            heapify(arr,n,largest); 
        } 
    }
}