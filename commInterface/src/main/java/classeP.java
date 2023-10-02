public class classeP  implements Generale{
    @Override
    public void afficherMessage(String msg) {
if(msg.equals("A")){
    System.out.println("message de la classe A");
}
else if(msg.equals("B")){
    System.out.println("message de la classe B");
}
    }

    public static void main(String toto[]){
    ClasseA A = new ClasseA();
    A.getMsgA().afficherMessage("A");







    }
}
