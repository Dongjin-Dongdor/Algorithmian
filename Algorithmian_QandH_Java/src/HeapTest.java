/**
 * Created by dongdor on 2016. 8. 2..
 */
/**
 * 우선수위 큐
 일반적인 큐는 FIFO자료구조이기에 먼저 들어온 데이터를 먼저 내보냈다면
 우선순위 큐는 우선순위가 높은 데이터를 먼저 내보내는 자료구조이다.

 CPU 스케쥴링중 Priority Scheduling 을 생각하면 쉽다
 보통 큐처럼 동작하지만 우선순위에 따라서 오름차순으로 정렬이 된 상태로 유지된다.

 */
public class HeapTest {

    public static void main(String[] args){
        Heap mHeap = new Heap(8);
        System.out.println("Insert 5,7 8, 9, 4, 2, 3, 1");
        mHeap.insert(5);
        mHeap.insert(7);
        mHeap.insert(8);
        mHeap.insert(9);
        mHeap.insert(4);
        mHeap.insert(2);
        mHeap.insert(3);
        mHeap.insert(1);
        mHeap.print();

        System.out.println(" ");
        System.out.println("Delete");
        mHeap.delete();
        mHeap.print();

        System.out.println(" ");
        System.out.println("Delete");
        mHeap.delete();
        mHeap.print();
    }

    static class Heap{
        int totalSize;
        int usedSize;
        int[] heapArray;


        public Heap(int size){
            totalSize = size;
            heapArray = new int[totalSize];
            usedSize  = 0;
        }

        public void insert(int data){
            int currentPosition = usedSize;
            int parentPosition = getParentPosition(currentPosition);

            if(usedSize == totalSize)
                return;
           //우선 배열 다음 위치에 데이터를 넣는다.
            heapArray[currentPosition] = data;

            while(currentPosition > 0 && heapArray[currentPosition] < heapArray[parentPosition]){
                swap(heapArray, currentPosition, parentPosition);
                currentPosition = parentPosition;
                parentPosition = getParentPosition(currentPosition);
            }
            usedSize += 1;
        }

        public void delete(){
            if(usedSize == 0)
                return;
            usedSize -= 1;

            int currentPosition = 0;
            int leftChildPosition = getLeftChildPosition(currentPosition);
            int rightChildPosition = getRightChildPosition(currentPosition);

            heapArray[currentPosition] = 0;
            swap(heapArray, currentPosition, usedSize);

            while(true){

                int selectChildPosition = 0;
                if(leftChildPosition >= usedSize)
                    break;
                if(rightChildPosition >= usedSize)
                    selectChildPosition = leftChildPosition;
                else{
                    if(heapArray[leftChildPosition] > heapArray[rightChildPosition])
                        selectChildPosition = rightChildPosition;
                    else selectChildPosition = leftChildPosition;
                }

                if(heapArray[selectChildPosition] < heapArray[currentPosition]){
                    swap(heapArray, selectChildPosition, currentPosition);
                    currentPosition = selectChildPosition;
                }
                else
                    break;

                leftChildPosition = getLeftChildPosition(currentPosition);
                rightChildPosition = getLeftChildPosition(currentPosition);
            }
        }

        public void swap(int[] array, int index1, int index2){

            int temp  = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;

        }

        public int getParentPosition(int subPosition){

            return (int)((subPosition -1)/2);

        }

        public int getLeftChildPosition(int parentPosition){
            return 2*parentPosition+1;
        }

        public int getRightChildPosition(int parentPosition){
            return 2*parentPosition+2;
        }

        public void print(){
            int depth = 0;
            int position = 0;
            for(int i=0; i<usedSize; i++){
                if(position == i){
                    if(position != 0) System.out.println("");
                    System.out.println("Depth : "+depth);
                    position = position + (int) Math.pow(2,depth);
                    depth += 1;
                }
                System.out.print(heapArray[i]+" ");
            }
            System.out.println("");
        }
    }
}



