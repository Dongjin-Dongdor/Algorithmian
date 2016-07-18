/**
 * Created by dongdor on 2016. 7. 18..
 */
public class Heap {

    public int[] array;
    public int count; //힙 안의 요소의 수
    public int capacity; //힙의 크기
    public int heap_type; //최대 힙인지 최저 힙인지

    public Heap(int capacity, int heap_type){

        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];

    }


    //i번째 위치의 노드에서 부모 노드는 i-1/2의 위치에 있어야 한다
    public int parent(int i){
        if(i<=0 || i>=this.count)
            return -1;
        return i-1/2;
    }

    //i번째 위치에 있는 노드의 자식들은 2*i+1과 2*i+2의 위치에 있다

    public int leftChild(int i){
        int left = 2 * i +1;
        if(left>=this.count)
            return -1;
        return left;
    }

    public int rightChild(int i){
        int right = 2 * i + 2;
        if(right>=this.count)
            return -1;
        return right;
    }

    //최대항목 구하기
    public int GetMaximum(){
        if(this.count == 0)
            return -1;
        return this.array[0];
    }

    //i위치의 항목 힙으로 만들기
    //O(logN)
    public void PercolateDown(int i){
        int l, r, max, temp;
        l = leftChild(i);
        r = rightChild(i);

        if(l != -1 && this.array[l] > this.array[i])
            max = l;
        else
            max = i;

        if(r != -1 && this.array[r]>this.array[max])
            max = r;

        if(max != i){
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[i] = temp;
        }

        PercolateDown(max);
    }

    int DeleteMax(){
        if(this.count == 0)
            return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count -1];
        this.count --;
        PercolateDown(0);
        return data;
    }

    void Insert(int data){
        int i;
        if(this.count == this.capacity)
            ResizeHeap();
        this.count++;
        i = this.count -1;
        while(i >= 0 && data>this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = i -1/2;
        }
        this.array[i] = data;
    }

    void ResizeHeap(){
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array,0,array_old,this.count-1,0);
        this.array = new int[this.capacity*2];
        if(this.array == null){
            System.out.println("Memory Error");
            return;
        }
        for(int i = 0;i<this.capacity;i++)
            this.array[i] = array_old[i];
        this.capacity *= 2;
        array_old = null;
    }

    void DestroyHeap(){
        this.count = 0;
        this.array = null;
    }

    void BuildHeap(Heap h, int A[], int n){
        if(h == null) return;
        while(n>this.capacity)
            h.ResizeHeap();
        for(int i = 0; i<n; i++)
            h.array[i] = A[i];

        this.count = n;

        for(int i = (n-1)/2; i>= 0; i--)
            h.PercolateDown(i);

    }
}
