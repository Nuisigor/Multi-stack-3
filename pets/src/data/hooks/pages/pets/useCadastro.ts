import { AxiosError } from "axios";
import { useState } from "react";
import { ApiService } from "../../../services/ApiService";

export function useCadastro(){

    const [nome, setNome] = useState('');
    const [historia, setHistoria] = useState('');
    const [foto, setFoto] = useState('');
    const [mensagem, setMensagem] = useState('');


    function cadastrar(){
        if(validarFormulario()){
            ApiService.post("/pets", {
                nome,
                historia,
                foto
            }).then(() => {
                limpar();
                setMensagem("Pet cadastrado com sucesso!")
            }).catch((error : AxiosError) => {
                setMensagem(error.response?.data.message);
            })
        }else{
            setMensagem("Preencha os dados corretamente");
        }
    }

    function validarFormulario(){
        return nome.length > 0 && historia.length > 0 && foto.length > 0;
    }

    function limpar(){
        setNome('');
        setHistoria('');
        setFoto('');
    }

    return ({
        nome,
        historia,
        foto,
        setNome,
        setHistoria,
        setFoto,
        mensagem,
        setMensagem,
        cadastrar
    })
}