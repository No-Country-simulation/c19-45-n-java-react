import Image from "next/image";

export const Banner = () => {
  return (
    <section className="bg-[#FFAC31] p-14 rounded-lg shadow-md flex gap-12 items-center">
      <div className="flex gap-2 flex-col">
        <h1 className="text-7xl font-bold">Hola,</h1>
        <p className="text-2xl mb-3">¡Bienvenido a Petfriendly! </p>
        <p className="text-xl">
          Con <b>Petfriendly</b>, puedes encontrar adorables mascotas en
          adopción, conectarte con otros amantes de los animales, y mantenerte
          al tanto de los mejores consejos y cuidados para tus amigos peludos.
        </p>
      </div>
      <Image src="/pet.png" height={100} width={640} alt="Perro" />
    </section>
  );
};
