#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 100


typedef struct {
    int front;
    int rear;
    int items[MAX_SIZE];
    int size;
} Queue;



void intitilaize(Queue *q) {
    q->size = 0;
    q->front = 0;
    q->rear = -1;
}


int isempty(Queue *q) {
    return q->size == 0;
}

int size(Queue *s) {
    return q->size;
}

void push(Queue *q, int item) {

    if (size(q) == MAX_SIZE - 1) {
        printf("Queue Overflow\n");
        return;
    }
    q->items[++q->rear] = item;
    q->size++;
}

int pop(Queue *q) {
    if (isempty(q)) {
        printf("Queue Underflow\n");
        return -1;
    }
    return q->items[q->front++];
}

int main() {
    Queue queue;
    intitilaize(&queue);
    printf("Is queue empty? %d\n", isempty(&queue));
    printf("Size of queue? %d\n", size(&queue));

    push(&queue, 10);
    push(&queue, 20); 
    push(&queue, 30);
    push(&queue, 40);

    printf("element popped: %d\n", pop(&queue));
    printf("element popped: %d\n", pop(&queue));
    printf("element popped: %d\n", pop(&queue));
    printf("element popped: %d\n", pop(&queue));

    printf("Size of queue? %d\n", size(&queue));
    printf("Is queue empty? %d\n", isempty(&queue));       
}