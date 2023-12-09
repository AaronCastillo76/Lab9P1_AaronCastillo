package lab9p1_aaroncastillo;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Gusanito {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    int fila, columna;

    public Gusanito(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public char[][] tablero() {
        char[][] temporal = new char[fila][columna];
        char espacio = ' ';
        char s = 's';
        char m = 'O';
        char obstaculo = '#';
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = espacio;
            }
        }
        int serpientex = random.nextInt(fila);
        int serpientey = random.nextInt(columna);
        temporal[serpientex][serpientey] = s;
        int manzanax = random.nextInt(fila);
        int manzanay = random.nextInt(columna);
        temporal[manzanax][manzanay] = m;
        int obstaculoss = 0;
        if (fila > columna) {
            obstaculoss = random.nextInt((fila - columna) + 1) + columna;
        } else if (columna > fila) {
            obstaculoss = random.nextInt((columna - fila) + 1) + fila;
        }
        for (int i = 0; i < obstaculoss; i++) {
            int equis = random.nextInt(fila);
            int igriega = random.nextInt(columna);
            if ((temporal[equis][igriega] != temporal[serpientex][serpientey]) && (temporal[equis][igriega] != temporal[manzanax][manzanay])) {
                temporal[equis][igriega] = obstaculo;
            }
        }
        return temporal;
    }

    public String imprimir(char[][] matriz) {
        String xd = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                xd += "[ " + matriz[i][j] + " ]";
            }
            xd += "\n";
        }
        return xd;
    }
}
