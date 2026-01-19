package inspector;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PbmImageLoader {

    public BinaryImage load(String filePath) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fileInputStream);

        try {
            String header = nextToken(scanner);

            if (!header.equalsIgnoreCase("P1")) {
                throw new IOException("Arquivo inválido! Esperado PBM ASCII (P1), mas encontrado: " + header);
            }

            int width = Integer.parseInt(nextToken(scanner));
            int height = Integer.parseInt(nextToken(scanner));

            System.out.println("Carregando imagem PBM: " + width + "x" + height);

            BinaryImage image = new BinaryImage(width, height);

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    String bit = nextToken(scanner);
                    int valor = Integer.parseInt(bit);
                    image.setPixel(r, c, valor);
                }
            }

            return image;

        } finally {
            scanner.close();
        }
    }


    private String nextToken(Scanner sc) throws IOException {
        while (sc.hasNext()) {
            String token = sc.next();

            if (token.startsWith("#")) {
                sc.nextLine();
            } else {
                return token;
            }
        }
        throw new IOException("Fim de arquivo inesperado (arquivo incompleto?)");
    }
}