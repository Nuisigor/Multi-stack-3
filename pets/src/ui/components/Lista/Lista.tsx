import { ListaStyled, ItemLista, Descricao, Informacoes, Nome, Foto } from "./Lista.style";
import { Button } from "@mui/material";
import { Pet } from "../../../data/@types/Pet";
import { TextService } from '../../../data/services/TextService';

interface ListaProps{
    pets: Pet[];
    onSelect : (pet : Pet) => void;
}


export default function Lista(props: ListaProps){

    const tamanhoMaximoTexto = 200;

    return(
        <ListaStyled>
            {props.pets.map( pet => (
                <ItemLista key={pet.id}>
                <Foto src={pet.foto} alt={pet.nome}/>
                <Informacoes>
                    <Nome>{pet.nome}</Nome>
                    <Descricao>{TextService.limitarTexto(pet.historia, tamanhoMaximoTexto)}</Descricao>
                    <Button variant="contained" onClick={() => props.onSelect(pet)} fullWidth>Adotar</Button>
                </Informacoes>
            </ItemLista>
            ))}
            
        </ListaStyled>
    )
}