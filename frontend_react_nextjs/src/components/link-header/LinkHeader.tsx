import Link from "next/link";

type LinkHeaderProps = {
    href: string;
    children: React.ReactNode;
};

export function LinkHeader({ href, children }: LinkHeaderProps){
    return (
        <Link href={ href } 
            className="bg-radial-[at_30%_25%] from-[#FBFCFB] to-[#CDCBCC] border border-gray-200/100 text-gray-700/100 text-center rounded-4xl hover:bg-radial-[at_50%_55%] w-30 p-5">
            { children }
        </Link>
    );
}