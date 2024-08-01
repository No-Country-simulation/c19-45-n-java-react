import Image from "next/image";
import Link from "next/link";

export const PetLarge = () => {
  return (
    <div className="bg-[#FFCD82] p-4 w-full rounded-lg shadow-md">
      <div className="flex gap-8 items-center">
        <Image
          src="/pet.png"
          width={100}
          height={100}
          alt="Mascota"
          className="shadow-lg w-[250px] object-cover rounded-lg bg-[#FFE2B6]"
        />
        <div className="w-full">
          <div className="flex justify-between items-center">
            <h1 className="font-bold text-4xl">Gringa</h1>
            <Link
              href="/dashboard/mascotas/1?accion=editar-mascota"
              className="btn btn-active text-white btn-md shadow-lg text-md px-6"
            >
              <span>Editar</span>
            </Link>
          </div>
          <div className="grid grid-cols-2 gap-1 mt-3">
            <p className="text-xl">
              <b>Edad:</b> 2 años
            </p>
            <p className="text-xl">
              <b>Sexo:</b> Hembra
            </p>
            <p className="text-xl">
              <b>Especie:</b> Gato
            </p>
            <p className="text-xl">
              <b>Raza:</b> -
            </p>
            <p className="text-xl">
              <b>Vacunas al día:</b> Si
            </p>
            <p className="text-xl">
              <b>Esterelización:</b> Si
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};
