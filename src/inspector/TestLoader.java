package inspector;

import java.io.IOException;

public class TestLoader {
    public static void main(String[] args) {
        PbmImageLoader loader = new PbmImageLoader();

        String caminho = "samples/teste.pbm";

        try {
            System.out.println("Tentando ler: " + caminho);
            BinaryImage img = loader.load(caminho);

            System.out.println("\nSucesso! Imagem carregada.");
            System.out.println("Dimensões lidas: " +
                    (img.getTotalWidth()-2) + "x" + (img.getTotalHeight()-2));

            System.out.println("Pixel Centro (2,2) deve ser 0: " + img.getPixel(2, 2));
            System.out.println("Pixel Parede (2,1) deve ser 1: " + img.getPixel(2, 1));

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}