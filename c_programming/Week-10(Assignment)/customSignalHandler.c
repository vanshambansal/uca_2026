// Custom Signal Handler
// Write a C program that runs an infinite loop. Customize the program so that when the user presses Ctrl+C (SIGINT), it catches the signal, prints a custom message, and keeps running. To exit the program, the user must press Ctrl+C a total of 3 times.


#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

volatile sig_atomic_t signal_count = 0;

// TODO: Write your signal handler function here
void handle_sigint(int sig) {

    signal_count++;
    printf("\nSignal is caught %d times.\n",signal_count);
    
    if (signal_count == 3) {
        printf("you pressed 3 times now its time to exit\n");
        printf("Exiting in 1 second...\n");
        sleep(1);
        exit(0);
    }
}

int main() {

    signal(SIGINT, handle_sigint);

    printf("Program running (PID: %d). Try pressing Ctrl+C...\n", getpid());

    while (1) {
        sleep(1);
    }

    return 0;
}
