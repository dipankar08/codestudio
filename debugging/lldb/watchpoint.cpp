#include<iostream>
using namespace std;

void fact(int n, int *res){
    int result = 1;
    for(int i =1;i<n ;i++){
        result = i* result;
    }
    *res = result;
}

int main(){
    int result =0;
    fact(10,&result);
    cout<<result;
    result =0;    
}
/********* Test watch point *******
* clang++-3.8 -g watchpoint.cpp 
*
*
*
************************************/