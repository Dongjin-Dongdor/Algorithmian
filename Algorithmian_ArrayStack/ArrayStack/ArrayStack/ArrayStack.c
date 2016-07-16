//
//  main.c
//  ArrayStack
//
//  Created by 김동진 on 2016. 7. 7..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "ArrayStack.h"


/* 스택의 생성과 소멸 */

void AS_CreateStack(ArrayStack** Stack, int Capacity)
{
    //스택을 자유 저장소에 생성
    (*Stack) = (ArrayStack*)malloc(sizeof(ArrayStack));
    
    //입력된 Capacity만큼의 노드를 자유 저장소에 생성
    (*Stack)->Nodes = (Node*)malloc(sizeof(Node)*Capacity);//*Cappacity사이즈 만큼의 공간을 받게됨
    
    // Capacity및 Top초기화
    (*Stack)->Capacity = Capacity;
    
    (*Stack)->Top = 0;//Top은 노드가 쌓일때마다 1씩 증가한다.
}


void AS_DestroyStack(ArrayStack* Stack)
{
    /*노드를 자유저장소에서 해제 */
    free(Stack->Nodes);
    
    /*스택을 자유 저장소에서 해제 */
    free(Stack);
}


/* 삽입(Push) 연산 */
// (*Stack).Data 를 줄여서 Stack->Data로 표시한다.
void AS_Push(ArrayStack* Stack, ElementType Data)
{
    int Position = Stack ->Top;
    Stack->Nodes[Position].Data = Data;
    Stack->Top++;
}

/* 제거 */
/* 탑이 가지고 있는 값은 실제 최상위 노드가 배열 내에서 위치하는 인덱스 값보다 1만큼 더 크다는 것이다.*/
ElementType AS_Pop(ArrayStack* Stack)
{
    int Position = --(Stack ->Top);
    
    return Stack->Nodes[Position].Data;
    
}

