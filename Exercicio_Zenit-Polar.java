import java.util.Scanner;

class Main {

  public static String codifica(String palavra){
    String resultado="";

    for(int i=0;i<palavra.length();i++){
      char c=palavra.charAt(i);

      if(c=='Z'||c=='z')
        c='p';
      else if(c=='P'||c=='p')
        c='z';
      else if(c=='E'||c=='e')
        c='o';
      else if(c=='O'||c=='o')
        c='e';
      else if(c=='N'||c=='n')
        c='l';
      else if(c=='L'||c=='l')
        c='n';
      else if(c=='I'||c=='i')
        c='a';
      else if(c=='A'||c=='a')
        c='i';
      else if(c=='T'||c=='t')
        c='r';
      else if(c=='R'||c=='r')
        c='t';

      resultado+=c;
    }
    
    return resultado;
  
  }
  
  public static void main(String[] args) {
    Scanner teclado= new Scanner(System.in);
    
    System.out.println("\nDigite a palavra para conversão: ");
    String palavra=teclado.nextLine();

    System.out.println("\n\nA palavra codificada é "+codifica(palavra));
      
  }
}