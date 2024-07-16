import Image from "next/image";


export const ViewPetsWelcome = () => {
  return (
    <div className="hero  bg-yellow-200 min-h-screen bg-cover bg-center">
       <Image
      src={"/imagen.jpg"}
      width={1440}
      height={1440}
      alt="Picture of the author"
      />
      <div className="hero-content text-center">
        <div className="max-w-md">
          <h1 className="text-5xl font-bold text-black mb:text-4xl  ">
            Adopta a tu mejor amig@
          </h1>
          <p className="py-6 text-black font-bold">
            Bienvenidos a nuestra <span>comunidad</span> de amantes de los<br />
            animales.Aquí, encontraras adorables mascotas <br />
            que buscan un hogar lleno de amor.
          </p>
          <button className="btn btn-primary">Crear cuenta</button>
          <p className="py-6 text-black font-bold">ya tengo una cuenta</p>
         
        </div>
      </div>
    </div>
  );
};
