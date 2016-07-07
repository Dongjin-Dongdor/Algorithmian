//
//  DoubleLinkedList.c
//  Algorithmian_DoubleLinkedList
//
//  Created by 김동진 on 2016. 7. 6..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "DoubleLinkedList.h"

/* 노드 생성 */
/*
 기존의 링크드 리스트의 버전과 비교해보면 생성한 노드의 PrevNode에 NULL 을 대입하여 초기화하는 부분만이 추가됐을 뿐이다.
 */
Node* DLL_CreateNode(ElementType NewData)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    
    NewNode->Data = NewData;
    NewNode->PrevNode = NULL;
    NewNode->NextNode = NULL;
    
    return NewNode;
    
}


/* 노드 소멸*/
/*
 이 부분은 아예 링크드리스트의 버전과 동일하다. free를 통해 자유저장소메모리를 해제해 줄 뿐이다.
 */
void DLL_DestroyNode(Node* Node)
{
    free(Node);
}

/*노드 추가*/
/*
 기존 링크드 리스트에서는 테일의 NextNode포인터가 새로 추가된 테일을 가리키도록하면 모든 일이 끝났다. 
 더블링크드리스트에서는 새로운 테일의 PrevNode포인터도 기존 테일의 주소를 가리키게 해야 한다.
 
 */
void DLL_AppendNode(Node** Head, Node* NewNode )
{
    /*헤드 노드가 NULL이면 새로운 노드가 Head*/
    if((*Head) == NULL)
    {
        *Head = NewNode;
    }
    else
    {
        /* 테일을 찾아 NewNode를 연결한다.*/
        Node* Tail = (*Head);
        while(Tail->NextNode != NULL)
        {
            Tail = Tail -> NextNode;
        }
        Tail->NextNode = NewNode;
        NewNode->PrevNode = Tail; /*기존의 테일을 새로운 테일의  PrevNode가 가리킨다 */
    }
}

/* 노드 탐색 */
/*
 링크드리스트의 노드탐색을 그대로 따라한다.
 */

Node* DLL_GetNodeAt(Node* Head, int Location)
{
    Node* Current = Head;
    
    while(Current != NULL && (--Location) >= 0)
    {
        Current  = Current -> NextNode;
    }
    
    return Current;
}


/* 노드 삭제 */

/* 살짝 골치 아프다. 1)삭제할 노드의 양쪽 포인터 두개 2)이전 노드의 NextNode포인터 3)이후 노드의 PrevNpde포인터 등을 다뤄야한다
    [1]삭제할 노드의 NextNode 포인터가 가리키고 있던 노드를 앞 노드의 NextNode 포인터가 가리키게 바꾸고
    [2]삭제할 노드의 PrevNode 포인터가 가리키고 있던 노드를 뒷 노드의 PrevNode포인터가 가리키게 바꾼다.
    [3]삭제할 노드의 NextNode와 PrevNode는 깨끗하게 NULL로 초기화한다.
 */
void DLL_RemoveNode(Node** Head, Node* Remove)
{
    if(*Head == Remove)//만약 삭제할 노드가 헤드노드라면 다른 작업없이 PrevNode와 NextNode를 NULL로 둔다.
    {
        *Head = Remove->NextNode;
        if((*Head)!= NULL)
        {
            (*Head)->PrevNode = NULL;
        }
        Remove->PrevNode = NULL;
        Remove->NextNode = NULL;
    }
    else
    {
        Node* Temp = Remove;
        if(Remove -> PrevNode != NULL)
        {
            Remove->PrevNode->NextNode = Temp -> NextNode;//[1]을 수행한다.
        }
        if(Remove-> NextNode != NULL)
        {
            Remove->NextNode->PrevNode = Temp -> PrevNode;//[2]를 수행한다.
        }
        //[3]을 수행한다.
        Remove -> PrevNode = NULL;
        Remove -> NextNode = NULL;
    }
}


/* 노드 삽입 */
/* 
 1)우선 삽입하는 노드의 PrevNode는 앞 노드를 NextNode는 뒷 노드를 가리킨다.
 2)앞 노드의 NextNode와 뒷 노드의 PrevNode는 새로 삽입하는 노드를 가리킨다.
 */

void DLL_InsertAfter(Node* Current, Node* NewNode)
{
    NewNode -> NextNode = Current -> NextNode;
    NewNode -> PrevNode = Current;
    
    if(Current -> NextNode != NULL)
    {
        Current -> NextNode -> PrevNode = NewNode; //뒷노드의 PrevNode가 NewNode를 가리키게 만든다.
        Current -> NextNode = NewNode;//앞 노드의 NextNode가 NewNode를 가리키게 만든다.
    }
}


/* 노드 개수 세기 */
/*
 링크드 리스트의 기본 GetNodeCount와 동일하다.
 */

int DLL_GetNodeCount(Node* Head)
{
    unsigned int Count = 0;
    Node* Current  = Head;
    
    while(Current != NULL)
    {
        Current = Current -> NextNode;
        Current++;
    }
    return Count;
}




void PrintNode(Node* _Node)
{
    if (_Node->PrevNode == NULL)
    {
        printf("Prev : NULL");
    }
    else
    {
        printf("Prev: %d",_Node->PrevNode->Data);
    }
    
    printf("Current:%d",_Node->Data);
    
    if(_Node->NextNode == NULL)
    {
        printf("Next: NULL\n");
    }
    else
    {
        printf("Next : %d\n",_Node->NextNode->Data);
    }
}



