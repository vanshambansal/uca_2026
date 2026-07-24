#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {

    if (argc != 2) {
        printf("Less then required arguments provided\n");
        exit(-1);
    }

    int fd = open(argv[1], O_RDONLY);
    
    if(fd == -1){
        printf("Cannot open the file\n");
        exit(-1);
    }

    char ch;
    char next;

    int temp = open("temp.c", O_WRONLY | O_CREAT | O_TRUNC, 0664);

    if(temp == -1){
        printf("Cannot create the file\n");
        exit(-1);
    }

    while (read(fd, &ch, 1) > 0) {

        if(ch == '"') {

            write(temp, &ch, 1);

            while (read(fd, &ch, 1) > 0)
            {
                write(temp, &ch, 1);
                if( ch == '\\' ){
                    if(read(fd, &ch, 1) > 0){
                        write(temp, &ch, 1);
                    }
                }
                else if(ch == '"'){
                    break;
                }
            }
            

        }else if (ch == '\'') {
            write(temp, &ch, 1);

            while (read(fd, &ch, 1) > 0)
            {
                write(temp, &ch, 1);
                if( ch == '\\' ){
                    if(read(fd, &ch, 1) > 0){
                        write(temp, &ch, 1);
                    }
                }
                else if(ch == '\''){
                    break;
                }
            }
        }
        else if (ch == '/') {

            if(read(fd, &next, 1) <=0 ){
                write(temp, &ch, 1);
                break;
            }

            if(next == '/') {

                while (read(fd, &ch, 1) > 0 && ch != '\n');
                if(ch == '\n'){
                    write(temp, &ch, 1);
                }

            }else if(next == '*'){
                
                char prev = 0;
                while(read(fd, &ch, 1) > 0 ){
                    if(prev == '*' && ch == '/'){
                        break;
                    }
                    prev = ch;

                }


            }else{
                write(temp, &ch, 1);
                lseek(fd, -1, SEEK_CUR);
                
            }

        }else{
            write(temp, &ch, 1);
        }

        
        
    }
    close(fd);
    close(temp);
    remove(argv[1]);
    rename("temp.c", argv[1]);

    printf("Comments Removed Successfully");

    return 0;

}




// #include <stdio.h>
// #include <unistd.h>
// #include <fcntl.h>

// int main(int argc, char *argv[])
// {
//     if(argc != 2)
//     {
//         printf("Usage: %s filename\n", argv[0]);
//         return 1;
//     }

    

//     int fd = open(argv[1], O_RDONLY);

//     if(fd < 0)
//     {
//         printf("Cannot open file\n");
//         return 1;
//     }

    

//     int temp = open("temp.c",
//                     O_WRONLY | O_CREAT | O_TRUNC,
//                     0644);

//     if(temp < 0)
//     {
//         printf("Cannot create temp file\n");
//         close(fd);
//         return 1;
//     }

//     char ch;
//     char next;

//     while(read(fd, &ch, 1) > 0)
//     {

        

//         if(ch == '"')
//         {
//             write(temp, &ch, 1);

//             while(read(fd, &ch, 1) > 0)
//             {
//                 write(temp, &ch, 1);

//                 if(ch == '\\')
//                 {
//                     if(read(fd, &ch, 1) > 0)
//                         write(temp, &ch, 1);
//                 }
//                 else if(ch == '"')
//                     break;
//             }
//         }

        

//         else if(ch == '\'')
//         {
//             write(temp, &ch, 1);

//             while(read(fd, &ch, 1) > 0)
//             {
//                 write(temp, &ch, 1);

//                 if(ch == '\\')
//                 {
//                     if(read(fd, &ch, 1) > 0)
//                         write(temp, &ch, 1);
//                 }
//                 else if(ch == '\'')
//                     break;
//             }
//         }

        

//         else if(ch == '/')
//         {
//             if(read(fd, &next, 1) <= 0)
//             {
//                 write(temp, &ch, 1);
//                 break;
//             }

            

//             if(next == '/')
//             {
//                 while(read(fd, &ch, 1) > 0 && ch != '\n');

//                 if(ch == '\n')
//                     write(temp, &ch, 1);
//             }

            

//             else if(next == '*')
//             {
//                 char prev = 0;

//                 while(read(fd, &ch, 1) > 0)
//                 {
//                     if(prev == '*' && ch == '/')
//                         break;

//                     prev = ch;
//                 }
//             }

            

//             else
//             {
//                 write(temp, &ch, 1);

//                 lseek(fd, -1, SEEK_CUR);
//             }
//         }

        

//         else
//         {
//             write(temp, &ch, 1);
//         }
//     }

//     close(fd);
//     close(temp);

//     remove(argv[1]);

//     rename("temp.c", argv[1]);

//     printf("Comments removed successfully.\n");

//     return 0;
// }