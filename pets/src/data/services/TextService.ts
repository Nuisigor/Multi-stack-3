export const TextService = {
    limitarTexto(texto: string, tamanhoMaximo: number){
        if(texto.length < tamanhoMaximo){
            return texto;
        }
        return texto.slice(0, tamanhoMaximo) + '...';
    }
}