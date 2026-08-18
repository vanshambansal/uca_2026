// Implement Base-64 Encoding
// Problem Statement
// Write a program or function that accepts an ASCII string input and returns its Base64 encoded equivalent without using built-in Base64 encoding libraries.

// Background Context
// Base64 is a binary-to-text encoding scheme that represents binary data in an ASCII string format. It works by taking groups of 3 bytes (24 bits) and splitting them into 4 groups of 6 bits. Each 6-bit group corresponds to an index (0 to 63) in the Base64 Index Table:

// Index Range	Characters
// 0–25	A–Z
// 26–51	a–z
// 52–61	0–9
// 62	+
// 63	/
// Encoding Algorithm Rules
// Convert to Binary: Convert each character of the input string into its 8-bit ASCII binary representation.
// Group into 6 Bits: Concatenate all bits into one long sequence and divide them into chunks of 6 bits.
// Handle Padding (Crucial):
// If the last group has fewer than 6 bits, pad it on the right with zeros to make it 6 bits.
// Total bytes input determines padding equal signs (=) at the end of the output string:
// If input length is a multiple of 3 -> No padding (=)
// If input length leaves a remainder of 2 bytes -> 1 padding character (=)
// If input length leaves a remainder of 1 byte -> 2 padding characters (==)
// Map to Character Set: Convert each 6-bit chunk to its decimal value, then replace it with the corresponding character from the Base64 Index Table.
    


#include <stdio.h>
#include <string.h>

char table[] = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

void encode(char *str) {

    int n = strlen(str);

    for (int i = 0; i < n; i+=3) {

        int a = str[i];
        int b = i + 1 >= n ? 0 : str[i + 1];
        int c = i + 2 >= n ? 0 : str[i + 2];

        int w = a >> 2;
        int x = ((a & 3) << 4) | (b >> 4);
        int y = ((b & 15) << 2) | (c >> 6);
        int z = c & 63;

        printf("%c%c", table[w], table[x]);

        if (i + 1 >= n) {
            printf("==");

        } else if (i + 2 >= n) {
            printf("%c=", table[y]);
            
        } else {
            printf("%c%c", table[y], table[z]);
        }

    }

}

int main() {

    char str[100];
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = '\0';

    encode(str);
    printf("\n");

    return 0;
}