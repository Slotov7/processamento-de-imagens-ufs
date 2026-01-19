package inspector;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        String filePath = "samples/teste.pbm";

        System.out.println("=== SISTEMA DE INSPEÇÃO GENERICSTUFF ===");
        System.out.println("Arquivo alvo: " + filePath);

        PbmImageLoader loader = new PbmImageLoader();
        ObjectInspector inspector = new ObjectInspector();

        try {
            long startLoad = System.currentTimeMillis();

            BinaryImage image = loader.load(filePath);

            long fimLoad = System.currentTimeMillis();
            System.out.printf("Imagem carregada (%dx%d) em %d ms.%n",
                    (image.getTotalWidth() - 2), (image.getTotalHeight() - 2), (fimLoad - startLoad));


            System.out.println("Iniciando análise de objetos...");
            long startProcess = System.currentTimeMillis();

            InspectionResult result = inspector.inspect(image);

            long endProcess = System.currentTimeMillis();

            System.out.println("\n" + result);
            System.out.println("Tempo de processamento: " + (endProcess - startProcess) + " ms");

        } catch (IOException e) {
            System.err.println("Erro de Leitura: " + e.getMessage());
            System.err.println("Verifique se o arquivo existe e se o caminho está correto.");
        } catch (Exception e) {
            System.err.println("Erro Inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}