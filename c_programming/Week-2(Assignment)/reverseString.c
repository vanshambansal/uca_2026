#include<stdio.h>
#include<string.h>

int main(){

    char str[100];
    fgets(str, sizeof(str), stdin);

    int len = strlen(str);
    printf("%d", len);


    return 0;
}