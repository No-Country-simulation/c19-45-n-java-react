import Image from "next/image";

export default function Hero() {
  return (
    <div className="artboard artboard-horizontal phone-6 rounded-lg bg-[#FFAC31] m-1">
      <div className="hero">
        <div className="hero-content flex-col lg:flex-row-reverse">
          <Image
            className="max-w-sm rounded-lg "
            src={"/imagen-01.png"}
            width={300}
            height={300}
            alt="Picture of the author"
          />
          <div className="w-3/4">
            <h1 className="text-6xl font-bold">Hola,</h1>
            <p className="py-6 text-2xl w-full">
              ¡Bienvenido a Petfriendly! <br />
              <br />
              Con <span className="font-bold">Petfriendly</span>,
              puedes encontrar adorables mascotas en adopción, conectarte con
              otros amantes de los animales, y mantenerte al tanto de los
              mejores consejos y cuidados para tus amigos peludos.
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
