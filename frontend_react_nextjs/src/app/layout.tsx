import "./globals.css";
import ClientLayout from "@/components/ClientLayout";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  
  return (
    <html lang="pt-br">
      <body className={''} cz-shortcut-listen="false">
        <ClientLayout>{children}</ClientLayout>
      </body>
    </html>
  );
}
