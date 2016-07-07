//
//  main.c
//  Algorithmian_DoubleLinkedList
//
//  Created by 김동진 on 2016. 7. 6..
//  Copyright © 2016년 김동진. All rights reserved.
//


//더블링크드리스트는 기본 링크드리스트의 탐색 기능을 개선한 자료구조이다.
//가령 기본 링크드리스트는 꼬리방향으로만 탐색을 할 수 있었다. 하지만 이 더블 링크드리스트는 머리 방향으로도 탐색이 가능하다.

#include "DoubleLinkedList.h"

int main(void)
{
    int i = 0;
    int Count = 0;
    Node* List = NULL;
    Node* NewNode = NULL;
    Node* Current = NULL;
    
    
    
    /*노드 5개 추가 */
    for(i=0;i<5;i++)
    {
        NewNode = DLL_CreateNode(i);
        DLL_AppendNode(&List,NewNode);
    }
    
    /*리스트 출력 */
    Count = DLL_GetNodeCount(List);
    for(i=0; i<Count; i++)
    {
        Current = DLL_GetNodeAt(List,i);
        printf("List[%d]:%d\n",i,Current->Data);
    }
    
    /* 리스트의 세 번째 칸 뒤에 노드 삽입*/
    printf("\nInserting 3000 After [2]....\n\n");
    
    Current = DLL_GetNodeAt(List,2);
    NewNode = DLL_CreateNode(3000);
    DLL_InsertAfter(Current, NewNode);
    
    /*리스트 출력*/
    Count = DLL_GetNodeCount(List);
    for(i = 0; i<Count; i++)
    {
        Current = DLL_GetNodeAt(List, i);
        printf("List[%d]:%d \n",i,Current->Data);
    }
    
    /* 모든 노드를 메모리에서 제거 */
    printf("\nDestroying List....\n");
    
    Count = DLL_GetNodeCount(List);
    
    for(i = 0;i<Count;i++)
    {
        Current = DLL_GetNodeAt(List, 0);
        
        if(Current != NULL)
        {
            DLL_RemoveNode(&List,Current);
            DLL_DestroyNode(Current);
        }
    }
    
    
    
    return 0;
}
