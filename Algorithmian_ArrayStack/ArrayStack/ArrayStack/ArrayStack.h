//
//  ArrayStack.h
//  ArrayStack
//
//  Created by 김동진 on 2016. 7. 7..
//  Copyright © 2016년 김동진. All rights reserved.
//

#ifndef ArrayStack_h
#define ArrayStack_h

#include<stdio.h>
#include<stdlib.h>


typedef int ElementType;

/*
스택의 노드는 다음과같이 데이터만 담는 구조체로 표현된다.
노드의 위치는 배열의 인덱스로 알 수 있기 때문에 링크드 리스트처럼 앞이나 뒷 노드에 대한 포인터는 필요없다.
 */
typedef struct tagNode
{
    ElementType Data;
    
}Node;


/*
배열기반 스택의 구조체는 [용량],[최상위 노드의 위치],[노드 배열]을 가지고 있다.
*/

typedef struct tagArrayStack
{
    int Capacity; //용량
    int Top; //최상위 노드의 위치
    Node* Nodes; // 노드
    
}ArrayStack;


void AS_CreateStack(ArrayStack** Stack, int Capacity);

void AS_DestroyStack(ArrayStack* Stack);

void AS_Push(ArrayStack* Stack, ElementType Data);

ElementType AS_Pop(ArrayStack* Stack);

ElementType AS_Top(ArrayStack* Stack);

int AS_GetSize(ArrayStack* Stack);

int AS_IsEmpty(ArrayStack* Stack);


#endif /* ArrayStack_h */
