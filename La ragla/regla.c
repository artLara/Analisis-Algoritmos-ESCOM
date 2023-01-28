#include <stdio.h>
#include <stdlib.h>

char **arr;
int tamanio;
void regla(int h, int t);
void dibujar(int h, int posicion);
void imprimir(){
    for (int i = 0; i < tamanio/2; i++) {
        for(int j=0; j<tamanio; j++){
            printf("%c  ", arr[i][j]);
        }
        printf("\n");
    }
    for(int i=0;i<tamanio;i++){
        if(i>9){
            printf("%i ", i);
        }
        else{
            printf("%i  ", i);
        }
    }
}
void dibujar(int h, int posicion){
    for(int j=0; j<h; j++){
        arr[tamanio/2-j-1][posicion]='|';
    }
}
void regla(int h, int t){
    //printf("h=%i\n",h);
    //printf("Posicion de h=%i\n",t/2);
    if(h>0 && t>0){
        t/=2;
        dibujar(h,t);
        //printf("t=%i\n",t);
        //imprimir();
        regla(h-1,t);
        regla(h-1,(t+(tamanio-t)/2)*2);
    }
}
int main(void){

    int num, opc;
    do {
        printf("\tIntroduce un tamanio para la regla(t)\n");
        scanf("%i", &num);
        tamanio=num;
        arr=calloc(num/2, sizeof(int *));
        for(int i = 0; i < num/2; i++) {
           arr[i] = calloc(num, sizeof(int));
        }
        for (int i = 0; i < tamanio/2; i++) {
            for(int j=0; j<tamanio; j++){
                arr[i][j]=' ';
            }
        }
        regla(num/2,num);
        imprimir();

        printf("\n\tQuiere hacer otra regla? Si=1  No=0\n");
        scanf("%i", &opc);
    } while(opc==1);
}
