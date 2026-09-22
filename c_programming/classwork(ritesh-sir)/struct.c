#include <stdio.h>
int main() {

    struct xyz {
        char a;
        double b;
        char e;
    };

    struct abc {
        struct xyz a;
        int i;
    };

    struct abc2 {
        int a[3];
        char i;
    };
    printf("%ld\n", sizeof(struct xyz));
    printf("%ld\n", sizeof(struct abc));
    printf("%ld\n", sizeof(struct abc2));
}