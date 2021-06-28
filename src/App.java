import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Fila<Object> fila = new Fila<Object>();
        String prioridade = "null";
        String nome = "null";
        String data = "null";
        String sintomas = "null";

        String i = "";
        int j = 0;
        int contador = 0;

        System.out.print("Aperte qualquer tecla para continuar ou digite 'exit' para finalizar: ");
        Scanner teclado = new Scanner(System.in);
        while (!i.equalsIgnoreCase("exit")) {
            contador = 0;
            i = teclado.next();
            if (!i.equalsIgnoreCase("exit") && j == 0) {
                System.out.print("Digite o nome do paciente: ");
                nome = teclado.next();
                j = 1;
            } else if (!i.equalsIgnoreCase("exit") && j == 1) {
                System.out.print("Digite a prioridade do paciente (vermelho > amarelo > verde): ");
                prioridade = teclado.next();
                j = 2;
            } else if (!i.equalsIgnoreCase("exit") && j == 2) {
                System.out.print("Digite a data de nascimento do paciente: ");
                data = teclado.next();
                j = 3;
            } else if (!i.equalsIgnoreCase("exit") && j == 3) {
                System.out.print("Digite o sintoma do paciente: ");
                sintomas = teclado.next();
                Paciente paciente = new Paciente(nome, prioridade, data, sintomas);
                nome = "null";
                data = "null";
                sintomas = "null";
                prioridade = "null";
                fila.enfileiraComPrioridade(paciente);
                j = 0;
                contador = 10;
            } else {
                if (contador != 10) {
                    Paciente pacienteInconpleto = new Paciente(nome, prioridade, data, sintomas);
                    fila.enfileiraComPrioridade(pacienteInconpleto);
                    teclado.close();
                }
                teclado.close();
            }
            System.out.print("Aperte qualquer tecla para 'continuar' ou 'exit' para finalizar: ");
        }

        System.out.println("\n\n" + "Lista dos pacientes de acordo com o protocolo de Manchester:");
        System.out.println("\n" + fila);

        fila.desenfileira();

        System.out.println("\n" + "Removendo o paciente que adentrou ao consultório:");
        System.out.println("\n" + fila);
    }
}