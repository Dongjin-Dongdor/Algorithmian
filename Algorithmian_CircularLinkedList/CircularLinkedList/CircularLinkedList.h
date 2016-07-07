//
//  CircularLinkedList.h
//  CircularLinkedList
//
//  Created by 김동진 on 2016. 7. 7..
//  Copyright © 2016년 김동진. All rights reserved.
//

#ifndef CircularLinkedList_h
#define CircularLinkedList_h

#include<stdio.h>
#include<stdlib.h>

typedef int ElementType;


typedef struct TagNode
{
    ElementType Data;
    struct TagNode* PrevNode;
    struct TagNode* NextNode;
    
}Node;

void CDLL_RemoveNode(Node** Head, Node* Remove);

void CDLL_AppendNode(Node** Head, Node* NewNode);

Node* CDLL_CreateNode(ElementType NewData);

void CDLL_DestroyNode(Node* Node);

void CDLL_InsertAfter(Node* Currnet, Node* NewNode);

Node* CDLL_GetNodeAt(Node* Head, int Location);

int CDLL_GetNodeCount(Node* Head);


#endif /* CircularLinkedList_h */
