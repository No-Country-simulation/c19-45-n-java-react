import Image from "next/image";

export const ViewPetsWelcome = () => {
  return (
    <div className="hero  bg-[#FFAC31] min-h-screen bg-cover bg-center">
      <div className="hero-content text-center">
        <div className="max-w-md">
          <Image
            className="mt-20"
            src={"/imagen-01.png"}
            width={400}
            height={400}
            alt="Picture of the author"
          />
          <h1 className="text-4xl font-bold text-black   ">
            Adopta a tu mejor amig@
          </h1>
          <p className="py-6 text-black text-sl">
            Bienvenidos a nuestra <span className="underline font-bold">comunidad</span> de amantes de los
            <br />
            animales.Aquí, encontraras adorables mascotas <br />
            que buscan un hogar lleno de amor.
          </p>
          <button className="btn btn-primary text-2xl m-6">Crear cuenta</button>
          <a href="#" className="block w-full  underline text-3xl text-black ">ya tengo una cuenta</a>
          
        </div>
      </div>
    </div>
  );
};
