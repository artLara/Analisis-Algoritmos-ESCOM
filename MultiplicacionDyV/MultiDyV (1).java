import java.util.Scanner;
import java.math.BigInteger;
public  class MultiDyV{
    static String a="";
    static String b="";
    static double n, m;
    static BigInteger big;
    public static void main(String[] args) {
        inicio();
    }

    private static void inicio(){
        Scanner s= new Scanner(System.in);
        boolean seguir=true;
        imp("\tPractica: multiplicaciòn con divide y venceras");
        while(seguir){
            imp("Oprima 10 para base 10 y 2 para base 2");
            if(s.nextInt()==10){
                recuperarNumeros();
                /*recuperarNumerosDigitos();
                generarNumeros();*/
                imp("\tMultiplicacion="+mul(a,b));
            } else{
                recuperarNumeros();
                /*recuperarNumerosDigitos();
                generarNumerosBi();*/
                imp("\tMultiplicacion="+mulBi(a,b));
            }
            imp("Desea seguir multiplicando? Si=1 No=0");
            if(s.nextInt()!=1){
                seguir=false;
                imp("Bye!!");
            }
        }
    }

    private static double mul(String numA, String numB){
        if(numA.length()==1 || numB.length()==1){
            return Double.parseDouble(numA)*Double.parseDouble(numB);
        } else{
            String iA= numA.substring(0,numA.length()/2);
            String dA= numA.substring(numA.length()/2,numA.length());
            String iB= numB.substring(0,numB.length()/2);
            String dB= numB.substring(numB.length()/2,numB.length());
            return Math.pow(10,dA.length())*Math.pow(10,dB.length())*mul(iA,iB)+
                   Math.pow(10,dA.length())*mul(iA,dB)+
                   Math.pow(10,dB.length())*mul(dA,iB)+
                   mul(dA,dB);
        }
    }

    private static double mulBi(String numA, String numB){
        if(numA.length()==1 || numB.length()==1){
            return Double.parseDouble(numA)*Double.parseDouble(numB);
        } else{
            String iA= numA.substring(0,numA.length()/2);
            String dA= numA.substring(numA.length()/2,numA.length());
            String iB= numB.substring(0,numB.length()/2);
            String dB= numB.substring(numB.length()/2,numB.length());
            return sumBi((int)(Math.pow(10,dA.length())*Math.pow(10,dB.length())*mulBi(iA,iB)) + "",
                   (int)(Math.pow(10,dA.length())*mulBi(iA,dB)) + "",
                   (int)(Math.pow(10,dB.length())*mulBi(dA,iB)) + "",
                   (int)(mulBi(dA,dB)) + "");
        }
    }

    private static double sumBi(String b1, String b2, String b3, String b4){

        try{
            String r=Integer.toString(Integer.parseInt(b1,2)+Integer.parseInt(b2,2)+Integer.parseInt(b3,2)+Integer.parseInt(b4,2),2);
            return Double.parseDouble(r);
        } catch (Exception e) {
            imp("Perdon es muy grande =(");
        }
        return 0.0;
    }

    private static void recuperarNumeros(){
        imp("Introduce el numero a:");
        Scanner s = new Scanner(System.in);
        a=s.nextLine();
        imp("Introduce el numero b:");
        b=s.nextLine();
    }

    private static void recuperarNumerosDigitos(){
        imp("Introduce el numero  de digitos del primer numero:");
        Scanner s = new Scanner(System.in);
        a=s.nextLine();
        imp("Introduce el numero de digitos del rpimer numero:");
        b=s.nextLine();
    }

    private static void generarNumeros(){
        int auxA=Integer.parseInt(a), auxB= Integer.parseInt(b);
        int numero;
        a="";
        b="";
        for(int i=0;i<auxA;i++){
            numero = (int) (Math.random() * 9) + 1;
            a+=numero;
        }
        for(int i=0;i<auxB;i++){
            numero = (int) (Math.random() * 9) + 1;
            b+=numero;
        }
        imp("Numero generado 1: "+ a);
        imp("Numero generadi 2: " + b);
    }

    private static void generarNumerosBi(){
        int auxA=Integer.parseInt(a), auxB= Integer.parseInt(b);
        int numero;
        a="";
        b="";
        for(int i=0;i<auxA;i++){
            numero = (int) (Math.random() * 2) ;
            a+=numero;
        }
        for(int i=0;i<auxB;i++){
            numero = (int) (Math.random() * 2) ;
            b+=numero;
        }
        imp("Numero generado 1: "+ a);
        imp("Numero generadi 2: " + b);
    }

    private static void imp(String m){
        System.out.println(m);
    }
}
