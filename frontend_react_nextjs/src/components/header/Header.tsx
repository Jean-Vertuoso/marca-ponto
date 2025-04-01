import { useRouter } from 'next/navigation';
import Link from 'next/link';
import { LinkHeader } from '../link-header/LinkHeader';

export default function Header(){

    const router = useRouter();

    return(
        <header>
            <nav className="flex items-center w-full justify-between flex-wrap bg-linear-to-r from-[#2D6884] to-[#479BA1] p-4 fixed">
                <div className="flex justify-between w-full">
                    <div className="flex justify-between items-baseline w-100 text-sm">
                        <LinkHeader href="#" >Marcações</LinkHeader>
                        <LinkHeader href="#" >Ausências</LinkHeader>
                        <LinkHeader href="#" >Teste</LinkHeader>
                    </div>
                    <div>
                        <button className="bg-radial-[at_30%_25%] from-[#FBFCFB] to-[#CDCBCC] border border-gray-200/100 text-gray-700/100 text-center rounded-4xl hover:bg-radial-[at_50%_55%] active:bg-gray w-30 p-5"
                                onClick={() => router.push('/login')}>
                            Sair
                        </button>
                    </div>
                </div>
            </nav>
        </header>
    )
}
//<button className="text-sm py-5 px-8 rounded-4xl border text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white"