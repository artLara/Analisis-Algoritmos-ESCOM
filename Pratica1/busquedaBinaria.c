#include <stdio.h>

int b(int *arr, int num, int tam);

int b(int *arr, int num, int tam){
    int m=tam/2;
    /*printf("Tamanio arr=%i\n", tam);
    printf("Array:\n");
    for (int i=0; i<tam; i++) {
        printf("%i,", arr[i]);
    }
    printf("\n");*/
    if(tam<0){
        printf("No encontrado!!\n");
        return -1;
    }
    if(num==arr[m]){
        printf("Encontrado!!\n");
        return 1;
    }
    if(num>arr[m]){
        //printf("Buscado en %i--->%i\n", m, arr[m]);
        b(arr+m+1, num, (tam-m-1));
    }
    if(num<arr[m]){
        //printf("Buscado en %i--->%i\n", m, arr[m]);
        b(arr, num, (tam-m-1));
    }
}
int main(void){
    int arr[]= {2,5,8,10,30,48,57,78,80,90,98,100,129};
    b(arr,20000000,13);
}
