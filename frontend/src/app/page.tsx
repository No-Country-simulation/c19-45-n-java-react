import Image from "next/image";
import Link from "next/link";
import { WelcomeContent, WelcomeTitle } from "@/app/_components";

const PageWelcome = () => {
  return (
    <main className="min-h-screen bg-[#FFAC31] flex items-center justify-center flex-col">
      <Image src="/pet.png" width={300} height={400} alt="Perro" />
      <WelcomeTitle />
      <WelcomeContent />
      <Link href="/mascotas">
        <button className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl">
          Ingresar
        </button>
      </Link>
    </main>
  );
};

export default PageWelcome;
