import Image from "next/image";
import React from "react";

interface PetLargeProps {
  imageSrc: string;
  name: string;
  age: string;
  species: string;
  vaccines: string;
  sex: string;
  breed: string;
  sterilized: string;
  
}

const PetLarge: React.FC<PetLargeProps> = ({
  imageSrc,
  name,
  age,
  species,
  vaccines,
  sex,
  breed,
  sterilized,
  
}) => {
  return (
    <div className="bg-[#FFCD82] p-4 w-3/4 rounded-lg shadow-md">
      <div className="card sm:flex flex-col items-start md:card-side bg-[#FFCD82] shadow-xl">
        <figure>
          <Image
            className="max-w-sm rounded-lg"
            src={imageSrc}
            width={300}
            height={300}
            alt={`Picture of ${name}`}
          />
        </figure>
        <div className="card-body flex sm:flex-col md:flex-row content-between items-end justify-evenly">
          <div>
            <h2 className="card-title font-bold text-2xl mb-2">Nombre: {name}</h2>
            <p className="font-bold">Edad: {age}</p>
            <p className="font-bold">Especie: {species}</p>
            <p className="font-bold">Vacunas: {vaccines}</p>
          </div>
          <div>
            <p className="font-bold">Sexo: {sex}</p>
            <p className="font-bold">Raza: {breed}</p>
            <p className="font-bold">Esterilizado: {sterilized}</p>
          </div>
          <div className="card-actions justify-end ml-10">
            <button className="btn btn-primary bg-black text-2xl" >
              Editar
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PetLarge;
