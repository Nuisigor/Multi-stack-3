import { NextPage } from "next";
import { useCadastro } from "../../data/hooks/pages/pets/useCadastro";
import Titulo from "../../ui/components/Titulo/Titulo";
import { Paper, Grid, TextField, Button, Snackbar } from "@mui/material";

const Cadastro : NextPage = ()=>{

    const {
        nome,
        historia,
        foto,
        setNome,
        setHistoria,
        setFoto,
        mensagem,
        setMensagem,
        cadastrar
    } = useCadastro();

    return (
        <>
            <Titulo
                titulo="Cadastro de pets para adoção"
                subtitulo={"Preencha os dados do novo pet"}
            />
            <Paper sx={{maxWidth : 970, mx: 'auto', p: 5}}>
                <Grid container spacing={3}>
                <Grid item xs={12}>
                        <TextField
                            label={"Nome"}
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                            placeholder={"Digite o nome do pet"}
                            fullWidth
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            label={"História do pet"}
                            value={historia}
                            onChange={(e) => setHistoria(e.target.value)}
                            multiline
                            fullWidth
                            rows={4}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            label={"Foto"}
                            value={foto}
                            onChange={(e) => setFoto(e.target.value)}
                            placeholder={"Digite o endereço da imagem"}
                            fullWidth
                        />
                    </Grid>
                    <Button
                        variant="contained"
                        color="secondary"
                        sx={{mt:2}}
                        component={'a'}
                        href={"https://imgur.com/upload"}
                        target={"_blank"}
                    >
                        Enviar Imagem
                    </Button>
                    <Grid item xs={12} sx={{textAlign: "center"}}>
                        <Button
                            variant="contained"
                            onClick={cadastrar}
                            fullWidth
                            sx = {{maxWidth: {md: 200, mt: 4}}}
                        >
                            Cadastrar pet
                        </Button>
                    </Grid>
                </Grid>
            </Paper>

            <Snackbar
                open = {mensagem.length > 0 ? true : false}
                message={mensagem}
                onClose = {() => setMensagem('')}
                autoHideDuration={2500}
            />
        </>
    )
}

export default Cadastro;