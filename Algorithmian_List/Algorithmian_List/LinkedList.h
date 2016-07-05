//
//  LinkedList.h
//  Algorithmian_List
//
//  Created by 김동진 on 2016. 7. 5..
//  Copyright © 2016년 김동진. All rights reserved.
//


#ifndef LinkedList_h
#define LinkedList_h


#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;

typedef struct TagName
{
    ElementType Data;
    struct TagName* NextNode;
}Node;

/*함수원형 선언 */
Node* SLL_CreateNode(ElementType NewData);

void SLL_DestroyNode(Node* Node);

void SLL_AppendNode(Node** Head, Node* NewNode);

void SLL_InsertAfter(Node* Current, Node* NewNode);

void SLL_InsertNewHead(Node** Head, Node* NewHead);

void SLL_RemoveNode(Node** Head, Node* Remove);

Node* SLL_GetNodeAt(Node* Head, int Location);

int SLL_GetNodeCount(Node* Head);






#endif /* LinkedList_h */
