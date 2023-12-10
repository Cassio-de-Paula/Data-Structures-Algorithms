package dataStructures.Pilha;

public class Main {
    public static void main(String args[]) {
        Stack stack = new Stack();

        for (int i = 0; i <= 8; i++) {
            stack.add(i);
        }

        stack.print();

        for (int i = 0; i <= 9; i++) {
            stack.remove();
        }

        stack.print();
    }

}

class Stack {
    int size = 10, pos = 0;
    int array[] = new int[size];

    Stack() {
    }

    // Adiciona um novo elemento a pilha, se o numero de elementos for igual a 70%
    // da capacidade atual do vetor,
    // A função chama outra para redimensioná-lo
    public void add(int value) {
        array[pos] = value;
        pos++;

        if (pos >= array.length * 7 / 10) {
            array = resizeArray();
        }
    }

    // Função auxiliar que cria ou vetor com o dobro da capacidadde anterior e copia
    // os valores antigos para ele
    private int[] resizeArray() {
        int newArray[] = new int[size * 2];

        for (int i = 0; i < pos; i++) {
            newArray[i] = this.array[i];
        }

        array = newArray;

        return array;
    }

    // Função para remover o ultimo elemento da lista (topo da pilha)
    public void remove() {
        if (pos == 0) {
            System.out.println("A pilha não possui mais elementos");
        } else {
            pos--;
        }
    }

    // FUnção para escrever o vetor no console
    public void print() {
        for (int i = 0; i < pos; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
