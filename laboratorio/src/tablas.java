
import java.util.Scanner;

public class tablas{
    static int b;
    static  double[] distancia;
    static double[] suma, promedio;
    static double[] velocidad; 
    static double[] aceleracion;
    static double []desviacion;
    static double[][] tiempos;
    static double[] acceGravedad;
    static double[] porcen;
        public static void main(String args[]) {
        
            menu();
        }
        
        private static void menu() {
            @SuppressWarnings("resource")
            Scanner Scanner= new Scanner(System.in);
            
            int op;
            
            System.out.println("Tablas De Laboratorios\n\n");
            System.out.print("Que tabla desea hacer?\n1.MRU\n2.MRUA\n3.Caida libre\n: ");
            op= Scanner.nextInt();
            
            System.out.println("\n\n");
            
            switch(op) {

                case 1:
                     MRU();
                    break;
                case 2:
                    MRUA();
                    break;
                case 3: 
                    caidaLibre();
                    break;
                default:
                    break;
                }
        }
        
        
        //Metodo de la tabla del MRUA
        private static void MRUA() {
            
            llenarTiempos();

            //average
            calculoPromedio();
            
            // resting the time with average and square all
            calculoDesviacion();
            
            //speed and accelerate
            calculoVelocidad();
            
            System.out.println("\n\n\nTabla Completa\n\n");
            
            System.out.println("intervalos  tiempo1  tiempo2  tiempo3  tiempo4 tiempo5  "
                              + "promedio   desviacion   velocidad   aceleracion ");
            for(int i=0;i<b;i++){
                System.out.print(distancia[i]+"\t     ");
                for(int j=0;j<5;j++){
                    System.out.print(tiempos[i][j]+"     ");
                }
                
                System.out.print(String.format("%.2f",promedio[i]));
                
                if(desviacion[i]*100>6) 
                    System.out.print("        "+"\033[31m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else if(desviacion[i]*100>2)
                    System.out.print("        "+"\033[33m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else
                    System.out.print("        "+"\033[32m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                            
                System.out.print("        "+String.format("%.2f", velocidad[i])
                    +"       "+String.format("%.2f", aceleracion[i])+"\n\n");
            }

            resultDesviacion();
            
           
    }
        
        //Metodo de la tabla del MRU
    private static void MRU() {

         llenarTiempos();
            //promedio
            calculoPromedio();

            //desviacion
            calculoDesviacion();
            
            //speed
            calculoVelocidad();
            
            
            System.out.println("\n\n\nTabla Completa\n\n");
            
            System.out.println("intervalos  tiempo1  tiempo2  tiempo3  tiempo4 tiempo5  "
                              + "promedio   desviacion   velocidad");
            
            for(int i=0;i<b;i++){
                System.out.print(distancia[i]+"\t     ");                                            
                for(int j=0;j<5;j++){
                    System.out.print(tiempos[i][j]+"     ");
                }
                
                System.out.print(String.format("%.2f",promedio[i]));
                
                if(desviacion[i]*100>6) 
                    System.out.print("        "+"\033[31m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else if(desviacion[i]*100>2)	
                    System.out.print("        "+"\033[33m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else
                    System.out.print("        "+"\033[32m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                            
                System.out.print("        "+String.format("%.2f", velocidad[i])+"\n\n");
            }

            resultDesviacion();
        
    }
        
        //tabla de la caida libre
    private static void caidaLibre() {
            
        llenarTiempos();

        acceGravedad = new double[b];
        porcen = new double[b];
       
            
        
            //promedio
            calculoPromedio();
           
            //desviacion
            calculoDesviacion();

            //speed and gravity accelerate  
            calculoVelocidad();
            
            //porcentaje de cuan cerca esta de la gravedad
            for(int i=0;i<b;i++) {
                porcen[i]= acceGravedad[i]*100/9.78;
                
                if(porcen[i]>100) {
                    @SuppressWarnings("unused")
                    double rest=porcen[i]-100;
                    porcen[i]-=porcen[i];
                }
            }

            //se muestra la tabla
            
            System.out.println("\n\n\nTabla Completa\n\n");
            
            System.out.println("intervalos  tiempo1  tiempo2  tiempo3  tiempo4 tiempo5  "
                              + "promedio   desviacion   velocidad   gravedad   acce.gravedad");
            
            for(int i=0;i<b;i++){
                System.out.print(distancia[i]+"\t     ");                                            
                for(int j=0;j<5;j++){
                    System.out.print(tiempos[i][j]+"     ");
                }
                
                System.out.print(String.format("%.2f",promedio[i]));
                
                //color de la desviacion
                if(desviacion[i]*100>6) 
                    System.out.print("        "+"\033[31m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else if(desviacion[i]*100>2)	
                    System.out.print("        "+"\033[33m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                
                else
                    System.out.print("        "+"\033[32m"+String.format("%.2f",desviacion[i]*100)+"\033[0m");
                            
                System.out.print("        "+String.format("%.2f", velocidad[i])
                +"      9.78"+"        ");
                
                //color de la acceleracion de la gravedad
                if(porcen[i]>80)
                    System.out.print("\033[32m"+String.format("%.2f", acceGravedad[i])+ "\033[0m");
                else if(porcen[i]>60)
                    System.out.print("\033[33m"+String.format("%.2f", acceGravedad[i])+ "\033[0m");
                else
                    System.out.print("\033[31m"+String.format("%.2f", acceGravedad[i])+ "\033[0m");
                
                System.out.print("\n\n");
            }

            resultDesviacion();
            
    }

    static void llenarTiempos(){
            //con los intervalos me refiero a en cuanto dividieron la distancia
            
            @SuppressWarnings("resource")
            Scanner Scanner= new Scanner(System.in);

            System.out.print("cuantos intervalos de tiempo?: ");
            b=Scanner.nextInt();

            distancia=new double[5];
            suma=new double[b]; 
            promedio=new double[b];
            velocidad=new double[b]; 
            aceleracion=new double[b];
            desviacion=new double[b];
            tiempos=new double[b][5];

            //fill out the distance and the time
            
            System.out.println("digite la distancia y luego los tiempos de seguido por intervalo");
            for(int i=0;i<b;i++){
                System.out.println("intervalo: "+(i+1));
                System.out.print("\ndistancia: ");
                distancia[i]=Scanner.nextDouble();
                
                System.out.print("\ntiempos: ");
                for(int j=0;j<5;j++){
                        tiempos[i][j]=Scanner.nextDouble();
                }
            }
            
    }


    static void resultDesviacion(){
    int cont=0;
    System.out.println("\n");
    System.out.println("intervalo  desviacion  resultado");
    for(int i=0;i<b;i++) {
        System.out.print(distancia[i]+"        "+String.format("%.2f",desviacion[i]*100)+"       ");
        if(desviacion[i]*100>6) {
            System.out.println("\033[31m AlTA \033[0m");
            cont++;
        }
        else
            System.out.println("\033[32m Buena \033[0m");
    }
    if(cont>0)
    System.out.println("\nHay "+cont+" Desviaciones altas. Se debe Repetir esos tiempos");
    }
    static void calculoDesviacion(){
         //se resta a los tiempos el promedio y se eleva al cuadrado
         double pot;
         for(int i=0;i<b;i++){
             suma[i]=0;
             for(int j=0;j<5;j++){
                 pot=Math.pow(tiempos[i][j]-promedio[i],2);
                 suma[i]+=pot;
                 
             }
             desviacion[i]=Math.sqrt(suma[i]/4);
         }

    }
    static void calculoPromedio(){
        double sum=0;
        for(int i=0;i<b;i++){
            for(int j=0;j<5;j++){
                sum+=tiempos[i][j];
            }
            suma[i]=sum;
            promedio[i]=sum/5;
            sum=0;
            
        }
    }
    static void calculoVelocidad(){
        for(int i=0;i<b;i++) {
            velocidad[i]=distancia[i]/promedio[i];
            aceleracion[i]=velocidad[i]/promedio[i];
            acceGravedad[i]= (2*distancia[i]/Math.pow(promedio[i],2))/100;
        }
    }
    
}

