#include <stdio.h>

void url_encode(char *str, int true_length)
{

    int space_count = 0;
    for (int i = 0; i < true_length; i++)
    {

        if (str[i] == ' ')
        {
            space_count++;
        }
    }

    int i = true_length - 1;
    int j = true_length + (2 * space_count) - 1;
    str[j + 1] = '\0';

    while (i >= 0)
    {
        if (str[i] == ' ')
        {

            str[j] = '0';
            str[j - 1] = '2';
            str[j - 2] = '%';
            j -= 3;
        }
        else
        {

            str[j] = str[i];
            j--;
        }
        i--;
    }

    printf("The modified string is: %s\n", str);
}

int main()
{

    char str[100];
    fgets(str, sizeof(str), stdin);
    int true_length;
    scanf("%d", &true_length);

    url_encode(str, true_length);

    return 0;
}