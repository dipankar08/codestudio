#include<iostream>
using namespace std;

int fact(int n){
    int result = 1;
    for(int i =1;i<n ;i++){
        result = i * result;
    }
    return result;
}

int main(){
    cout<<fact(10);   
}
/********* Test watch point *******
* clang++ -g fact.cpp -o fact
* lldb ./fact

* Breakpoint <tab>
* help breakpoint set
* breakpoint set -n main
* breakpoint list
* r
* b 7
* help n
* breakpoint modify -c "i ==7" 2
* breakpoint list
* breakpoint modify -c "" 2
* breakpoint command add 2

* watchpoint set variable result
* watchpoint list
* watchpoint modify -c "result == 6" 1
* watchpoint list
*
*
*

* threadb	
* thread backtrace
* thread backtrace all
* thread list
* thread select 1
* thread return 500
*
* frame variable 
* bt
* frame select 2
* frame variable n
* frame variable -f x n

* help expression
* expr i =10
* expr fact(10)

*
*
* target stop-hook add -o "fr v i"
* target stop-hook add
* target variable myglobal
*
*
*
************************************/