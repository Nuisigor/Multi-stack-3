import { HeaderContainer, Logo, LinksContainer } from "./HeaderAdmin.style"
import { Link, Box } from "@mui/material"
import NextLink from 'next/link'

export default function HeaderAdmin(){
    return (
        <HeaderContainer>
            <div>
                <LinksContainer>
                    <Link component={NextLink} href={'/'}>
                        <a>
                            <Logo src="/imagens/logo.svg" alt="Adote um pet"/>
                        </a>
                    </Link>
                </LinksContainer>
                <LinksContainer>
                    <Link component={NextLink} href={'/pets/cadastro'}>
                        <a>
                            Cadastrar Pet
                        </a>
                    </Link>
                    <Link component={NextLink} href={'/pets/relatorio'}>
                        <a>
                            Relatório{' '}
                            <Box component={'span'} sx={{display : {sm : 'initial', xs : 'none'}}}>
                                de adoção
                            </Box>
                        </a>
                    </Link>
                </LinksContainer>
            </div>
        </HeaderContainer>
    )
}