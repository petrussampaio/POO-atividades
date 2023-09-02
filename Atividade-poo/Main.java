import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Círculo
        System.out.print("Digite o raio do círculo: ");
        double raioCirculo = scanner.nextDouble();
        Circulo circulo = new Circulo(raioCirculo);
        System.out.println("Área do círculo: " + circulo.calcularArea());
        System.out.println("Perímetro do círculo: " + circulo.calcularPerimetro());

        // Quadrado
        System.out.print("Digite o lado do quadrado: ");
        double ladoQuadrado = scanner.nextDouble();
        Quadrado quadrado = new Quadrado(ladoQuadrado);
        System.out.println("Área do quadrado: " + quadrado.calcularArea());
        System.out.println("Perímetro do quadrado: " + quadrado.calcularPerimetro());

        // Retângulo
        System.out.print("Digite o comprimento do retângulo: ");
        double comprimentoRetangulo = scanner.nextDouble();
        System.out.print("Digite a largura do retângulo: ");
        double larguraRetangulo = scanner.nextDouble();
        Retangulo retangulo = new Retangulo(comprimentoRetangulo, larguraRetangulo);
        System.out.println("Área do retângulo: " + retangulo.calcularArea());
        System.out.println("Perímetro do retângulo: " +     
        retangulo.calcularPerimetro());

        // Triângulo
        System.out.print("Digite a base do triângulo: ");
        double baseTriangulo = scanner.nextDouble();
        System.out.print("Digite a altura do triângulo: ");
        double alturaTriangulo = scanner.nextDouble();
        Triangulo triangulo = new Triangulo(baseTriangulo, alturaTriangulo);
        System.out.println("Área do triângulo: " + triangulo.calcularArea());
        System.out.println("Perímetro do triângulo: " +       
        triangulo.calcularPerimetro());

        scanner.close();
    }
}