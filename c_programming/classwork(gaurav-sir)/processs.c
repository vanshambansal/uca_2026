#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {

    pid_t pid = fork();

    if (pid  == 0) {
        // child process
        printf("Child process: PID = %d, PPID = %d\n", getpid(), getppid());
    } else if (pid > 0) {
        // parent process
        printf("Parent process: PID = %d, Child PID = %d\n", getpid(), pid);
        printf("parent of parent process: PID = %d\n", getppid());
        sleep(3);
    } else {
        printf("Fork failed!\n");
    }

    return 0;

}