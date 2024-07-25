import Image from "next/image";


export const ViewPetsWelcome = () => {
  return (
    <div className="hero  bg-[#FFAC31] min-h-screen bg-cover bg-center flex items-center justify-center">
      <div className="hero-content text-center">
        <div className="sm:max-w-3xl lg:max-w-6xl">
          <Image
            className="mt-20 mx-auto"
            src={"/imagen-01.png"}
            width={400}
            height={400}
            alt="Picture of the author"
          />
          <h1 className="text-3xlc sm:text-4xl font-bold text-black lg:text-6xl    ">
            Adopta a tu mejor amig@
          </h1>
          <p className="sm:text-xl py-4 text-black lg:text-3xl">
            Bienvenidos a nuestra <span className="underline font-bold">comunidad</span> de amantes de los
            animales.Aquí, encontraras adorables mascotas que buscan un hogar lleno de amor.
          </p>
        {/* <Link className="btn m-2 font-bold font-worksans bg-secondary" to="/dashboard">Crear cuenta </Link> */}

          <button className="btn btn-primary  bg-black text-2xl m-3 hover:bg-gray-600 border-transparent">Crear cuenta</button>
          <a href="/login" className="sm:text block w-full  text-black  underline lg:text-3xl">ya tengo una cuenta</a>
          
        </div>
      </div>
    </div>
  );
};
