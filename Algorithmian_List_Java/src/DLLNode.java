/**
 * Created by dongdor on 2016. 7. 12..
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public DLLNode getNext(){
        return this.next;
    }

    public int getDLLLength(DLLNode head){
        int count = 0;
        DLLNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }

    public void setPrevious(DLLNode previous){
        this.previous = previous;
    }

    public DLLNode getPrevious(){
        return this.previous;
    }

    //노드 삽입
    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position){
        if(headNode == null){ //시작 부분에 삽입한다
            return nodeToInsert;
        }

        int size = getDLLLength(headNode);

        if(position > size+1 || position <1){
            System.out.println("position of nodeToInsert is invalid");
            return headNode;
        }

        if(position == 1){
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        }
        else{ //중간에 노드 삽입
            DLLNode previousNode = headNode;
            int count = 1;
            while(count<position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode != null){
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    //노드 삭제
    DLLNode DLLDelete(DLLNode headNode, int position){
        int size = getDLLLength(headNode);

        if(position>size || position <1){
            System.out.println("position of node to delete is invalid");
            return headNode;
        }

        if(position ==1){
            DLLNode currentNode = headNode.getNext();
            headNode = null;
            currentNode.setPrevious(null);
            return currentNode;
        }
        else{
            DLLNode previousNode = headNode;
            int count = 1;
            while(count<position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode != null){
                laterNode.setPrevious(previousNode);
            }
            currentNode = null;
        }
        return headNode;
    }
}
