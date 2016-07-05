//
//  main.c
//  Algorithm
//
//  Created by 김동진 on 2016. 7. 4..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "LinkedList.h"

/*노드 생성*/

Node* SLL_CreateNode(ElementType NewData)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;//다음 데이터 저장
    NewNode->NextNode = NULL; //다음 노드에 대한 포인터는 NULL로 초기화
    
    return NewNode; //노드의 주소를 반환
}

/*노드 소멸*/


