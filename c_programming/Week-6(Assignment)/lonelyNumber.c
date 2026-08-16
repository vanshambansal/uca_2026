#include <stdio.h>

int main () {

    int arr[] = {1, 2, 3, 4, 1, 2, 4, 1, 2, 4, 4, 3, 3};
    int n = 13;
    int ans = 0;

    for(int i = 31; i >= 0; i--) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if((arr[j] >> i) & 1){
                count++;
            }
        }
        ans = ans << 1;
        if(count % 3 != 0){
            ans |= 1;
        }
    }

    printf("%d\n",ans);

    return 0;
}