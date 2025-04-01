'use client'

import { useState } from 'react';
import { useRouter } from 'next/navigation';
import login from '@/services/LoginService'
import Image from 'next/image';
import { MenuButton } from '@/components/button/Button';

export default function Login(){

    const [isLoginForm, setIsLoginForm] = useState(true);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const router = useRouter();

    const handleLogin = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
    
        setError('');
    
        const loginData = {
            email,
            password
        }
    
        try{
            const response = await login(email, password);

            if(response.status === 200){
                router.push('/timeentry');
                const token = response.data;
                console.log(token);                
            }else{
                const errorData = await response.data.json()
                setError(errorData.message || 'Login failed for user. Please retry!')
            }
        }catch(error){
            setError('And error occured. Please retry')
            alert(`Usuário ou senha incorreta`)
        }
    } 
    
    return (
        <div className="bg-radial-[at_50%_25%] from-[#f5f5f5fb] to-[rgba(253,253,253,0.92)] h-screen flex justify-center items-center">
            <div className="rounded-xl">
                <form className="flex justify-center items-center w-full p-30" onSubmit={handleLogin}>
                    <div className='min-w-80'>                        
                        <Image src="/logoMarcaPonto.png" width={250} height={250} className='relative min-size m-0 p-0' alt="" draggable='false'/>
                    </div>
                    {isLoginForm ? (
                        <div className="loginForm animate-fade-right w-85 min-w-80">
                            <Image src="/emailIcon.webp" width={43} height={43} className='absolute my-2 ml-2' alt="" draggable='false'/>
                            <input type="email" 
                                    id="email" 
                                    className="bg-radial-[at_35%_25%] from-[#FBFCFB] to-[#CDCBCC] pl-15 border border-gray-200/70 text-gray-700 mb-6 rounded-4xl w-full p-4" 
                                    placeholder="Email ID" 
                                    required 
                                    onChange={ (e) => setEmail(e.target.value) }/>
                                    
                            <Image src="/passwordIcon.webp" width={43} height={43} className='absolute my-2 ml-2' alt="" draggable='false'/>
                            <input type="password" 
                                    id="password" 
                                    className="bg-radial-[at_35%_25%] from-[#FBFCFB] to-[#CDCBCC] pl-15 border border-gray-200/70 text-gray-700 rounded-4xl w-full p-4" 
                                    placeholder="Senha" 
                                    required 
                                    onChange={ (e) => setPassword(e.target.value) }/>

                            <div className='flex justify-between items-center'>
                                <button className='w-40 h-10 p-5 m-0 transition delay-150 duration-150 ease-in-out hover:-translate-y-1 hover:scale-110 justify-self-end text-gray-700/90' onClick={() => setIsLoginForm(false)}>Esqueci a senha</button>
                                <MenuButton type={"submit"}>
                                            Entrar
                                </MenuButton>
                            </div>
                        </div>
                    ) : (
                        <div className="forgotPasswordForm animate-fade-left w-85 min-w-80">
                            <Image src="/emailIcon.webp" width={43} height={43} className='absolute my-2 ml-2' alt="" draggable='false'/>
                            <input type="email" 
                                    id="email" 
                                    className="bg-radial-[at_35%_25%] from-[#FBFCFB] to-[#CDCBCC] pl-15 border border-gray-200/70 text-gray-700 mb-2 rounded-4xl w-full p-4" 
                                    placeholder="Email ID" 
                                    required />
                            <div className='flex justify-between'>
                                <button className="bg-radial-[at_30%_25%] to-[#CDCBCC] border border-gray-200/70 text-gray-700/90 mt-6 text-sm rounded-4xl hover:bg-radial-[at_50%_55%] active:bg-[#dad3d6] w-40 p-5"
                                        onClick={() => setIsLoginForm(true)}>
                                    Voltar para login
                                </button>
                                <button className="bg-radial-[at_30%_25%] to-[#CDCBCC] border border-gray-200/70 text-gray-700/90 mt-6 text-sm rounded-4xl hover:bg-radial-[at_50%_55%] active:bg-[#dad3d6] w-40 p-5">
                                    Enviar
                                </button>
                            </div>
                        </div>
                    )}
                </form>
            </div>
        </div>
    )
}

/* */