#include<stdio.h>

int my_strlen(char *str){

    int length = 0;
    for(int i = 0; str[i] != '\0'; i++) {
        length++;
    }
    return length;
    
}

int main() {

    char str[100];
    fgets(str , sizeof(str) , stdin);
    int length = my_strlen(str);
    printf("%d\n",length-1);

    return 0;
}