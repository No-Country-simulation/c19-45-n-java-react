import Image from "next/image";
import Link from "next/link";
import { WelcomeContent, WelcomeTitle } from "@/components";

const PageWelcome = () => {
  return (
    <main className="min-h-screen bg-[#FFAC31] flex items-center justify-center flex-col">
      <Image src="/pet.png" width={300} height={400} alt="Perro" />
      <WelcomeTitle />
      <WelcomeContent />
      <Link
        href="/mascotas"
        className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl mt-6"
      >
        Ingresar
      </Link>
      <Link
        href="/auth/inicio-sesion"
        className="underline font-medium text-3xl mt-5"
      >
        Ya tengo una cuenta
      </Link>
    </main>
  );
};

export default PageWelcome;
