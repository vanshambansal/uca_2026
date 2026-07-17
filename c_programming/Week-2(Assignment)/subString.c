#include<stdio.h>

int my_strlen(const char *str){

    int length = 0;
    for(int i = 0; str[i] != '\0' && str[i] != '\n'; i++) {
        length++;
    }
    return length;
    
}

int find_substring(const char *haystack, const char *needle) {

    int len1 = my_strlen(haystack);
    int len2 = my_strlen(needle);

    for(int i=0; i<= len1-len2; i++){
        int flag = 1;
        for(int j=0; j<len2; j++){
            if(haystack[i+j] != needle[j]){
                flag = 0;
                break;
            }
        }
        if(flag){
            return i;
        }

    }
    return -1;

}

int main() {

    char haystack[100];
    char needle[100];
    fgets(haystack, sizeof(haystack), stdin);
    fgets(needle, sizeof(needle), stdin);

    int index = find_substring(haystack, needle);

    printf("%d", index);

    return 0;
}