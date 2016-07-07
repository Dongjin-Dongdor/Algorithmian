//
//  main.c
//  CircularLinkedList
//
//  Created by 김동진 on 2016. 7. 7..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "CircularLinkedList.h"

/*  노드 추가 */
/* 
 비어 있는 리스트에 새 노드를 추가하는 과정을 생각해보자.
 환형 링크드 리스트의 경우 새로운 노드는 헤드가 되고, 헤드의 앞 노드는 헤드가 되고, 헤드의 뒷 노드 역시 헤드 자신이 된다. 
 
 비어 있지않은 리스트의 경우 "테일 노드 뒤에 새 노드를 붙인다" 보다는 "테일과 헤드 사이에 새 노드를 삽입한다"라고 생각하는 것이 이해하기 쉽다.
 */

void CDLL_AppendNode(Node** Head, Node* NewNode)
{
    /*Head가  NULL이라면 새로운 노드가 Head*/
    if( (*Head) == NULL)
    {
        *Head = NewNode;
        (*Head) -> NextNode = *Head;
        (*Head) -> PrevNode = *Head;
        
    }
    else
    {
        /* 테일과 헤드 사이에 NewNode를 삽입한다. */
        Node* Tail = (*Head)->PrevNode;//헤드의 앞 노드이므로 결국 테일이다.
        
        Tail->NextNode->PrevNode = NewNode;//테일의 NextNode의 PrevNode이므로 결국 헤드의 PrevNode를 새로운 노드에 연결
        Tail->NextNode = NewNode;//테일의 NextNode를 새로운 노드에 연결한다.
        
        NewNode->NextNode = (*Head);//새로운 노드의 NextNode는 현재 Head로 지정.
        
        /* 기존의 테일을 새로운 테일의 PrevNode가 가리킨다 */
        NewNode->PrevNode = Tail;
    }
}

/* 노드 제거 */
/* Head와 Tail이 연결되어 있는 점에 주의해야하지만, 더블 링크드 리스트 버전과 비교해서 크게 달라질 것은 없다. */

void CDLL_RemoveNode(Node** Head, Node* Remove)
{
    if( (*Head) == Remove)
    {
        (*Head)->PrevNode->NextNode = Remove->NextNode;
        (*Head)->NextNode->PrevNode = Remove->PrevNode;
        
        *Head = Remove->NextNode;
        
        Remove->PrevNode = NULL;
        Remove->NextNode = NULL;
    }
    else
    {
        Node* Temp = Remove;
        
        Remove->PrevNode->NextNode = Temp->NextNode;
        Remove->NextNode->PrevNode = Temp->PrevNode;
        
        Remove->PrevNode = NULL;
        Remove->NextNode = NULL;
    }
}

/* 노드 생성 */
Node* CDLL_CreateNode(ElementType NewData)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    
    NewNode->Data = NewData;
    NewNode->PrevNode = NULL;
    
    NewNode->NextNode = NULL;
    
    return NewNode;
}

/* 노드 소멸 */
void CDLL_DestroyNode(Node* Node)
{
    free(Node);
}


/* 노드 탐색 */
Node* CDLL_GetNodeAt(Node* Head, int Location)
{
    Node* Current = Head;
    while(Current != NULL && (--Location)>=0)
    {
        Current = Current->NextNode;
    
    }
    
    return Current;
}

/* 노드 삽입 */
void CDLL_InsertAfter(Node* Current, Node* NewNode)
{
    NewNode->NextNode = Current->NextNode;
    NewNode->PrevNode = Current;
    
    if (Current->NextNode != NULL)
    {
        Current->NextNode->PrevNode = NewNode;
        Current->NextNode = NewNode;
    }
}

/* 노드 수 세기 */
int CDLL_GetNodeCount(Node* Head)
{
    unsigned int Count = 0;
    Node* Current = Head;
    
    while(Current != NULL)
    {
        Current  = Current -> NextNode;
        Count++;
        
        if(Current == Head)
        {
            break;
        }
    }
    return Count;
}

void PrintNode(Node* _Node)
{
    
    if(_Node->PrevNode == NULL)
        printf("Prev:NULL");

    else
        printf("Prev:%d",_Node->PrevNode->Data);
    
    printf("Current :%d",_Node->Data);
    
    if(_Node->NextNode == NULL)
        printf("Next:NULL\n");
    else
        printf("Next: %d\n",_Node->NextNode->Data);
    
}






