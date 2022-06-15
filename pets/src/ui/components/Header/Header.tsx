import { HeaderContainer, Logo } from "./Header.style";
import Link from "next/link";
import NextLink from 'next/link'

export default function Header(){
    return(
        <HeaderContainer>
            <Link component={NextLink} href={'/'}>
                <a>
                    <Logo src="/imagens/logo.svg" alt="Adote um pet"/>
                </a>
            </Link>
        </HeaderContainer>
    )
}
