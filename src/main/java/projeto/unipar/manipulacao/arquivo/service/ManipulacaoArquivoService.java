package projeto.unipar.manipulacao.arquivo.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class ManipulacaoArquivoService {

    private static final String DIRETORIO = System.getProperty("user.home") + "/.manipulacaoArquivo";

    private static final String ARQUIVO = "ARQUIVO.txt";

    public void criarOuExibirArquivo() {
        try {
            Path userHome = FileSystems.getDefault().getPath(System.getProperty("user.home"));

            Path diretorioPath = userHome.resolve(DIRETORIO);
            if (!Files.exists(diretorioPath)) {
                Files.createDirectories(diretorioPath);
            }

            File arquivo = new File(DIRETORIO + "/" + ARQUIVO);
            if (!arquivo.exists()) {
                FileWriter writer = new FileWriter(arquivo);
                for (int i = 1; i <= 10; i++) {
                    writer.write("9 x " + i + " = " + (9 * i) + "\n");
                }
                writer.close();
            }
            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso.\nLocal: " + DIRETORIO + "/" + ARQUIVO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletarArquivo() {
        try {
            Path arquivoPath = Paths.get(DIRETORIO + "/" + ARQUIVO);
            if (Files.exists(arquivoPath)) {
                Files.delete(arquivoPath);
                System.out.println("Arquivo deletado com sucesso.");
            } else {
                System.out.println("Arquivo não encontrado.");
            }
            JOptionPane.showMessageDialog(null, "Arquivo deletado com sucesso.\nLocal: " + DIRETORIO + "/" + ARQUIVO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerConteudoArquivo() {
        try {
            Path arquivoPath = Paths.get(DIRETORIO + "/" + ARQUIVO);
            if (Files.exists(arquivoPath)) {
                return new String(Files.readAllBytes(arquivoPath));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
