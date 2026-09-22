#include<stdio.h>
#include<unistd.h>
#include<signal.h>

static void sigHandler(int sig){

    if (sig == SIGINT)
        printf("hello fron SIGIN\n");
    else if (sig == SIGQUIT)
        printf("hello from SIGQUIT\n");
}

int main() {

    signal(SIGINT, sigHandler);
    signal(SIGQUIT, sigHandler);

    for(int i = 0; i < 3; i++){    
        printf("Hello World\n");
        sleep(10);
    }
    return 0;
}