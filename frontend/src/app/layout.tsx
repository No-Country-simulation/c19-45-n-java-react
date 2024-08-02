import { Inter } from "next/font/google";
import "../styles/index.css";
import { Metadata } from "next";

const inter = Inter({ subsets: ["latin"] });
export const metadata: Metadata = {
  title: {
    template: "%s | PetFriendly",
    default: "PetFriendly - Adopción de Mascotas",
  },
  description: "Website para Adopción de Mascotas",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={`${inter.className} bg-[#FFE2B6] min-h-screen text-black flex flex-col justify-between`}
      >
        {children}
      </body>
    </html>
  );
}
