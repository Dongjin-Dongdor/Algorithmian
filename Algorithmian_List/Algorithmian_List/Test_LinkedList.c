//
//  main.c
//  Algorithmian_List
//
//  Created by 김동진 on 2016. 7. 5..
//  Copyright © 2016년 김동진. All rights reserved.
//

#include "LinkedList.h"

int main() {
    
    int i = 0;
    int Count = 0;
    
    Node* List = NULL;
    Node* Current = NULL;
    Node* NewNode = NULL;
    
    /* 노드 5개 추가 */
    for(int i =0; i<5; i++)
    {
        NewNode = SLL_CreateNode(i);
        SLL_AppendNode(&List, NewNode);
        
    }
    
    NewNode = SLL_CreateNode(-1);
    SLL_InsertNewHead(&List, NewNode);
    
    NewNode = SLL_CreateNode(-2);
    SLL_InsertNewHead(&List, NewNode);
    
    /* 리스트 출력 */
    Count = SLL_GetNodeCount(List);
    for(i = 0; i<Count; i++)
    {
        Current = SLL_GetNodeAt(List,i);
        printf("List[%d] : %d\n",i, Current->Data);
        
    }
    
    /* 모든 노드를 메모리에서 제거 */
    printf("\nDestroying List...\n");
    
    for(i = 0; i<Count; i++)
    {
        Current = SLL_GetNodeAt(List, 0);
        
        if(Current != NULL)
        {
            SLL_RemoveNode(&List, Current);
            SLL_DestroyNode(Current);
        }
    }
    
    return 0;
    
}

