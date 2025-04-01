"use client"; // Habilita o client-side rendering

import { usePathname } from "next/navigation";
import Header from "@/components/header/Header";

export default function ClientLayout({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const isLoginPage = pathname === "/login";

  return (
    <div>
      {!isLoginPage && <Header />} {/* Exibe a Navbar apenas se NÃO estiver na página de login */}
      {children}
    </div>
  );
}
