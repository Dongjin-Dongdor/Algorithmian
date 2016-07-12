/**
 * Created by dongdor on 2016. 7. 12..
 */
public class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return this.next;
    }

    //노드 탐색
    //시간 복잡도 : 크기가 n인 전체 리스트를 스캔하는데 O(n)
    //공간 복잡도 : 하나의 임시 변수를 만드는 데 O(1)
    int ListLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    //노드 추가
    //시간 복잡도 : 가장 끝에 삽입할 경우 O(n)
    //공간 복잡도 : 하나의 임시 변수를 만드는 데 O(1)
    ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
        if(headNode == null) //최초 설정
            return nodeToInsert;
        int size = ListLength(headNode);
        if(position > size+1 || position < 1){
            System.out.println("Position of node to insert is invalid");
            return headNode;
        }
        if(position == 1){//첫 노드 삽입
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }
        else{//중간 혹은 끝에 노드 삽입
            ListNode previousNode = headNode;
            int count = 1;
            while(count<position-1){
                previousNode = previousNode.getNext();//옆으로 이동
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;

    }

    //연결리스트 노드 삭제하기
    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
        int size = ListLength(headNode);
        if(position>size || position <1){
            System.out.println("Position of node to delete is invalide");
            return headNode;
        }

        if(position == 1){//리스트 가장 앞에서 삭제
            ListNode currentNode  = headNode.getNext();
            headNode = null;
            return currentNode;
        }
        else{
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position - 1){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    //리스트 삭제하기
    void DeleteLinkedList(ListNode head){
        ListNode auxilaryNode, iterator = head;
        while(iterator != null){
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
    }


}
