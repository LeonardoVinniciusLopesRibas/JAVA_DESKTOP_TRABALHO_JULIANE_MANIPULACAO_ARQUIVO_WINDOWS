package projeto.unipar.manipulacao.arquivo.controller;

import projeto.unipar.manipulacao.arquivo.service.ManipulacaoArquivoService;

public class ManipulacaoArquivoController {

    private final ManipulacaoArquivoService arquivoService;

    public ManipulacaoArquivoController() {
        this.arquivoService = new ManipulacaoArquivoService();
    }

    public void criarOuExibirArquivo() {
        arquivoService.criarOuExibirArquivo();
    }

    public void deletarArquivo() {
        arquivoService.deletarArquivo();
    }

    public String lerConteudoArquivo() {
        return arquivoService.lerConteudoArquivo();
    }
}
