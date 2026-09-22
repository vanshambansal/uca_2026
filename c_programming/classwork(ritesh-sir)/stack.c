#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 100


typedef struct Stack {
    int top;
    int items[MAX_SIZE];
} Stack;


void intitilaize(Stack *s) {
    s->top = -1;
}

int isempty(Stack *s) {
    return s->top == -1;
}

int size(Stack *s) {
    return s->top + 1;
}

void push(Stack *s, int item) {
    if (s->top == MAX_SIZE - 1) {
        printf("Stack Overflow\n");
        return;
    }
    s->items[++s->top] = item;
}

int pop(Stack *s) {
    if (isempty(s)) {
        printf("Stack Underflow\n");
        return -1;
    }
    return s->items[s->top--];
}

int main() {
    Stack stack;
    intitilaize(&stack);
    printf("Is stack empty? %d\n", isempty(&stack));
    printf("Size of stack? %d\n", size(&stack));

    push(&stack, 10);
    push(&stack, 20); 
    push(&stack, 30);
    push(&stack, 40);

    printf("element popped: %d\n", pop(&stack));
    printf("element popped: %d\n", pop(&stack));
    printf("element popped: %d\n", pop(&stack));
    printf("element popped: %d\n", pop(&stack));

    printf("Size of stack? %d\n", size(&stack));
    printf("Is stack empty? %d\n", isempty(&stack));
}