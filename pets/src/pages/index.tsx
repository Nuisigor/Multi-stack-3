import type { NextPage } from 'next'
import Lista from '../ui/components/Lista/Lista'
import Titulo from '../ui/components/Titulo/Titulo'
import { Dialog, TextField, Grid, DialogActions, Button, Snackbar } from '@mui/material'
import { useIndex } from '../data/hooks/pages/useIndex'

const Home: NextPage = () => {

  const {
    listaPets,
    petSelecionado,
    setPetSelecionado,
    email,
    setEmail,
    valor,
    setValor,
    mensagem,
    setMensagem,
    adotar
  } = useIndex();

  return (
    <div >
      <Titulo titulo='' subtitulo={<span>Com um pequeno valor você pode <strong>adotar um pet virtualmente.</strong></span>}/>
      <Lista pets={listaPets} onSelect={(pet) => setPetSelecionado(pet)}/>

      <Dialog 
        open={petSelecionado != null}
        onClose={() => setPetSelecionado(null)}  
        fullWidth 
        PaperProps={{sx : {p : 5}}}
        >
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField 
              label={'E-mail'} 
              type='email'
              value={email}
              onChange={(e) => setEmail(e.target.value)} 
              fullWidth
              />
          </Grid>
          <Grid item xs={12}>
            <TextField 
              label={"Quantia por mês"} 
              type='number'
              value={valor}
              onChange={(e) => setValor(e.target.value)} 
              fullWidth
              />
          </Grid>
        </Grid>
        <DialogActions sx={{mt : 5}}>
          <Button 
            color='secondary' 
            onClick={() => setPetSelecionado(null)}
            >
            Cancelar
          </Button>
          <Button 
            variant='contained'
            onClick={() => adotar()}
            >
            Confirmar adoção
          </Button>
        </DialogActions>
      </Dialog>

      <Snackbar 
        open={mensagem.length > 0} 
        message={mensagem}
        autoHideDuration={2500}
        onClose={() => setMensagem('')}
      />
    </div>
  )
}

export default Home
