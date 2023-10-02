public class Main {
    public static void main(String[] args) {
        Crier[] animauxQuiCrient = new Crier[2];

        animauxQuiCrient[0] = new Chat();
        animauxQuiCrient[1] = new Chien();

        for (Crier animal: animauxQuiCrient) {
            animal.crier();
        }
    }
}