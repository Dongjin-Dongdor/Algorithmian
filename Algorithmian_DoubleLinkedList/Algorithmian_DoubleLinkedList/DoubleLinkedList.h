//
//  Header.h
//  Algorithmian_DoubleLinkedList
//
//  Created by 김동진 on 2016. 7. 6..
//  Copyright © 2016년 김동진. All rights reserved.
//

#ifndef Header_h
#define Header_h

#include<stdio.h>
#include<stdlib.h>//malloc 쓰려고 

typedef int ElementType;

typedef struct tagNode
{
    int Data;
    struct tagNode* PrevNode;
    struct tagNode* NextNode;
    
}Node;


Node* DLL_CreateNode(ElementType NewData);

void DLL_DestroyNode(Node* Node);

void DLL_AppendNode(Node** Head, Node* NewNode );

Node* DLL_GetNodeAt(Node* Head, int Location);

void DLL_InsertAfter(Node* Current, Node* NewNode);

void DLL_RemoveNode(Node** Head, Node* Remove);

Node* DLL_GetNodeAt(Node* Head, int Location);

int DLL_GetNodeCount(Node* Head);



#endif /* Header_h */
