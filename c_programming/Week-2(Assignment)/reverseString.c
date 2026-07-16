#include<stdio.h>
#include<string.h>

void reverse_string(char *str) {

    int len = strlen(str);
    if(str[len-1] == '\n')
    {
        str[len-1] = '\0';
        len--;
    }

    for(int i=0;i<len/2;i++){
        char temp = str[i];
        str[i] = str[len-i-1];
        str[len-i-1] = temp;
    }
    printf("%s", str);

}


int main(){

    char str[100];
    fgets(str, sizeof(str), stdin);

    reverse_string(str);

    return 0;
}