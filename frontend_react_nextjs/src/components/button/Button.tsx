import { ButtonHTMLAttributes } from "react";

type ButtonProps = {
    onClick?: () => void;
    type?: "submit";
    children?: React.ReactNode;
}

export function TimeEntryButton({onClick}: ButtonProps){
    return (    
        <button className="bg-radial-[at_30%_25%] from-[#FBFCFB] to-[#CDCBCC] border border-gray-200/100 text-gray-700/100 text-2xl rounded-full hover:bg-radial-[at_50%_55%] select-none w-50 h-50 p-5"
                onClick={onClick}>
                Bater ponto
        </button>
    );
}

export function MenuButton({ type, children }: ButtonProps){
    return (
        <button className="bg-radial-[at_30%_25%] to-[#cdcbcc] border border-gray-200/70 text-gray-700/90 mt-6 text-sm rounded-4xl hover:bg-radial-[at_50%_55%] active:bg-[#dad3d6] block w-40 p-5"
                type={ type }>
                { children }
        </button>
    );
}