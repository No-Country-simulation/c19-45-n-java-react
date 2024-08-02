import Link from "next/link";

export const WelcomeContent = () => {
  return (
    <p className="text-2xl w-[850px] mb-4">
      Bienvenidos a nuestra{" "}
      <Link href="/mascotas" className="underline font-bold">
        comunidad
      </Link>{" "}
      de amantes de los animales. Aquí, encontraras adorables mascotas que
      buscan un hogar lleno de amor.
    </p>
  );
};
