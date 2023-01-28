#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <time.h>
int n;
int b4(int *arr, int num, int tam);
void generarArreglo(int tamanio,int* numero);
void generarArreglo(int tamanio,int* numero){
    srand(time(NULL));
    int num1, num2, aux;
    for (int i = 0; i < tamanio; i++) {
        numero[i] = rand() % 900 + 1;
    }
    for(int i=1;i<tamanio;i++){
        for(int j=0;j<tamanio-1;j++){
            if(numero[j]>numero[j+1]){
                aux=numero[j];
                numero[j]=numero[j+1];
                numero[j+1]=aux;
            }
        }
    }
    printf("Array generado:\n{");
    for (int i = 0; i < tamanio; i++) {
        if(i==tamanio-1){
            printf("%i", numero[i]);
        } else{
            printf("%i,", numero[i]);
        }
    }
    printf("}\n\n");
}
int b4(int *arr, int num, int tam){
    int a=tam/4;
    int b=(tam*2)/4;
    int c=(tam*3)/4;
    if(tam<0){
        printf("No encontrado!!\n");
        return 1;
    }
    if(num==arr[a]){
        printf("Encontrado!!\n");
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[a])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num==arr[b]){
        printf("Encontrado!!\n");
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[b])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num==arr[c]){
        printf("Encontrado!!\n");
        printf("\nPosicion-->%d\n",(abs(abs((uintptr_t)&arr[c])-abs((uintptr_t)n)))/(sizeof(int)));
        return 10;
    }
    if(num>arr[a] && num<arr[b]){
        b4(arr+a+1, num, a-1);
    }
    if(num>arr[b] && num<arr[c]){
        b4(arr+b+1, num, a-1);
    }
    if(num>arr[c]){
        b4(arr+c+1, num, (tam-c-1));
    }
    if(num<arr[a]){
        b4(arr, num, (tam-c-1));
    }
}
int main(void){
    int tamanio, num, opc;
    printf("\tIntroduce un tamaño para el arreglo\n");
    scanf("%i", &tamanio);
    int arr[tamanio];
    generarArreglo(tamanio,arr);
    n=(uintptr_t)&arr;
    do {
        printf("\tIntroduce el numero a buscar\n");
        scanf("%i", &num);
        b4(arr,num,tamanio);
        printf("\tQuiere buscar otro numero? Si=1  No=0\n");
        scanf("%i", &opc);
    } while(opc==1);
}
