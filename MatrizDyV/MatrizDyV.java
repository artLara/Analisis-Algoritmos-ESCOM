import java.util.*;
public class MatrizDyV{
    private static int[][] a,b;
    public static void main(String[] args) {
        inicio();
    }

    private static void inicio(){
        Scanner s= new Scanner(System.in);
        int f,c;
        boolean seguir=true;
        imp("\tPractica: multiplicacion de matrices con divide y venceras");
        while(seguir){
            imp("Digite el numero de filas de la matriz A");
            f=s.nextInt();
            imp("Digite el numero de columnas de la matriz A y el numero de filas de B");
            c=s.nextInt();
            a = new int[f][c];
            imp("Digite el numero de columnas de la matriz B");
            f=s.nextInt();
            b = new int[c][f];
            generarMatrices();
            imp("Matriz A generada:");
            impMatriz(a);
            imp("Matriz B generada:");
            impMatriz(b);
            imp("Resultado:");
            impMatriz(mul(a,b));
            imp("Desea seguir multiplicando? Si=1 No=0");
            if(s.nextInt()!=1){
                seguir=false;
                imp("Bye!!");
            }
        }
    }
    private static void generarMatrices(){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]= (int) (Math.random() * 9) + 1;
            }
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                b[i][j]= (int) (Math.random() * 9) + 1;
            }
        }
    }

    private static void impMatriz(int[][] s){
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s[i].length;j++){
                System.out.print("\t"+s[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] mul(int[][] x, int[][] y){
        if(x.length == 1 || y[0].length==1){
            return mulM(x,y);
        }
        else{
            int[][] c;
            int[][] d;
            int[][] e;
            int[][] f;
            //partir matriz
            //Si el tamaño es impar se resta uno
            if(x.length%2 == 0){
                c =  partirMatriz(x, x.length/2, x[0].length, 0);
                d=  partirMatriz(x, x.length - x.length/2, x[0].length, x.length-x.length/2);
            } else{
                c=  partirMatriz(x, x.length/2, x[0].length, 0);
                d=  partirMatriz(x, x.length - x.length/2, x[0].length, x.length-x.length/2-1);
            }

            if(y[0].length%2 == 0){
                e=  partirMatriz2(y, y.length, y[0].length/2, 0);
                f=  partirMatriz2(y, y.length, y[0].length - y[0].length/2, y[0].length-y[0].length/2);
            } else{
                e=  partirMatriz2(y, y.length, y[0].length/2, 0);
                f=  partirMatriz2(y, y.length, y[0].length - y[0].length/2, y[0].length-y[0].length/2-1);
            }

            /*imp("Matriz C:");
            impMatriz(c);
            imp("Matriz D:");
            impMatriz(d);
            imp("Matriz E:");
            impMatriz(e);
            imp("Matriz F:");
            impMatriz(f);*/

            return combinar(mul(c,e), mul(c,f), mul(d,e), mul(d,f));
        }
    }

    private static int[][] mulM(int[][] x, int[][] y){
        int[][] c = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    c[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        /*imp("Matrice X a multiplicar:");
        impMatriz(x);
        imp("Matrice Y a multiplicar:");
        impMatriz(y);
        imp("Resultado de multiplicar:");
        impMatriz(c);*/
        return c;
    }

    private static int[][] partirMatriz(int[][] x, int filas, int columnas, int p){
        //imp("filas="+filas);
        //imp("columnas="+columnas);
        int[][] c = new int[filas][columnas];
        for(int i=0;i<filas;i++,p++){
            //imp("i="+i);
            //imp("p="+p);
            for(int j=0;j<columnas;j++){
                c[i][j]= x[p][j];
            }
        }
        return c;
    }

    private static int[][] partirMatriz2(int[][] y, int filas, int columnas, int p){
        //imp("filas="+filas);
        //imp("columnas="+columnas);
        int aux=p;
        int[][] c = new int[filas][columnas];
        for(int i=0;i<filas;i++){
            //imp("i="+i);
            //imp("p="+p);
            for(int j=0;j<columnas;j++,aux++){
                c[i][j]= y[i][aux];
            }
            aux=p;
        }
        return c;
    }

    private static int[][] combinar(int[][] x, int[][] y, int[][] z, int[][] w){
        //imp("Filas="+(x.length + z.length));
        int[][] c= new int[x.length + z.length][z[0].length + w[0].length];
        int cY=0, fZ=0, cW=0;
        for(int i=0; i<c.length; i++){
            cY=0;
            cW=0;
            for (int j=0; j< c[0].length; j++) {
                if(j<x[0].length && i<x.length){
                    c[i][j]=x[i][j];
                } else if(j>=x[0].length && i<y.length){
                    c[i][j]=y[i][cY];
                    cY++;
                } else if(j<z[0].length && i>=x.length){
                    c[i][j]=z[fZ][j];
                } else{
                    c[i][j]=w[fZ][cW];
                    cW++;
                }
            }
            if(i>=x.length){
                fZ++;
            }
        }
        /*imp("Matrice X a cobinar:");
        impMatriz(x);
        imp("Matrice Y a cobinar:");
        impMatriz(y);
        imp("Matrice Z a cobinar:");
        impMatriz(z);
        imp("Matrice W a cobinar:");
        impMatriz(w);
        imp("Matrice final cobinada:");
        impMatriz(c);*/
        return c;
    }
    private static void imp(String m){
        System.out.println(m);
    }
}
