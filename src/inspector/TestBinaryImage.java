package inspector;

public class TestBinaryImage {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE INGRIDIENTES: BINARY IMAGE ===");

        int w = 3;
        int h = 3;
        BinaryImage img = new BinaryImage(w, h);

        System.out.println("Solicitado: " + w + "x" + h);
        System.out.println("Memória Total (esperado 5x5): " + 
                           img.getTotalWidth() + "x" + img.getTotalHeight());


        System.out.println("\n Pintando pixel (0,0) com valor de OBJETO...");
        img.setPixel(0, 0, BinaryImage.OBJECT);

        
        int cantoBorda = img.getRawPixel(0, 0);
        int cantoReal  = img.getRawPixel(1, 1);

        System.out.println("Valor na Borda [0][0] (esperado " + BinaryImage.BACKGROUND + "): " + cantoBorda);
        System.out.println("Valor no Conteúdo [1][1] (esperado " + BinaryImage.OBJECT + "): " + cantoReal);

        if (cantoBorda == BinaryImage.BACKGROUND && cantoReal == BinaryImage.OBJECT) {
            System.out.println("\nSUCESSO: O Padding está protegendo a imagem corretamente!");
        } else {
            System.out.println("\nERRO: Os pixels não estão onde deveriam.");
        }
    }
}