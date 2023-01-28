#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <math.h>
int n;
int b3(int *arr, int num, int tam);
int b3(int *arr, int num, int tam){
    int a=tam/4;
    int b=(tam*2)/4;
    int c=(tam*3)/4;
    printf("Tamanio arr=%i\n", tam);
    printf("a=%i\n",a);
    printf("b=%i\n",b);
    printf("c=%i\n",c);
    printf("Array:\n");
    for (int i=0; i<tam; i++) {
        printf("%i,", arr[i]);
    }
    printf("\n");
    if(tam<0){
        printf("No encontrado!!\n");
        return 1;
    }
    if(num==arr[a]){
        printf("Encontrado!!\n");
        printf("ArrFFFFFFFF=%i\n", (uintptr_t)&arr[a]);
        //return (intptr_t)arr;
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[a])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num==arr[b]){
        printf("Encontrado!!\n");
        printf("ArrFFFFFFFF=%i\n", (uintptr_t)&arr[b]);
        //return (intptr_t)arr;
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[b])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num==arr[c]){
        printf("Encontrado!!\n");
        printf("ArrFFFFFFFF=%i\n", (uintptr_t)&arr[c]);
        //return (intptr_t)arr;
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[c])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num>arr[a] && num<arr[b]){
        printf("Buscado en A%i--->%i\n", a, arr[a]);
        printf("Buscado en B%i--->%i\n", b, arr[b]);
        b3(arr+a+1, num, a-1);
    }
    if(num>arr[b] && num<arr[c]){
        printf("Buscado en B%i--->%i\n", b, arr[b]);
        printf("Buscado en C%i--->%i\n", c, arr[c]);
        b3(arr+b+1, num, a-1);
    }
    if(num>arr[c]){
        printf("Buscado en %i--->%i\n", c, arr[c]);
        b3(arr+c+1, num, (tam-c-1));
    }
    if(num<arr[a]){
        printf("Buscado en %i--->%i\n", a, arr[a]);
        b3(arr, num, (tam-c-1));
    }
}
int main(void){
    int arr[]= {2,5,8,10,30,48,57,78,80,90,98,100,800};
    n=(uintptr_t)&arr;
    int aux = b3(arr,100,13);
}
