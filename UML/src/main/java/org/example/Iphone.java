package org.example;

public record Iphone() implements MusicPlayer, TelephoneDevice, InternetExplorer{
    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para "+numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo ligação");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando Correio de Voz");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando musica");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando musica");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("musica selecionada "+musica);
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo " +url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando pagina");
    }
}
