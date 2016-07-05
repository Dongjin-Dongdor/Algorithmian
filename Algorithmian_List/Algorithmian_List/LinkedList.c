//
//  LinkedList.c
//  Algorithmian_List
//
//  Created by 김동진 on 2016. 7. 5..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "LinkedList.h"

/* 노드 생성 */
Node* SLL_CreateNode(ElementType NewData)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));

    NewNode -> Data = NewData; //데이터 저장한다.
    NewNode -> NextNode = NULL;// 다음 노드에 대한 포인터는 NULL로 초기화한다.
    
    return NewNode; //노드의 주소 반환
    
}


/* 노드 소멸 */
void SLL_DestroyNode(Node* Node)
{
    free(Node);
}


/* 노드 추가 */
void SLL_AppendNode(Node** Head, Node* NewNode)
{
    
    if((*Head) == NULL)
    {
        *Head = NewNode;
    }

    else
    {
        Node* Tail = (*Head);
        while(Tail->NextNode !=NULL)
        {
            Tail = Tail->NextNode;//꼬리
        }
     
        Tail->NextNode = NewNode;
    }
}

/* 노드 삽입 */
void SLL_InsertAfter(Node* Current, Node* NewNode)
{
    NewNode -> NextNode = Current->NextNode;
    Current -> NextNode = NewNode;
}

/*  노드 헤드에 삽입 */
void SLL_InsertNewHead(Node** Head, Node* NewHead)
{
    if(Head == NULL)
    {
        (*Head) = NewHead;
        
    }
    else
    {
        NewHead -> NextNode = (*Head);
        (*Head) = NewHead;
        
    }
}

/* 노드제거 */

void SLL_RemoveNode(Node** Head, Node* Remove)
{
    if(*Head == Remove)
    {
        *Head = Remove->NextNode;
        
    }
    else
    {
        Node* Current = *Head;
        while(Current != NULL && Current->NextNode != Remove)
        {
            Current = Current->NextNode;
        }
        
        if(Current != NULL)
        {
            Current->NextNode = Remove->NextNode;
        }
    }
}

/* 노드탐색 */
Node* SLL_GetNodeAt(Node* Head, int Location)
{
    Node* Current = Head;
    
    while(Current != NULL && (--Location)>=0)
    {
        Current = Current->NextNode;
    }
    return Current;
    
}

/* 노드 수 세기 */
int SLL_GetNodeCount(Node* Head)
{
    int Count = 0;
    Node* Current = Head;
    
    while(Current != NULL)
    {
        Current = Current->NextNode;
        Count++;
    }
    
    return Count;
}






