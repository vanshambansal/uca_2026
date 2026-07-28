#include <stdio.h>
#include <sys/stat.h>
#include <time.h>

int main(int argc, char* argv[]){
    
    if (argc != 2) {

        printf("less than required arguments provided\n");
        return 1;
    }

    struct stat file;
    
    int result = stat(argv[1], &file);

    if(result == -1){

        printf("Cannot access the file\n");
        return 1;
    }

    printf("File attributes for %s \n", argv[1]);

    if (S_ISREG(file.st_mode)) {
        printf("File Type:              Regular File\n");

    }
    else if (S_ISDIR(file.st_mode)) {
        printf("File Type:      Directory\n");

    }
    else {
        printf("File Type:      Other\n");

    }

    printf("Permissions:            %04o\n", file.st_mode & 0777);
    printf("File Size:              %ld bytes\n", file.st_size);
    printf("Hard Links Count:       %ld\n", file.st_nlink);
    printf("Owner (UID):            %d\n", file.st_uid);
    printf("Group (GID):            %d\n", file.st_gid);
    printf("Last Access Time:       %s\n", ctime(&file.st_atime));
    printf("Last Modification:      %s\n", ctime(&file.st_mtime));
    printf("Status Change Time:     %s\n", ctime(&file.st_ctime));




    return 0;
}